package com.goodhealth.algorithm.DataStruct;

import java.util.*;

public class TreeMapDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		TreeMap<Integer, String> map2 = new TreeMap<>();
		map.put(1, null);
		map.put(2, "aaa");
		map.put(3, "bbb");
		map.put(4, "ccc");
		System.out.println(map);
		map2.putAll(map);
		System.out.println(map2);
		System.out.println(map.size());
		System.out.println("---------------------------");

		Map.Entry<Integer, String> entry = map.ceilingEntry(3);
		System.out.println(entry);
		System.out.println("---------------------------");
		Integer i = map.ceilingKey(3);
		System.out.println(i);
		System.out.println("---------------------------");
		TreeMap<Integer, String> map3;
		map3 = (TreeMap<Integer, String>) map.clone();
		Object map4;
		map4 = map.clone();
		System.out.println(map3);
		System.out.println(map4);
		System.out.println("---------------------------");
		Comparator<Integer> mComparator = (Comparator<Integer>) map.comparator();
		System.out.println(mComparator);
		System.out.println("---------------------------");
		System.out.println(map.containsKey(4));
		System.out.println(map.containsValue("bbb"));
		NavigableMap<Integer, String> an = map.descendingMap();
		System.out.println(an);
		NavigableSet<Integer> ans = map.navigableKeySet();
		Iterator<Integer> inte = ans.iterator();
		while (inte.hasNext()) {
			System.out.println(inte.next());
		}
	     Set<Map.Entry<Integer,String>> l=map.entrySet();
	     Iterator iterator=l.iterator();
	      while (iterator.hasNext()) {
             System.out.println(iterator.next());			
	}
	      Set<Integer> ll=map.keySet();
      Iterator<Integer> iterator2=ll.iterator();
      while (iterator2.hasNext()) {
              System.out.println(iterator2.next());			
	}
      Collection<String> lll=map.values();
    Iterator<String> iterator3=lll.iterator();
	      while (iterator3.hasNext()) {
    	  System.out.println(iterator3.next());
	      }
		}
}
	      
	      
	      
	      
	      
	      
	      
	      
	      
		
		

