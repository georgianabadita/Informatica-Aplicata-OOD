package application;

import abstractions.IElement;
import shape.Group;
import shape.Patrat;

public class PaintMain {

	public static void main(String[] args) {
		
		ApplicationMenu menu = new ApplicationMenu();
		menu.load();
		menu.execute();
		
	}

}
