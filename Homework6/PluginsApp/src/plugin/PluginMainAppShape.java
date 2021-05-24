package plugin;
import group.Group;
import menu.*;
import plugins.abstractions.*;

public class PluginMainAppShape {
	public static void main(String[] args)
    {
        PluginsManager pluginMan = new PluginsManager();
        Group group = new Group();
        
        ApplicationMenu menu = new ApplicationMenu(pluginMan, group);
        
        menu.load();
        menu.execute();        
    }
}
