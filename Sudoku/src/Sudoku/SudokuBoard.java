package Sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuBoard implements SudokuSolver{
	private int [][] board;
	private int col;
	private int row;
	
	public SudokuBoard(int row, int col) {
		this.board = new int[row][col];
		this.row = row;
		this.col = col;
	}

	@Override
	public boolean solve() {
		return solve(0, 0);
	}
	
	private boolean solve(int row, int col) {
		
		/** 
		 * Kollar om row, col har en siffra.
		 * Om den inte innehåller en siffra går den vidar till nästa ruta.
		 */
		if(!hasNbr(row, col)) {
			
			//Siffrorna som ska läggas till på i board
			for(int i = 1; i<10; i++) {
				
				//Försöker lägga till siffran i. Om inte den går testar man nästa siffra.
				if(tryAdd(row, col, i)) {
					
					if(col < 8) {
                        if (solve(row, col + 1)) {
                            return true;
                        }
                    } else if (row < 8) {
                        if (solve(row + 1, 0)) {
                            return true;
                        }
                    } else if (col == 8 && row == 8) {
                        return isValid();
					}
				}
				
			}
			
			
			/* 
			 * Om det ej går att lösa sudoku med siffrorna på brädan
			 */
			remove(row, col);
			return false;
		} else {
			
			/*
			 * Om det redan stod en siffra på platsen går man vidar till nästa
			 * Om sista rutan innehåller en siffra fångas detta fallet upp av "else"
			 */
			 if (col < 8) {
	            return solve(row, col + 1);
	         } else if (row < 8) {
	            return solve(row + 1, 0);
	         } else {
	        	 return isValid();
	         }
		}
	}
	
	
	//Om man kan addera en siffra till en ruta,
	@Override
	public boolean tryAdd(int row, int col, int nbr) {
			/** 
			 * Här kommer siffrorna som man kan lägga till på platsen row och col tas reda på
			 * Man kollar vågrätt, lodrätt och i rutan man befinner sig i
			 */
			
			//Siffrorna vågrätt läggs till i listan.
			for(int c = 0; c < this.col; c++) {
				if(board[row][c] == nbr) {
					return false;
				}
			}
			
			//Siffrorna lodrätt
			for(int r = 0; r < this.row; r++) {
				if(board[r][col] == nbr) {
					return false;
				}
			}
			
			/*
			 * Siffrorna i rutan
			 * Då mod 3 beskriver var dom befinner sig i rutan tar vi enbart
			 * bort hur många "steg" in row är för att sedan addera 0->3
			 * för att kolla igenom hela rutan.
			 */
			for(int r = 0; r < 3; r++) {
				for(int c = 0; c < 3; c++) {
					if(board[row - (row % 3) + r][col - (col % 3) + c] == nbr) {
						return false;
					}
				}	
			}
			
			//Om nbr upfyller kraven läggs den till
			add(row, col, nbr);
			return true;	
	}
	
	// Returnerar true om det finns något i den rutan
	@Override
	public boolean hasNbr(int row, int col) {
		if(board[row][col] == 0) {
			return false;
		}
		return true;
	}
	
	//retrurnerar värdet på platsen row och col
	@Override
	public int get(int row, int col) {
		return board[row][col];
	}
	
	//Om brädan följer alla sudoku regler
	@Override
	public boolean isValid() {
		if(!isHorizontalValid()) {
			return false;	
		} else if(!isVerticalValid()) {
			return false;
		} else if(!isBoxValid()) {
			return false;
		}
		return true;
	}
	
	//Kollar om sudokut följer reglerna vågrätt
	private boolean isHorizontalValid() {
		Set<Integer> horiSet = new HashSet<Integer>();
		for(row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				if(board[row][col] != 0) {
					if(horiSet.add(board[row][col]) == false) {
						System.out.println("1");
						return false;
					}
				}
			}
			horiSet.clear();
		}
		return true;
	}
	
	//Kollar om sudokut följer reglerna lodrätt
	private boolean isVerticalValid() {
		Set<Integer> vertSet = new HashSet<Integer>();
		for(int col = 0; col < 9; col++) {
			for(int i = 0; i < 9; i++) {
				if(board[i][col] != 0) {
					if(vertSet.add(board[i][col]) == false) {
						System.out.println("2");
						return false;
					}
				}
			}
			vertSet.clear();
		}
		return true;
	}
	
	//Kollar om sudokut följer reglerna i ruterna
	private boolean isBoxValid() {
		Set<Integer> boxSet = new HashSet<Integer>();
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
					for(int i = 0; i < 3; i++) {
						for(int j = 0; j < 3; j++) {
							if(board[row*3 + i][col*3 + j] != 0) {
								if(boxSet.add(board[row*3 + i][col*3 + j]) == false) {
									System.out.println("3");
									return false;
								}
							}
						}	
					}
					boxSet.clear();
				}
			}
		return true;
	}
	
	
	//Tar bort ett värde från brädan
	@Override
	public void remove(int row, int col) {
		board[row][col] = 0;
	}
	
	//Returnerar antalet col
	@Override
	public int getCol() {
		return col;
	}
	
	//Returnerar antalet row
	@Override
	public int getRow() {
		return row;
	}
	
	//Ändrar bärdan till matrisen "m"
	@Override
	public void setMatrix(int [][] m) {
		board = m;
	}
	
	//Returnerar matrisen
	@Override
	public int [][] getMatrix() {
		return board;
	}
	
	//Tar bort allt på brädan
	@Override
	public void clear() {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				remove(row, col);
			}
		}
	}
	
	//Gick inte att göra private, då man egentligen ska alltid använda "tryAdd"
	@Override
	public void add(int row, int col, int nbr) {
		//Lägger till siffran som önskas
		this.board[row][col] = nbr;
	}
	
	//Om brädan är tom 
	@Override
	public boolean isEmpty() {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				if(board[row][col] != 0) {
					return false;
				}
			}
		}	
		return true;
	}

}
