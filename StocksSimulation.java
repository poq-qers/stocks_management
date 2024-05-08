package main;

import impl.CommandRead;
import impl.CommandSortName;
import impl.CommandStop;
import impl.CommandWrite;
import menu.Menu;
import menu.Submenu;
import model.Aktie;
import model.Reader;

public class StocksSimulation {
	
		ApplicationContext appContext;
		
		Menu mainMenu;
		
		public StocksSimulation() {
			this.appContext = new ApplicationContext();
		}
		
		public void play() {
			mainMenu = initMainMenu();
			
			while(true) {
				mainMenu.showMenu();
			}
		}
		
		private Menu initMainMenu() {
			Submenu stock_management = new Submenu("Aktienverwaltung", appContext, "Zurück"); // namen noch ändern
			stock_management.setCommand(new CommandRead());
			stock_management.setCommand(new CommandWrite());
			stock_management.setCommand(new CommandSortName());
			
			// Hauptmenu
			Menu mainMenu = new Menu("Hauptmenu", appContext, "Zurück");
			mainMenu.setCommand(stock_management);
			mainMenu.setCommand(new CommandStop());
			
			return mainMenu;
		}
		
		
}
