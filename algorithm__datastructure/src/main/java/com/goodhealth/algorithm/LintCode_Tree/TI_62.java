/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

/**
 * @author 24663
 * @date 2018年9月3日
 * @Description
 62. 搜索旋转排序数组
假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
你可以假设数组中不存在重复的元素。
样例
给出[4, 5, 1, 2, 3]和target=1，返回 2
给出[4, 5, 1, 2, 3]和target=0，返回 -1
 */
public class TI_62 {

	public int search(int[] A, int target) {
		// write your code here
		if (A == null || A.length == 0) {
			return -1;
		}
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] <= A[end]) {
				if (A[end] < target) {
					end = mid;
				} else {
					if (A[mid] > target) {
						end = mid;
					} else if (A[mid] < target) {
						start = mid;
					}else {
						return mid;
					}
				}
			} else {
				if (A[start] > target) {
					start = mid;
				} else if (A[start] < target && A[mid] > target) {
					end = mid;
				} else if (A[mid] == target) {
					return mid;
				}
			}
		}
		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}
		return -1;
	}
	
}
