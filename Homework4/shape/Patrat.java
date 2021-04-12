package shape;

import java.awt.Point;
import java.util.Scanner;

import abstractions.IElement;

public class Patrat implements IElement {

	private double side;
	//Point center = new Point();
	//Scanner sc = new Scanner(System.in);
	public Patrat()
	{
		this.side = 0;
	}
	public Patrat(double side)
	{
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	 public void draw() {
	        System.out.println("Patrat\t[side=" + side + "]");
	 }
}
