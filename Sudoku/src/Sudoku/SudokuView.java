package Sudoku;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class SudokuView {
	private JTextField [][] fields;
	private JPanel sudokuPanel;
	private SudokuBoard board;
	private int dim;
	private String val;
		
	public SudokuView(String title, int width, int height, SudokuBoard b) {
		this.board = b;
		this.dim = 9;
		fields = new JTextField[dim][dim];
		SwingUtilities.invokeLater(() -> createWindow(title, width, height));
	}
	
	private void createWindow(String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container pane = frame.getContentPane();
		
		sudokuPanel = new JPanel(new GridLayout(dim, dim));
		this.buildBoard(dim, true, false);
		
		//Lägger till båda knapparna
		JButton solveBTN = new JButton("Solve");
		JButton clearBTN = new JButton("Clear");
		
		solveBTN.addActionListener((e) -> {
			
			//Konvertera värden som skrivits till "board" 
			int [][] values = new int[9][9];
			for(int row = 0; row < 9; row++) {
				for(int col = 0; col < 9; col++) {
					if(fields[row][col].getText().length() == 0) {
						values[row][col] = 0;
					} else {
						try {
						
							//om siffran är för hög.
							if(Integer.parseInt(fields[row][col].getText()) > 9) {
								JOptionPane.showMessageDialog(frame, "Enbart siffror 1-9 är tillåtna", "Error", JOptionPane.ERROR_MESSAGE);
								fields[row][col].requestFocus();
								fields[row][col].selectAll();
								return;
							}
							values[row][col] = Integer.parseInt(fields[row][col].getText());
						} 
					
						//Om man t.ex. har skrivit in ord
						catch (Exception w){
							JOptionPane.showMessageDialog(frame, "Enbart siffror 1-9 är tillåtna", "Error", JOptionPane.ERROR_MESSAGE);
							fields[row][col].requestFocus();
							fields[row][col].selectAll();
							return;
							}
						}
					}
				}
				board.setMatrix(values);
				
				if(board.isValid()) {
			
					//Lösa sudokut när bräda är lösbar.
					if(board.solve()) {
						buildBoard(9, false, false);
						JOptionPane.showMessageDialog(frame, "Sudokut gick att lösa");
					} else {
						JOptionPane.showMessageDialog(frame, "Sudokut går ej att lösa", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} else {
					JOptionPane.showMessageDialog(frame, "Sudokut går ej att lösa, lol", "Error", JOptionPane.ERROR_MESSAGE);
		}
			
		});
		
		clearBTN.addActionListener((e) -> {
			buildBoard(9, false, true);		
		});
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(solveBTN, BorderLayout.EAST);
		btnPanel.add(clearBTN, BorderLayout.EAST);

		pane.add(sudokuPanel, BorderLayout.NORTH);
		pane.add(btnPanel, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void buildBoard(int dim, boolean first, boolean clear) {
		if(clear ) {
			board.clear();
		}
		
		//Visar brädan hur den ser ut 
		for (int row = 0; row < dim; row++) {
			for(int col = 0; col < dim; col ++) {
				int nbr = this.board.get(row, col);
				
				if(nbr == 0) {						
					val = "";
				} else {
					val = "" + nbr;
				}	
					
				//Enbart för att "bygga" bräda
				if (first) {
					fields[row][col] = new JTextField("");
					fields[row][col].setPreferredSize(new Dimension(50,50));
					fields[row][col].setHorizontalAlignment(SwingConstants.CENTER);
					fields[row][col].setFont(new Font("Courier", Font.BOLD, 30));
					sudokuPanel.add(fields[row][col]).setLocation(row, col);
					
					//Färgerna på rutorna ska vara korrekt.
					if(row/3 == 1 && col/3 !=1) {
						fields[row][col].setBackground(Color.WHITE);
					} else if(row/3 != 1 && col/3 == 1) {
						fields[row][col].setBackground(Color.WHITE);
					} else {
						fields[row][col].setBackground(Color.ORANGE);
					}
					
				}
				
				//Stoppar in alla siffror ifrån board.
				fields[row][col].setText(val);
			}
		}
	}
}
