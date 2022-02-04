package rekrytering;

import java.util.Arrays;

public class Applicant implements Comparable<Applicant> {
	//Varje sökande har ett namn och ett antal betyg
	private String name;
	private int[] grades;
	private double avg = 0;
	private int n = 0;

	public Applicant(String name, String gradesAsString) {
		this.name = name;
		// Har flyttat tolkningen av betygen till en privat hjälpmetod för att hålla
		// konstruktorn kortare
		// Anropa denna och skicka vidare parametern som innehåller betygen
		parseGrades(gradesAsString);
	}

	private void parseGrades(String gradesAsString) {
		// gradesAsString har formatet x,y,z,q där respektive bokstav är ett betyg
		// Om vi splittar strängen på komma (",") hamnar varje betyg i en vektor
		String[] g = gradesAsString.split(",");
		// Skapa vektorn med heltal
		grades = new int[g.length];
		// Iterera över alla betyg för att översätta dessa till ett heltal
		for (int i = 0; i < g.length; i++) {
			if (g[i].equals("U")) {
				// Om underkänd så räknar vi det som en nolla
				grades[i] = 0;
			} else {
				grades[i] = Integer.parseInt(g[i]);
			}
		}
	}

	public double getAvgGrade() {
		n = 0;
		avg = 0;
		for(int i = 0; i < grades.length; i++) {
			avg = avg + grades[i];
			n = i;
		}
		return avg/(n+1); 
	}

	
	  //Implementera denna när labbeskrivningen kräver det 
	  public String toString() {
	      String nameGrade = name + Arrays.toString(grades) +  " (avg: " + getAvgGrade()+ ")";
	      return nameGrade;
	  }
	 

	/*
	 * Metod för att jämföra detta Applicant-objekt med ett annat och få ut vilket
	 * som är störst. Retunerar något > 0 om detta objektet är störst. Returnerar något < 0 om other är störst och returnerar 0 om objekten är lika.
	 * Används av javas inbyggda sorteringsmetoder
	 */
	public int compareTo(Applicant other) {
		// Om exakt samma objekt
		if (other == this) {
			return 0;
		}
		// Annars jämför snittbetyget i första hand
		int gradeRes = (int) Math.round((getAvgGrade() - ((Applicant) other).getAvgGrade()) * 100);
		if (gradeRes == 0) {
			// Om snittbetyget är samma, låt namnet avgöra på namnet
			return name.compareTo(((Applicant) other).name);
		}
		return gradeRes;
	}
}
