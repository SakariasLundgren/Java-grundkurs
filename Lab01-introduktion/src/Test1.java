import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
	//max 40
	//mer än 35.5 p ger 5a
	//mer än 29 ger 4a
	//20 poäng ger 3a
	//under 20 ger U
		
	Scanner scan = new Scanner(System.in);
	System.out.println("Skriv in dina poäng");
	double p = scan.nextDouble();
	
	if(p>40)
	{
		System.out.println("Det går tyvärr inte att ha " + p + " poäng, max är 40");
	}
	else if(p<0)
	{
		System.out.println("Du kan inte ha negativa poäng");
	}
	else if(p>=35.5)
	{
		System.out.println("Grattis! Du fick " + p + ", vilket betyder att du fick en femma!");
	}
	else if(p>=29)
	{
		System.out.println("nice man, en fyra");
	}
	else if(p>=20)
	{
		System.out.println("En 3a");
	}
	else
	{
		System.out.println("Du misslyckades tyvärr");
	}
	}

}
