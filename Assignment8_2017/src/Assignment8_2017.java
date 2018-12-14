/*
 * Assignment 8
 *
 * Student name: Manik Shakya
 * Student number: 2869290
 *
 */
import java.time.Month;
import java.util.*;
public class Assignment8_2017 {
 public static void main(String[] args) {
   //Q1 Test =====================================
	 System.out.println(Converter.toCelcius(98));
	 System.out.println(Converter.toFahrenheit(98));
	 System.out.println(Converter.toMiles(98));
	 System.out.println(Converter.toKilometers(98));
	 	
   // Q1 end ======================================

	 	//Q2 Test ======================================
	    //Test array
	     Module[] mlst = {
	    	 new Module("Programming","Donal",36),
	    	 new Module("Networks","Faheem",36),
	    	 new Module("Graphics","Barry",36),
	    	 new Module("Web","Ruairi",36),
	    	 new Module("Hardware","Paddy",36),
	    	 new Module("Algorithms","Eoin",36),
	    	 new Module("OOP","Tony",36),
	    	 new Module("Maths","Paddy",36),
	    	 new Module("BigData","Osama",36)
	    };
	     
	     System.out.println();
	     for(Module m : mlst)
	    	 System.out.println(m);
	     
	     Arrays.sort(mlst);
	     System.out.println();
	     for(Module m : mlst)
	    	 System.out.println(m);
	     
	     Arrays.sort(mlst, Module.lectCompare);
	     System.out.println();
	     for(Module m : mlst)
	    	 System.out.println(m);
	    //Q2 end =======================================
   //Q3 Test ======================================
	     System.out.println(Year.Month.AUGUST.getSeason());
	     
   
   
 }
}

class Converter{
	private Converter(){};
	
	public static double toCelcius(double f){
		//double c = (f - 32)*5.0/9.0;
		return Double.parseDouble(String.format("%.2f", (f - 32)*5.0/9.0));
	}
	public static double toFahrenheit(double c){
		double f = (c * 9.0/5.0) + 32;
		return Double.parseDouble(String.format("%.2f", (c * 9.0/5.0) + 32));
	}
	public static double toKilometers(double m){
		double k = 1.609*m;
		return Double.parseDouble(String.format("%.2f", 1.609*m));
	}
	public static double toMiles(double k){
		double m = k /1.609;
		return Double.parseDouble(String.format("%.2f", k /1.609));
	}
	

}
class Module implements Comparable<Module>{ //implements Comparable<Module>{
	private String title;
	private String lecturer;
	private int hours;
	Module(String t, String l, int h){
		title = t; lecturer = l; hours = h;
	}
	public String title(){return title;}
	String lecturer(){return lecturer;}
  int hours(){return hours;}
  public boolean equals(Object ob){
  	if(!(ob instanceof Module)) return false;
  	Module m = (Module)ob;
  	return title.equals(m.title);
  }
  public int hashCode(){return title.hashCode();}
  public String toString(){return title+" "+lecturer+" "+hours;}
  
  @Override
  public int compareTo(Module m){
	  if(m == null) return -1;
	  if(this.equals(m)) return 0;
	  
	  return this.title.compareTo(m.title);
  }
  public static Comparator<Module> lectCompare = new Comparator<Module>(){
	@Override
	public int compare(Module o1, Module o2) {
		// TODO Auto-generated method stub
		return o1.lecturer.compareTo(o2.lecturer);
	}
  };
  
}

class Year{
	enum Season{
		SPRING, SUMMER, FALL, WINTER;
		
		public String toString(){
			
			switch(this){
			case SPRING: return "Spring";
			case SUMMER: return "Summer";
			case FALL: return "Fall";
			default: return "Winter";
			}
		}
	}
	enum Month{
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
		
		public String toString(){
			switch(this){
			case JANUARY: return "January";
			case FEBRUARY: return "February";
			case MARCH: return "March";
			case APRIL: return "April";
			case MAY: return "May";
			case JUNE: return "June";
			case JULY: return "July";
			case AUGUST: return "August";
			case SEPTEMBER: return "September";
			case OCTOBER: return "October";
			case NOVEMBER: return "November";
			default: return "December";
			}
		}
		public Season  getSeason(){
			switch(this){
			case JANUARY: return Season.WINTER;
			case FEBRUARY: return Season.WINTER;
			case MARCH: return Season.SPRING;
			case APRIL: return Season.SPRING;
			case MAY: return Season.SPRING;
			case JUNE: return Season.SUMMER;
			case JULY: return Season.SUMMER;
			case AUGUST: return Season.SUMMER;
			case SEPTEMBER: return Season.FALL;
			case OCTOBER: return Season.FALL;
			case NOVEMBER: return Season.FALL;
			default: return Season.WINTER;
			}
//			for(Month k : Month.values()){
//				if(k.ordinal() == 3 || k.ordinal() == 4 || k.ordinal() == 5){
//					return Season.SPRING;
//				}else if(k.ordinal() == 6 || k.ordinal() == 7 || k.ordinal() == 8){
//					return Season.SUMMER;
//				}else if(k.ordinal() == 9 || k.ordinal() == 10 || k.ordinal() == 11){
//					return Season.FALL;
//				}
//			}
//			return Season.WINTER;
		}
	}
}



