package dreptunghiplugin;

import java.awt.Point;
import java.util.Scanner;
import plugins.abstractions.*;

public class Dreptunghi implements IElement{
    private Scanner scanner = new Scanner(System.in);
    private Point stangaSus;
    private Point dreaptaJos;
    private String nume;

    public Dreptunghi(){}

    public Dreptunghi(Point p1, Point p2) {
        this.nume = "Dreptunghi";
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
        System.out.print("Coordonatele: P1(" + (int)this.stangaSus.getX() + " , " + (int)this.stangaSus.getY() + "), P2(" + (int)this.dreaptaJos.getX() + " , " + (int)this.dreaptaJos.getY() + ")");
    }

    @Override
    public void draw() {
        System.out.println("Dreptunghi desenat!");
    }

    @Override
    public void printShapeDetails() {
        System.out.print(this.nume);
        System.out.println();
        getCoordonate();
        System.out.println("\nPerimetru: " + (2 * (stangaSus.getY() - dreaptaJos.getY()) + 2 * (stangaSus.getX() - dreaptaJos.getX())) );
        System.out.println();
    }

    @Override
    public void read() {
        this.nume = "Dreptunghi";
        System.out.println("Introduceti coordonatele pentru P1 si P2:");
        this.stangaSus = new Point(scanner.nextInt(), scanner.nextInt());
        this.dreaptaJos = new Point(scanner.nextInt(), scanner.nextInt());
    }
}