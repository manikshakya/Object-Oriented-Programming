/**
 * Assignment 1_2017
 *
 * Student name: Manik Shakya
 * Student Number: 2869290
 * 
 * 
 * 
 * 
 * 
Question 1
Implement a class to model an on/off switch. Your class should have methods to turn on the switch, 
turn off the switch and check its current status. The class should have a toString method that returns 
its current state as a String. Write a short code block in to test your class in the file given for this 
assignment.

Question 2
Design and implement a class called Film that has the following attributes: name of film, 
name of director, duration of film measured in minutes and cost of production. 
The class should have methods to retrieve information on the current state of each of its attributes 
and a toString method that can be used to print its current state. In the file given for the assignment 
create 3 instances of the Film class and write a code fragment that finds the film with the most 
expensive production cost.
 */

public class Assignment1_2017{
	public static void main(String[] args){
		//===============================================
		//Test code for Question 1
		Switch sw = new Switch();
		sw.turnOn();
		System.out.println(sw);
		
		sw.turnOff();
		System.out.println(sw);
		System.out.println(sw.currentStatus());
				
		//===============================================
		//Test code for Question 2
		Film f1 = new Film("Cast Away", "Robert Zemeckis", "147", 90000000);
		System.out.println("\n\n" +f1);
		
		Film f2 = new Film("The Da Vinci Code", "Ron Howard", "149", 125000000);
		System.out.println("\n\n" +f2);
		
		Film f3 = new Film("The Terminal", "Steven Spielberg", "128", 60000000);
		System.out.println("\n\n" +f3);
		//===============================================
	}
}
//================================================
//code for classes here
class Switch{
	private boolean status;
	
	public void turnOn(){status = true;}
	public void turnOff(){status = false;}
	public boolean currentStatus(){return status;}
	public String toString(){
		if(status){
			return "On";
		}else{
			return "Off";
		}
	}
}

class Film{
	private String filmName, director, duration;
	private int cost;
	
	public Film(String f, String d, String du, int c){
		filmName = f; director = d; duration = du;
	}
	public String getFilm(){
		return filmName;
	}
	public String getDirector(){
		return filmName;
	}
	public String getDuration(){
		return filmName;
	}
	public int getCost(){
		return cost;
	}
	
	public String toString(){
		return "Film: " + filmName + "\nDirector: "+ director + "\nDuration: " + duration + "\nCost: " + cost;
	}
	
	
	
	
	
	
	
}