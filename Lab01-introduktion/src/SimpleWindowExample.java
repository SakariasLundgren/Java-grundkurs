
import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;
public class SimpleWindowExample {

	public static void main(String[] args) {
	SimpleWindow w = new SimpleWindow(500, 500, "Drawing Window");
	w.moveTo(100, 100);
	Color myColor = new Color(40, 240, 240); //Ändrar färg på kvadraten
	w.setLineColor(myColor);
	w.lineTo(150, 100);
	w.lineTo(150, 150);
	w.lineTo(100, 150);
	int Storlek = w.getLineWidth();
	System.out.println(Storlek);
	w.setLineWidth(10); //Påverkar enbart linjer som ritas, inte text som skrivs
	w.lineTo(250, 50);
	w.writeText("Hej Hej"); //Skriver ut texten "Hejhej"
	}

}
