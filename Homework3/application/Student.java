package application;

public class Student
{
	private String nume;
	private String prenume;
	private double medie;
	private String specializare;

	public Student(String nume, String prenume,double medie, String specializare)
	{
		this.nume = nume;
		this.prenume = prenume;
		this.medie = medie;
		this.specializare = specializare;
	}
	

	public String getNume()
	{
		return nume;
	}
	public void setNume(String nume) 
	{
		this.nume = nume;
	}
	public String getPrenume()
	{
		
		return prenume;
	}
	public void setPrenume(String prenume) 
	{
		this.prenume = prenume;
	}
	public double getMedia()
	{
		return medie;
	}
	public void setMedia(double medie)
	{
		this.medie = medie;
	}
	
	public String getSpecializare() 
	{
		return specializare;
	}

	public void setSpecializare(String specializare)
	{
		this.specializare = specializare;
	}






}
