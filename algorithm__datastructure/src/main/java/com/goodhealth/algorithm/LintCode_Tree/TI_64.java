/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

/**
 * @author 24663
 * @date 2018年9月4日
 * @Description 64. 合并排序数组 合并两个排序的整数数组A和B变成一个新的数组。 样例 给出 A = [1, 2, 3, empty,
 *              empty], B = [4, 5] 合并之后 A 将变成 [1,2,3,4,5] 注意事项
 *              你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。
 */
public class TI_64 {

	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		int i = m - 1;
		int j = n - 1;
		int index = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] >B[j]) {
				A[index--] = A[i--];
			}else{
				A[index--] = B[j--];
			}
		}
		while (i >= 0 && j < 0) {
			A[index--] = A[i--];
		}
		while (i < 0 && j >= 0) {
			A[index--] = B[j--];
		}
	}

}
