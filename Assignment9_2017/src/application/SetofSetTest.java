package application;

import java.util.*;

public class SetofSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<TreeSet<Integer>> s1 = new HashSet<>();
		TreeSet<Integer> a = new TreeSet<>(Arrays.asList(2,3,5,7));
		TreeSet<Integer> a1 = new TreeSet<>(Arrays.asList(1,3,5,8,10));
		TreeSet<Integer> a2 = new TreeSet<>(Arrays.asList(3,6,9,10));
		
		s1.add(a);
		s1.add(a1);
		s1.add(a2);
		
		System.out.println(s1);
		
		HashSet<Integer> union = new HashSet<>();
		for(TreeSet<Integer> k : s1)
			union.addAll(k);
		
		System.out.println(union);
		
		HashSet<Integer> in = new HashSet<>();
		for(TreeSet<Integer> k : s1)
			if(in.size() == 0) in.addAll(k);
			else in.retainAll(k);
		
		System.out.println(in);
		
		HashSet<Integer> unique = new HashSet<>();
		for(Integer x : union){
			int count = 0;
			for(TreeSet<Integer> k : s1)
				if(k.contains(x)) count++;
				
			if(count == 1) unique.add(x);
		}
			
		
		System.out.println(unique);

	}

}
