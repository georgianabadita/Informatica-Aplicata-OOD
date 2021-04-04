package studentApp;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

public class MenuApp {
	private static Scanner in = new Scanner(System.in);
	private static  ArrayList<Student> studentsList = new ArrayList<Student>();
	
	protected void DisplayMenu()
	{

		System.out.println("---- GESTIONARE STUDENTI GRUPA ----\n");
		System.out.println("0. Iesire");
		System.out.println("1. Adaugare student");
		System.out.println("2. Modificare informatii student");
		System.out.println("3. Stergere student");
		System.out.println("4. Vizualizare lista");
		System.out.println("\nIntorduceti optiunea dvs.: ");
		
	}
	
	public void Run()
	{
		int option = 0;
		
		do
		{
		  try {
			DisplayMenu();
			option = in.nextInt();
			switch (option)
			{
				case 1:
					addStudent();
					break;
				case 2:
					modifyStudent();
					break;
				case 3:
				
					deleteStudent();
					break;
				case 4:
					viewStudents();
					break;
					
				default:
					System.out.println("\nAlegeti o optiune valida");
			
			}
			}catch(Exception ex)
            {
	               System.out.println(ex.getMessage());
	               continue; 
	            }
	      finally
	       {
		       System.out.println("\n");
	       }
		}while (option != 0);	
		
		System.out.println("Aplicatia se inchide ...");
	}

	private void viewStudents() 
	{
		System.out.println("Index\tNume\tPrenume\tMedie\tSpecializare");
		
		for(Student current: studentsList)
		{
			listStudent(current);
		}
		in.nextLine();
		in.nextLine();
			
	}


	private void listStudent(Student current) 
	{
		System.out.println((studentsList.indexOf(current)+1)+ "\t" + current.getNume() + "\t" + current.getPrenume() + " \t" + current.getMedia()  + "\t" + current.getSpecializare());
		
	}

	private void modifyStudent() 
	{
		System.out.println("Introduceti index-ul studentului: ");
		int index = in.nextInt();
		System.out.println("Introduceti modificarea numelui studentului: ");
		String nume = in.next();
		System.out.println("Introduceti modificarea prenumelui studentului: ");
		String prenume = in.next();
		System.out.println("Introduceti modificarea mediei studentului: ");
		double medie = in.nextDouble();
		System.out.println("Introduceti modificarea specializarii studentului: ");
		String specializare = in.next();
		
		studentsList.set(index, new Student(nume,prenume,medie,specializare));
		
	/*	for( Student current: studentsList)
		{
			if(current!= null && nume.equals(current.getNume()))
			{
				current.setMedia(medie);
				break;
			}
		}*/
	}

	
	public static void addStudent() {
		
		try
		{				
		System.out.println("Nume: ");
		String nume = in.next();

		System.out.println("Prenume: ");
		String prenume = in.next();
	
		
		System.out.println("Medie: ");
		double medie = in.nextDouble();
		
		System.out.println("Specializare: ");
		String specializare = in.next();
		
		
		studentsList.add(new Student(nume, prenume, medie, specializare));
		
		}
		catch (InputMismatchException ex) 
        {
            System.out.println("Error: " + ex.toString());
        }
		 
		
	}
		

	private void deleteStudent() {
		
		System.out.println("Introduceti nume: ");
		String nume = in.next();
		try {
		for(int i=0; i<studentsList.size()-1; i++)
		{
			if(studentsList.get(i).getNume().equals(nume) && studentsList.get(i+1).getNume().equals(nume))
			{
				System.out.println("Introduceti prenume: ");
				String prenume = in.next();
				if(studentsList.get(i).getPrenume().equals(prenume))
				{ 
					studentsList.remove(i);
					System.out.println("Stergerea s-a efectuat cu succes!");
					break;
				}
			}
		}
			
		}catch(Exception ex){
			System.out.println("Nu se poate sterge!");
			}
		
	 }
}

