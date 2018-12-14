import java.util.*;
public class Assignment3_2017{
	public static void main(String args[]){
    IntManager in = new IntManager(100);
		System.out.println(in);
		for(int j = 0; j < 20; j++){
			int x = (int)(Math.random()*20);
			in.add(x);
		}
		System.out.println(in);
		
		System.out.println(in.size());
		
		System.out.println(in.found(2));
		
		System.out.println(in.sumOdd());
		
		System.out.println(in.max());
		
		System.out.println(in.freq(19));
		
		in.sort();
		System.out.println(in);
		
		
		System.out.println(Arrays.toString(in.getOdd()));
		
		
		
		
		
		
		
		
		
		//Q2  ==============================================
		// This code is a sample test for Q2.
		 	TicketManager tm = new TicketManager();
     	System.out.println(tm);
     	Ticket t1 = new Ticket((int)(Math.random()*5),(int)(Math.random()*5));
     	tm.buy(t1);
     	System.out.println(tm);
     	Ticket t2 = new Ticket((int)(Math.random()*5),(int)(Math.random()*5));
     	tm.buy(t2);
     	System.out.println(tm);
     	for(int j = 0; j < 200; j++)
     		tm.buy(new Ticket((int)(Math.random()*5),(int)(Math.random()*5)));
     	System.out.println(tm.sold());
     	Ticket draw = new Ticket((int)(Math.random()*5),(int)(Math.random()*5));
     	System.out.println(tm);
     	System.out.println(draw);
     	System.out.println(tm.freqWinner(draw));
     	
     	System.out.println(tm.search(draw));
     	
     	
     	
		
	}
}
//Q1 class ===============================================
class IntManager{
	private Integer dt[];
	private int size;
	public IntManager(int k){
		dt = new Integer[k];
		size = 0;
	}
	public void add(Integer x){
		if(size < dt.length){
			dt[size] = x; size++;
		}
	}
	public boolean found(Integer x){
		boolean found = false;
		int j = 0;
		while(j < size && !found){
		 if(x.equals(dt[j]))
		   found = true;
		 else 
		   j++;
		}
		return found;
		
	}
	
	public Integer sumOdd(){
		int sum = 0;
		for(int i = 0; i < size; i++){
			if(dt[i] % 2 == 1){
				sum += dt[i];
			}
		}
		
		return sum;
	}
	public Integer max(){
		int max = dt[0];
		
		for(int i = 0; i < size; i++){
			if(dt[i] > max){
				max = dt[i];
			}
		}
		return max;
	}
	
	public Integer freq(Integer x){
		int counter = 0;
		for(int i = 0; i < size; i++){
			if(x == dt[i]){
				counter++;
			}
		}
		
		return counter;
	}
	
	public void sort(){
		int i, j, temp;
		for (i = 1; i < size; i++)
	    {
	        j = i - 1;
	        while (j >= 0 && dt[j] > dt[i] )
	        {
	            temp = dt[i];
	            dt[i] = dt[j];
	            dt[j] = temp;
	            i=j;
	            j--;

	        }
	    }
	}
	
	public Integer[] getOdd(){
		int totalOdd = 0;
		
		for(int i = 0; i < size; i++){
			if(dt[i] % 2 == 1){
				totalOdd++;
			}
		}
		
		Integer[] odd = new Integer[totalOdd];
		int j = 0;
		for(int i = 0; i < size; i++){
			if(dt[i] % 2 == 1){
				odd[j] = dt[i];
				j++;
			}
		}
		
		return odd;
	}
	
	public int size(){return size;}
	public String toString(){
		if(size == 0) return "[]";
		String s = "[";
		for(int j = 0; j < size - 1; j++)
			s = s + dt[j] + ",";
		return s+dt[size-1]+"]";
	}
}


//Q2 classes ================================================
class Ticket{
	private final int a,b;
	Ticket(int a1, int b1){a = a1; b = b1;}
	public int a(){return a;}
	public int b(){return b;}
	public String toString(){return "["+a+","+b+"]";}
}


class TicketManager{
	private Ticket[] tickets;
	private int sold = 0;
	private int maxTickets = 500;
	TicketManager(){tickets = new Ticket[maxTickets];}
	public boolean buy(Ticket t){
		boolean bought = false;
		if(sold < tickets.length){
			tickets[sold] = t; sold++;
			bought = true;
		}
		return bought;
	}
	public int freqWinner(Ticket t){
		int count = 0;
		for(int i = 0; i < sold; i++){
			if((t.a() == tickets[i].a() && t.b() == tickets[i].b())){
				count++;
			}
		}
		return count;
	}
	public boolean search(Ticket t){
		boolean search = false;
		for(int i = 0; i < sold; i++){
			if((t.a() == tickets[i].a() && t.b() == tickets[i].b())){
				search = true; break;
			}
		}
		return search;
	}
	public int sold(){return sold;}
	public boolean allsold(){return (sold == 500)? true: false;}
	public String toString(){
		if(sold == 0) return "[]";
		String s = "[";
		for(int j = 0; j < sold - 1; j++)
			s = s + tickets[j] + ",";
		return s+tickets[sold-1]+"]";
	}
}
