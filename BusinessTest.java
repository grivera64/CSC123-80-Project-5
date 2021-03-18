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
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class BusinessTest
{
	
	
	public static void main(String[] args) throws IOException
	{
		
		Scanner keyboard = new Scanner(System.in);
		
		ArrayList<Employee> employeeAL = new ArrayList<Employee>();
		ArrayList<Manager> managerAL = new ArrayList<Manager>();
		ArrayList<Executive> executiveAL = new ArrayList<Executive>();
		File file = null;
		
		do
		{
			System.out.printf("Please enter the employee list text file name: ");
			String fileName = keyboard.nextLine();
			file = new File(fileName);
			
		
		} while (!file.exists());
		
		Scanner inFile = new Scanner(file);
		
		while(inFile.hasNext())
		{
			
			String name = "";
			String title = "";
			int idNumber = 0;
			int age = 0;
			double salary = 0.0;
			
			try
			{
				
				name = inFile.next();
				title = inFile.next();
				idNumber = inFile.nextInt();
				age = inFile.nextInt();
				salary = inFile.nextDouble();
				if (inFile.hasNext())
				{
					
					inFile.nextLine();
				
				}
				
			}
			catch (InputMismatchException e)
			{
				
				System.out.printf("Corrupt Data! Terminating Program!\n");
				System.exit(0);
				
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
		
		inFile.close();
		
		int indexOfAddManager = 0;
		for (Employee employee : employeeAL)
		{
			
			managerAL.get(indexOfAddManager++).addManagedEmployee(employee);
			
			indexOfAddManager %= managerAL.size();
			
		}
		
		int indexOfAddExecutive = 0;
		for (Manager manager : managerAL)
		{
			
			executiveAL.get(indexOfAddExecutive++).addManagedEmployee(manager);
			indexOfAddExecutive %= executiveAL.size();
			
		}
		
		System.out.printf("Please enter the total company profit for the year: $");
		double profit = keyboard.nextDouble();
		keyboard.nextLine();
		
		System.out.printf("Please enter the executive bonus percentage for the year correct to 1 decimal place: ");
		double bonus = keyboard.nextDouble();
		keyboard.nextLine();
		
		System.out.printf("Please enter the name of the ouput file: ");
		PrintWriter outputFile = new PrintWriter(new File(keyboard.nextLine()));
		
		
		double totalPayRoll = 0;
		
		for (Executive executive : executiveAL)
		{
			executive.setTotalComp(profit, bonus);
			totalPayRoll += executive.getTotalComp();
			
		}
		
		outputFile.printf("The total payroll for the business is $%,.2f\n", totalPayRoll);
		
		outputFile.printf("Compensation Table\nExecutives\n");
		
		outputFile.printf("%-15s%-18s%-9s%-7s%-15s%s\n", "Name", "Title", "ID", "Age", "Salary", "Total Comp");
		
		for (Executive executive : executiveAL)
		{
			
			//					name,  title, id, age,  salary, total comp
			outputFile.printf("%-15s%-18s%-9d%-7d$%-14.2f$%.2f\n", 
								executive.getName(), executive.getTitle(),
								executive.getIdNumber(), executive.getAge(), 
								executive.getSalary(), executive.getTotalComp());
			
		}
		
		outputFile.println();
		
		outputFile.printf("Managers\n");
		outputFile.printf("%-15s%-18s%-9s%-7s%-15s\n", "Name", "Title", "ID", "Age", "Salary");
		
		for (Manager manager : managerAL)
		{
			
			outputFile.printf("%-15s%-18s%-9d%-7d$%-15.2f\n", 
								manager.getName(), manager.getTitle(),
								manager.getIdNumber(), manager.getAge(), 
								manager.getSalary());
			
		}
		
		outputFile.println();
		
		outputFile.printf("Employees\n");
		outputFile.printf("%-15s%-18s%-9s%-7s%-15s\n", "Name", "Title", "ID", "Age", "Salary");
		
		for (Employee employee : employeeAL)
		{
			
			outputFile.printf("%-15s%-18s%-9d%-7d$%-15.2f\n", 
								employee.getName(), employee.getTitle(),
								employee.getIdNumber(), employee.getAge(), 
								employee.getSalary());
			
		}
		
		outputFile.println("\n");
		
		outputFile.printf("Reporting Structure\n\n");
		
		outputFile.printf("Direct Reports To Executive\n");
		
		for (Executive executive : executiveAL)
		{
			
			outputFile.printf("Executive %s has the following direct reports\n", executive.getName());
			
			for (int indexOfExecutive = 0; indexOfExecutive < executive.getManagedEmployeeListSize(); indexOfExecutive++)
			{
				
				Employee current = executive.getManagedEmployee(indexOfExecutive);
				
				outputFile.printf("%-15s%d\n", current.getName(), current.getIdNumber());
				
			}
			
			outputFile.println();
			
		}
		
		outputFile.printf("\n\n");
		
		outputFile.printf("Direct Reports To Managers\n");
		
		for (Manager manager : managerAL)
		{
			
			outputFile.printf("Manager %s has the following direct reports\n", manager.getName());
			
			for (int indexOfManager = 0; indexOfManager < manager.getManagedEmployeeListSize(); indexOfManager++)
			{
				
				Employee current = manager.getManagedEmployee(indexOfManager);
				
				outputFile.printf("%-15s%d\n", current.getName(), current.getIdNumber());
				
			}
			
			outputFile.println();
			
		}
		
		outputFile.printf("\n");
		
		System.out.printf("Please enter the salary change for a Manager as a percentage: ");
		double change = keyboard.nextDouble();
		keyboard.nextLine();
		
		outputFile.printf("Manager List iWith New Salary\n");
		
		for (Manager manager : managerAL)
		{
			
			outputFile.printf("%s\n", manager);
		
		}
		
		
		outputFile.close();
		
		keyboard.close();
		
	}
	
	
}