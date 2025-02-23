package softwareschreiber.chessengine;

public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean equals(Position position) {
		return x == position.getX() && y == position.getY();
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
