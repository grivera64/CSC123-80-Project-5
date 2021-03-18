 //package project5;
 
 /*
 *	
 *	Name: Employee.java
 *	Driver Class: BusinessTest.java (BuisinessTest.java)
 *	Purpose: Serve the basic class for Employees
 *	Author: grivera64
 *	Date: 3/17/2021
 *
 */
 
 public class Employee
 {
	 
	 private String name;
	 private String title;
	 private int idNumber;
	 private int age;
	 private double salary;
	 
	 public Employee(String name, String title, int idNumber, int age, double salary)
	 {
		 
		 this.setName(name);
		 this.setTitle(title);
		 this.setIdNumber(idNumber);
		 this.setAge(age);
		 this.setSalary(salary);
		 
	 }
	 
	 public void setName(String name)
	 {
		 
		 this.name = name;
		 
	 }
	 
	 public String getName()
	 {
		 
		 return this.name;
		 
	 }
	 
	 public void setTitle(String title)
	 {
		 
		 this.title = title;
		 
	 }
	 
	 public String getTitle()
	 {
		 
		 return this.title;
		 
	 }
	 
	 public void setIdNumber(int idNumber)
	 {
		 
		 this.idNumber = (idNumber > 0 && idNumber <= 2000) ? idNumber : 0;
		 
	 }
	 
	 public int getIdNumber()
	 {
		 
		 return this.idNumber;
		 
	 }
	 
	 public void setAge(int age)
	 {
		 
		 this.age = (age > 15) ? age : 15;
		 
	 }
	 
	 public int getAge()
	 {
		 
		return this.age; 
		 
	 }
	 
	 public void setSalary(double salary)
	 {
		 
		 this.salary = (salary >= 0) ? salary : 0;
		 
	 }
	 
	 public double getSalary()
	 {
		 
		 return this.salary;
		 
	 }
	 
	 public void changeSalary(double percentage)
	 {
		 
		 if (percentage < -100.0001 || 100.001 < percentage)
		 {
			 
			 System.out.printf("Error! Salary not changed.\n");
			 return;
			 
		 }
		 
		 this.setSalary(this.getSalary() * (1.0 + (percentage * 0.01)));
		 
	 }
	 
	 //@Override
	 public String toString()
	 {
		 
		 return String.format(
		 "The employee name and title are %s %s\n" + 
		 "The employee ID is %d The employee age is %d\n" + 
		 "The Employee salary is %,.2f",
		 this.getName(), this.getTitle(), this.getIdNumber(), this.getAge(), this.getSalary());
		 
	 }
	 
 }