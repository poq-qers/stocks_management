package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.ApplicationContext;

public class Menu {

	private String menuName;
	
	private String backButtonName;
	
	// Liste von möglichen Commands im Menu
	List<Command> menuItems = new ArrayList<Command>();

	ApplicationContext appContext;

	// Konstruktor
	public Menu(String menuName, ApplicationContext context, String backButtonName) {
		this.menuName=menuName;
		this.appContext = context;
		this.backButtonName=backButtonName;
	}

	/**
	 * Neues Command der Liste von möglichen Commands im Menu hinzufuegen
	 * 
	 * @param command - das Objekt des Commands, das ausgeführt werden soll bei Auswahl
	 */
	public void setCommand(Command command) {
		if(command!=null) {
			menuItems.add(command);
		}
	}

	/**
	 * Die zuvor ueber setCommand() hinzugefuegten Commands werden hiermit
	 * dargestellt. Es wird eine Auswahl ermoeglicht, sodass das
	 * entsprechende Command ausgefuehrt wird. Abschliessend wird ein 
	 * Menuepunkt hinzugefuegt, der das Verlassen des Menues ermoeglicht. 
	 */
	public void showMenu() {

		while(true) {
			System.out.println("========== "+menuName+" ==========");

			// true setzen, falls Integer eingegeben wurde, ansonsten false
			boolean scannerErfolg=false;

			// Variable für Eingabe der zu verkaufenden Menge
			int auswahlMenuItem=0;

			// darstellen
			int menuItemCounter=1; // Einsen um zu korriegeren, dass Ausgabe 1 bis ... ist statt 0 bis ...
			for (menuItemCounter=1; menuItemCounter<menuItems.size()+1; menuItemCounter++) {
				Command command = menuItems.get(menuItemCounter-1);
				showMenuItem(menuItemCounter, command.menuItemName());
			}
			showMenuItem(menuItemCounter, backButtonName);

			// abfragen
			Scanner myScanner = new Scanner(System.in);
			while(!scannerErfolg) {
				try {
					auswahlMenuItem = myScanner.nextInt();
					scannerErfolg=true;
					myScanner.nextLine();
				} catch (Exception e) {
					//e.printStackTrace();
					scannerErfolg=false;
					myScanner.nextLine();
				}
			}

			if(auswahlMenuItem==menuItemCounter) {
				// Verlassen des Menus (Zurück)
				return;
			}

			// ausgewähltes Command ausführen
			menuItems.get(auswahlMenuItem-1).execute(appContext);
		}
	}

	private void showMenuItem(int itemNumber, String commandMenuItemName) {
		System.out.println(itemNumber + ": "+commandMenuItemName);
	}

	public String getMenuName() {
		return menuName;
	}

}