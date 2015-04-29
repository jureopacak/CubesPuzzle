package hr.jureopacak.cubespuzzle;

import hr.jureopacak.cubespuzzle.domain.Cube;
import hr.jureopacak.cubespuzzle.domain.Piece;
import hr.jureopacak.cubespuzzle.support.PieceFactory;
import hr.jureopacak.cubespuzzle.support.PieceFactory.PieceSet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

/**
 * Cubes task
 * 
 */
public class CubesPuzzle {

	/**
	 * Entry point of Cubes Puzzle task. Program can be started in two different
	 * ways.
	 * <p>
	 * 1. With one argument. Where argument is piece set. Piece set is one of
	 * (blue|red|purple|yellow). In this way solution will be printed to standard
	 * out.
	 * <p>
	 * 2. With two arguments. Where first argument is piece set. Piece set is
	 * from (blue|red|purple|yellow). And second argument is path to file where
	 * solution will be saved.
	 * <p>
	 * 
	 * @param args
	 *            arguments for cubes puzzle program.
	 */
	public static void main(String[] args) {

		if (args.length > 2 || args.length < 1) {
			System.err
					.println("Ivalid argument number! First argument should be Piece set, second argument should be path to file where to store solution.");
			System.err
					.println("Program should be started with those args: (blue|red|purple|yellow) [filePathWhereToSaveSolution]");
			return;
		}

		PieceSet pieceSet = null;
		try {
			pieceSet = PieceSet.valueOf(args[0].toUpperCase());
		} catch (IllegalArgumentException e) {
			System.err
					.println("Illegal argument! First argument should be one from set (blue|red|purple|yellow)");
			return;
		}

		Cube cube = new Cube(PieceFactory.getBoxWithPieces(pieceSet));
		List<List<Piece>> solutions = cube.solve();

		if (solutions.isEmpty()) {
			System.out.println("There are no any solutions found.");
			return;
		}

		/*
		 * if args.length == 2 save solution to file, otherwise print it to
		 * standard out.
		 */
		if (args.length == 2) {
			saveSolutionToFile(cube.getFirstSolution(), args[1]);
		} else {
			System.out.println(cube.getFirstSolution());
		}

	}

	private static void saveSolutionToFile(String firstSolution, String filePath) {
		File fileToSave = new File(filePath);
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(fileToSave)))) {
			writer.write(firstSolution);
			System.out.println("Solution is saved to: "
					+ fileToSave.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
