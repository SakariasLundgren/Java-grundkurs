package Sudoku;

public interface SudokuSolver {

		boolean solve();

		/**
		 * Puts digit in the box row, col.
		 * 
		 * @param row   The row
		 * @param col   The column
		 * @param digit The digit to insert in box row, col
		 * @throws IllegalArgumentException if row, col or digit is outside the range
		 *                                  [0..9]
		 */
		void add(int row, int col, int digit);

		/**
		 * Removes digit in the row, col.
		 * 
		 * @param row   The row
		 * @param col   The column
		 * @throws IllegalArgumentException if row, col or digit is outside the range
		 *                                  [0..9]
		 */
		
		void remove(int row, int col);
		
		
		/**
		 * Removes digit in the row, col.
		 * 
		 * @param row   The row
		 * @param col   The column
		 * @param nbr	The value
		 * @throws IllegalArgumentException if row, col or digit is outside the range
		 *                                  [0..9]
		 * @return true if it is possible to add, false if it's not.
		 */
		public boolean tryAdd(int row, int col, int nbr);
		
		/**
		 * Tells if the position has a number or not.
		 * 
		 * @param row   The row
		 * @param col   The column
		 * @throws IllegalArgumentException if row, col or digit is outside the range
		 *                                  [0..9]
		 * @return true if the position has a number, false if it's not.
		 */
		boolean hasNbr(int row, int col);

		/**
		 * Obtains digit in the row, col.
		 * 
		 * @param row   The row
		 * @param col   The column
		 * @throws IllegalArgumentException if row, col or digit is outside the range
		 *                                  [0..9]
		 */
		int get(int row, int col);

		/**
		 * Checks that all filled in digits follows the the sudoku rules
		 * @return true if sudoku is solvable, false if it's not
		 */
		boolean isValid();

		/**
		 * Removes all the digit on the board.
		 */
		void clear();

		/**
		 * Fills the grid with the digits in m. The digit 0 represents an empty box.
		 * 
		 * @param m the matrix with the digits to insert
		 * @throws IllegalArgumentException if m has the wrong dimension or contains
		 *                                  values outside the range [0..9]
		 */
		void setMatrix(int[][] m);

		/**
		 * Returns the board
		 * @return the board
		 */
		int[][] getMatrix();
		
		
		/**
		 * If the board is empty or not
		 * @return true if it is empty, returns false if it's not
		 */
		boolean isEmpty();
		
		/**
		 * Returns number of columns in the board.
		 * @return number of columns
		 */
		int getCol();
		
		/**
		 * Returns number of row in the board.
		 * @return number of rows
		 */
		int getRow();
}