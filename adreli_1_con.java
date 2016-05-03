import java.io.*;

import java.util.*;
import java.util.regex.Matcher;
/* 
 *
 *Autoren: 

 *Muraca, Kevin
 *Alueste, Onur
 *Ringler, Sabine
 *
 */
import java.util.regex.Pattern;

public class adreli_1_con {

	static boolean go_on = true;

	private static int persCounter = 0;

	public static String name;
	public static String vorname;
	public static String anrede;
	public static String strasse;
	public static String plz;
	public static String ort;
	public static String telefon;
	public static String fax;
	public static String bemerkung;

	static String newPers[] = new String[9]; // Array zum Erfassen
	static String myPers[][] = new String[9][20];// Array zum Auslesen

	public static ArrayList<Person> personen = new ArrayList<>();

	// Definition der Konstanten fuer den Arrayzugriff
	final static int NAME = 0;
	final static int VORNAME = 1;
	final static int ANREDE = 2;
	final static int STRASSE = 3;
	final static int PLZ = 4;
	final static int ORT = 5;
	final static int TELEFON = 6;
	final static int FAX = 7;
	final static int BEMERKUNG = 8;

	static Pattern stringregex = Pattern.compile("[A-Z]{1}[a-z]{1,}");
	static Pattern nummerregex = Pattern.compile("[0-9]{5,}");
	static Pattern anrederegex = Pattern.compile("(Herr|Frau)");
	static Pattern strasseregex = Pattern.compile("[A-Z][a-z]*\\.?\\s[0-9]");

	// Einlesen vom File// Einlesen vom File
	public static void main(String[] args) {
		while (go_on) {
			main_menu(); // Aufruf der Menue-Ausgabe

		}
	} // end of main()

	public static void main_menu() {
		int answer = 0;

		System.out.println("    ADRELI - Adressverwaltung   ");

		System.out.println("Wollen Sie... ");

		System.out.println("     eine neue Person aufnehmen : > 1");
		System.out.println("              Records auflisten : > 2");
		System.out.println("    Records in eine Datei laden : > 3");
		System.out.println("  Records aus einer Datei laden : > 4");
		System.out.println("    in-memory Records sortieren : > 5");
		System.out.println("                 Datei loeschen : > 6");
		System.out.println("         das Programm verlassen : > 7");

		answer = StdInput.readInt("\n");
		switch (answer) {

		case 1:
			funct_1();// in newPers[] AUFNEHMEN
			break;
		case 2:
			funct_2();
			break; // auf Konsole AUFLISTEN
		case 3:
			funct_3();
			break; // in Datei SICHERN
		case 4:
			funct_4();
			break; // aus Datei LADEN
		case 5:
			funct_5();
			break; // Datei SORTIEREN
		case 6:
			funct_6();
			break; // Datei LOESCHEN
		case 7:
			go_on = false;
			System.out.println("Das Programm wurde beendet.");
			break; // BEENDEN
		default:
			System.out.println("Keine gueltige Eingabe. Nur Zahlen von [1-7] sind erlaubt.");
		}
	} // end of main_menu()

