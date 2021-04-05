package application;

import implementation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import abstractions.*;

public class ApplicationMenu {
	private static Scanner consoleIn = new Scanner(System.in);
	private static  ArrayList<Student> studentsList = new ArrayList<Student>();
	private Menu mainMenu = null;
	
    public ApplicationMenu()
    {
                 
    }
    private void uiAddStudent() {
		System.out.println("Adauga student: ");
		try
		{				
		System.out.println("Nume: ");
		String nume = consoleIn.next();

		System.out.println("Prenume: ");
		String prenume = consoleIn.next();
	
		
		System.out.println("Medie: ");
		double medie = consoleIn.nextDouble();
		
		System.out.println("Specializare: ");
		String specializare = consoleIn.next();
		
		
		studentsList.add(new Student(nume, prenume, medie, specializare));
		
		}catch (InputMismatchException ex) 
        {
            System.out.println("Error: " + ex.toString());
        }
		 	
	}
    /*
	private void uiDeleteStudent() {
		System.out.println("Sterge student");
		System.out.println("Introduceti nume: ");
		
		String nume = consoleIn.next();
		
		try {
		for(int i = 0; i < studentsList.size(); i++)
		{
			if(studentsList.get(i).getNume().equalsIgnoreCase(nume))
			{
					studentsList.remove(i);
					System.out.println("Stergerea s-a efectuat cu succes!");
					break;
					
			}
			else {
				System.out.println("Nu se poate sterge! ");
				break;
			}
		}
			
		}catch(Exception ex){
			ex.getMessage();
		}
  }
		*/
    private void uiDeleteStudent() {
		
		alfabeticNume();
		
		try {
			System.out.println("Introduceti nume: ");
			String nume = consoleIn.next();
			for(int i = 0; i < studentsList.size(); i++)
			{
				if(studentsList.get(i).getNume().equalsIgnoreCase(nume))
				{
					for(int id = i+1; id < studentsList.size(); id++)
					if( studentsList.get(id).getNume().equalsIgnoreCase(nume))
						{
							System.out.println("Introduceti prenume: ");
							String prenume = consoleIn.next();
							if(studentsList.get(i).getPrenume().equalsIgnoreCase(prenume))
								{ 
									studentsList.remove(i);
									System.out.println("Stergerea s-a efectuat cu succes!");
									break;
								}
				
							}
					studentsList.remove(i);
					System.out.println("Stergerea s-a efectuat cu succes!");
					break;
				}			
			}
			
		}catch(InputMismatchException ex){
		
            System.out.println("Error: " + ex.toString());
			}
		
	 }

    
    private void viewStudents() 
   	{
   		System.out.println("Index\t\tNume\t\tPrenume\t\tMedie\t\tSpecializare");
   		
   		for(Student current: studentsList)
   		{
   			listStudent(current);
   		}
   		consoleIn.nextLine();
   		consoleIn.nextLine();
   	}


   	private void listStudent(Student current) 
   	{
   		System.out.println((studentsList.indexOf(current)+1)+ "\t\t" + current.getNume() + "\t\t" + current.getPrenume() + "\t\t" + current.getMedia()  + "\t\t" + current.getSpecializare());
   		
   	}
    
	private void alfabeticNume() {
    	Collections.sort(studentsList, new Comparator<Student>() {
            public int compare(Student Student1, Student Student2)
            {
                return ((Student)Student1).getNume()
                        .compareToIgnoreCase(((Student)Student2).getNume());
            }
        }); 
    	viewStudents();
    	
    }
	
	private void alfabeticPrenume() {
    	Collections.sort(studentsList, new Comparator<Student>() {
            public int compare(Student Student1, Student Student2)
            {
                return ((Student)Student1).getPrenume()
                        .compareToIgnoreCase(((Student)Student2).getPrenume());
            }
        }); 
    	viewStudents();
    	
    }
	private void crescatorMedie() {
    	Collections.sort(studentsList, new Comparator<Student>() {
            public int compare(Student Student1, Student Student2)
            {
               return Double.compare(Student1.getMedia(),Student2.getMedia());
            }
        }); 
    	viewStudents();
    	
    }
	private void descrescatorMedie() {
    	Collections.sort(studentsList, new Comparator<Student>() {
            public int compare(Student Student1, Student Student2)
            {
               return Double.compare(Student1.getMedia(),Student2.getMedia());
            }
        }); 
    	Collections.reverse(studentsList);
    	viewStudents();
    	
    }
	private void uiModifyStudent() 
	{
		viewStudents();
		try{
			System.out.println("Introduceti index-ul studentului: ");
		int index = consoleIn.nextInt();
		System.out.println("Introduceti modificarea numelui studentului: ");
		String nume = consoleIn.next();
		System.out.println("Introduceti modificarea prenumelui studentului: ");
		String prenume = consoleIn.next();
		System.out.println("Introduceti modificarea mediei studentului: ");
		double medie = consoleIn.nextDouble();
		System.out.println("Introduceti modificarea specializarii studentului: ");
		String specializare = consoleIn.next();
				
		studentsList.set(index, new Student(nume,prenume,medie,specializare));
		}catch(IndexOutOfBoundsException ex){
		
			System.out.println("Eroare: " + ex.getMessage());
		}
	}
    public void load()
    {
        
        ArrayList<IMenuItem> menuItems = new ArrayList();
        ArrayList<IMenuItem> showStudentsOptions = new ArrayList();
        
        int shortCut = 1;    
        
         
       IMenuItem currentItem = new MenuItem("Adaugare informatii student nou ", shortCut++, (parameters)->{
           uiAddStudent();
       });       
       menuItems.add(currentItem);
       
       currentItem = new MenuItem("Stergere informatii student", shortCut++, (parameters)->{
    	   	uiDeleteStudent();
       });       
       menuItems.add(currentItem); 
       currentItem = new MenuItem("Modificare informatii student", shortCut++, (parameters)->{
   	   	uiModifyStudent();
      });       
      menuItems.add(currentItem); 
       
       showStudentsOptions.add(new MenuItem("Ordonare alfabetica dupa numele de familie", 1, (parameters) -> {
    	   alfabeticNume();
    	  
       }));
       showStudentsOptions.add(new MenuItem("Ordonare alfabetica dupa prenume", 2, (parameters) -> {
    	   alfabeticPrenume();
    	 
       }));
       
       showStudentsOptions.add(new MenuItem("Ordonare medie crescator ", 3, (parameters) -> {
       
    	   crescatorMedie();
          }));
       showStudentsOptions.add(new MenuItem("Ordonare medie descrescator", 4, (parameters) -> {
    	   
        	   descrescatorMedie();
              }));
         
       currentItem = new Menu("Afiseaza informatii student", shortCut++, showStudentsOptions);       
       menuItems.add(currentItem);
       
       
        
        mainMenu = new Menu("Main Menu", -1, menuItems);
        
    }
       
    public void execute()
    {
        mainMenu.execute();
    }
    
}







