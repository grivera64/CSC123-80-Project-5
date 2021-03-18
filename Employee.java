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
	 //private global fields
	 private String name;
	 private String title;
	 private int idNumber;
	 private int age;
	 private double salary;
	 
	 //constructor for initializing employee
	 public Employee(String name, String title, int idNumber, int age, double salary)
	 {
		 
		 this.setName(name);
		 this.setTitle(title);
		 this.setIdNumber(idNumber);
		 this.setAge(age);
		 this.setSalary(salary);
		 
	 }
	 
	 /* Accessor and Mutator Methods Start */
	 
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
		 
		 this.idNumber = idNumber;
		 
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
	 
	 /* Accessor and Mutator Methods End */
	 
	 //changes the salary based on a percentage
	 public void changeSalary(double percentage)
	 {
		 
		 this.setSalary(this.getSalary() + (this.getSalary() * (percentage * 0.01)));
		 
	 }
	 
	 /* Accessor and Mutator Methods End */
	 
	 //@Override
	 //Overriding the toSring() method to provide our own string return for an Employee
	 public String toString()
	 {
		 
		 return String.format(
		 "The employee name and title are %s %s\n" + 
		 "The employee ID is %d The employee age is %d\n" + 
		 "The Employee salary is %,.2f",
		 this.getName(), this.getTitle(), this.getIdNumber(), this.getAge(), this.getSalary());
		 
	 }
	 
 }