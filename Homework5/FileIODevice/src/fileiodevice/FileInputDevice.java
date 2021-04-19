package fileiodevice;

import iowithplugins.abstractions.IIOPlugin;
import iowithplugins.abstractions.IInputDevice;
import iowithplugins.abstractions.IOutputDevice;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;

public class FileInputDevice implements IInputDevice{

	@Override
	public String ReadString() {
		FileInputStream fileInput = null;
		String string = "";
		try
		{
			fileInput = new FileInputStream("input.txt");
			@SuppressWarnings("resource")
			Scanner fileScanner = new Scanner(fileInput);
			string = fileScanner.nextLine();
		
		}catch(FileNotFoundException ex)
		{
			System.out.println("Eroare atunci cand se deschide fisierul" + ex.getMessage());
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println("Eroare procesare fisier " + ex.getMessage());
			ex.printStackTrace();
		}
		
		if(fileInput != null)
		{
			try {
				fileInput.close();
			}
			catch(IOException ex)
			{
				System.out.println("Fisierul nu este deschis " + ex.getMessage());
			}
	
		}
		return string;
		
		}
}
