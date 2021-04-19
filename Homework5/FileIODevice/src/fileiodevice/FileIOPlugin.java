package fileiodevice;

import iowithplugins.abstractions.IIOPlugin;
import iowithplugins.abstractions.IInputDevice;
import iowithplugins.abstractions.IOutputDevice;

public class FileIOPlugin implements IIOPlugin {
	
//	 FileInputDevice inputDevice = new FileInputDevice();
//	 FileOutputDevice outputDevice = new FileOutputDevice();
	@Override
	public String getPluginName() {
        return "filePlugin";
    }

    @Override
    public IInputDevice getInputDevice() {
       return new FileInputDevice();
    }

    @Override
    public IOutputDevice getOutputDevice() {
        return new FileOutputDevice();
    }

}
