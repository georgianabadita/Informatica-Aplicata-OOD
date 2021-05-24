package patratplugin;

import plugins.abstractions.*;

public class PatratPlugin  implements IPluginsApp {

	@Override
	public String getNameShape() {
        return "PatratPlugin";
    }

    @Override
    public String getDisplayShape() {
        return "Patrat";
    }

    @Override
    public IElement getShape() {
        return new Patrat();
    }
}
