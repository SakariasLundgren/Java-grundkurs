
public class TestAvLoopar {

	public static void main(String[] args) {
    int nbr1 = 2;
    int sum = 0;
     while(nbr1<50)
     {
    	 sum = nbr1 + sum;
    	 nbr1 = nbr1 + 2;
     }
     System.out.println(sum);
     
     sum = 0;
     
     for (int nbr2 = 2; nbr2<50; nbr2 = nbr2 + 2)
     {
    	 sum = sum + nbr2;
     }
     System.out.println(sum);
	}

}
