package shape;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

import abstractions.*;
import implementation.MenuItem;

public class Group {
	
	private ArrayList<IElement> elements = new ArrayList();
	private Scanner myScanner;
	
	public Group() {
	}
	
	public void add(IElement elementToAdd)
	{
		elements.add(elementToAdd);
	}
	
	public void draw()
	{
		int index = 0;
		if(elements.size() == 0) {
			System.out.println("Plansa e goala ba boule !!!\n");
			return;
		}
		System.out.println("Nr. Tip         Info");
		for(IElement element:elements)
		{
			if (index < 10) {
				System.out.print(index++ + ")  ");	
			} else {
				System.out.print(index++ + ") ");
			}
			
			element.draw();
		}
		System.out.println();
	}
	
	public IElement remove(int index) 
	{
		return elements.remove(index);
	}
	
	public IElement get(int index) 
	{
		return elements.get(index);
	}
	
	public void set(int index, IElement arg) 
	{
		elements.set(index, arg);
	}



}
