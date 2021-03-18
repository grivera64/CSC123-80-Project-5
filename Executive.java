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

public class Executive extends Manager
{
	
	private double totalComp;
	
	public Executive(String name, String title, int idNumber, int age, double salary)
	{
		
		super(name, title, idNumber, age, salary);
		
	}
	
	//bug here ASK ABOUT in class
	public void setTotalComp(double profits, double bonus)
	{
		
		this.totalComp = profits + bonus;
		
	}
	
	public double getTotalComp()
	{
		
		return this.totalComp;
		
	}
	
	
	//@Override
	public String toString()
	{
		
		return String.format(
		"The executive name and title are %s %s\n" +
		"The executive ID is %d The executive age is %d\n" +
		"The executive salary and total compensation are $%,.2f and $%,.2f",
		super.getName(), super.getTitle(), super.getIdNumber(), super.getAge(), super.getSalary(), this.getTotalComp());
		
	}
	
}