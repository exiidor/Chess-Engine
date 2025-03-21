package softwareschreiber.chessengine.move;

import softwareschreiber.chessengine.Board;
import softwareschreiber.chessengine.Position;
import softwareschreiber.chessengine.gamepieces.Piece;

public class CastlingMove extends Move {
	private final Piece other;
	private final Move otherMove;

	public CastlingMove(Position position, Position targetPosition, Piece other, Position otherTargetPosition) {
		super(position, targetPosition);
		this.other = other;
		this.otherMove = new Move(other.getPosition(), otherTargetPosition);
	}

	public Piece getOther() {
		return other;
	}

	public Move getOtherMove() {
		return otherMove;
	}

	@Override
	public String toString() {
		return super.toString() + " Castling with " + other;
	}

	@Override
	public CastlingMove copyWith(Board board) {
		return new CastlingMove(getSourcePos(), getTargetPos(), board.getPieceAt(other.getPosition()), otherMove.getTargetPos());
	}
}
