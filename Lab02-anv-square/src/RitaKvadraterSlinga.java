import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class RitaKvadraterSlinga {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(800, 800, "RitaKvadrater");
		int oldX = 0; // Veta var förra punkten var
		int oldY = 0;
		int distXledKuber = 0; // Distansen i x led mellan kuberna
		int distYledKuber = 0; // Distansen i y led mellan kuberna
		int x = 0; // Var det nya klicket finns
		int y = 0;
		int yDist = 0; // Distansen mellan gamla och nya punkten
		int xDist = 0;

		while (true) {
			w.waitForMouseClick();
			x = w.getClickedX();
			y = w.getClickedY();
			xDist = x - oldX;
			yDist = y - oldY;
			int distNew2Old = (int) Math.sqrt(xDist * xDist + yDist * yDist); // distansen mellan punkterna
			Square sq2 = new Square(x, y, 100); // Skapa en ny kub där man klickar
			sq2.draw(w);
			int Distance = distNew2Old / 10; // Antalet kuber som kan placera med 10 pixlars mellanrum
			for (int i = 0; i < 10; i++) {
				sq2.move(x + Distance*i, y + Distance*i);
			}
			oldY = y; // Korrigera om gamla punkten
			oldX = x;
		}

	}

}
