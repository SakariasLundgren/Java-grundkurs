import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class AnimatedSquare {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(800, 800, "RitaKvadrater");
		Square sq1 = new Square(0, 0, 100); // Skapa en ny kub där man klickar
		int oldX = 0; // Veta var förra punkten var
		int oldY = 0;
		int x = 0; // Var det nya klicket finns
		int y = 0;
		int yDist = 0; // Distansen mellan gamla och nya punkten
		int xDist = 0;

		while (true) {
			w.waitForMouseClick();
			sq1.erase(w);
			x = w.getClickedX();
			y = w.getClickedY();
			xDist = x - oldX;
			yDist = y - oldY;
			//int distNew2Old = (int) Math.sqrt(xDist * xDist + yDist * yDist); // distansen mellan punkterna
			//int Distance = distNew2Old/10;
			for (int i = 1; i < 11; i++) {
				sq1.move(xDist/10, yDist/10);
				sq1.draw(w);
				SimpleWindow.delay(100);
				sq1.erase(w);
			} 
			oldY = y; // Korrigera om gamla punkten
			oldX = x;
			sq1.draw(w);
		}

	}

}
