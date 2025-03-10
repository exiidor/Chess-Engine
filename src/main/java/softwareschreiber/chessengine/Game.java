package softwareschreiber.chessengine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import softwareschreiber.chessengine.gamepieces.Pawn;
import softwareschreiber.chessengine.gamepieces.Piece;
import softwareschreiber.chessengine.gamepieces.PieceColor;
import softwareschreiber.chessengine.player.ComputerPlayer;
import softwareschreiber.chessengine.player.HumanPlayer;
import softwareschreiber.chessengine.player.Player;

public abstract class Game {
	private final Board board;
	private final List<Consumer<PieceColor>> gameEndListeners;
	private PieceColor activeColor;
	private boolean gameOver = false;
	private Player whitePlayer;
	private Player blackPlayer;

	public Game(PieceColor startingColor) {
		board = new Board(this);
		gameEndListeners = new ArrayList<>();
		activeColor = startingColor;
		whitePlayer = new HumanPlayer(PieceColor.WHITE);
		blackPlayer = new ComputerPlayer(PieceColor.BLACK);
	}

	public Board getBoard() {
		return board;
	}

	public void setIsWhitesTurn(boolean isWhitesTurn) {
		if (isWhitesTurn) {
			activeColor = PieceColor.WHITE;
		} else {
			activeColor = PieceColor.BLACK;
		}
	}

	public Player getWhitePlayer() {
		return whitePlayer;
	}

	public Player getBlackPlayer() {
		return blackPlayer;
	}

	public void startGame() {
		board.initializeStartingPositions();

		board.addSubmittedMoveDoneListener((piece, move) -> {
			checkForMate(piece.getColor().getOpposite());

			if (!gameOver) {
				activeColor = piece.getColor().getOpposite();
			}
		});
		board.addSubmittedUndoMoveDoneListener((piece, move) -> {
			if (!gameOver) {
				activeColor = piece.getColor();
			}
		});
	}

	private void checkForMate(PieceColor color) {
		switch (board.checkForMate(color)) {
			case CHECKMATE:
				checkMate(color.getOpposite());
				break;
			case STALEMATE:
				staleMate();
				break;
			case null:
				break;
		}
	}

	public void addGameEndListener(Consumer<PieceColor> listener) {
		gameEndListeners.add(listener);
	}

	protected abstract Piece getPromotionTarget(Board board, Pawn pawn);

	protected abstract void checkMate(PieceColor winningColor);

	protected abstract void staleMate();

	protected void endGame() {
		gameOver = true;
		gameEndListeners.forEach(listener -> listener.accept(activeColor));
	}

	public boolean isWhitesTurn() {
		return activeColor == PieceColor.WHITE;
	}

	public boolean isTimeForTurn(Piece piece) {
		return piece.getColor() == activeColor;
	}

	public boolean isGameOver() {
		return gameOver;
	}
}
