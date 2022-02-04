import java.util.ArrayList;

public class TurtleRace {

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> s1 = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> s1Finished = new ArrayList<RaceTurtle>();
		for(int i = 0; i < 8; i++) {
				s1.add(i, new RaceTurtle(w, i+1));	
		}
		while(s1.isEmpty() == false) {
			for(int i = 0; i < s1.size(); i++) {
				s1.get(i).raceStep();
				RaceWindow.delay(5);
				if(s1.get(i).getX() >= w.X_END_POS) {
					s1Finished.add(s1.get(i));
					s1.remove(i);
					i--;
				}
			}
		}
		for(int i = 0; i < 8; i++) {
			System.out.println("På plats " + (i + 1) + ": " + s1Finished.get(i).toString()); 
		}
	}

}
