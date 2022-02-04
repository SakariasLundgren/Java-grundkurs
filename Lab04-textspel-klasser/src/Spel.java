import java.util.Scanner;
import java.util.Random;

public class Spel {
	private Random rand = new Random();
	private Scanner scan = new Scanner(System.in);
	private int svar; //Hålla koll på rätt svar
	private int guess; //användarens svar
	private int highestNbr; //Högsta numret man kna gissa på
	private int retry; //Hur många försök det tog för att få rätt svar
	
	public Spel (int nbr) {
		svar = rand.nextInt(nbr);
		highestNbr = nbr;
		
	}
		public void startaSpel() {
		System.out.println("Vilket tal gissar du på? Kom ihåg att det lägsta talet är 0, och högsta är " + highestNbr);
		retry = 1;
		do
		{
			guess = scan.nextInt();
			if(guess<svar) {
				System.out.println("Din gissning " + guess + " är tyvärr för lågt, gissa igen");
				retry++;
			} 
			else if(guess>svar) {
				System.out.println("Din gissning " + guess + " är tyvärr för högt, gissa igen");
				retry++;
			}
			else if (guess>highestNbr) {
				System.out.println("Din gissning är för hög");
				retry++;
			}
		  
		} while (guess != svar);
		
		System.out.println("Grattis! Du gissade " + guess + " vilket va rätt");
		}
		
		public int getRetry(){
			return retry;
		}
	}
	
	

