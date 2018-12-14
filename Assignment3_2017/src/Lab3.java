
public class Lab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class Counter{
	private int count = 0;
	public Counter(int k){count = k;}
	public void inc(){count++;}
	public void dec(){count--;}
	public int count(){return count;}
	public String toString(){return count + "";}
}
class Car{
	private String make;
	private Counter kilometers;
	private RegNumber regNum;
	public Car(String m, Counter k, RegNumber r){
		make = m;
		kilometers = new Counter(0);
		regNum = new RegNumber("123456");
	}
	public Counter kilometers(){
		
		return new Counter(kilometers.count());
	}
}
class RegNumber{
	private String regNum;
	RegNumber(String n){regNum = n;}
	public String regNum(){return regNum;}
	public void editNum(String n){regNum = n;}
	public String toString(){return regNum;}
}