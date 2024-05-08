package impl;

import java.util.ArrayList;

import model.Aktie;
import model.Reader;
import main.ApplicationContext;
import main.StocksSimulation;
import menu.Command;

public class CommandRead implements Command {

	@Override
	public String menuItemName() {
		return "Zeilen auslesen";
	}

	@Override
	public void execute(ApplicationContext context) {
		
		for(int i = 0; i < context.getAktien().size(); i++) {
			System.out.println(context.getAktien().get(i).toString());
		}
					
	}
	
}
