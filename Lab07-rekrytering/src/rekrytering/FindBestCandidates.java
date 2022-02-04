package rekrytering;

import java.util.Arrays;

public class FindBestCandidates {
	private static final double MIN_AVG_GRADE = 4.0;

	public static void main(String[] args) {
		// Läs från fil (Börja med "applications_small.txt), spara resultatet i en
		// vektor

		// Skicka in Applicant-vektorn (som du fick i föregående steg) till metoden
		// findBestCandidiates (nedan)
		// Spara resultatet i en vektor

		// Printa resultatet från findBestCandidates
		
		FileReader file = new FileReader();
		Applicant[] Applicants1 = new Applicant[232];
		Applicant [] bestApplicants1 = new Applicant [200];
		Applicants1 = file.readFromFile("applications_x.txt", 232);
		System.out.println("Dom bästa applicants");
		bestApplicants1 = findBestCandidates(Applicants1);
		for(int i = 0; i < 100; i++) {
			System.out.println(bestApplicants1[i]);
		}
		
	}

	public static Applicant[] findBestCandidates(Applicant[] applicants) {
		// Hitta alla kandidater som har medelbetyg över MIN_AVG_GRADE
		// Lagra alla dessa kandidater i en vektor, returnera vektorn
		 //Byt ut denna rad mot hela din egen lösning
		Applicant[] bestApplicants  = new Applicant[150]; 
		int n = 0;
		for(int i = 0; i < 232; i++) {
			if(applicants[i] != null && applicants[i].getAvgGrade() > MIN_AVG_GRADE) {
				bestApplicants[n] = applicants[i]; 
				n++;
			}
			//Array.sort(bestApplicants); funkar inte då jag får felmedelanden
		}
		return bestApplicants;
	}
}
