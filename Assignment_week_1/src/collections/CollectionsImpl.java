package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CollectionsImpl {
	public static void main(String[] args) {
		// List
		List<Number> list = new ArrayList<Number>();
		list.add(30);
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(20);
		list.add(null);
		list.add(5665.23f);
		list.add(456.2);
		list.add(15454542424542L);
		System.out.println(list);
		
		List<Number> list1 = new LinkedList<Number>();
		list1.add(30);
		list1.add(10);
		list1.add(20);
		list1.add(40);
		list1.add(20);
		list1.add(null);
		list1.add(5665.23f);
		list1.add(456.2);
		list1.add(15454542424542L);
		System.out.println(list1);
		
		// First way to print collection elements
		Iterator it = list.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		System.out.println("For Each loop");
		
		// Another way to print collection elements 	
		for(Number n:list)
		{
			System.out.println(n);
		}
		
		// Map
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(103,"ravi");
		map.put(102,"tom");
		map.put(101,"sai");
		map.put(104,"smith");
		map.put(103,"john");
		map.put(105,"Sibi");

		System.out.println(map);
		
		Set<Integer> set = map.keySet();
		Iterator<Integer> it1 = set.iterator();
		while(it1.hasNext())
		{
			Integer k = (Integer) it1.next();
			System.out.println(k + " " + map.get(k));
		}
		Collection<String> list11 = map.values();
		for(String name:list11)
		{
			System.out.println(name);
		}
		
		// queue
		
		PriorityQueue<String> queue= new PriorityQueue();  
		queue.add("Amit");  
		queue.add("Vijay");  
		queue.add("Karan");  
		queue.add("Jai");  
		queue.add("Rahul");  
		System.out.println("head:"+queue.element());  
		System.out.println("head:"+queue.peek());  
		System.out.println("iterating the queue elements:");  
		Iterator itr=queue.iterator();  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		}  
		queue.remove();  
		queue.poll();  
		System.out.println("after removing two elements:");  
		Iterator<String> itr2=queue.iterator();  
		while(itr2.hasNext()){  
			System.out.println(itr2.next());  
		}
		
		// set
		
		Set<String> set1 = new HashSet<String>();
		set1.add("king");
		set1.add("smith");
		set1.add("adam");
		set1.add("ford");
		System.out.println(set1);
		
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(34);
		set2.add(12);
		set2.add(56);
		set2.add(9);
		System.out.println(set2);
		
		//Upon running above both cases for HashSet we are getting the output in any random order because it is printing the order
		// as per order of HashCode which is not visible but the order is based as per HashCode only for it 
		
		Set<String> set3 = new LinkedHashSet<String>();
		set3.add("king");
		set3.add("smith");
		set3.add("adam");
		set3.add("ford");
		System.out.println(set3);
		
		for (String i:set3)
		{
			System.out.println(i);
		}
	}
}
