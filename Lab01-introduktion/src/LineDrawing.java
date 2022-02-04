import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 0);
		while (true) { //För att kunna rita många sträckor
			w.waitForMouseClick(); //Invänta användarens musklilck
			int X = w.getClickedX(); //Tar reda på var musen befinner sig 
			int Y = w.getClickedY();
			w.lineTo(X, Y); //rita en linje från sista punkten till där användaren klickade
		}
	}
}
