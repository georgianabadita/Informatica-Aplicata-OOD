package shape;

import java.awt.Point;
import java.util.Scanner;

import abstractions.IElement;

public class Dreptunghi implements IElement {

	private double width;
	private double height;

	public Dreptunghi(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public Dreptunghi() {
		super();
		this.width = 0;
		this.height = 0;
	}
   
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
   
    @Override
    public void draw() {
        System.out.println("Dreptunghi\t[width=" + width + ", height=" + height + "]");
    }    
 
}
