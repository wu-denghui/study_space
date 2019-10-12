/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

/**
 * @author 24663
 * @date 2018年9月4日
 * @Description 65. 两个排序数组的中位数 两个排序的数组A和B分别含有m和n个数，找到两个排序数组的中位数，要求时间复杂度应为O(log
 *              (m+n))。 样例 给出数组A = [1,2,3,4,5,6] B = [2,3,4,5]，中位数3.5 给出数组A =
 *              [1,2,3] B = [4,5]，中位数 3 挑战 时间复杂度为O(log n)
 */
public class Ti_65 {

	public double findMedianSortedArrays(int[] A, int[] B) {
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
		if (result.length % 2 == 1) {
			return result[result.length / 2];
		} else {
			double a = result[result.length / 2] + result[result.length / 2 - 1];
			return a / 2;
		}
	}

	public double findMedianSortedArray(int A[], int B[]) {
		int n = A.length + B.length;

		if (n % 2 == 0) {
			return (findKth(A, 0, B, 0, n / 2) + findKth(A, 0, B, 0, n / 2 + 1)) / 2.0;
		}

		return findKth(A, 0, B, 0, n / 2 + 1);
	}

	// find kth number of two sorted array
	public static int findKth(int[] A, int startOfA, int[] B, int startOfB, int k) {
		if (startOfA >= A.length) {
			return B[startOfB + k - 1];
		}
		if (startOfB >= B.length) {
			return A[startOfA + k - 1];
		}

		if (k == 1) {
			return Math.min(A[startOfA], B[startOfB]);
		}

		int halfKthOfA = startOfA + k / 2 - 1 < A.length ? A[startOfA + k / 2 - 1] : Integer.MAX_VALUE;
		int halfKthOfB = startOfB + k / 2 - 1 < B.length ? B[startOfB + k / 2 - 1] : Integer.MAX_VALUE;

		if (halfKthOfA < halfKthOfB) {
			return findKth(A, startOfA + k / 2, B, startOfB, k - k / 2);
		} else {
			return findKth(A, startOfA, B, startOfB + k / 2, k - k / 2);
		}
	}
}
