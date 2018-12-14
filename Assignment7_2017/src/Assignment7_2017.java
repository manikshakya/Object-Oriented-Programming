import java.util.Arrays;

/**
 *
 * Student name: Manik Shakya
 * Student number: 2869290
 *
 */
public class Assignment7_2017{
	public static void main(String args[]){
	 //Test Q1 =======================================
	 Person p1 = new Person("1234abc", "Manik", "08/12/1994");
	 Person p2 = new Person("1234ABC", "Tony", "02/10/1975");
	 
	 Person[] array = {new Person("1235pqc", "Manik", "02/10/1934"),
			 new Person("1234abc", "Tony", "08/08/1999"),
			 new Person("1234ayz", "Paddy", "08/12/1984"),
			 new Person("1234aYZ", "Eoin", "11/11/1990"),
			 new Person("1234ABc", "Ruairi", "08/10/1884"),
			 new Person("1234CbA", "Barry", "04/05/2000")};
	 
	 Arrays.sort(array);
	 
	 for(int i = 0; i < array.length; i++){
		 System.out.println(array[i]);
	 }
	 
	 
	 System.out.println(p1.compareTo(p2));
	 System.out.println(p1.equals(p2));
	 System.out.println(p1);
	 System.out.println(p2.hashCode());
	 
	 //Test Q2 =======================================
	  Vector v1 = new Vector(-2,4);
	  Vector v2 = new Vector(4,3);
	  Vector v3 = new Vector(2,4);
	  
	  System.out.println(v1.compareTo(v2));
	  System.out.println(v2.compareTo(v3));
	  System.out.println(v1.compareTo(v3));
	  
	  System.out.println(v1.equals(v2));
	  System.out.println(v2.equals(v3));
	  System.out.println(v1.equals(v3));
	  
	  System.out.println(v1.hashcode());
	  System.out.println(v2.hashcode());
	  System.out.println(v3.hashcode());
	}
}
//Q1  =============================================
//Add classes for Q1 here =========================
final class Person implements Comparable<Person>{// implements Comparable<Person>{{
	private final String prsi;
	private final String name;
	private final String dob;
	Person(String p, String n, String d){
		prsi = p; name = n; dob = d;
	}
	public String prsi(){return prsi;}
	public String name(){return name;}
	public String dob(){return dob;}
	
	
	@Override
	public int compareTo(Person o) {
		if(o == null){
			return -1;
		}else{
			return this.prsi.compareTo(o.prsi);
		}
	}
	
	public boolean equals(Person o){
		if(this.prsi.equals(o.prsi)){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return this.name+ " " + this.dob +" "+ this.prsi;
	}
	
	public int hashcode(){
		int i = this.prsi.hashCode();
		
		return i;
	}
	
	
	
	
}


//Q2 ===============================================
class Vector implements Comparable<Vector>{ // implements Comparable<Vector>{
	private double a,b;
	Vector(double a0, double b0){a = a0; b = b0;}
	
	@Override
	public int compareTo(Vector o) {
		if(o == null) return -1;
		Double a1 = a, b1 = b, c1 = o.a, d1 = o.b;
	    int i = a1.compareTo(c1);
		int j = b1.compareTo(d1);
		return (i != 0) ? i : j;
		
	}
	
	public boolean equals(Vector v){
		if(this.a == v.a && this.b == v.b){
			return true;
		}
		return false;
	}
	
	public int hashcode(){
		Double a1 = a, b1 = b;
		
		Integer i = b1.intValue();
		int hash = a1.hashCode() + i;
		
		return hash;
	} 
	
	public String toString(){
		return a +"i + "+ b + "j";
	}

	
} 


//end =============================

