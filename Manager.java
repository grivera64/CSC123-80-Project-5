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

import java.util.ArrayList;

public class Manager extends Employee
{
	
	private ArrayList<Employee> managedEmployees = new ArrayList<Employee>();
	
	public Manager(String name, String title, int idNumber, int age, double salary)
	{
		
		super(name, title, idNumber, age, salary);
		
	}
	
	public void addManagedEmployee(Employee employee)
	{
		
		this.managedEmployees.add(employee);
		
	}
	
	public int getManagedEmployeeListSize()
	{
		
		return this.managedEmployees.size();
		
	}
	
	public Employee getManagedEmployee(int i)
	{
		
		return this.managedEmployees.get(i);
		
	}
	
	//@Override
	//uses "Dynamic Dispatch"
	public void setIdNumber(int idNumber)
	{
		
		super.setIdNumber((2000 < idNumber && idNumber <= 3000) ? idNumber : 0);
		
	}
	
	//@Override
	public String toString()
	{
		
		return String.format(
		"The manager name and title are %s %s\n" +
		"The manager ID is %d The manager age is %d\n" +
		"The manager salary is $%.2f",
		super.getName(), super.getTitle(), super.getIdNumber(), super.getAge(), super.getSalary());
		
	}
	
}