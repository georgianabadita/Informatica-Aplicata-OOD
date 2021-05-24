package dreptunghiplugin;

import plugins.abstractions.*;

public class DreptunghiPlugin implements IPluginsApp{

    @Override
    public String getNameShape() {
        return "DreptunghiPlugin";
    }

    @Override
    public String getDisplayShape() {
        return "Dreptunghi";
    }

    @Override
    public IElement getShape() {
        return new Dreptunghi();
    }
    
}
