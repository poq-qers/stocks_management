package model;

public class Aktie implements Comparable<Aktie>{
		private int number; // Nummer um alle Aktien zu identifizieren innerhalb des Systems
		private String isin;
		private String name;
		private double price;
		private double course;
		private double dividende;
		static int countNumber = 0;
		
		public Aktie(String isin, String name, String price, String course, String dividende) {
			countNumber++;
			this.number=countNumber;
			this.isin=isin;
			this.name=name;
			this.price=Double.parseDouble(price); // parseDouble-Methode um String in Double-Value umzuwandeln
			this.course=Double.parseDouble(course);
			this.dividende=Double.parseDouble(dividende);
		}
	
		@Override
		public String toString() {
			return "Aktie [number=" + number + ", isin=" + isin + ", name=" + name + ", price=" + price + ", course="
					+ course + ", dividende=" + dividende + "]";
		}

		@Override
		public int compareTo(Aktie aktie) {
			int result = this.name.trim().compareTo(aktie.name.trim()); // trim aus Sicherheit vllt auch weglassen später
			if(result == 0) {
				return 0; // Namen sind identisch
			} else if(result < 0) {
				return  -1; // this.name liegt alphabetisch vor aktie.name
			} else {
				return 1; // aktie.name liegt alphabetisch vor this.name
			}
		}
}