	// AUSLESEN
	static void funct_1() // Achtung static-Methoden; die brauchen kein Objekt
	{
		// Definition symb. Konstanten fuer den Arrayzugriff


//		boolean ok = false;
		String auswahl = null ;
		int eingabe = 0;
		
		//ABFRAGE NAME
		
		boolean nameOK=false;
		do{ 
		name = StdInput.readString("Name:");
		newPers[0] = name;
		Matcher namematch = stringregex.matcher(newPers[0]);
		
		nameOK=namematch.matches();
		
		if(nameOK==false){
			System.out.println("\tBitte Namen korrekt eingeben."
								+ "\n\tBsp.: Mustermann");
		}
		}
		while (nameOK==false);
		
		//ABFRAGE VORNAME
			
		boolean vornameOK=false;
		do{ 
		vorname = StdInput.readString("Vorame:");
		newPers[1] = vorname;
		Matcher vornamematch = stringregex.matcher(newPers[1]);
		
		vornameOK=vornamematch.matches();
		
		if(vornameOK==false){
			System.out.println("\tBitte Vornamen korrekt eingeben."
								+ "\n\tBsp.: Peter");
		}
		}
		while (vornameOK==false);
		
		//ABFRAGE ANREDE

		boolean anredeOK=false;
		do{ 
		anrede = StdInput.readString("Anrede:");
		newPers[2] = anrede;
		Matcher anredematch = anrederegex.matcher(newPers[2]);
		
		anredeOK=anredematch.matches();
		
		if(anredeOK==false){
			System.out.println("\tBitte Anrede korrekt eingeben."
								+ "\n\tBsp.: Herr");
		}
		}
		while (anredeOK==false);
		
		//ABFRAGE STRASSE

		boolean strasseOK=false;
		do{ 
		strasse = StdInput.readString("Strasse:");
		newPers[3] = strasse;
		Matcher strassematch = strasseregex.matcher(newPers[3]);
		
		strasseOK=strassematch.matches();
		
		if(strasseOK==false){
			System.out.println("\tBitte Strasse korrekt eingeben."
								+ "\n\tBsp.: Bergweg 9");
		}
		}
		while (strasseOK==false);
		
		//ABFRAGE PLZ

		boolean plzOK=false;
		do{ 
		plz = StdInput.readString("PLZ:");
		newPers[4] = plz;
		Matcher plzmatch = nummerregex.matcher(newPers[4]);
		
		plzOK=plzmatch.matches();
		
		if(plzOK==false){
			System.out.println("\tBitte PLZ korrekt eingeben."
								+ "\n\tBsp.: 74120");
		}
		}
		while (plzOK==false);
		
		//ABFRAGE ORT

		boolean ortOK=false;
		do{ 
		ort = StdInput.readString("Ort:");
		newPers[5] = ort;
		Matcher ortmatch = stringregex.matcher(newPers[5]);
		
		ortOK=ortmatch.matches();
		
		if(ortOK==false){
			System.out.println("\tBitte Ort korrekt eingeben."
								+ "\n\tBsp.: Furtwangen");
		}
		}
		while (ortOK==false);
		
		//ABFRAGE TELEFON

		boolean telefonOK=false;
		do{ 
		telefon = StdInput.readString("Telefon:");
		newPers[6] = telefon;
		Matcher telefonmatch = nummerregex.matcher(newPers[6]);
		
		telefonOK=telefonmatch.matches();
		
		if(telefonOK==false){
			System.out.println("\tBitte Telefonnummer korrekt eingeben."
								+ "\n\tBsp.: 25367");
		}
		}
		while (telefonOK==false);
		
		//ABFRAGE FAX

		boolean faxOK=false;
		do{ 
		fax = StdInput.readString("Fax:");
		newPers[7] = fax;
		Matcher faxmatch = nummerregex.matcher(newPers[7]);
		
		faxOK=faxmatch.matches();
		
		if(faxOK==false){
			System.out.println("\tBitte FAX korrekt eingeben."
								+ "\n\tBsp.: 56478");
		}
		}
		while (faxOK==false);

			bemerkung = StdInput.readString("Bemerkung:");
			newPers[8] = bemerkung;

			 Scanner einlesen = new Scanner(System.in);
             
	            System.out.println("Stimmt's (J|N)");
	            auswahl = einlesen.next();
	            if (auswahl.equals("J")) {
	                person_append();
	                System.out.println("Noch eine Person aufnehmen?(J/N)");
	                auswahl = einlesen.next();
	                if(auswahl.equals("J")){
	                    funct_1();
	                     
	                }else{
	                    main_menu();
	                }
	            }else{
	                funct_1();
	            }
	        }
		
	
	// end of funct_1()

	// AUFLISTEN
	static void funct_2() {
		boolean ok;
		for (int i = 0; i < persCounter; i++) {

			System.out.println("Name: " + myPers[NAME][i]);
			System.out.println("Vorname: " + myPers[VORNAME][i]);
			System.out.println("Anrede: " + myPers[ANREDE][i]);
			System.out.println("Strasse: " + myPers[STRASSE][i]);
			System.out.println("PLZ: " + myPers[PLZ][i]);
			System.out.println("Ort: " + myPers[ORT][i]);
			System.out.println("Telefon: " + myPers[TELEFON][i]);
			System.out.println("Fax: " + myPers[FAX][i]);
			System.out.println("Bemerkung: " + myPers[BEMERKUNG][i]);
			if ((i + 1) < persCounter) {

				ok = ((StdInput.readString("Um fortzufahren weiter mit 'ENTER' | ABBRUCH mit beliebiger Taste"))).equals("\u2386");
				if (ok != true) {
					System.out.println("---------------");
//					main_menu();
				}

			} else {
				System.out.println("---------------");
				System.out.println("Ende der Liste.");
				main_menu();
			}
		}
	} // end of funct_2()

