package hr.jureopacak.cubespuzzle.support;

import hr.jureopacak.cubespuzzle.domain.Edge;
import hr.jureopacak.cubespuzzle.domain.Piece;

import java.util.Arrays;

/**
 * Helper class for providing task with a pieces.
 * 
 */
public class PieceFactory {

	public enum PieceSet {
		BLUE, RED, PURPLE, YELLOW;
	}

	/**
	 * Creating BoxWithPieces for given piece set. 
	 * 
	 * @param pieceSet
	 * @return BoxWithPieces filled with pieces from given piece set
	 */
	public static BoxWithPieces getBoxWithPieces(PieceSet pieceSet) {
		switch (pieceSet) {
		case BLUE:
			return bluePieces();
		case RED:
			return redPieces();
		case PURPLE:
			return purplePieces();
		case YELLOW:
			return yellowPieces();

		}
		return null;
	}

	private static BoxWithPieces bluePieces() {

		Piece p1 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		Piece p2 = new Piece(
				new Edge(Arrays.asList(1, 0, 1, 0, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 0, 1, 0, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 1)));
		Piece p3 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)));
		Piece p4 = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		Piece p5 = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)));
		Piece p6 = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 1)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)));

		BoxWithPieces box = new BoxWithPieces();
		box.addPiece(p1);
		box.addPiece(p2);
		box.addPiece(p3);
		box.addPiece(p4);
		box.addPiece(p5);
		box.addPiece(p6);
		return box;
	}

	private static BoxWithPieces redPieces() {

		Piece p1 = new Piece(
				new Edge(Arrays.asList(0, 0, 0, 1, 1)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 0, 1, 0, 1)));
		Piece p2 = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		Piece p3 = new Piece(
				new Edge(Arrays.asList(0, 1, 1, 0, 1)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 0, 0, 1, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 1)));
		Piece p4 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		Piece p5 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)));
		Piece p6 = new Piece(
				new Edge(Arrays.asList(0, 1, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 1)),
				new Edge(Arrays.asList(0, 0, 1, 0, 1)));

		BoxWithPieces box = new BoxWithPieces();
		box.addPiece(p1);
		box.addPiece(p2);
		box.addPiece(p3);
		box.addPiece(p4);
		box.addPiece(p5);
		box.addPiece(p6);
		return box;
	}

	private static BoxWithPieces purplePieces() {

		Piece p1 = new Piece(
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(1, 1, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 0, 1, 0)));
		Piece p2 = new Piece(
				new Edge(Arrays.asList(0, 0, 0, 1, 1)),
				new Edge(Arrays.asList(0, 1, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(1, 0, 1, 0, 0)));
		Piece p3 = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		Piece p4 = new Piece(
				new Edge(Arrays.asList(1, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(1, 1, 0, 0, 0)));
		Piece p5 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 1)),
				new Edge(Arrays.asList(0, 0, 1, 1, 1)),
				new Edge(Arrays.asList(1, 0, 1, 1, 0)),
				new Edge(Arrays.asList(1, 1, 1, 0, 0)));
		Piece p6 = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(0, 0, 0, 1, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(1, 0, 1, 0, 0)));

		BoxWithPieces box = new BoxWithPieces();
		box.addPiece(p1);
		box.addPiece(p2);
		box.addPiece(p3);
		box.addPiece(p4);
		box.addPiece(p5);
		box.addPiece(p6);
		return box;
	}

	private static BoxWithPieces yellowPieces() {

		Piece p1 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		Piece p2 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 1)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(1, 1, 0, 0, 0)));
		Piece p3 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 1)),
				new Edge(Arrays.asList(0, 0, 1, 1, 1)),
				new Edge(Arrays.asList(1, 0, 1, 0, 0)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)));
		Piece p4 = new Piece(
				new Edge(Arrays.asList(1, 0, 1, 0, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 0, 1, 0, 0)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)));
		Piece p5 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)));
		Piece p6 = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(0, 0, 1, 0, 1)));

		BoxWithPieces box = new BoxWithPieces();
		box.addPiece(p1);
		box.addPiece(p2);
		box.addPiece(p3);
		box.addPiece(p4);
		box.addPiece(p5);
		box.addPiece(p6);
		return box;
	}
}
