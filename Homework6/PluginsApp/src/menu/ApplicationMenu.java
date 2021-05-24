package menu;

import group.Group;
import plugin.PluginsManager;
import plugins.abstractions.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationMenu{
    private Group group;
    private Scanner scanner = new Scanner(System.in);
    private PluginsManager pluginMan;
    private Menu mainMenu = null;
    private Menu subMenu = null;
    
    public ApplicationMenu(PluginsManager pluginMan, Group group)
    {
        this.pluginMan = pluginMan;
        this.group = group;
    }

    public void load()
    {
        pluginMan.loadPlugins("/plugins");
        ArrayList<IMenuItem> menuItems = new ArrayList();

        int shortCut = 1;
        var plugins = pluginMan.getPlugins();

        for (int i = 0 ; i < plugins.size(); i++)
        {
           var currentPlugin = plugins.get(i); 
           MenuItem currentItem = new MenuItem(plugins.get(i).getDisplayShape(), shortCut++, (parameters)->{
               IElement shape = currentPlugin.getShape();
               group.setShape(shape);
               group.add();
           });
           menuItems.add(currentItem);

        }
        subMenu=new Menu("Adaugare forma",1,menuItems);
        
        mainMenu = new Menu("Main Menu", -1);
        
        mainMenu.addItem(1, "Adaugare forma",(parameters)->{
               subMenu.execute();
           });
        mainMenu.addItem(2, "Stergere forma", (parameters) ->{
            group.printShapes();
            group.deleteShape(scanner.nextInt());
        });
        mainMenu.addItem(3, "Vizualizare plansa(grupul de forme)", (parameters) ->{
            group.printShapes();
        });
        mainMenu.addItem(4, "Modificare forma", (parameters) ->{
            group.printShapes();
            group.editShape(scanner.nextInt());
        });
    }

    public void execute()
    {
        mainMenu.execute();
    }


}
