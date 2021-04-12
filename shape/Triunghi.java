package shape;

import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Scanner;

import abstractions.IElement;

public class Triunghi implements IElement{

	private double side2 =0;
	private double side1 =0;
	private double base = 0;
	 //Point center=new Point();
	
   
	public double getBase() {
		return base;
	}
	
	public Triunghi(double side2, double side1, double base) {
		super();
		this.side2 = side2;
		this.side1 = side1;
		this.base = base;
	}

	public Triunghi() {
		super();
		this.side2 = 0;
		this.side1 = 0;
		this.base = 0;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public void setBase(double base) {
		this.base = base;
	}


	@Override
	public void draw() {
		  System.out.println("Triunghi\t[side2=" + side2 + ", side1=" + side1 + ", base=" + base + "]");
		
	}
	
}