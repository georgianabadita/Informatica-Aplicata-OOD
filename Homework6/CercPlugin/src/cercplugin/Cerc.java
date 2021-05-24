package cercplugin;

import java.awt.Point;
import java.util.Scanner;

import plugins.abstractions.*;

public class Cerc implements IElement {
	private Scanner scanner = new Scanner(System.in);
	private double raza;
    private Point punct;
    private String nume;

    public Cerc(){}
    public Cerc(Point p, double raza) {
        this.punct = p;
        this.raza = raza;
        this.nume = "Cerc";
    }

    @Override
    public void printShapeDetails() {
        System.out.print(this.nume);
        System.out.println();
        getCoordonate();
        //double area = Math.pow((3.14 * r),2);
        System.out.println("\nRaza: " + this.getRaza() +  " Perimetru: " + (2 * 3.14 * raza));
        System.out.println();

    }

    @Override
    public void read() {
        this.nume = "Cerc";
        System.out.println("Introduceti coordonatele P1 si P2:");
        this.punct = new Point(scanner.nextInt(), scanner.nextInt());
        System.out.println("Introduceti raza:");
        this.raza = scanner.nextInt();
    }

    public double getRaza() {
        return raza;
    }

    @Override
    public void getCoordonate() {
        System.out.print("Centru de coordonate: " + "P( " + (int)this.punct.getX() + " , " + (int)this.punct.getX() + " )");
    }

    @Override
    public void draw() {
        System.out.println("Circ Desenat ");
    }



}
