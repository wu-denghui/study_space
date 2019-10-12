package com.goodhealth.algorithm.NKExercise;

public class IntTest {

	public static void main(String[] args) {
		IntTest test = new IntTest();
		int[] an = { 1, 2, 3, 4 };
		if (an[0] < an[1]) {
//			int temp = an[0];
//			an[0] = an[1];
//			an[1] = temp;
			test.swap(an[0], an[1]);
		}
		
		String str1=" str11";
		String str2="str2";
//		test.swap(str1, str2);
		if (!str1.equals(str2)) {
			String temp = str1;
			str1= str2;
			str2= temp;
		}
		System.out.println(str1);
		
		int a2 = 92;
		int a3 = 91;
		Integer a4 = 93;
		Integer a5 = new Integer(94);
		// System.out.println(an[0]);
		test.swap(a4, a5);
		 System.out.println(a5);
	}

	public void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}
	
	public void swap(String x, String y) {
		String temp = x;
		x = y;
		y = temp;
	}
	
}
