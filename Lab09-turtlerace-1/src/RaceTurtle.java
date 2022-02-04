import java.util.Random;
public class RaceTurtle extends Turtle{
	Random rnd = new Random();
	int nbr;
	
	public RaceTurtle (RaceWindow w, int nbr) {
		super(w,w.getStartXPos(nbr),w.getStartYPos(nbr));
		left(270);
		penDown();
		this.nbr = nbr;
	}
	
	void raceStep() {
		forward(rnd.nextInt(6)+1);
	}
	
	public String toString() {
		String nummer = "Nummer " + Integer.toString(nbr); 
		return nummer;
	}
}
