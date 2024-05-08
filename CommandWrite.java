package impl;

import java.util.Scanner;
import model.Writer;
import main.ApplicationContext;
import menu.Command;

public class CommandWrite implements Command {

	@Override
	public String menuItemName() {
		return "Zeilen einlesen";
	}

	@Override
	public void execute(ApplicationContext context) {
		Writer writer = new Writer("C:\\Users\\benei\\Desktop\\fileio.txt");
		Scanner aktienscanner = new Scanner(System.in);
		
			boolean nextLine = true;
			// neue Zeile einlesen
					while(nextLine == true) {
						int i = 0; // richtige Anzahl an Elementen
						System.out.print("Möchtest du eine Zeile hinzufügen (y/n)?");
						String decision = aktienscanner.nextLine();
						System.out.println("");
						if(decision.equals("y")) {
							System.out.println("Gebe die neue Aktie nach folgenden Schema ein:");
							System.out.println("ISIN;Name;Preis;Kurs;Dividende"); // Eingabeprüfung noch verbessern
							String newLine = aktienscanner.nextLine(); 
							String[] elements = newLine.split(";");
							for(String element : elements) {
								i++;
								if(i >= 3) { // Größer drei weil dann Preis,Kurs,Dividende beginnen
									try {		// vllt später nochmal verbessern
										double temp = Double.parseDouble(element); // Geht, außer wenn Zahl mit Buchstaben folgt
									} catch (NumberFormatException e) {
										System.out.println("Du musst bei Preis, Kurs und Dividende eine Zahl eingeben!");
										break;
									}
								}
							}
							if(i != 5) {
								System.out.println("Falsche Eingabe: Du musst genau die 5 Elemente mit ; eingeben!");
								nextLine = true;
								continue;
							}
							writer.writeLine(newLine);
						} else {
							nextLine = false;
						}
					}
		
	}

}
