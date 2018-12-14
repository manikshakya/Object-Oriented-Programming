import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;


public class SetTesting {

	Set<Integer> dt;
	public SetTesting(){
		dt = new TreeSet<>(Arrays.asList(4,7,1,3,5,9));
	}
	
	@Test
	public void testContains(){
		assertEquals(dt.contains(5), true);
	}
	
	@Test
	public void testInter(){
		Set<Integer> tmp = new HashSet<>(Arrays.asList(1,4,5,9));
		assertEquals(tmp.retainAll(dt), new TreeSet<Integer>(Arrays.asList(1,4,5)));
	}

}
