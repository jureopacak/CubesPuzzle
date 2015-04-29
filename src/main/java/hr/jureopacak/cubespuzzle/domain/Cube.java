package hr.jureopacak.cubespuzzle.domain;

import hr.jureopacak.cubespuzzle.support.BoxWithPieces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cube {

	private BoxWithPieces box;

	/**
	 * Every List<Piece> in {@link #solutions} is representing solution.
	 * 
	 * 1st element in List<Piece> is representing FRONT  side
	 * 2nd element in List<Piece> is representing RIGHT  side
	 * 3rd element in List<Piece> is representing BACK   side
	 * 4th element in List<Piece> is representing LEFT   side
	 * 5th element in List<Piece> is representing TOP    side
	 * 6th element in List<Piece> is representing BOTTOM side
	 *         +--------+
	 *	  /|       /|
	 *	 / |  T   / |
	 *      +--|---B-+  |
	 *	|L |     |R |
	 *	|  +-F---|--+
	 *	| /      | /
	 *	|/    B  |/
	 *	+--------+
	 *
	 * 
	 */
	private List<List<Piece>> solutions = new ArrayList<>();

	public Cube(BoxWithPieces box) {
		this.box = box;
	}

	/**
	 * Call to invoke finding of solutions.
	 * @return {@link List} of solutions.
	 */
	public List<List<Piece>> solve() {
		recursiveSolving(new ArrayList<Piece>(6), box.getPieces());
		return solutions;
	}

	/**
	 * Solving cubes recursivly.
	 * 
	 * @param previousSolution
	 *            already matched pieces which are fitting in current finding
	 *            of solution.
	 * @param remainingPieces
	 *            pieces which are not yet in solution.
	 */
	private void recursiveSolving(List<Piece> previousSolution, List<Piece> remainingPieces) {

		if (previousSolution.size() == 6){
			if (isSolutionUnique(previousSolution)) {
				solutions.add(previousSolution);
			}
			return;
		}

		List<Piece> currentSolution = null;
		for (Piece piece : remainingPieces) {

			for (int i = 0; i < 8; i++) {

				if (checkIfFits(piece, previousSolution) || previousSolution.isEmpty()) {

					currentSolution = new ArrayList<Piece>();

					for (Piece pieceFromPrevoius : previousSolution) {
						currentSolution.add(new Piece(pieceFromPrevoius));
					}

					currentSolution.add(new Piece(piece));

					List<Piece> remainingPiecesForNextStep = new ArrayList<Piece>();
					for (Piece remaiendPiece : remainingPieces) {
						if (remaiendPiece.getId() != piece.getId()) {
							remainingPiecesForNextStep.add(new Piece(remaiendPiece));
						}
					}

					recursiveSolving(currentSolution, remainingPiecesForNextStep);

				}

				if (i == 3) {
					piece.flipHorizontal();
				} else {
					piece.rotate90CCW();
				}
			}
		}
		return;
	}

	/**
	 * Checks if {@link Piece} is fitting on next place of solution.
	 * @param pieceToCheck
	 * @param solution
	 * @return <code>true</code> if piece is fitting otherwise <code>false</code>
	 */
	public boolean checkIfFits(Piece pieceToCheck, List<Piece> solution) {

		switch (solution.size()) {
		case 1:
			return checkIfFittingOnRight(pieceToCheck, solution);
		case 2:
			return checkIfFittingOnLeft(pieceToCheck, solution);
		case 3:
			return checkIfFittingOnTop(pieceToCheck, solution);
		case 4:
			return checkIfFittingOnBottom(pieceToCheck, solution);
		case 5:
			return checkIfFittingOnBack(pieceToCheck, solution);

		default:
			return false;
		}

	}

	private boolean checkIfFittingOnRight(Piece pieceToCheck,
			List<Piece> solution) {
		return checkPins(solution.get(0).getRightPins(), pieceToCheck.getLeftPins());
	}

	private boolean checkIfFittingOnLeft(Piece pieceToCheck,
			List<Piece> solution) {
		return checkPins(solution.get(0).getLeftPins(), pieceToCheck.getRightPins());
	}

	private boolean checkIfFittingOnTop(Piece pieceToCheck, List<Piece> solution) {
		boolean matchFront = checkPins(solution.get(0).getTopPins(), pieceToCheck.getBottomPins());
		Collections.reverse(solution.get(1).getTopPins());
		boolean matchRight = checkPins(solution.get(1).getTopPins(), pieceToCheck.getRightPins());
		Collections.reverse(solution.get(1).getTopPins());
		boolean matchLeft = checkPins(solution.get(2).getTopPins(), pieceToCheck.getLeftPins());

		if (matchFront && matchRight && matchLeft) {

			if (solution.get(2).haveTopRightCorner() && pieceToCheck.haveBottomLeftCorner()) {
				return false;
			} else if (solution.get(1).haveTopLeftCorner() && pieceToCheck.haveBottomRightCorner()) {
				return false;
			}

			return true;

		}

		return false;
	}

	private boolean checkIfFittingOnBottom(Piece pieceToCheck, List<Piece> solution) {
		boolean matchFront = checkPins(solution.get(0).getBottomPins(), pieceToCheck.getTopPins());
		boolean matchRight = checkPins(solution.get(1).getBottomPins(), pieceToCheck.getRightPins());
		Collections.reverse(pieceToCheck.getLeftPins());
		boolean matchLeft = checkPins(solution.get(2).getBottomPins(), pieceToCheck.getLeftPins());
		Collections.reverse(pieceToCheck.getLeftPins());

		if (matchFront && matchRight && matchLeft) {

			if (solution.get(2).haveBottomRightCorner() && pieceToCheck.haveTopLeftCorner()) {
				return false;
			} else if (solution.get(1).haveBottomLeftCorner() && pieceToCheck.haveTopRightCorner()) {
				return false;
			}

			return true;
		}
		return false;
	}

	private boolean checkIfFittingOnBack(Piece pieceToCheck, List<Piece> solution) {
		boolean matchRight = checkPins(solution.get(1).getRightPins(), pieceToCheck.getRightPins());
		boolean matchLeft = checkPins(solution.get(2).getLeftPins(), pieceToCheck.getLeftPins());
		boolean matchBottom = checkPins(solution.get(4).getBottomPins(), pieceToCheck.getBottomPins());
		boolean matchTop = checkPins(solution.get(3).getTopPins(), pieceToCheck.getTopPins());

		if (matchRight && matchLeft && matchBottom && matchTop) {

			if ((solution.get(1).haveBottomRightCorner() || solution.get(1).haveBottomRightCorner()) && pieceToCheck.haveBottomRightCorner()) {
				return false;
			} else if ((solution.get(2).haveBottomLeftCorner() || solution.get(4).haveBottomLeftCorner()) && pieceToCheck.haveBottomLeftCorner()) {
				return false;
			} else if ((solution.get(2).haveTopLeftCorner() || solution.get(3).haveTopLeftCorner()) && pieceToCheck.haveTopLeftCorner()) {
				return false;
			} 

			return true;
		}
		return false;
	}

	/**
	 * Checking if to edges of different piece is matching each other. Piece is
	 * maching another piece if and only if pices haves 1s (pins) on different
	 * places, and there are no gaps beetween non cornerd pins.
	 * 
	 * @param rootPins
	 * @param toCheckPins
	 * @return <code>true</code> if pieces matching each other, otherwise
	 *         <code>false</code>
	 */
	public boolean checkPins(List<Integer> rootPins, List<Integer> toCheckPins) {
		for (int i = 0; i < 5; i++) {

			if (rootPins.get(i) == 1 && toCheckPins.get(i) == 1) {
				return false;
			}

			if (i >= 1 && i <= 3) {
				if (rootPins.get(i) == 0 && toCheckPins.get(i) == 0) {
					return false;
				}
			}

		}

		return true;
	}

	/**
	 * Prints solution.
	 * 
	 * @param index
	 *            of solution to print
	 * @return String solution
	 */
	public String printSolution(int index) {
		String newLine = System.getProperty("line.separator");
		String indent = "     ";
		StringBuilder sb = new StringBuilder();
		List<Piece> solution = solutions.get(index);

		for (int i = 1; i <= 5; i++) {
			sb.append(solution.get(2).getRow(i) + solution.get(0).getRow(i) + solution.get(1).getRow(i) + newLine);
		}

		for (int j = 1; j <= 5; j++) {
			sb.append(indent + solution.get(4).getRow(j) + newLine);
		}

		solution.get(5).invert();

		for (int j = 1; j <= 5; j++) {
			sb.append(indent + solution.get(5).getRow(j) + newLine);
		}

		for (int j = 1; j <= 5; j++) {
			sb.append(indent + solution.get(3).getRow(j) + newLine);
		}

		sb.append(newLine);

		return sb.toString();
	}

	/**
	 * Prints all solutions to System.out;
	 */
	public void printAllSolutions() {
		for (int i = 0; i < solutions.size(); i++) {
			printSolution(i);
		}
	}

	/**
	 * Return first soltion as {@link String}.
	 * @return solution.
	 */
	public String getFirstSolution() {
		if (solutions.isEmpty()) {
			return "";
		}
		return printSolution(0);
	}

	/**
	 * Checking if given solution is unique to previously found solutions.
	 * Checking is primitive in this time. Mirroring and rotating of solutions
	 * is neglected.
	 * 
	 * @param solution
	 *            to check
	 * @return true if solution is unique or there are no any solutions found,
	 *         othewise returns false
	 */
	private boolean isSolutionUnique(List<Piece> solution) {

		if (solutions.isEmpty()) {
			return true;
		}

		for (int i = 0; i < solutions.size(); i++) {
			if (compareSolutions(solution, solutions.get(i))) {
				return false;
			}

		}

		return true;
	}

	/**
	 * Cheking if two solutions are same.
	 * 
	 * @param compareWith
	 *            solution to compare
	 * @param comapreTo
	 *            solution to comapre with
	 * @return <code>true</code> if solutions are same, otherwise returns
	 *         <code>false</code>
	 * 
	 */
	public boolean compareSolutions(List<Piece> compareWith, List<Piece> comapreTo) {
		for (int i = 0; i < comapreTo.size(); i++) {
			if (!comapreTo.get(i).isSameAs(compareWith.get(i))) {
				return false;
			}
		}
		return true;
	}

}
