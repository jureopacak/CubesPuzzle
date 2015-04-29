package hr.jureopacak.cubespuzzle.domain;

import java.util.Collections;
import java.util.List;

public class Piece implements Cloneable {

	public enum Orientation {
		N, W, S, E;
	}

	public enum Side {
		OBVERSE, REVERSE;
		@Override
		public String toString() {
			switch (this) {
			case OBVERSE:
				return "O";
			case REVERSE:
				return "R";
			default:
				break;
			}
			return null;
		}
	}

	public int id;

	private Edge topEdge;
	private Edge leftEdge;
	private Edge bottomEdge;
	private Edge rightEdge;

	private Orientation orientation = Orientation.N;
	private Side side = Side.OBVERSE;

	/**
	 * Creates new Piece object with given edges.
	 * 
	 * @param topEdge
	 * @param leftEdge
	 * @param bottomEdge
	 * @param rightEdge
	 */
	public Piece(Edge topEdge, Edge leftEdge, Edge bottomEdge, Edge rightEdge) {
		this.topEdge = topEdge;
		this.leftEdge = leftEdge;
		this.bottomEdge = bottomEdge;
		this.rightEdge = rightEdge;
	}

	/**
	 * Copy construcor for Piece.
	 * 
	 * @param piece
	 *            to clone
	 */
	public Piece(Piece piece) {
		this.topEdge = new Edge(piece.topEdge);
		this.leftEdge = new Edge(piece.leftEdge);
		this.bottomEdge = new Edge(piece.bottomEdge);
		this.rightEdge = new Edge(piece.rightEdge);

		this.id = piece.getId();
		this.orientation = piece.getOrientation();
		this.side = piece.getSide();

	}

	/**
	 * Flips pice horizontaly.
	 */
	public void flipHorizontal() {
		Edge tempLeft = leftEdge;
		Edge tempRight = rightEdge;

		leftEdge = tempRight;
		rightEdge = tempLeft;

		invertEdges(topEdge, bottomEdge);

		if (side == Side.OBVERSE) {
			side = Side.REVERSE;
		} else {
			side = Side.OBVERSE;
		}

	}

	/**
	 * Rotates piece for 90 degrees counter clockwise.
	 */
	public void rotate90CCW() {

		Edge tempTop = topEdge;
		Edge tempLeft = leftEdge;
		Edge tempBottom = bottomEdge;
		Edge tempRight = rightEdge;

		leftEdge = tempTop;
		bottomEdge = tempLeft;
		rightEdge = tempBottom;
		topEdge = tempRight;

		invertEdges(leftEdge, rightEdge);

		switch (orientation) {
		case N:
			orientation = Orientation.W;
			break;
		case W:
			orientation = Orientation.S;
			break;
		case S:
			orientation = Orientation.E;
			break;
		case E:
			orientation = Orientation.N;
			break;
		}
	}

	/**
	 * Inverts given edge/edges.
	 * 
	 * @param edges
	 *            to reverse
	 */
	private void invertEdges(Edge... edges) {
		for (Edge edge : edges) {
			Collections.reverse(edge.getPins());
		}
	}

	/**
	 * Invert piece.
	 */
	public void invert() {
		flipHorizontal();
		rotate90CCW();
		rotate90CCW();
	}

	public String getRow(int i) {
		StringBuilder sb = new StringBuilder("");

		if (i == 1) {
			if (leftEdge.getPins().get(0) == 1 || topEdge.getPins().get(0) == 1) {
				sb.append("1");
			} else {
				sb.append("0");
			}

			sb.append(topEdge.getPins().get(1));
			sb.append(topEdge.getPins().get(2));
			sb.append(topEdge.getPins().get(3));
			if (rightEdge.getPins().get(0) == 1
					|| topEdge.getPins().get(4) == 1) {
				sb.append("1");
			} else {
				sb.append("0");
			}
		} else if (i == 2 || i == 4 || i == 3) {
			sb.append(leftEdge.getPins().get(i - 1) + "111"
					+ rightEdge.getPins().get(i - 1));
		} else if (i == 5) {
			if (leftEdge.getPins().get(4) == 1
					|| bottomEdge.getPins().get(0) == 1) {
				sb.append("1");
			} else {
				sb.append("0");
			}

			sb.append(bottomEdge.getPins().get(1));
			sb.append(bottomEdge.getPins().get(2));
			sb.append(bottomEdge.getPins().get(3));
			if (rightEdge.getPins().get(4) == 1
					|| bottomEdge.getPins().get(4) == 1) {
				sb.append("1");
			} else {
				sb.append("0");
			}

		}

		return sb.toString().replace("0", " ").replace("1", "o");
	}

	public List<Integer> getTopPins() {
		return topEdge.getPins();
	}

	public List<Integer> getLeftPins() {
		return leftEdge.getPins();
	}

	public List<Integer> getBottomPins() {
		return bottomEdge.getPins();
	}

	public List<Integer> getRightPins() {
		return rightEdge.getPins();
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public Side getSide() {
		return side;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean haveTopRightCorner() {
		if (topEdge.getPins().get(4) == 1) {
			return true;
		}
		return false;
	}

	public boolean haveTopLeftCorner() {
		if (topEdge.getPins().get(0) == 1) {
			return true;
		}
		return false;
	}

	public boolean haveBottomRightCorner() {
		if (bottomEdge.getPins().get(4) == 1) {
			return true;
		}
		return false;
	}

	public boolean haveBottomLeftCorner() {
		if (bottomEdge.getPins().get(0) == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if {@link Piece} is same as given {@link Piece} in contest of
	 * edges.
	 * 
	 * @param piece
	 *            to check
	 * @return <code>true</code> if there are same, othervise returns
	 *         <code>false</code>
	 */
	public boolean isSameAs(Piece piece) {
		if (!comparePins(getTopPins(), piece.getTopPins())) {
			return false;
		} else if (!comparePins(getLeftPins(), piece.getLeftPins())) {
			return false;
		} else if (!comparePins(getRightPins(), piece.getRightPins())) {
			return false;
		} else if (!comparePins(getBottomPins(), piece.getBottomPins())) {
			return false;
		}
		return true;
	}

	/**
	 * Compares pins
	 * 
	 * @param toCheck
	 *            pins of edge to check
	 * @param checkWith
	 *            pins of edge to check with
	 * @return <code>true</code> if pins of edge are same , othervise returns
	 *         <code>false</code>
	 */
	private boolean comparePins(List<Integer> toCheck, List<Integer> checkWith) {
		for (int i = 0; i < 5; i++) {
			if (toCheck.get(i) != checkWith.get(i)) {
				return false;
			}

		}

		return true;
	}
}
