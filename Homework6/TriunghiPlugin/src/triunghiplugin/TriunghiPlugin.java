package triunghiplugin;
import plugins.abstractions.*;

public class TriunghiPlugin implements IPluginsApp {

    @Override
    public String getNameShape() {
        return "TriunghiPlugin";
    }

    @Override
    public String getDisplayShape() {
        return "Triunghi";
    }

    @Override
    public IElement getShape() {
        return new Triunghi();
    }
    
}
