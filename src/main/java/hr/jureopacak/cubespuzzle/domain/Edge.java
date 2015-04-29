package hr.jureopacak.cubespuzzle.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Edge is representing one edge of the piece.
 * 
 */
public class Edge {

	/**
	 * Collection of pins for edge. Pins are in horizontal order from left to
	 * right for bottom and top edge of piece, pins are in vertical order from
	 * top to bottom for left and right edge of the piece.
	 * <p>
	 * Pins are represented with 0s and 1s for edge lenght. Where the pin is
	 * poped on that place goes 1, where the pin is not poped there goes 0.
	 */
	private List<Integer> pins;

	public Edge(List<Integer> pins) {
		this.pins = pins;
	}

	/**
	 * Copy constructor for Edge
	 * 
	 * @param edge
	 *            to copy
	 */
	public Edge(Edge edge) {
		pins = new ArrayList<Integer>(edge.getPins());
	}

	public List<Integer> getPins() {
		return pins;
	}

	public void setPins(List<Integer> pins) {
		this.pins = pins;
	}

}
