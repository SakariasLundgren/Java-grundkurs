package Sudoku;

public class SudokuApplication {

	public static void main(String[] args) {
		SudokuBoard board = new SudokuBoard(9,9);
		SudokuView window = new SudokuView("Sudoku", 1000, 1000, testBoard(board));
	}
	
	private static SudokuBoard testBoard(SudokuBoard b) { 
		int [][] example = {{0,0,8,0,0,9,0,6,2}, {0,0,0,0,0,0,0,0,5}, {1,0,2,5,0,0,0,0,0}, {0,0,0,2,1,0,0,9,0}, 
				{0,5,0,0,0,0,6,0,0}, {6,0,0,0,0,0,0,2,8}, {4,1,0,6,0,8,0,0,0}, {8,6,0,0,3,0,1,0,0}, {0,0,0,0,0,0,4,0,0}};
		b.setMatrix(example);
		return b;
	}

}
