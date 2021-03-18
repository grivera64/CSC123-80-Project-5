//package project5;

/*
*	
*	Name: Executive.java
*	Driver Class: BusinessTest.java (BuisinessTest.java)
*	Purpose: Extends the Manager Class for Executive-level Employees
*	Author: grivera64
*	Date: 3/17/2021
*	
*/

//inhertis the Manager class (which inherites the Exployee class)
public class Executive extends Manager
{
	
	//private global variables
	private double totalComp;
	
	//constructor specific to Executive Manager Employee
	public Executive(String name, String title, int idNumber, int age, double salary)
	{
		
		super(name, title, idNumber, age, salary);
		
	}
	
	/* Mutator and Accessor */
	public void setTotalComp(double profits, double bonus)
	{
		
		this.totalComp = super.getSalary() + (profits * (bonus * 0.01));
		
	}
	
	public double getTotalComp()
	{
		
		return this.totalComp;
		
	}
	
	
	//@Override
	//Returns a string version of the Executive
	public String toString()
	{
		
		return String.format(
		"The executive name and title are %s %s\n" +
		"The executive ID is %d The executive age is %d\n" +
		"The executive salary and total compensation are $%,.2f and $%,.2f",
		super.getName(), super.getTitle(), super.getIdNumber(), super.getAge(), super.getSalary(), this.getTotalComp());
		
	}
	
}