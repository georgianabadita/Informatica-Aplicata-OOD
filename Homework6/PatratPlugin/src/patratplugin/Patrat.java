package patratplugin;

import java.awt.Point;
import java.util.Scanner;

import plugins.abstractions.*;

public class Patrat implements IElement {
	private Scanner scanner = new Scanner(System.in);
    private Point stangaSus;
    private Point dreaptaJos;
    private String nume;
    
    public Patrat(){}

    public Patrat(Point p1, Point p2) {
        this.nume = "Patrat";
        this.stangaSus = new Point(Math.min(p1.x, p2.x), Math.max(p1.y, p2.y));
        this.dreaptaJos = new Point(Math.max(p1.x, p2.x), Math.min(p1.y, p2.y));
    }
    public Point getStangaSus() {
        return stangaSus;
    }

    public Point getDreaptaJos() {
        return dreaptaJos;
    }

    @Override
    public void getCoordonate() {
        System.out.print("Coordonatele sunt: P1(" + (int)this.stangaSus.getX() + " , " + (int)this.stangaSus.getY() + "), P2(" + (int)this.dreaptaJos.getX() + " , " + (int)this.dreaptaJos.getY() + ")");
    }

    @Override
    public void draw() {
        System.out.println("Patrat desenat");
    }

    @Override
    public void printShapeDetails() {
    	 int l = (int) (stangaSus.getY() - dreaptaJos.getY());
        System.out.print(this.nume);
        System.out.println();
        getCoordonate();
        System.out.println("Perimetru: " + (int)4 * l);
        System.out.println();
    }

    @Override
    public void read() {
        this.nume = "Patrat";
        System.out.println("Introduceti coordonatele P1 si P2");
        this.stangaSus = new Point(scanner.nextInt(), scanner.nextInt());
        this.dreaptaJos = new Point(scanner.nextInt(), scanner.nextInt());
    }

}
