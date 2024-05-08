package menu;

import main.ApplicationContext;

public interface Command {

	public String menuItemName();
	
	public void execute(ApplicationContext context);
	
}
