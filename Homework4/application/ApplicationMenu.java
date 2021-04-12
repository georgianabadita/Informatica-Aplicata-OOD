package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import abstractions.*;
import implementation.Menu;
import implementation.MenuItem;
import shape.Cerc;
import shape.Dreptunghi;
import shape.Group;
import shape.Patrat;
import shape.Triunghi;

public class ApplicationMenu {
	private static Scanner consoleIn = new Scanner(System.in);
	private static  Group elementsList = new Group();
	private Menu mainMenu = null;
    
	public ApplicationMenu()
    {
                 
    }
	
    private void uiAddElement( ArrayList<IMenuItem> addElementsOptions) {
		
		for(IMenuItem option:addElementsOptions)
		{
			System.out.println(option.getText());
		}
		System.out.print("Introduceti optiunea dvs.: ");
		try {
			addElementsOptions.get(consoleIn.nextInt()).execute();
		} catch (Exception e) {
			System.out.println("Optiune incorecta boule !!!\n");
		}
		
		 	
	}
    
    private void uiDeleteElement() {
		System.out.print("Introduceti index-ul formei care trebuie stearsa: ");
		try {
			int index = consoleIn.nextInt();
			elementsList.remove(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 	
	}
   
    private void display() 
   	{
   		elementsList.draw();
   	}
	
	public void addPatrat()
	{
		System.out.print("Introduceti latura: ");
		double l = consoleIn.nextDouble();
		elementsList.add(new Patrat(l));
	}
	public void addCerc()
	{
		System.out.print("Introduceti x: ");
		double x = consoleIn.nextDouble();
		System.out.print("Introduceti y: ");
		double y = consoleIn.nextDouble();
		System.out.print("Introduceti raza: ");
		double r = consoleIn.nextDouble();
		elementsList.add(new Cerc(x, y, r));
		
	}
	public void addTriunghi()
	{
		System.out.print("Introduceti baza: ");
		double b = consoleIn.nextDouble();
		System.out.print("Introduceti l1: ");
		double l1 = consoleIn.nextDouble();
		System.out.print("Introduceti l2: ");
		double l2 = consoleIn.nextDouble();
		elementsList.add(new Triunghi(l1, l2, b));
		
	}
	public void addDreptunghi()
	{
		System.out.print("Introduceti latime: ");
		double width = consoleIn.nextDouble();
		System.out.print("Introduceti lungime: ");
		double length = consoleIn.nextDouble();
		elementsList.add(new Dreptunghi(width, length));
		
	}
	
	public void editPatrat(int index)
	{
		System.out.print("Introduceti latura: ");
		double l = consoleIn.nextDouble();
		elementsList.set(index, new Patrat(l));
	}
	public void editCerc(int index)
	{
		System.out.print("Introduceti x: ");
		double x = consoleIn.nextDouble();
		System.out.print("Introduceti y: ");
		double y = consoleIn.nextDouble();
		System.out.print("Introduceti raza: ");
		double r = consoleIn.nextDouble();
		elementsList.set(index, new Cerc(x, y, r));
		
	}
	public void editTriunghi(int index)
	{
		System.out.print("Introduceti baza: ");
		double b = consoleIn.nextDouble();
		System.out.print("Introduceti l1: ");
		double l1 = consoleIn.nextDouble();
		System.out.print("Introduceti l2: ");
		double l2 = consoleIn.nextDouble();
		elementsList.set(index, new Triunghi(l1, l2, b));
		
	}
	public void editDreptunghi(int index)
	{
		System.out.print("Introduceti latime: ");
		double width = consoleIn.nextDouble();
		System.out.print("Introduceti lungime: ");
		double length = consoleIn.nextDouble();
		elementsList.set(index, new Dreptunghi(width, length));
		
	}
    public void load()
    {
        
        ArrayList<IMenuItem> menuItems = new ArrayList();
        ArrayList<IMenuItem> showElementsOptions = new ArrayList();
        ArrayList<IMenuItem> addElementsOptions = new ArrayList();
        
        
        int shortCut = 1;    
        
         
       IMenuItem currentItem = new MenuItem("Adaugare forma.  ", shortCut++, (parameters)->{
           uiAddElement(addElementsOptions);
           System.out.println();
       });      
       menuItems.add(currentItem);
       
       addElementsOptions.add(new MenuItem("0. Iesire.", 0, (parameters) -> {
       }));
       
       addElementsOptions.add(new MenuItem("1. Adauga patrat.", 1, (parameters) -> {
    	   addPatrat();
    	  
       }));
       addElementsOptions.add(new MenuItem("2. Adauga cerc.", 2, (parameters) -> {
    	   addCerc();
    	 
       }));
       
       addElementsOptions.add(new MenuItem("3. Triunghi. ", 3, (parameters) -> {
       
    	   addTriunghi();
          }));
    
       addElementsOptions.add(new MenuItem("4. Dreptunghi. ", 4, (parameters) -> {
           
    	   addDreptunghi();
          }));
       
       currentItem = new MenuItem("Stergere forma.", shortCut++, (parameters)->{
    	   	uiDeleteElement();
    	   	System.out.println();
       });       
       menuItems.add(currentItem); 
      currentItem = new MenuItem("Modificare informatii forma.", shortCut++, (parameters)->{
   	   	uiModifyElement();
   	   	System.out.println();
      });       
      menuItems.add(currentItem); 
      currentItem = new MenuItem("Afisare plansa.", shortCut++, (parameters)->{
  	   	display();
     });       
     menuItems.add(currentItem); 
     
        
        mainMenu = new Menu("Main Menu", -1, menuItems);
        
    }

	private void uiModifyElement() {
		System.out.println("Introduceti index: ");
		try {
			int index = consoleIn.nextInt();
			if (elementsList.get(index).getClass() == Patrat.class) {
				editPatrat(index);
			} else if (elementsList.get(index).getClass() == Cerc.class) {
				editCerc(index);
			} else if (elementsList.get(index).getClass() == Triunghi.class) {
				editTriunghi(index);
			} else {
				editDreptunghi(index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void execute()
    {
        mainMenu.execute();
    }
    

}



