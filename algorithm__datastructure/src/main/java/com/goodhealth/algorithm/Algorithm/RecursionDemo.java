package com.goodhealth.algorithm.Algorithm;

import java.util.Deque;
import java.util.LinkedList;

// 递归算法解决汉诺塔问题
public class RecursionDemo {
	private int b1 = 12;
	private int b2 = 8;
	private int b3 = 5;
	private int m = 6;
	public static void main(String[] args) {
		RecursionDemo recursionDemo = new RecursionDemo();
//		int[] an = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15 };
//		int a=recursionDemo.binarySearch(an, 9, 0, an.length - 1);
//		System.out.println(a);
//        int b=recursionDemo.gcd(55, 65);	
//        System.out.println(b);
//        int  c=recursionDemo.get(4);
//        System.out.println(c);
        Deque<Integer> dueueA=new LinkedList<>();
        dueueA.push(1);
        dueueA.addFirst(2);
        dueueA.push(3);
        dueueA.addFirst(4);
        System.out.println(dueueA);
        Deque<Integer> dueueB=new LinkedList<>();
        Deque<Integer> dueueC=new LinkedList<>();
        recursionDemo.hanNote(4, dueueA, dueueB, dueueC);
        System.out.println(dueueA);
        System.out.println(dueueC);
	}

	public int binarySearch(int[] an, int key, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (an[mid] < key) {
			return binarySearch(an, key, mid + 1, right);
		}
		else if (an[mid] > key) {
			return binarySearch(an, key, left, mid - 1);
		}
		else if (an[mid] == key) {
			return mid;
		}
		return -1;
	}
	public int gcd(int a,int b){
		if (b==0) {
			return a;
		}else{
		    return  gcd(b,a%b );
	   }
	}
	public int get(int n) {
		if (n==1) {
			return 1;
		}else{
		return n*get(n-1);
		}
	}
	
	private void backBottle(int bb1,int bb2,int bb3){
		System.out.println("bb1:"+bb1+"~~bb2:"+bb2+"~~bb3:"+bb3);
		if(bb1 == m||bb2 == m||bb3 == m){
			System.out.println("find the bottle");
			return;
		}
		if(bb2!=0&&bb3!=b3){
			if(bb2+bb3<=b3){
				backBottle(bb1, 0, bb2+bb3);
			}else{
				backBottle(bb1, bb2-(b3-bb3), b3);
			}
		}else if(bb3==b3){
			if(bb3+bb1<=b1){
				backBottle(bb1+bb3, bb2, 0);
			}else{
				backBottle(b1, bb2, bb3-(b1-bb1));
			}
		}else if(bb2 == 0){
			if(bb1>=b2){
				backBottle(bb1-b2, b2, bb3);
			}else{
				backBottle(0, bb1, bb3);
			}
		}
		
	}
	public void hanNote(int n,Deque<Integer> dueueA,Deque<Integer> dueueB,Deque<Integer> dueueC) {
		if (n==1) {
			move(dueueA,dueueC);
		}else{
			hanNote(n-1, dueueA, dueueC, dueueB);
			move(dueueA, dueueC);
			hanNote(n-1, dueueB, dueueA, dueueC);
		}
	}

	private void move(Deque<Integer> dueueA, Deque<Integer> dueueC) {
		int n=dueueA.removeFirst();
		dueueC.addFirst(n);
	}
}
