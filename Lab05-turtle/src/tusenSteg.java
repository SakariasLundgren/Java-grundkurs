import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;

public class tusenSteg {

	public static void main(String[] args) {
		int n;
		int steg = 0;
		int alpha;
		Random rand = new Random();
		SimpleWindow w = new SimpleWindow(600,600,"tusenSteg");
		Turtle t1 = new Turtle(w, 300, 300);
		t1.penDown();
		while (steg<999) {
			if(1000-steg<10) { //för att den ska gå exakt 1000 steg
				n = 1000-steg;
			}
			else {
				n = rand.nextInt(10);
			}
			steg = steg + n;
			t1.forward(n);
			alpha = rand.nextInt(180);
				if(rand.nextDouble()<0.5) {
					alpha = -alpha;
				}
			t1.left(alpha);
		}
		System.out.println();

	}

}
