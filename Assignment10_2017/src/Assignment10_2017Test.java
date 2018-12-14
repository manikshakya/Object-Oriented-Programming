/*
 * Student Name: Manik Shakya
 * Student number: 2869290
 *
 *
 **/
/*
For this assignment the class Coin is given. You are required to complete the methods
for the Purse class and then complete the class Assignment10_2017Test by writing JUnit 
test methods that check all of its methods.
*/
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
public class Assignment10_2017Test{
	//create a Purse instance and write asserts that test its methods. 
	  Purse purse;
	  public Assignment10_2017Test(){
	    purse = new Purse();
	    purse.add(Arrays.asList(Coin.TWENTY, Coin.FIFTY, Coin.TWENTY, Coin.ONEEURO, Coin.FIFTY, Coin.FIFTY, Coin.FIFTY, Coin.TEN, Coin.FIVE));
	  }
	  
	  @Test
	  public void testFreq(){
		  assertEquals(4, purse.freq(Coin.FIFTY));
	  }
	  @Test
	  public void testSum(){
		  assertEquals(355, purse.sum());
	  }
	  @Test
	  public void testRemove(){
		  assertEquals(true, purse.remove(Coin.FIFTY));
	  }
	  @Test
	  public void testRemoveAll(){
		  assertEquals(true, purse.removeAll(Coin.FIFTY));
	  }
	  @Test
	  public void testValue(){
		  assertEquals(200, purse.value(Coin.FIFTY));
	  }
	  
	
//	public static void main(String[] args){
//		Purse purse = new Purse();
//		purse.add(Arrays.asList(Coin.TWENTY, Coin.FIFTY, Coin.TWENTY, Coin.FIFTY, Coin.FIFTY, Coin.FIFTY, Coin.TEN, Coin.FIVE));
//		
//		System.out.println(purse.freq(Coin.FIFTY));
//		System.out.println(purse.value(Coin.FIFTY));
//		System.out.println(purse.sum());
//		System.out.println(purse);
//		System.out.println(purse.remove(Coin.FIFTY));
//		System.out.println(purse);
//		System.out.println(purse.removeAll(Coin.FIFTY));
//		System.out.println(purse);
//		System.out.println(purse.contains(Coin.FIFTY));
//		System.out.println(purse.contains(Coin.TWENTY));
//		purse.add(Coin.TWENTY);
//		System.out.println(purse);
//		System.out.println(purse.remove(Coin.TWENTY));
//		System.out.println(purse.getSum());
//		
//	}
  
}

class Purse{
	private ArrayList<Coin> purse;
	Purse(){purse = new ArrayList<Coin>();}
	public void add(Coin c){
		//add coin to purse
		purse.add(c);
		
	}
	public void add(List<Coin> coins){
		//add a list of coins to the purse
		purse.addAll(coins);
	}
	public boolean contains(Coin c){
		//check if coin is in the purse
		if(purse.contains(c)){
			return true;
		}
		return false;
	}
	public boolean remove(Coin c){
		//remove a single coin from purse if it is in the purse
		if(purse.contains(c)){
			purse.remove(c);
			return true;
		}
		return false;
	}
	public boolean removeAll(Coin c){
		//remove all coin c from purse if it is in the purse
		boolean remove = false;
		Iterator<Coin> i = purse.iterator();
		while(i.hasNext()){
			if(i.next().equals(c)){
				i.remove();
				remove = true;
			}
		}
		return remove;
	}
	public int freq(Coin c){
		//calculate the frequency of c in the purse
		int count = 0;
		Iterator<Coin> i = purse.iterator();
		while(i.hasNext()){
			if(i.next().equals(c)){
				count++;
			}
		}
		return count;
	}
	public int value(Coin c){
		//calculate the total value of c in the purse
		int value = 0;
		Iterator<Coin> i = purse.iterator();
		while(i.hasNext()){
			if(i.next().equals(c)){
				value += c.value();
			}
		}
		return value;
	}
	public int sum(){
		//calculate the sum of money in the purse
		int sum = 0;
		Iterator<Coin> i = purse.iterator();
		while(i.hasNext()){
			sum += i.next().value();
		}
		return sum;
	}
	public String getSum(){
		//return a string representation of the sum in euros
    // e.g. 2.65
		double sum = 0;
		Iterator<Coin> i = purse.iterator();
		while(i.hasNext()){
			sum += i.next().value();
		}
		
		return Double.toString(sum/100) + " euros";
	}
	public String toString(){
		//string representation of all coins in purse
		String s = "[";
		Iterator<Coin> i = purse.iterator();
		while(i.hasNext()){
			s += i.next();
			if(i.hasNext()){
				s += ", ";
			}
		}
		return s + "]";
	}
}

enum Coin{
	ONE,TWO,FIVE,TEN,TWENTY,FIFTY,ONEEURO,TWOEURO;
	public String toString(){
	  String lst[] = {"1 Cent","2 Cent","5 Cent","10 Cent","20 Cent","50 Cent","1 Euro","2 Euro"};
		return lst[this.ordinal()];
	}
	public int value(){
		int val[] ={1,2,5,10,20,50,100,200};
		return val[this.ordinal()];
	}
	public int add(Coin c){
		return (this.value()+ c.value());
	}
	public int add(int x){ //add sum of money in cents to this coin
	 if(x >= 0) return x + this.value();
	 else return this.value();
	}
}