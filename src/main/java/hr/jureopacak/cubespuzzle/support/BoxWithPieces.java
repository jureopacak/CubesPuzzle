package hr.jureopacak.cubespuzzle.support;

import hr.jureopacak.cubespuzzle.domain.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * BoxWithPieces is container for piece set given from {@link PieceFactory}
 * 
 */
public class BoxWithPieces {

	private List<Piece> pieces = new ArrayList<>();
	private int nextId = 1;

	/**
	 * Add {@link Piece} to box. To every added {@link Piece} unique ID will be
	 * assigned by {@link BoxWithPieces}
	 * 
	 * @param piece
	 *            to add
	 */
	public void addPiece(Piece piece) {
		if (pieces.size() >= 6) {
			System.out.println("Box have allready 6 pieces!");
			return;
		}
		piece.setId(nextId++);
		pieces.add(piece);
	}

	public List<Piece> getPieces() {
		return pieces;
	}

}
