import java.util.Arrays;

/**
 *
 * Student name: Manik Shakya
 * Student number: 2869290
 */

/*
 * Question 1

(a)	A computer program for a certain university has to manipulate both lecturers and students. 
A class is required for each. Write a class Person that encapsulates what is common to the notion 
of a person. The class should include a name, a phone number, a gender and an all argument constructor.
Methods that retrieve name, phone and gender should be included. 
It should also have a toString() method that returns a string representing the state of the class.

(b)	A student is a person with additionally a student number and a subject of study. 
Write a class Student by extending class Person. 
It should include a toString()  method and methods to retrieve name, phone, gender, student number 
and subject.
 
(c)	A lecturer is a person with additionally a staff number and a department. 
Write a class Lecturer by extending class Person. It should include a toString()  
method and methods to retrieve details about a lecturer.

(d)	Write a simple test program that tests your classes.

 * */

public class Assignment4_2017 {
  public static void main(String[] args) {
        // Code for test here
	  
	  Student p = new Student("Manik", "24134", "Male", "2869290", "OOP");
	  Lecturer p1 = new Lecturer("Tony", "45678", "Male", "OOPTONY", "OOP");
	  
	  System.out.println(p);
	  System.out.println(p.getGender());
	  System.out.println(p.getStudentNumber());
	  System.out.println(p1);
	  System.out.println(p1.getName());
	  System.out.println(p1.getDepartment());
	  
	  
	  // Question 2
	  Lecturers test1 = new Lecturers(10);
	  test1.add(new Lecturer("Paddy", "45678", "Male", "CHPaddy", "CH"));
	  test1.add(new Lecturer("TONY", "65756", "Male", "OOPTONY", "OOP"));
	  test1.add(new Lecturer("Eoin", "762345", "Male", "OOPEOIN", "Basic"));
	  test1.add(new Lecturer("Barry", "45678", "Male", "RDBMS", "RDBMS"));
	  test1.add(new Lecturer("Patrick", "45678", "Male", "RDBMS", "RDBMS"));
		  
	  //test1.getLecturersByDepartment("OOP");
	  System.out.println(Arrays.toString(test1.getLecturersByDepartment("RDBMS")));
  }
}
//Q1 classes ==================================================
class Person{
	private String name, phoneNumber, gender;
	
	public Person(String n, String p, String g){name = n;phoneNumber = p;gender = g;}
	
	public String getName(){return name;}
	public String getPhone(){return phoneNumber;}
	public String getGender(){return gender;}
	
	public String toString(){
		
		return name + " " + phoneNumber + " " + gender;
	}
}

class Student extends Person{
	private String studentNumber, subject;
	
	public Student(String n, String p, String g, String sn, String sub){
		super(n, p, g);
		studentNumber = sn;
		subject = sub;
	}
	
	public String getStudentNumber(){return studentNumber;}
	public String getSubject(){return subject;}
	
	public String toString(){
		return super.toString() + " " + studentNumber + " " + subject;
	}
}

class Lecturer extends Person{
	private String staffNo, department;
	public Lecturer(String n, String p, String g, String sn, String dep){
		super(n, p, g);
		staffNo = sn;
		department = dep;
	}
	
	public String getStaffNo(){return staffNo;}
	public String getDepartment(){return department;}
	
	public String toString(){
		return super.toString() + " " + staffNo + " " + department;
	}
}

//Q2 class ====================================================

/*
 * Question 2

Write a class Lecturers that encompasses a collection of Lecturer. 
It should be possible to add a new lecturer, retrieve all lecturers of a given gender, 
retrieve all lecturers working in a given department and find a lecturer given their staff number.

 * */
class Lecturers{
	private Lecturer[] data;
	private int size;
	public Lecturers(int n){
		data = new Lecturer[n];
		size = 0;
	}
	
	public void add(Lecturer l){
		if(size < data.length){
			data[size] = l; size++;
		}
	}
	
	public String[] getLecturersByGender(String g){
		int totalLecturers = 0;
		
		for(int i = 0; i < size; i++){
			if((data[i].getGender()).equals(g)){
				totalLecturers++;
			}
		}
		
		String[] Lecturers = new String[totalLecturers];
		
		int j = 0;
		for(int i = 0; i < size; i++){
			if((data[i].getGender()).equals(g)){
				Lecturers[j] = data[i].getName();
				j++;
			}
		}
		return Lecturers;
	}
	public String[] getLecturersByDepartment(String dep){
		int totalLecturers = 0;
		
		for(int i = 0; i < size; i++){
			if((data[i].getDepartment()).equals(dep)){
				totalLecturers++;
			}
		}
		
		String[] Lecturers = new String[totalLecturers];
		
		int j = 0;
		for(int i = 0; i < size; i++){
			if((data[i].getDepartment()).equals(dep)){
				Lecturers[j] = data[i].getName();
				j++;
			}
		}
		return Lecturers;	
	}
	public String[] getLecturerByStaffNumber(String sn){
		int totalLecturers = 0;
		
		for(int i = 0; i < size; i++){
			if((data[i].getStaffNo()).equals(sn)){
				totalLecturers++;
			}
		}
		
		String[] Lecturers = new String[totalLecturers];
		
		int j = 0;
		for(int i = 0; i < size; i++){
			if((data[i].getStaffNo()).equals(sn)){
				Lecturers[j] = data[i].getName();
				j++;
			}
		}
		return Lecturers;
	}
	
	
	
	public int size(){return size;}
	public String toString(){
		if(size == 0) return "[]";
		String s = "[";
		for(int j = 0; j < size - 1; j++)
			s = s + data[j] + ",";
		return s+data[size-1]+"]";
	}
}

//=============================================================