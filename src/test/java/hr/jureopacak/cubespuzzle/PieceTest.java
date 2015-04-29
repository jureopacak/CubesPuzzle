package hr.jureopacak.cubespuzzle;

import static org.junit.Assert.assertEquals;
import hr.jureopacak.cubespuzzle.domain.Edge;
import hr.jureopacak.cubespuzzle.domain.Piece;

import java.util.Arrays;

import org.junit.Test;

public class PieceTest {

	@Test
	public void testFlipHorizontal() {
		Piece piece = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));

		piece.flipHorizontal();
		
		Piece expectedFlipped = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)));
		
		assertEquals(piece.getTopPins(), expectedFlipped.getTopPins());
		assertEquals(piece.getLeftPins(), expectedFlipped.getLeftPins());
		assertEquals(piece.getBottomPins(), expectedFlipped.getBottomPins());
		assertEquals(piece.getRightPins(), expectedFlipped.getRightPins());

		
	}
	
	@Test
	public void testRotate90CCW() {
		Piece piece = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		
		piece.rotate90CCW();
		
		Piece expectedFlipped = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)));
		
		assertEquals(piece.getTopPins(), expectedFlipped.getTopPins());
		assertEquals(piece.getLeftPins(), expectedFlipped.getLeftPins());
		assertEquals(piece.getBottomPins(), expectedFlipped.getBottomPins());
		assertEquals(piece.getRightPins(), expectedFlipped.getRightPins());
	}

	@Test
	public void testInverte() {
		Piece piece = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		
		piece.invert();
		
		Piece expectedFlipped = new Piece(
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		
		assertEquals(piece.getTopPins(), expectedFlipped.getTopPins());
		assertEquals(piece.getLeftPins(), expectedFlipped.getLeftPins());
		assertEquals(piece.getBottomPins(), expectedFlipped.getBottomPins());
		assertEquals(piece.getRightPins(), expectedFlipped.getRightPins());
	}
	
	@Test
	public void testIsSameAs() {
		Piece piece = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		
		Piece piece2 = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		
		assertEquals(piece.isSameAs(piece), true);
		assertEquals(piece.isSameAs(piece2), false);
		
		
	}
	
}
