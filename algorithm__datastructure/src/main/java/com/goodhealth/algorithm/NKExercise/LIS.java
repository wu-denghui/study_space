/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

/**
 * @author 24663
 * @date 2018年8月23日
 * @Description
 * 最长上升子序列的定义：
最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，这种子序列不一定是连续的或者唯一的。
https://en.wikipedia.org/wiki/Longest_increasing_subsequence
样例
给出 [5,4,1,2,3]，LIS 是 [1,2,3]，返回 3
给出 [4,2,4,5,3,7]，LIS 是 [2,4,5,7]，返回 4
挑战
要求时间复杂度为O(n^2) 或者 O(nlogn)
 */
public class LIS {


	public static void main(String[] args) {
		LIS lis=new LIS();
		int[] an={4,2,4,5,3,7};
		int[] an2={5,4,1,2,3};
		int[]  result=lis.getLIS(an2);
		System.out.println(lis.getMax(result, an2.length-1));

	}
	
	public int[] getLIS(int[] an){
		int[]  result=new int[an.length];
		for (int i = 0; i < result.length; i++) {
			result[i]=1;
		}
		for (int i = 0; i < an.length; i++) {
			for (int k = 0; k < i; k++) {
				if (an[i]>=an[k]) {
					result[i]=getMax(result, k)+1;
				}else{
					continue;
				}
			}
		}
		return result;
	}
	
	public  int getMax(int[] an,int n){
		if (an==null||an.length<=0) {
			return -1;
		}
		int i=0;
		int max=0;
		while (i<=n) {
			if (max<=an[i]) {
				max=an[i];
			}
			i++;
		}
		return max;
		
	}
	

}
