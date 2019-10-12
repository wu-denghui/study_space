/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Array;

/**
 * @author 24663
 * @date 2018年12月24日
 * @Description
 */
public class MergerSortedArrary {
	
	
	public static void main(String[] args) {
		int[] A={1,2,3,4};
		int[] B={2,4,5,6};
		int[]  C=mergeSortedArray(A, B);
		System.err.println(getString(C));
	}
	
	/**
	 * @param A
	 * @param B
	 * @return
	 * @Description  描述 合并两个排序的整数数组A和B变成一个新的数组。 
 *              给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
	 */
	public  static int[] mergeSortedArray(int[] A, int[] B) {
		int[] result = new int[A.length + B.length];
		int i = 0, j = 0, index = 0;
		while (index < result.length) {
			
			while (i >= A.length && j < B.length) {
				result[index++] = B[j++];
			}
			while (i < A.length && j >= B.length) {
				result[index++] = A[i++];
			}
			if (i < A.length && j < B.length && A[i] <= B[j]) {
				result[index++] = A[i++];
			}
			if (i < A.length && j < B.length && A[i] > B[j]) {
				result[index++] = B[j++];
			}
		}
		return result;
	}
	
	public static  String getString(int[] num) {
		StringBuffer sBuffer=new StringBuffer();
		for (int i = 0; i < num.length; i++) {
			sBuffer.append(num[i]);
		}
		return sBuffer.toString();
	}
}
