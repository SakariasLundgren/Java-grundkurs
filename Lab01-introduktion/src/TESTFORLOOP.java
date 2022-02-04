import java.util.Scanner;

public class TESTFORLOOP {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int limit = scan.nextInt();
		int lower = 0;
		int higher = 0;
		for(int i = 0; i<10; i++)
		{
			int nbr = scan.nextInt();
			if(nbr>limit)
			{
				higher = higher + nbr;
			}
			else if (nbr<limit)
			{
				lower = lower + nbr;
			}
		}
		System.out.println(lower);
		System.out.println(higher);
	}

}
