import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {

	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	private double x;
	private double y;
	private double x1; //koordinaten som "turtle" är på efter man har rört sig frammåt
	private double y1; 
	private boolean draw = false;
	private double beta = Math.toRadians(90);
	private int grader = 90;
	private SimpleWindow W;
	
	public Turtle(SimpleWindow w, int x, int y) {
		this.x = x;
		this.y = y;
		this.W = w;
		W.moveTo(x, y);
	}

	/** Sänker pennan. */
	public void penDown() {
		draw = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		draw = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		x1 = x + n*Math.cos(beta);
		y1 = y - n*Math.sin(beta);
 		if(draw == true) {
 			W.moveTo((int)x,(int)y);
			W.lineTo((int) Math.round(x1), (int) Math.round(y1));
		}
		else if(draw == false) {
			W.moveTo((int) Math.round(x1), (int) Math.round(y1));
		}
		x = x1;
		y = y1;
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		this.beta = this.beta + Math.toRadians(beta);
		grader = grader + beta;
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
		
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		beta = Math.toRadians(90);
		grader = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return grader;
	}
 	
}
