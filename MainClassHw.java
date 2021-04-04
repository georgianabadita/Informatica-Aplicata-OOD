package homework1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainClassHw {

	public static void main(String[] args) {
        Scanner scan = null;
        FileWriter output = null;
        String inputText;
        try {

            scan = new Scanner(System.in);
            output = new FileWriter("TextOutput.txt");

            while (true) 
            {
            	System.out.println("Introduceti textul : ");
                inputText = scan.nextLine();
                if(inputText.equalsIgnoreCase("end"))
                {
                	System.out.println("S-a citit textul " + inputText + " si nu se mai pot citi alte cuvinte");
                }
                else
                {
                System.out.println("Am citit textul: " + inputText);
                }
     
                if (inputText.equalsIgnoreCase("end")) 
                {
                    break;
                }

                output.write(inputText);
                output.write("\n");

            }

        } catch (IOException e) 
        	{

          
            System.out.println("Eroare la citire/afisare");

        	}
        finally 
        {
            if (scan != null) 
            {
                scan.close();
            }

            try {

                if (output != null)
                {
                    output.close();
                }

            } catch (IOException e) 
            {
                System.out.println("Fisierul nu s-a inchis!");

            }

        }

	}

}
