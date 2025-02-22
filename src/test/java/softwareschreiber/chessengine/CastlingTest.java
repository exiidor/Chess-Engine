package softwareschreiber.chessengine;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import softwareschreiber.chessengine.gamepieces.King;
import softwareschreiber.chessengine.gamepieces.Rook;
import softwareschreiber.chessengine.move.CastlingMove;
import softwareschreiber.chessengine.move.Move;

class CastlingTest {
	@Test
	void test() {
		noObstruction(new Board(new CliGame()), true, true);
		noObstruction(new Board(new CliGame()), true, false);
		noObstruction(new Board(new CliGame()), false, true);
		noObstruction(new Board(new CliGame()), false, false);

		obstruction(new Board(new CliGame()), true, true);
		obstruction(new Board(new CliGame()), true, false);
		obstruction(new Board(new CliGame()), false, true);
		obstruction(new Board(new CliGame()), false, false);
	}

	private void noObstruction(Board board, boolean isWhite, boolean left) {
		int y = isWhite ? 7 : 0;

		King king = board.addPiece(4, y, new King(isWhite, board));
		Rook rook = board.addPiece(left ? 0 : 7, y, new Rook(isWhite, board));

		Set<? extends Move> kingMoves = king.getValidMovesInternal();
		int castleCount = 0;

		for (Move move : kingMoves) {
			if (move instanceof CastlingMove castlingMove) {
				assertTrue(castleCount == 0);

				board.move(king, castlingMove, false);

				assertTrue(king.getPosition().equals(new Position(left ? 2 : 6, king.getY())));
				assertTrue(rook.getPosition().equals(new Position(left ? 3 : 5, y)));

				castleCount++;
			}
		}
	}

	private void obstruction(Board board, boolean isWhite, boolean left) {
		int y = isWhite ? 7 : 0;

		King king = board.addPiece(4, y, new King(isWhite, board));
		board.addPiece(3, 7 - y, new King(!isWhite, board));
		board.addPiece(left ? 0 : 7, y, new Rook(isWhite, board));
		board.addPiece(left ? 3 : 5, 4, new Rook(!isWhite, board));

		Set<? extends Move> kingMoves = king.getValidMovesInternal();
		int castleCount = 0;

		for (Move move : kingMoves) {
			if (move instanceof CastlingMove) {
				castleCount++;
			}
		}

		assertTrue(castleCount == 0);
	}
}
