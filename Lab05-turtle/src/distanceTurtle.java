import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;

public class distanceTurtle {

	public static void main(String[] args) {
		int n;
		int distance = 100000; // måste ändra till korrekta sen
		int distanceX;
		int distanceY;
		int alpha;
		Random rand = new Random();
		SimpleWindow w = new SimpleWindow(600,600,"tusenSteg");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		t1.penDown();
		t2.penDown();
		while(distance >= 2500) {
			
			n = rand.nextInt(10); //sköldpadda ett
			t1.forward(n);
			alpha = rand.nextInt(180);
			if(rand.nextDouble()<0.5) {
				alpha = -alpha;
			}
			t1.left(alpha);
		
			n = rand.nextInt(10); //sköldpadda två
			t2.forward(n);
			alpha = rand.nextInt(180);
			if(rand.nextDouble()<0.5) {
				alpha = -alpha;
			}
			t2.left(alpha);
			distanceX = t1.getX()-t2.getX();
			distanceY= t1.getY() - t2.getY();
			distance = distanceX*distanceX + distanceY*distanceY;//säkert fel distans beräkning
			SimpleWindow.delay(10);
			System.out.println(distance);
		}

	}

}
