//package project5;

/*
*	
*	Name: BusinessTest.java (BuisinessTest.java) [Driver Class]
*	Purpose: Tests the Employee.java, Manager.java, and Executive.java classes
*	Author: grivera64
*	Date: 3/17/2021
*	
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.InputMismatchException;

public class BusinessTest
{
	
	
	public static void main(String[] args) throws IOException
	{
		
		ArrayList<Employee> employeeAL = new ArrayList<Employee>();
		ArrayList<Manager> managerAL = new ArrayList<Manager>();
		ArrayList<Executive> executiveAL = new ArrayList<Executive>();
		
		Scanner keyboard = new Scanner(System.in);
		File file;
		
		do
		{
			System.out.printf("Please enter the employee list text file name: ");
		
			file = new File(keyboard.nextLine());
		
		} while (!file.exists());
		
		Scanner inFile = new Scanner(file);
		
		while(inFile.hasNext())
		{
			
			try
			{
				
				String name = keyboard.next();
				String title = keyboard.next();
				int idNumber = keyboard.nextInt();
				int age = keyboard.nextInt();
				double salary = keyboard.nextDouble();
			}
			catch (InputMismatchException e)
			{
				
				System.out.printf("Corrupt Data! Terminating Program!\n);
				System.exit(0);
				
			}
			finally
			{
				keyboard.nextLine();
			}
			
			if (1 <= idNumber && idNumber <= 2000)
			{
				
				employeeAL.add(new Employee(name, title, idNumber, age, salary));
				
			}
			else if (idNumber <= 3000)
			{
				
				managerAL.add(new Manager(name, title, idNumber, age, salary));
				
			}
			else if (idNumber <= 3500)
			{
				
				executiveAL.add(new Executive(name, title, idNumber, age, salary));
				
			}
			else
			{
				
				System.out.printf("Not a valid ID\n");
				
			}
			
		}
		
		int indexOfManager = 0;
		for (Employee employee : employeesAL)
		{
			
			managerAL.get(indexOfManager++).addManagedEmployee(employee);
			
			indexOfManager %= managerAL.size();
			
		}
		
		int indexOfExecutive = 0;
		for (Manager manager : managerAL)
		{
			
			executiveAL.get(indexOfExecutive++).addManagedEmployee(manager);
			indexOfExecutive %= executiveAL.size();
			
		}
		
		System.out.printf("Please enter the total company profit for the year: $");
		double profit = keyboard.nextDouble();
		keyboard.nextLine();
		
		System.out.printf("Please enter the executive bonus percentage for the year correct to 1 decimal place: ");
		double bonus = keyboard.nextDouble();
		keyboard.nextLine();
		
		System.out.printf("Please enter the name of the ouput file: ");
		FileWriter outputFile = new FileWriter(keyboard.nextLine());
		
		
		double totalPayRoll = 0;
		
		for (Executive executive : executiveAL)
		{
			
			totalPayRoll += executive.getTotalComp();
			
		}
		
		outputFile.printf("The total payroll for the business is $%,.2f\n", totalPayRoll);
		
		outputFile.printf("Compensation Table\nExecutives\n");
		
		outputFile.printf("%-15s%-18s%-9s%-7s%-15s%s\n", "Name", "Title", "ID", "Age", "Salary", "Total Comp");
		
		for (Executive executive : executiveAL)
		{
			
			//					name,  title, id, age,  salary, total comp
			outputFile.printf("%-15s%-18s%-9d%-7d$%-15,.2f$%,.2f\n", 
								executive.getName(), executive.getTitle(),
								executive.getIdNumber(), executive.getAge(), 
								executive.getSalary(), executive.getTotalComp());
			
		}
		
		outputFile.println();
		
		outputFile.printf("Managers\n");
		outputFile.printf("%-15s%-18s%-9s%-7s%-15s\n", "Name", "Title", "ID", "Age", "Salary");
		
		for (Manager manager : managerAL)
		{
			
			outputFile.printf("%-15s%-18s%-9d%-7d$%-15,.2f$%,.2f\n", 
								manager.getName(), manager.getTitle(),
								manager.getIdNumber(), manager.getAge(), 
								manager.getSalary(), manager.getTotalComp());
			
		}
		
		outputFile.println();
		
		outputFile.printf("Employees\n");
		outputFile.printf("%-15s%-18s%-9s%-7s%-15s\n", "Name", "Title", "ID", "Age", "Salary");
		
		for (Employee employee : employeeAL)
		{
			
			outputFile.printf("%-15s%-18s%-9d%-7d$%-15,.2f$%,.2f\n", 
								employee.getName(), employee.getTitle(),
								employee.getIdNumber(), employee.getAge(), 
								empployee.getSalary(), employee.getTotalComp());
			
		}
		
		outputFile.println("\n");
		
		outputFile.printf("Reporting Structure\n\n");
		
		outputFile.printf("Direct Reports To Executive\n");
		
		for (Executive executive : executiveAL)
		{
			
			outputFile.printf("Executive %s has the following direct reports\n");
			
			for (int indexOfExecutive = 0; indexOfExecutive < executive.getManagedEmployeesListSize() - 1; indexOfExecutive++)
			{
				
				Manager current = executive.getManagedEmployee(indexOfExecutive);
				
				outputFile.printf("%-15s%d\n", current.getName(), current.getIdNumber());
				
			}
			
			outputFile.println();
			
		}
		
		outputFile.printf("\n\n");
		
		outputFile.printf("Direct Reports To Managers\n");
		
		for (Manager manager : managerAL)
		{
			
			outputFile.printf("Manager %s has the following direct reports\n");
			
			for (int indexOfManager = 0; indexOfManager < manager.getManagedEmployeesListSize() - 1; indexOfManager++)
			{
				
				Employee current = manager.getManagedEmployee(indexOfManager);
				
				outputFile.printf("%-15s%d\n", current.getName(), current.getIdNumber());
				
			}
			
			outputFile.println();
			
		}
		
		outputFile.printf("\n");
		
		
		
		
		keyboard.close();
		
	}
	
	
}