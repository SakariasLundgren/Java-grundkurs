package memory;

public class MemoryGame {
	
	private static int oldX = 0;
	private static int oldY = 0;
	private static int cardsSelected = 0;
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		MemoryBoard memory = new MemoryBoard (4,"back.jpg", frontFileNames);
		MemoryWindow w = new MemoryWindow (memory);
		w.drawBoard();
		
		while(memory.hasWon() == false) {
			w.waitForMouseClick();
			if(memory.frontUp(w.getMouseRow(), w.getMouseCol()) == false) {
				memory.turnCard(w.getMouseRow(), w.getMouseCol());
				w.drawCard(w.getMouseRow(),w.getMouseCol());
				cardsSelected++;
			} 
			if(cardsSelected == 2) {
				if(memory.same(oldY, oldX, w.getMouseRow(), w.getMouseCol())==false) {
					w.delay(1000);
					memory.turnCard(oldY, oldX);
					memory.turnCard(w.getMouseRow(), w.getMouseCol());
					w.drawCard(w.getMouseRow(),w.getMouseCol());
					w.drawCard(oldY,oldX);
					cardsSelected = 0;
				} else {
					cardsSelected = 0;
				}
				
			}
			oldX = w.getMouseCol();
			oldY = w.getMouseRow();
			
		}
		System.out.print("Grattis! Du klarade det!");
	}
}
