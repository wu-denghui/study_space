package com.goodhealth.algorithm.DataStruct;

import java.util.*;
import java.util.Map.Entry;

public class HashMapDemo {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> map=new LinkedHashMap<>();
		map.put(1, "wxh");
		map.put(2, "ys");
		map.put(2, "ys");
		map.put(null, "wdh");
		map.put(4, null);
		System.out.println(map);
		Boolean lo =map.containsKey(1);
		System.out.println(lo);
		Boolean lol =map.containsValue("ysd");
		System.out.println(lol);
		
		System.out.println("-------------------------------");
		Set<Entry<Integer,String>> po=map.entrySet();
		System.out.println(po);
		Iterator<Entry<Integer, String>> iters=po.iterator();
		while (iters.hasNext()) {
            System.out.println( iters.next());
		}
		System.out.println("-------------------------------");
        String str2=map.get(5);
        System.out.println(str2);
        System.out.println("-------------------------------");


        Set<Integer> set=map.keySet();
        System.out.println(set);
        Iterator<Integer> it =  set.iterator();
        while (it.hasNext()) {
			System.out.println(it.next());
		}
        System.out.println("----------------hashmap---------------");
		Map<Integer, String> map2=new HashMap<>();
		map2.put(1, "wdh");
		map2.put(1, "wdh");
		map2.put(null, "wdh");
		map2.put(4, null);
		System.out.println(map2);
		Set<Entry<Integer,String>> po2=map2.entrySet();
		System.out.println(po2.equals(po));
		System.out.println("-------------------------------");
        map.putAll(map2);
        System.out.println(map.size());
        
        Collection <String> list=map.values();
        Iterator<String>  iter=list.iterator();
             while (iter.hasNext()) {
				System.out.println(iter.next());
				
			}
        

}
}