package impl;

import main.ApplicationContext;
import menu.Command;

public class CommandStop implements Command {

	@Override
	public String menuItemName() {
		return "Programm beenden";
	}

	@Override
	public void execute(ApplicationContext context) {
		System.out.println("Das Programm wurde beendet!");
		System.exit(0);
	}

}
