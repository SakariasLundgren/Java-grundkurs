import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class RitaKvadrater {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "RitaKvadrater");
		Square sq1 = new Square(250, 250, 100);
		
		while(true)
		{
			w.waitForMouseClick();
			sq1.erase(w);
			Square sq2 = new Square (w.getClickedX(), w.getClickedY(), 100);
			sq1 = sq2; //För att den kvadraten som redan är på skärmen ska tasbort varje gång jag klickar
			sq1.draw(w);
		}
		

	}

}
