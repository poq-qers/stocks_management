package menu;

import main.ApplicationContext;

public class Submenu extends Menu implements Command {

	private String commandKey;
	
	public Submenu(String menuName, ApplicationContext context, String backButtonName) {
		super(menuName, context, backButtonName);
	}

	@Override
	public String menuItemName() {
		return this.getMenuName();
	}

	@Override
	public void execute(ApplicationContext context) {
		this.showMenu();
	}

}
