
public class Interface {
	int [] [] board;
	
	public Interface(int boardSize) {
		board = new int [boardSize][boardSize];
	}
	
	public void add(int nbr, int x, int y) {
		board [x][y] = nbr;
	}
}
