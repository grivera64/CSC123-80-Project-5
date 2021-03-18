//package project5;

/*
*
*	Name: Manager.java
*	Driver Class: BusinessTest.java (BuisinessTest.java)
*	Purpose: Extends the Employee Class for Manager-level Employees
*	Author: grivera64
*	Date: 3/17/2021
*
*/

//importing the ArrayList from the java.util package
import java.util.ArrayList;

//inherits from Employee
public class Manager extends Employee
{
	
	//private global fields
	private ArrayList<Employee> managedEmployees = new ArrayList<Employee>();
	
	//constructor specific to Manager Employees
	public Manager(String name, String title, int idNumber, int age, double salary)
	{
		
		super(name, title, idNumber, age, salary);
		
	}
	
	/* Accessors adn Mutators */
	public void addManagedEmployee(Employee employee)
	{
		//adds to ArrayList
		this.managedEmployees.add(employee);
		
	}
	
	public int getManagedEmployeeListSize()
	{
		//returns the size of the ArrayList
		return this.managedEmployees.size();
		
	}
	
	//Return a specific employee of the managedEmployees ArrayList
	public Employee getManagedEmployee(int i)
	{
		//get member of the ArrayList
		return this.managedEmployees.get(i);
		
	}
	
	//@Override
	public String toString()
	{
		//returns a formatted String
		return String.format(
		"The manager name and title are %s %s\n" +
		"The manager ID is %d The manager age is %d\n" +
		"The manager salary is $%.2f",
		super.getName(), super.getTitle(), super.getIdNumber(), super.getAge(), super.getSalary());
		
	}
	
}