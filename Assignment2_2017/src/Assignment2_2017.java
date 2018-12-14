/**
 * Assignment 2_2017
 *
 * Student Name: Manik Shakya
 * Student Number: 2869290
 
 *
 *Assignment 2
Please complete the problems listed below. 
This assignment forms part of the assessment for this module and you are required to upload a 
copy of your solution on Moodle using the template program listed on Moodle. 
Please remember to include your name and student number. 

Question 1
A circle in co-ordinate Geometry has a centre, represented by a point in the plane, and a radius. 
Write a class that represents a circle. Your class should have methods that:
•	return the centre of the circle;
•	returns its radius
•	calculates its area
•	calculates its circumference
•	calculates the distance of its centre point from that of a given circle c1
•	determines if a point is on the circle
•	determines if it intersects with a given circle c1
Formulas


 
Question 2
Write a class Email that has two string attributes: home that records the home e-mail address 
and work that records the work e-mail. It should have methods to retrieve both addresses 
and also methods that change email addresses. You may assume that both e-mail addresses are valid.

Write a class Employee that has three attributes: a surname, a first name and an e-mail address 
represented by the class Email. Your constructor should take 3 arguments: surname, firstName 
and an instance of the Email class.

This class should have methods that return: the name as a string representing both surname 
and first name and the e-mails of the employee. 

The important point is to write this Employee class so that encapsulation is not endangered by any of its public methods

 *
 */
import java.util.*;
public class Assignment2_2017 {
	public static void main(String[] args) {
    //Question 1 test Circle class here
    Point p1 = new Point(2.0, 3.0);
    Point p2 = new Point(3.0, 2.0);
		
	Circle c1 = new Circle(p1, 3.5);
    Circle c2 = new Circle(p2, 4.5);
    
    
    System.out.println("Radius: " + c1.getRadius());
    System.out.println("Area: " + c1.getArea());
    System.out.println("Circumference: " + c1.getCircumference());
    System.out.println("Midpoint: " + p1.midPoint(p2));
    System.out.println("Distance: " + c1.getCentre(p1).distance(c2.getCentre(p2)));
    
    //============================================================
    //Question 2 testing here ====================================
    Email e = new Email("abc@yahoo.com", "xyz@yahoo.com");
	Employee employee = new Employee("Shakya", "Manik", e);
	
	
	
	System.out.println("\n\n" + employee.getName());
	System.out.println("\n\n" + employee.getEmails());
	System.out.println("\n\n" + employee.toString());
	
	e.setHomeEmail("abc123@yahoo.com");
	e.setWorkEmail("xyz987@yahoo.com");
	
	System.out.println("\n\n" + e.toString());
	System.out.println("\n\n" + e.getHome());
	System.out.println("\n\n" + e.getWork());
	System.out.println("\n\n" + employee.toString()); // Employee emails not changed even when we used the setter functions.
    
  }
}
//Classes for Question 1======================================
class Circle{
	private double radius, area, circumference, distance, x1, y1;
	private Scanner in;
	
	public Circle(Point p, double r){
		radius = r;
	}
	
	public Point getCentre(Point p){
		
		return new Point(p.x(), p.y()).midPoint(p);
		
	}
	public double getRadius(){
		return radius;
	}
	public double getArea(){
		return Math.PI * radius * radius;
	}
	public double getCircumference(){
		return 2 * Math.PI * radius;
	}
}
//classes for Question 2==================================================
class Emails{
	private String homeEmail;
	private String workEmail;
	
	public Emails(String h, String w){
		homeEmail = h;
		workEmail = w;
	}
	
	public String getHome(){
		return homeEmail;
	}
	public String getWork(){
		return workEmail;
	}
	public void setHomeEmail(String e){
		this.homeEmail = e;
	}
	public void setWorkEmail(String e){
		this.workEmail = e;
	}
	public String toString(){
		return "Home email: " + homeEmail + "\nWork email: " + workEmail;
	}
}

class Employees{
	private String surname;
	private String firstname;
	private Emails email;
	
	public Employees(String s, String f, Email e){
		this.surname = s;
		this.firstname = f;
		this.email = new Emails(e.getHome(), e.getWork());
	}
	
	public String getName(){
		return surname + " " + firstname;
	}
	public Emails getEmails(){
		return email; 
	}
	public String toString(){
		return "Name: "+ surname + " " + firstname + "\nHome email: " + email.getHome() + "\nWork email: " + email.getWork();
	}



}

class Point{
	private double x,y;
	public Point(double x0, double y0){
		x = x0; y = y0;
	}
	public Point(){
		 x = 0.0; y = 0.0;
	}
  public Point(Scanner in){
  	  System.out.print("Enter Co-ordinates: ");
  	  x = in.nextDouble();
  	  y = in.nextDouble();
  }
	public double x(){return x;}
	public double y(){return y;}
	public void setX(double x0){x = x0;}
	public void setY(double y0){y = y0;}
	public String toString(){
		return "("+x+","+y+")";
	}
	public void display(){
		String out = "("+x+","+y+")";
		System.out.println(out);
	}

	public double distance(Point p){
		double x1 = this.x-p.x();
		double y1 = this.y-p.y();
		double d = Math.sqrt(x1*x1+y1*y1);
		return d;
	}
	public void move(double x1, double y1){
		x = x + x1;  
		y = y + y1;
	}
	public Point midPoint(Point p){
		return new Point((this.x+p.x())/2.0,
		                  (this.y+p.y())/2.0);
	}
}



