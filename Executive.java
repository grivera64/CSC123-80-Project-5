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
	
	public void setTotalComp(double profits, double bonus)
	{
		
		this.totalComp = super.getSalary() + 
						(profits * 
						((bonus < -0.0001 || 100.0001 < bonus) ? 0 : bonus)
						);
		
	}
	
	public double getTotalComp()
	{
		
		return this.totalComp;
		
	}
	
	//@Override
	//uses "Dynamic Dispatch"
	public void setIdNumber(int idNumber)
	{
		
		super.idNumber = (3001 <= idNumber && idNumber <= 3500) ? idNumber : 0;
		
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