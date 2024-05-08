package impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.ApplicationContext;
import menu.Command;
import model.Aktie;

// Bei der Eingabeprüfung zum anfang nur Großbustaben zulassen wegen sortieren -> kleinbuchstaben immer am ende 
public class CommandSortName implements Command {

	@Override
	public String menuItemName() {
		return "Aktien sortieren nach Name";
	}

	@Override
	public void execute(ApplicationContext context) {
		
		List<Aktie> aktien_sort = new ArrayList<Aktie>();
		
		
		aktien_sort = context.getAktien();
		
		Collections.sort(aktien_sort); // Sortieren 
		
		// printen
		for(int i = 0; i < aktien_sort.size(); i++) {
			System.out.println(aktien_sort.get(i).toString()); // vllt verbessern
		}
	}
	
}
