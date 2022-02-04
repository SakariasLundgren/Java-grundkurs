package rekrytering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	/**
	 * Returnerar max nbrOfRows rader från filen som en vektor av Applicant-objekt.
	 * Läser i filen tills det inte finns fler rader eller tills man läst nbrOfRows
	 * rader (det som inträffar först). 
	 * Returnerar null om filen inte finns.
	 */
	
	public static Applicant[] readFromFile(String fileName, int nbrOfRows) {
		Scanner scan;
		Applicant[] Applicants = new Applicant[nbrOfRows];
		int nbrValue = 0;
		try {
			scan = new Scanner(new File(fileName), "utf-8");
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + fileName);
			e.printStackTrace();
			return null;
		}
		//Här kan du använda Scannern för att läsa från filen fileName.
		//Varje rad motsvarar en Applicant. Kontrollera vad Applicants konstruktor kräver
		//Alla Applicant-objekt (max nbrOfRows stycken) ska lagras i en Applicant-vektor och returneras på slutet
		while (scan.hasNext() == true) {
			String s = scan.nextLine();
			String [] splits = s.split(" ");
				if(splits[2].contains("A") == true) { //lite chesse, men funar, hade behövt flertal if satser.
					splits[2] = splits[2].replaceAll("A", "5");
					splits[2] = splits[2].replaceAll("B", "5");
			} 
			Applicant ap = new Applicant(splits[0] + " " + splits[1] + " ", splits[2]);
			Applicants[nbrValue] = ap;
			nbrValue++;
		}
		return Applicants;
	}
}
