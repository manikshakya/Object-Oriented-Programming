/* Assignment9_2017

Student name: Manik Shakya
Student number: 2869290

*/
import java.util.*;
public class Assignment9_2017{
	public static void main(String args[]){
	  //Create instance of Friends class and test methods here.
		
		Friends f = new Friends();
		
		f.add(new Person("Tony","Mullins"));
		f.add(new Person("Barry","Mullins"));
		f.add(new Person("Barry","Tony"));
		f.add(new Person("Paddy","Fahy"));
		f.add(new Person("Barry","Murphy"));
		
		System.out.println(f);
		System.out.println(f.size());
		
		System.out.println(f.search(new Person("Barry","Mullins")));
		
		System.out.println(f.getSurname(("Mullins")));
		System.out.println(f.getFirstname(("Barry")));
		System.out.println(f.getFreq(("Barry")));
		
		System.out.println(f);
		f.del(new Person("Barry", "Mullins"));
		System.out.println(f);
		
		System.out.println(f.sort());
	  
	}
}

class Friends{
	private Set<Person> data = new HashSet<>();
	private int size;
	
	Friends(){
		//data = new HashSet[x];
		size = 0;
	}
	public void add(Person p){
		data.add(p); size++;
	}
	
	public boolean search(Person p){
		if(data.contains(p)){
			return true;
		}
		return false;
	}
	 public int size(){
		 return size;
	 }
	 public Set<Person> getSurname(String s){
		 Set<Person> p = new HashSet<>();
		 for(Person p1 : data){
			 if(p1.sName().equals(s)){
				 p.add(p1);
			 }
		 }
		 
		 return p;
	 }
	 public Set<Person> getFirstname(String f){
		 Set<Person> p = new HashSet<>();
		 for(Person p1 : data){
			 if(p1.fName().equals(f)){
				 p.add(p1);
			 }
		 }
		 
		 return p;
	 }
	 public int getFreq(String f){
		 //Set<Person> p = new HashSet<>();
		 int counter = 0;
		 for(Person p1 : data){
			 if(p1.fName().equals(f)){
				 counter++;
			 }
		 }
		 
		 return counter;
	 }
	 public void del(Person p){
		 //Set<Person> p = new HashSet<>();
		 //int counter = 0;
		 Iterator<Person> loop = data.iterator();
		 
		 while(loop.hasNext()){
			 if(loop.next().equals(p)){
				 loop.remove();
			 }
		 }
		 
//		 for(Person p1 : data){
//			 if(p1.equals(p)){
//				 data.remove(p);
//			 }
//		 }
		 
		 //return counter;
	 }
	 
	 public Set<Person> sort(){
		 Set<Person> p = new TreeSet<>();
		 for(Person p1 : data){
			 p.add(p1);
		 }
		 
		 return p;
	 }
	 
	 public String toString(){return data.toString();}
	
}

final class Person implements Comparable<Person>{
	private final String sName;
	private final String fName;
	
	Person(String fn, String sn){fName = fn; sName = sn;}
	public String sName(){return sName;}
	public String fName(){return fName;}
	public String toString(){return fName+" "+sName;}
	public boolean equals(Object ob){
		if(!(ob instanceof Person)) return false;
		Person p = (Person)ob;
		return sName.equals(p.sName) && fName.equals(p.fName);
	}
	public int compareTo(Person p){
		if(p == null) return -1;
    if(this.equals(p)) return 0;
		if(sName.equals(p.sName)) return fName.compareTo(p.fName);
		return sName.compareTo(p.sName);
	}
	public int hashCode(){
    return sName.hashCode() * fName.hashCode();
  }
}