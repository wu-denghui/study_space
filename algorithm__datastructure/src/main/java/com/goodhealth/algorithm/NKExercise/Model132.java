/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

import java.util.Stack;

/**
 * @author 24663
 * @date 2018年8月28日
 * @Description 给你一个 n 个整数的序列 a1,a2,…,an，一个 132 模式是对于一个子串 ai,aj,ak， 满足 i < j < k
 *              和 ai < ak < aj。设计一个算法来检查输入的这 n 个整数的序列中是否存在132模式。
 */
public class Model132 {

	public static void main(String[] args) {
		Model132 model132 = new Model132();
		int[] an = { 3, 1, 4, 2 };
		System.out.println(model132.find132pattern(an));

	}

	public boolean getResult(int[] an) {
		if (an == null || an.length < 3) {
			return false;
		}
		int min = an[0];
		for (int i = 1; i < an.length; i++) {
			min = Math.min(min, an[i - 1]);
			for (int j = i + 1; j < an.length; j++) {
				if (min < an[j] && an[j] < an[i]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean find132pattern(int[] nums) {
		int third = Integer.MIN_VALUE;
		Stack<Integer> s = new Stack<>();
		for (int i = nums.length - 1; i >= 0; --i) {
			if (nums[i] < third) {
				return true;
			}else{
				while (!s.empty() && nums[i] > s.peek()) {
					third = s.peek();
					s.pop();
				}
			}
			s.push(nums[i]);
		}
		return false;
	}

}
