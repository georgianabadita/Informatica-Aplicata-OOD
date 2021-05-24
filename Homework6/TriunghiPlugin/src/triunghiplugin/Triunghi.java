package triunghiplugin;

import java.awt.Point;
import java.util.Scanner;
import plugins.abstractions.*;

public class Triunghi implements IElement{
    private Scanner scanner = new Scanner(System.in);
    private Point stangaSus;
    private Point dreaptaJos;
    private String nume;

    public Triunghi(){}

    public Triunghi(Point p1, Point p2) {
        this.nume = "Triunghi";
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
        System.out.print("Coordonate: P1(" + (int)this.stangaSus.getX() + " , " + (int)this.stangaSus.getY() + "), P2(" + (int)this.dreaptaJos.getX() + " , " + (int)this.dreaptaJos.getY() + ")");
    }

    @Override
    public void draw() {
        System.out.println("Triunghi desenat.");
    }

    @Override
    public void printShapeDetails() {
        int l = (int)(stangaSus.getY() - dreaptaJos.getY());
        System.out.print(this.nume);
        System.out.println();
        getCoordonate();
        System.out.println("\nPerimetru: " + 3 * l);
        System.out.println();
    }

    @Override
    public void read() {
        this.nume = "Triunghi";
        System.out.println("Introduceti coordonatele pentru P1 si P2:");
        this.stangaSus = new Point(scanner.nextInt(), scanner.nextInt());
        this.dreaptaJos = new Point(scanner.nextInt(), scanner.nextInt());
    }

}
