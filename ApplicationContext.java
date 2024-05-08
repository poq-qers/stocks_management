package main;

import java.util.ArrayList;

import model.Aktie;
import model.Reader;

public class ApplicationContext {
		
		private ArrayList<Aktie> aktien = new ArrayList<Aktie>();
		
		public ApplicationContext() {
			initAktienliste();
		}

		private void initAktienliste() {
			ArrayList<String> lines = new ArrayList<String>();
			Reader reader = new Reader("C:\\Users\\benei\\Desktop\\fileio.txt"); // In den Reader path reingeben
			String line;
			boolean firstAktie = true;
			// alle Zeilen auslesen
			while((line = reader.readLine()) != "error") {
				int i = 0;
				String[] elements = line.split(";"); // Alle Teile von Line die durch ein ; getrennt sind gehen in das elements Array rein
				for(String element : elements) { // for-each Loop durchläuft jedes Element von elements
					if(firstAktie == true) {
						lines.add(element);
					}
					else {
						lines.set(i, element);
					}
					i++;
					}
					firstAktie = false;
					aktien.add(new Aktie(lines.get(0),lines.get(1),lines.get(2),lines.get(3),lines.get(4)));
				}
		}
		
		public ArrayList<Aktie> getAktien() {
			return aktien;
		}
}
