package rekrytering;

public class Main {

	public static void main(String[] args) {
		FileReader file = new FileReader();
		Applicant[] Applicants1 = new Applicant[7];
		Applicants1 = file.readFromFile("applications_small.txt", 7);
		for(int i = 0; i < 7; i++) {
			System.out.println(Applicants1[i]);
		}

	}

}
