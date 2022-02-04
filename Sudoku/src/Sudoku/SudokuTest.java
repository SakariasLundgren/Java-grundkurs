package Sudoku;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokuTest {
	private SudokuBoard sudokuGame;
	private SudokuBoard sudokuGameComp; 
	private int [][] solvableSudoku = {{0,0,8,0,0,9,0,6,2}, {0,0,0,0,0,0,0,0,5}, {1,0,2,5,0,0,0,0,0}, {0,0,0,2,1,0,0,9,0}, 
			{0,5,0,0,0,0,6,0,0}, {6,0,0,0,0,0,0,2,6}, {4,1,0,6,0,8,0,0,0}, {8,6,0,0,3,0,1,0,0}, {0,0,0,0,0,0,4,0,0}};
	private int [][] unsolvableSudoku = {{1,2,3,4,5,6,0,0,0},{0,0,0,0,0,0,7,0,0}};
	

	@BeforeEach
	void setUp() {
		sudokuGame = new SudokuBoard(9, 9);
		sudokuGameComp = new SudokuBoard(9,9);
	}
	
	@AfterEach
	void tearDown() {
		this.sudokuGame = null;
	}
	
	
	@Test
	void testEmpty() {
		assertTrue(sudokuGame.isEmpty(), "Expected true, got false");
		sudokuGame.tryAdd(2, 3, 5);
		assertFalse(sudokuGame.isEmpty(), "Expected false, got true");
	}
	
	void testGetCol() {
		assertEquals(sudokuGame.getCol(), 9, "Expected 9, but got" + sudokuGame.getCol());
	}
	
	void testGetrow() {
		assertEquals(sudokuGame.getRow(), 9, "Expected 9, but got " + sudokuGame.getRow());
	}
	
	void testGetAndAdd() {
		sudokuGame.tryAdd(1, 3, 7);
		assertEquals(sudokuGame.get(1, 3), 7, "Expected 7, got " + sudokuGame.get(1, 3));
	}
	
	void testRemove() {
		sudokuGame.remove(2, 3);
		assertEquals(sudokuGame.get(2, 3), 0, "Expected 0, got " + sudokuGame.get(2, 3));
	}
	
	void testClear() {
		sudokuGame.tryAdd(4, 5, 7);
		sudokuGame.clear();
		assertTrue(sudokuGame.isEmpty(), "Expected true, got false");
	}
	
	void testGetMatrix() {
		sudokuGameComp.tryAdd(1, 1, 5);
		sudokuGame.tryAdd(1, 1, 5);
		assertEquals(sudokuGame.getMatrix(), sudokuGameComp);
	}
	
	void testsSetMatrix() {
		sudokuGame.setMatrix(this.solvableSudoku);
		assertEquals(sudokuGame.getMatrix(), solvableSudoku, "Expected same, but the matrixes where different");
	}
	
	void testIsValid() {
		assertTrue(sudokuGame.isValid(), "Expected true, got false");
	}
	
	void testSolve() {
		assertTrue(sudokuGame.solve(), "Expected true, got false");
	}
	
	void testSameNumbers() {
		sudokuGame.clear();
		sudokuGame.tryAdd(0, 0, 1);
		assertFalse(sudokuGame.tryAdd(0, 4, 1), "System didn't recognice same number on row");
		assertFalse(sudokuGame.tryAdd(1, 2, 1), "System didn't recognice same number in box");
		assertFalse(sudokuGame.tryAdd(4, 0, 1), "System didn't recognice same number on col");
	}
	
	void testUnsolvable() {
		sudokuGame.setMatrix(unsolvableSudoku);
		assertFalse(sudokuGame.solve(), "Expected false, got true");
	}
	
	
	void testEmptySudoku() {
		sudokuGame.clear();
		assertTrue(sudokuGame.solve(), "Expected true, got false");
	}

}
