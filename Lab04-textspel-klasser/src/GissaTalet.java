import java.util.Scanner;

public class GissaTalet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nbrVal;
		String forts;
		do {
			System.out.println("Fyll i mellan vilka siffror du vill gissa mellan");
			nbrVal = scan.nextInt();
			Spel start = new Spel(nbrVal);
			start.startaSpel();
			System.out.println("Det tog dig "+ start.getRetry() + " försök att få rätt svar. Vill du köra en runda till");
			forts = scan.next();
		} while(forts.equalsIgnoreCase("ja") == true);
		
	}

}
