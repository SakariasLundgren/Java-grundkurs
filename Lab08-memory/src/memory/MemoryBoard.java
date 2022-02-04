package memory;

import java.util.Random;

public class MemoryBoard {
	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	Random rnd = new Random();
	private int size = 0;
	private int c = 0;
	private int r = 0;
	private int correct = 0;
	private boolean [][] turned = new boolean [4][4];	
	MemoryCardImage [][] Cards = new MemoryCardImage [4][4];
	
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		createCards(backFileName, frontFileNames);
		}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {
		for(int i = 0; i <= 7; i++) {
			MemoryCardImage Card = new MemoryCardImage(frontFileNames[i], backFileName);
				c = rnd.nextInt(size);//Placera ut första kortet
				r  = rnd.nextInt(size);
				while(Cards[r][c] != null) {
					c = rnd.nextInt(size);
					r  = rnd.nextInt(size);
				}
				Cards [r][c] = Card;
			
				c = rnd.nextInt(size); //placera ut andra kortet
				r  = rnd.nextInt(size);
				while(Cards[r][c] != null) {
					c = rnd.nextInt(size);
					r  = rnd.nextInt(size);
				}
				Cards [r][c] = Card;
		
		}
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return Cards [r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if(turned[r][c] == false) {
			turned[r][c] = true;
		} else {
		turned [r][c] = false;
		}
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		if (turned [r][c] == true) {
			return true;
		} else {
			return false;	
		}
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		if(Cards[r1][c1].equals(Cards[r2][c2])==true) { 
			return true;
		} else {
			return false;
		}
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for(int i = 0; i < 4; i++  ) {
			for(int p = 0; p < 4 ; p++) {
				if (frontUp(i,p) == true) {
					correct++;
				}
			}
		}
		if(correct == 16) {
			return true;
		} else {
			correct = 0;
			return false;
		}
	
	}	
}
