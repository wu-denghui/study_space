package com.goodhealth.algorithm.NKExercise;

public class FanxingArrary {

	public static void main(String[] args) {
		String[] a={"asd","zx","qdw"};
		Integer[] b={1,2,3,4};
		FanxingArrary fa =new FanxingArrary();
		fa.tell(a);
		fa.tell(b);

	}
    public <T> void tell(T arr[]) {
    	for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
