import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
public class MyGarageTest {
	MyGarage mg;
	
	public MyGarageTest(){
		mg = new MyGarage(100);
		mg.add(new Car("John","123456","Ford",30000, 21000));
		mg.add(new Car("Jack","123465","BMW",20000, 25000));
		mg.add(new Car("James","123654","Ford",15000, 10000));
		mg.add(new Car("Jeffrey","123546","Ferrari",40000, 9000));
	}
	
	@Test
	public void testgetCar(){
		assertEquals(mg.getCar("123456"), new Car("John","123456","Ford",30000, 21000));
	}
	
	@Test
	public void testtotalValue() {
		assertEquals(mg.totalValue(), 65000.0, 0.001);
	}
	
	@Test
	public void testMake(){
		Car[] tmp = {new Car("John","123456","Ford",30000, 21000), new Car("James","123654","Ford",15000, 10000)};
		
		assertArrayEquals(mg.getMake("Ford"), tmp);
	}
	
	@Test
	public void testChangeOwner(){
		mg.changeOwner("123456", "Jacky");
		assertEquals(mg.getCar("123456"), new Car("Jacky","123456","Ford",30000, 21000) );
	}
	
	@Test
	public void testchangePrice(){
		mg.changePrice("123456", 20000);
		assertEquals(mg.getCar("123456"), new Car("John","123456","Ford",30000, 20000));
	}
	
	@Test
	public void testreducePricesBy(){
		mg.reducePricesBy(20);
		assertEquals(mg.getCar("123456").price(), 16800, 0.001);
	}
}
