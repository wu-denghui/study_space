package com.goodhealth.algorithm.DataStruct;

import java.util.*;

public class ListDemo {
	public static void main(String[] args) {
		LinkedList<Integer> arrayList=new LinkedList<>();
		arrayList.addFirst(2);
		arrayList.addFirst(4);
		arrayList.addFirst(4);
		//  ArrayList 允许元素为空 且允许多个空
		arrayList.addFirst(null);
		arrayList.addLast(null);
//		arrayList.set(4, 8);
		System.out.println(arrayList);
//		LinkedList<Integer> linkedList= new LinkedList<>();
//		linkedList.addFirst(2);
//		linkedList.addFirst(3);
//		linkedList.addFirst(4);
//
//		System.out.println(linkedList.peekLast());
//		linkedList.removeLast();
///*		linkedList.add(2);
//		linkedList.add(4);
//		linkedList.add(4);
//		linkedList.add(null);
//		linkedList.add(null);*/
//		System.out.println(linkedList+"111");

//		Vector<Integer> vector2 = new Vector<>();
//		vector2.add(2);
//		vector2.add(2);
//		vector2.add(4);
//		vector2.add(4);
//		vector2.add(null);
//		vector2.add(null);
//		System.out.println(vector2);

//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(2);
//		stack.push(2);
//		stack.push(4);
//		stack.push(null);
//		stack.add(null);
//		System.out.println(stack);

//		Deque<Integer> da = new ArrayDeque<Integer>();
//		Vector<Integer> vector = new Vector<Integer>();
//		vector.add(1);
//		vector.add(2);
//		vector.add(3);
//		vector.add(null);
//		System.out.println("-------------------");
//		System.out.println(vector.get(3));
//		System.out.println(vector.toString());
//		System.out.println("-------------------");
//		Object[] object = vector.toArray();
//		Integer[] annn = (Integer[]) vector.toArray(new Integer[vector.size()]);
//		for (int i = 0; i < annn.length; i++) {
//			System.out.println(annn[i]);
//		}
//		System.out.println("-------------------");
//		ListIterator<Integer> cc = vector.listIterator(vector.size());
//		while (cc.hasPrevious()) {
//			System.out.println(cc.previous());
//		}
//		System.out.println("-------------------");
//		Enumeration<Integer> xx = vector.elements();
//		while (xx.hasMoreElements()) {
//			System.out.println((Integer) xx.nextElement());
//		}
	}
}