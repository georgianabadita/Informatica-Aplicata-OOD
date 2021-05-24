package group;
import plugins.abstractions.IElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.Point;

public class Group {
    private IElement shape;
    private ArrayList<IElement> shapes = new ArrayList<>();

    public List<IElement> getShapeList() {
        return shapes;
    }
    
    public void setShape(IElement shape){
        this.shape = shape;
    }
   

    public void add(){
        shape.read();
        shapes.add(shape);
        shape.draw();
        shape.printShapeDetails();
    }

    public void printShapes() {
        for (int i = 0; i < shapes.size(); i++) {
            System.out.print((i + 1) + ". ");
            shapes.get(i).printShapeDetails();
        }
    }

    public void editShape(int position) {
        position = position - 1;
        if(shapes.get(position) != null){
            shapes.get(position).read();
        }
    }
    
    public void deleteShape(int pos) {
        pos = pos - 1;
        for (int i = 0; i < shapes.size(); i++) {
            if (pos == i) {
                shapes.remove(i);
            }
        }
    }

}
