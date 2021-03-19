//package project5;

/*
*	
*	Name: BusinessTest.java (BuisinessTest.java) [Driver Class]
*	Purpose: Tests the Employee.java, Manager.java, and Executive.java classes
*	Author: grivera64
*	Date: 3/17/2021
*	
*/

//importing ArrayList from util
import java.util.ArrayList;
//importing Scanner
import java.util.Scanner;
//impoting File
import java.io.File;
//importing Exception
import java.io.IOException;
//importing PrintWriter
import java.io.PrintWriter;
//importing Exceptions
import java.util.InputMismatchException;

public class BusinessTest
{
	
	//driver (entrance) method
	public static void main(String[] args) throws IOException
	{
		
		//Make keyboard scanner
		Scanner keyboard = new Scanner(System.in);
		
		//make Array List of each type of employee
		ArrayList<Employee> employeeAL = new ArrayList<Employee>();
		ArrayList<Manager> managerAL = new ArrayList<Manager>();
		ArrayList<Executive> executiveAL = new ArrayList<Executive>();
		
		//create file variable (must exists to continue)
		File file = null;
		
		do
		{
			System.out.printf("Please enter the employee list text file name: ");
			String fileName = keyboard.nextLine();
			file = new File(fileName);
			
		
		} while (!file.exists());
		
		//scan file
		Scanner inFile = new Scanner(file);
		while(inFile.hasNext())
		{
			
			//initializing to default
			String name = "";
			String title = "";
			int idNumber = 0;
			int age = 0;
			double salary = 0.0;
			
			//try to read from file unless inproper data type
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
			catch (InputMismatchException e) 		//exit if improper data
			{
				
				System.out.printf("Corrupt Data! Terminating Program!\n");
				System.exit(0);
				
			}
			
			//add to specific ArrayList
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
		
		//close Scanner
		inFile.close();
		
		/* add each Employee type under the higher Employee's managedEmployee ArrayList */
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
		
		/* End add to ArrayList */
		
		/* ask user for input and store */
		System.out.printf("Please enter the total company profit for the year: $");
		double profit = keyboard.nextDouble();
		keyboard.nextLine();
		
		System.out.printf("Please enter the executive bonus percentage for the year correct to 1 decimal place: ");
		double bonus = keyboard.nextDouble();
		keyboard.nextLine();
		
		//create output file
		System.out.printf("Please enter the name of the ouput file: ");
		PrintWriter outputFile = new PrintWriter(new File(keyboard.nextLine()));
		
		/* End asking */
		
		//calcuating the Total Compensation
		double totalPayRoll = 0;
		
		for (Executive executive : executiveAL)
		{
			executive.setTotalComp(profit, bonus);
			totalPayRoll += executive.getTotalComp();
			
		}
		
		for (Manager manager : managerAL)
		{
			
			totalPayRoll += manager.getSalary();
			
		}
		
		for (Employee employee : employeeAL)
		{
			
			totalPayRoll += employee.getSalary();
			
		}
		
		
		/* Print to Output File */
		outputFile.printf("The total payroll for the business is $%,.2f\n", totalPayRoll);
		
		outputFile.printf("Compensation Table\nExecutives\n");
		
		outputFile.printf("%-15s%-18s%-9s%-7s%-15s%s\n", "Name", "Title", "ID", "Age", "Salary", "Total Comp");
		
		for (Executive executive : executiveAL)
		{
			
			//					name,  title, id, age,  salary, total comp
			outputFile.printf("%-15s%-18s%-9d%-7d$%-,14.2f$%,.2f\n", 
								executive.getName(), executive.getTitle(),
								executive.getIdNumber(), executive.getAge(), 
								executive.getSalary(), executive.getTotalComp());
			
		}
		
		outputFile.println();
		
		outputFile.printf("Managers\n");
		outputFile.printf("%-15s%-18s%-9s%-7s%-15s\n", "Name", "Title", "ID", "Age", "Salary");
		
		for (Manager manager : managerAL)
		{
			
			outputFile.printf("%-15s%-18s%-9d%-7d$%-,15.2f\n", 
								manager.getName(), manager.getTitle(),
								manager.getIdNumber(), manager.getAge(), 
								manager.getSalary());
			
		}
		
		outputFile.println();
		
		outputFile.printf("Employees\n");
		outputFile.printf("%-15s%-18s%-9s%-7s%-15s\n", "Name", "Title", "ID", "Age", "Salary");
		
		for (Employee employee : employeeAL)
		{
			
			outputFile.printf("%-15s%-18s%-9d%-7d$%-,15.2f\n", 
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
		
		/* End Printing to Output File temporarily */
		
		//request for salary change percentage and store
		System.out.printf("Please enter the salary change for a Manager as a percentage: ");
		double change = keyboard.nextDouble();
		keyboard.nextLine();
		
		/* Finish printing to Output File */
		outputFile.printf("Manager List iWith New Salary\n");
		
		for (Manager manager : managerAL)
		{
			manager.changeSalary(change);
			outputFile.printf("%s\n", manager);
		
		}
		
		//close Files and Scanners
		outputFile.close();
		keyboard.close();
		
		//Terminate Program
		
	}
	
	
}