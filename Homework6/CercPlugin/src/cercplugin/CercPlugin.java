package cercplugin;
import plugins.abstractions.*;


public class CercPlugin implements IPluginsApp{
	@Override
    public String getNameShape() {
        return "CercPlugin";
    }

    @Override
    public String getDisplayShape() {
        return "Cerc";
    }

    @Override
    public IElement getShape() {
        return new Cerc();
    }
}
