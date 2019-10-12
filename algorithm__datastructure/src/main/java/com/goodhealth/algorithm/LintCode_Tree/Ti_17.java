/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 24663
 * @date 2018年9月14日
 * @Description 求一个集合的所有子集
 */
public class Ti_17 {
	public static void main(String[] args) {
		Ti_17 ti_17 = new Ti_17();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = ti_17.subsets(nums);
		System.out.println(result);

	}
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }
    private void helper(ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(subset, nums, i + 1, results);
            subset.remove(subset.size() - 1);
        }

    }
}
