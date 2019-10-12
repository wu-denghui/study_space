/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

/**
 * @author 24663
 * @date 2018年8月24日
 * @Description 描述 给定 n 个不同的正整数，整数 k（k <= n）以及一个目标数字 target。 在这 n 个数里面找出 k个数，
 *              使得这 k 个数的和等于目标数字，求问有多少种方案？ 样例 给出 [1,2,3,4]，k=2， target=5，[1,4] 和
 *              [2,3] 是 2 个符合要求的方案，返回 2。
 */
public class K_sum {

	public static void main(String[] args) {
		K_sum k_sum = new K_sum();
		int[] an = { 1,2,3,4 };
		int k = 2;
		int target = 5;
		System.out.println(k_sum.getSumm(an, k, target));

	}

	public int getSum(int[] an, int k, int target) {
		// result[i][j][k] 表示从数组前i个数中选出j个数组成和为k的组合数
		int[][][] result = new int[an.length + 1][k + 1][target+1];
	for (int i = 0; i < an.length + 1; i++) {
			result[i][0][0] = 1;
		}
		for (int i = 1; i < an.length + 1; i++) {
			for (int j = 1; j <= i&&j<=k; j++) {
				for (int p = 1; p <= target; p++) {
					result[i][j][p]=0;
					if (an[i - 1] <= p) {
						result[i][j][p] = result[i - 1][j - 1][p - an[i - 1]];
					}
					result[i][j][p]+=result[i-1][j][p];
				}
			}
		}
		return result[an.length][k][target];

	}

	public int getSumm(int[] an, int k, int target) {
		int[][] result = new int[k + 1][target + 1];
		result[0][0] = 1;
		for (int a : an) {
			for (int i = k; i >= 1; i--) {
				for (int j = target; j >= a; j--) {
					result[i][j] += result[i - 1][j - a];
				}
			}
		}
		return result[k][target];
	}

}
