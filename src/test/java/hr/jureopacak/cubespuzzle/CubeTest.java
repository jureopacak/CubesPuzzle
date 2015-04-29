package hr.jureopacak.cubespuzzle;

import static org.junit.Assert.*;
import hr.jureopacak.cubespuzzle.domain.Cube;
import hr.jureopacak.cubespuzzle.domain.Edge;
import hr.jureopacak.cubespuzzle.domain.Piece;
import hr.jureopacak.cubespuzzle.support.BoxWithPieces;
import hr.jureopacak.cubespuzzle.support.PieceFactory;
import hr.jureopacak.cubespuzzle.support.PieceFactory.PieceSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CubeTest {

	private BoxWithPieces pieces;
	private Cube cube;
	
	@Before
	public void before() {
		pieces = PieceFactory.getBoxWithPieces(PieceSet.BLUE);
		cube = new Cube(pieces);
	}

	@Test
	public void testCompareSolutions() {
		boolean isSame = cube.compareSolutions(pieces.getPieces(), pieces.getPieces());
		assertEquals(isSame, true);
		
		BoxWithPieces otherPieces = PieceFactory.getBoxWithPieces(PieceSet.BLUE);
		otherPieces.getPieces().get(0).rotate90CCW();
		//Should be true because first piece is symmetrical
		isSame = cube.compareSolutions(pieces.getPieces(), otherPieces.getPieces());
		assertEquals(isSame, true);
		
		otherPieces.getPieces().get(1).rotate90CCW();
		//Shouldn't be true because second piece is not symmetrical
		isSame = cube.compareSolutions(pieces.getPieces(), otherPieces.getPieces());
		assertEquals(isSame, false);
		
	}
	
	@Test
	public void testCheckPins() {
		assertEquals(true, cube.checkPins(Arrays.asList(1, 0, 1, 0, 1), Arrays.asList(0, 1, 0, 1, 0)));
		assertEquals(true, cube.checkPins(Arrays.asList(1, 0, 1, 0, 0), Arrays.asList(0, 1, 0, 1, 0)));
		assertEquals(true, cube.checkPins(Arrays.asList(0, 0, 1, 0, 1), Arrays.asList(0, 1, 0, 1, 0)));
		assertEquals(true, cube.checkPins(Arrays.asList(0, 0, 1, 0, 0), Arrays.asList(0, 1, 0, 1, 0)));
		
		assertEquals(false, cube.checkPins(Arrays.asList(1, 0, 0, 0, 1), Arrays.asList(0, 1, 0, 1, 0)));
		assertEquals(false, cube.checkPins(Arrays.asList(1, 1, 1, 0, 1), Arrays.asList(0, 1, 0, 1, 0)));
	}
	
	@Test
	public void testCheckIfFits() {
		ArrayList<Piece> toCheck = new ArrayList<Piece>();
		
		Piece p1 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 1)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 1)));
		Piece p2 = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		Piece p3 = new Piece(
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		Piece p4 = new Piece(
				new Edge(Arrays.asList(1, 0, 1, 0, 0)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 0)));
		Piece p5 = new Piece(
				new Edge(Arrays.asList(1, 0, 1, 0, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 0, 1, 0, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 1)));
		Piece p6 = new Piece(
				new Edge(Arrays.asList(0, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 1, 0, 1, 1)),
				new Edge(Arrays.asList(1, 1, 0, 1, 0)),
				new Edge(Arrays.asList(0, 0, 1, 0, 0)));
		
		toCheck.add(p1);

		assertEquals(true, cube.checkIfFits(p2, toCheck));
		assertEquals(true, cube.checkIfFits(p3, toCheck));
		assertEquals(false, cube.checkIfFits(p4, toCheck));
		assertEquals(false, cube.checkIfFits(p5, toCheck));
		assertEquals(false, cube.checkIfFits(p6, toCheck));
		toCheck.add(p2);
		
		assertEquals(true, cube.checkIfFits(p3, toCheck));
		assertEquals(false, cube.checkIfFits(p4, toCheck));
		assertEquals(false, cube.checkIfFits(p5, toCheck));
		assertEquals(true, cube.checkIfFits(p6, toCheck));
		toCheck.add(p3);
		
		assertEquals(true, cube.checkIfFits(p6, toCheck));
		assertEquals(false, cube.checkIfFits(p4, toCheck));
		assertEquals(false, cube.checkIfFits(p5, toCheck));
		toCheck.add(p6);
		
		assertEquals(true, cube.checkIfFits(p4, toCheck));
		assertEquals(false, cube.checkIfFits(p5, toCheck));
		toCheck.add(p4);
		
		assertEquals(true, cube.checkIfFits(p5, toCheck));
		toCheck.add(p5);
		
	}
	
	@Test
	public void testSolve() {
		List<List<Piece>> solutions = cube.solve();
		assertNotNull(solutions);
		assertEquals(true, !solutions.isEmpty());
	}

}
