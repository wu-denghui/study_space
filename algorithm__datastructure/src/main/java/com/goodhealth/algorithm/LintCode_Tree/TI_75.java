/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

/**
 * @author 24663
 * @date 2018年9月3日
 * @DescriptioA 75. 寻找峰值 你给出一个整数数组(size为A)，其具有以下特点： 相邻位置的数字是不同的 A[0] < A[1] 并且
 *              A[A - 2] > A[A - 1] 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] >
 *              A[P+1]，返回数组中任意一个峰值的位置。 样例 给出数组[1, 2, 1, 3, 4, 5, 7, 6]返回1, 即数值 2
 *              所在位置, 或者6, 即数值 7 所在位置. 挑战 Time complexity O(logA)
 */
public class TI_75 {
	public int fiAdPeak(int[] A) {
        int start = 1, end = A.length-2; // 1.答案在之间，2.不会出界 
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {
                end = mid;
            } else if(A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else { 
            return start;
        }
	}
}