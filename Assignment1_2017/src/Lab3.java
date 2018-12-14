import java.util.Scanner;

public class Lab3 {

	public static void main(String[] args) {
		
		int i1= 5;
		Integer i = new Integer(5);
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		Monitor test1 = new Monitor("Samsung", "1234", 4000.00, 42);
		Monitor test2 = new Monitor("Apple TV", "5678", 5555.00, 36);
		
		System.out.println(test1.name());
		System.out.println(test1.serialNo());
		System.out.println(test1.price());
		System.out.println(test1.size());
		
		test1.setPrice(8000);
		
		System.out.println(test1);
		
		if(test1.price() == test2.price()) System.out.println("Prices are equal");
		else System.out.println("Prices are different");
		
		Monitor[] array = new Monitor[6];
		
		array[0] = new Monitor("Samsung", "1234", 4000.00, 42);
		array[1] = new Monitor("Apple TV", "5678", 5555.00, 36);
		array[2] = new Monitor("Dell", "1357", 2222, 21);
		array[3] = new Monitor("Sony", "9876", 3254, 25);
		array[4] = new Monitor("Motorola", "4545", 6575, 29);
		array[5] = new Monitor("Nokia", "2342", 7868, 31);
		
		int largestScreen = 0;
		double cheapest = array[0].price();
		double totalCost = 0;
		
		for(Monitor m1 : array){
			if(largestScreen < m1.size()){
				largestScreen = m1.size();
			}
			if(cheapest > m1.price()){
				cheapest = m1.price();
			}
			
			totalCost += m1.price();
		}
		
		System.out.println(largestScreen + " " + cheapest +" "+ totalCost);
		
		for(Monitor m1 : array){
			m1.setPrice(((20/100) * m1.price()) + m1.price());
		}
		System.out.println(largestScreen + " " + cheapest +" "+ totalCost);
		
	}

}

class Monitor{
	private String name, serialNo;
	private double price;
	private int size;
	
	public Monitor(String n, String s, double p, int sz){
		name = n;
		serialNo = s;
		price = p;
		size = sz;
	}
	
	public String name(){return name;}
	public String serialNo(){return serialNo;}
	public double price(){return price;}
	public int size(){return size;}
	
	public void setPrice(double p){price = p;}
	
	public String toString(){
		return "Name: " + name + "\nSerial No: "+ serialNo + "\nPrice: " + price + "\nSize: " + size;
	}
	
	
	
}
