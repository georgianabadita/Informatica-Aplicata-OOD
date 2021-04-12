package shape;

import java.awt.Point;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import abstractions.IElement;

public  class Cerc implements IElement{
	private double ox;
	private double oy;
	private double raza;
	
	public Cerc()
	{
		this.ox = 0;
		this.oy = 0;
		this.raza = 0;
	}
	public Cerc(double ox, double oy, double raza)
	{
		this.ox = ox;
		this.oy = oy;
		this.raza = raza;
	}
		
	public double getOx() {
		return ox;
	}

	public void setOx(double ox) {
		this.ox = ox;
	}

	public double getOy() {
		return oy;
	}

	public void setOy(double oy) {
		this.oy = oy;
	}

	public double getRaza() {
		return raza;
	}

	public void setRaza(double raza) {
		this.raza = raza;
	}


	
	@Override
	public void draw()
	{
		System.out.println("Cerc\t[ox=" + ox + ", oy=" + oy + ", raza=" + raza + "]");
	}
	
}
