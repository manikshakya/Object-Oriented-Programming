/**
 *
 * Student name: Manik Shakya
 * Student number: 2869290
 */
 
import java.util.*;
public class Assignment6_2017{
	public static void main(String args[]){
	  //Q1 Testing ===================================
		Car c1 = new Car("Manik", "123456", "Ferrari", 1000,150000);
		Car c2;
		Car c3;
		
		
		c2 =  c1.setOwner("Tony");
		//System.out.println(c1);
		c3 = c2.setMake("Lamborghini");
		
		System.out.println(c1);
		System.out.println("\n" + c2);
		
		System.out.println("\n" + c1);
		System.out.println("\n" + c3);
		System.out.println("\n" + c2);
		
		c1 = c1.setMake("Lamborghini");
		System.out.println("\n" + c1);
		
		
		
	  //==============================================
	  //Q2 Testing ===================================
	  MyGarage garage = new MyGarage(5);
	  
	  garage.add(new Car("Manik", "123456", "Ferrari", 1000,150000));
	  garage.add(new Car("Paddy", "12345678", "Lamborghini", 3000,300000));
	  garage.add(new Car("Eoin", "1234567", "Bugatti", 2345,600000));
	  garage.add(new Car("Faheem", "1233424", "Ferrari", 3214,180000));
	  garage.add(new Car("Ruairi", "12345632", "Maserati", 10000,120000));
	  
	  garage.add(new Car("Manik", "1234234", "Ferrari", 1000,125000));
	  
	  
	  System.out.println(garage);
	  System.out.println(Arrays.toString(garage.getMake("Ferrari")));
	  System.out.println(garage.totalValue());
	  
	  garage.changeOwner("12345678", "Tony");
	  garage.changePrice("123456", 20000);
	  
	  garage.reducePricesBy(10);
	  System.out.println(garage);
	  
	  
	  
	  
	  
	  //=============================================
	}
}
//Q1  =============================================
//edit Car class here =============================
final class Car{
	private final String owner;
	private final String reg;
	private final String make;
	private final int kilometres;
	private final double price;
	
	public Car(String ow, String r, String m, int k, double p){
	 owner = ow; reg = r; make = m; kilometres = k; price = p; 
	}
	public String owner(){return owner;}
	public String reg(){return reg;}
	public String make(){return make;}
	public int kilometres(){return kilometres;}
	public double price(){return price;}
	
	public String toString(){
		return "Owner: " + this.owner + "\nRegistration no: " + this.reg + "\nMake: " + this.make
				+ "\nKilometers: " + this.kilometres + "\nPrice: " + this.price + "\n";
	}
	
//	public void setPrice(double p){price = p;}
//	public void setOwner(String ow){owner = ow;}
//	public void setKil(int k){kilometres = k;}
//	public void setMake(String m){make = m;}
	
	public Car setPrice(double p){return new Car(this.owner, this.reg, this.make, this.kilometres, p);}
	public Car setOwner(String ow){return new Car(ow, this.reg, this.make, this.kilometres, this.price);}
	public Car setKil(int k){return new Car(this.owner, this.reg, this.make, k, this.price);}
	public Car setMake(String m){return new Car(this.owner, this.reg, m, this.kilometres, this.price);}
	
	public boolean equals(Object ob){
		if(!(ob instanceof Car)) return false;
		Car c = (Car)ob;
		return c.reg().equals(reg);
	}
	
}

interface Garage{
  public boolean add(Car c);
  public Car getCar(String reg);
  public Car[] getMake(String make);
  public double totalValue();
  public boolean changeOwner(String reg, String ow);
  public boolean changePrice(String reg, double p);
  public void reducePricesBy(double per);
}

class MyGarage implements Garage{
	private int size;
	private Car[] data;
	
	public MyGarage(int k){
		data = new Car[k];
		size = 0;
	}
	
	@Override
	public boolean add(Car c) {
		boolean adding = false;
		if(size == 0){
			data[size] = c; size++;
			adding = true;
		}else if(size < data.length){
			if(getCar(c.reg()) == null){
				data[size] = c; size++;
				adding = true;
			}
		}
		return adding;
	}

	@Override
	public Car getCar(String reg) {
		Car carFound = null;
		for(int i = 0; i < size; i++){
			if(reg.equals(data[i].reg())){
				carFound = new Car(data[i].owner(), data[i].reg(), data[i].make(), data[i].kilometres(), data[i].price());
			}
		}
		
		return carFound;
	}

	@Override
	public Car[] getMake(String make) {
		//Car carFound = null;
		int carFound = 0;
		
		for(int i = 0; i < size; i++){
			if(make.equals(data[i].make())){
				carFound++;
			}
		}
		
		Car[] cars = new Car[carFound];
		
		int j = 0;
		for(int i = 0; i < size; i++){
			if((data[i].make()).equals(make)){
				cars[j] = data[i];
				j++;
			}
		}
		return cars;
	}

	@Override
	public double totalValue() {
		double total = 0;
		for(int i = 0; i < size; i++){
			total += data[i].price();
		}
		return total;
	}

	@Override
	public boolean changeOwner(String reg, String ow) {
		boolean changeOwner = false;
		
		for (int i = 0; i < size; i++) {
			if(data[i].reg().equals(reg)){
				data[i] = data[i].setOwner(ow);
				changeOwner = true;
			}
		}
		
		
//		Car car = getCar(reg);
//		if(car != null){
//			car.setOwner("Tony");
//			System.out.println(car);
//			changeOwner = true;
//		}
		
		return changeOwner;
	}


	@Override
	public boolean changePrice(String reg, double p) {
		boolean changeOwner = false;
		
		for (int i = 0; i < size; i++) {
			if(data[i].reg().equals(reg)){
				data[i] = data[i].setPrice(p);
				changeOwner = true;
			}
		}
		
		
		return changeOwner;
	}

	@Override
	public void reducePricesBy(double per) {
		for(int i = 0; i < size; i++){
			data[i] = data[i].setPrice((data[i].price() - (per/100)* data[i].price()));
		}
	}
	
	
	
	
	public String toString(){
		if(size == 0) return "[]";
		String s = "[";
		for(int j = 0; j < size - 1; j++)
			s = s + data[j] + ",";
		return s+data[size-1]+"]";
	}

	
	
	
	
	
}
// =====================================================