package fileiodevice;

import iowithplugins.abstractions.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import iowithplugins.abstractions.*;

public class FileOutputDevice implements IOutputDevice {
	
	@Override
	public void WriteString(String s)
	{
		FileOutputStream output = null;
		try
		{
			output = new FileOutputStream("output.txt");
			PrintWriter writer = new PrintWriter(output);
			writer.print(s);
			writer.flush();
			
		}catch(FileNotFoundException ex)
		{
			System.out.println("Eroare deschidere fisier "+ ex.getMessage());
		}
		catch(NoSuchElementException ex)
		{
			System.out.println("Eroare la procesare fisier " + ex.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Eroare " + e.getMessage());
		}
		 if(output != null) {
	            try
	            {
	                output.close();
	            }
	            catch(IOException e)
	            {
	                System.out.println("Fisierul nu este deschis." + e.getMessage());
	            }
	        }
	}

	

	


}