	// SPEICHERN
	static void funct_3() {
		final String NEWLINE = System.getProperty("line.separator");
		System.out.println("Daten werden gesichert...");
		try {
			/*** RandomAccessFile Solution zum Schreiben auf File ***/
			RandomAccessFile raf = new RandomAccessFile("personDB.csv", "rw");
			for (Person pers : personen) {
				raf.writeBytes(pers.name + ";" + pers.vorname + ";" + pers.anrede + ";" + pers.strasse + ";" + pers.plz
						+ ";" + pers.ort + ";" + pers.telefon + ";" + pers.fax + ";" + pers.bemerkung + NEWLINE);
			}
			raf.close();

			try {
				Thread.sleep(2500); // 1000 milliseconds is one second. 2500 =
									// 2.5 Sekunden
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			if (persCounter == 1) {
				System.out.println(persCounter + " Datei wurden gesichert." + NEWLINE);
			} else if (persCounter == 0) {
				System.out.println("Es wurde kein Datensatz zum speichern gefunden!");
			} else {
				System.out.println(persCounter + " Daten wurden gesichert." + NEWLINE);
			}
			
			// persCounter = 0;
		} catch (IOException noex) {
			System.out.println("Datei konnte nicht erstellt oder gefunden werden!");
		}
		main_menu();
	}

	/**
	 * 4 = Records aus der Datei personDB.csv einlesen in den Puffer
	 * MyPerson[][] speichern
	 */

	// AUSLESEN
	static void funct_4() {
		try {

			Scanner sc = null; // leeres Scanner-Objekt

			sc = new Scanner(new File("personDB.csv"));

			System.out.println("Datei wird eingelesen!");

			try {
				Thread.sleep(1500); // 1000 milliseconds is one second. 2500 =
									// 2.5 Sekunden
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			int j = 0; // Spalten-Index
			System.out.println("\n-Datensaetze wurden einglesen-\n");
			while (sc.hasNextLine())// Pruefung, ob Zeile vorhanden?
			{
				String myLine = sc.nextLine();// Zeile aus Datei holen
				if (myLine == null)
					break;

				newPers = myLine.split(";");// myLine aufgeteilt

				for (int i = 0; i < newPers.length; i++) {
					myPers[i][j] = newPers[i];

					System.out.println(myPers[i][j]); // AUSGABE DER
														// DATENSAETZE(zur Kontrolle)
				}
				persCounter++;
				j++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Keine Datei zum einlesen vorhanden!");
		}
	}

	static void funct_5() {
		System.out.println("\n\n\n\n");

		Collections.sort(personen, new Comp());
		System.out.println("Records erfolgreich sortiert.");

		// Zurück zum Menu

		main_menu();
	}

	// LOESCHEN
	static void funct_6() {
		try {

			File db = new File("personDB.csv");

			db.setWritable(true);
			if (db.delete()) {
				System.out.println("Die Datei " + "'" + db.getName() + "'" + " wurde geloescht!");
			} else {
				System.out.println("Loeschen fehlgeschlagen!");
			}

		} catch (Exception e) {

			System.out.println("Loeschen fehlgeschlagen!");

		}

	}

	static void person_append() { // neuer Datensatz von newPers in myPers
									// puffern
		for (int i = 0; i < newPers.length; i++) {
			myPers[i][persCounter] = newPers[i];

		}
		Person pers = new Person(name, vorname, anrede, strasse, plz, ort, telefon, fax, bemerkung);
		personen.add(pers);
		System.out.println("Person erfasst");

		persCounter++; // static Variable, Anzahl erfasster Autorecords
	}

	// end of person_append()

}
