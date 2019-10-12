/**
 * 
 */
package com.goodhealth.algorithm.ListExercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 24663
 * @date 2018年12月24日
 * @Description 给定一个序列，求得所有的排列 例如 1 2 3------- 123 132 213 231 312 321
 */
public class AllSort {

	/**
	 * @param nums
	 * @return
	 * @Description   解法一
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		getAllList(result, nums, new boolean[nums.length], new LinkedList<Integer>());
		return result;
	}
	
	public void getAllList(List<List<Integer>> result, int[] nums, boolean[] visited, LinkedList<Integer> list) {
		if (nums == null) {
			result.add(list);
		}
		/*递归调用结束的出口*/
		if (list.size() == nums.length) {
			result.add(new LinkedList<Integer>(list));
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {//用过就不在访问
				continue;
			}
			list.add(nums[i]);
			visited[i] = true;//用过了就标记它被用过了
			getAllList(result, nums, visited, list);
/*		在上一轮调用getAllList时，将第i个元素开头的情况全确定了。
		现在将用第i+1个元素开头，此时第i个元素是可用的，所以要将其标记清除并且将list中的第i个元素踢出开头位置*/
			visited[i] = false;
			list.removeLast();
		}
	}

	/**
	 * @param result
	 * @param list
	 * @param nums
	 * @Description   解法二
	 */
	public void getAllSort(List<List<Integer>> result, LinkedList<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			result.add(new LinkedList<Integer>(list));
			return;
		}
		for (int i : nums) {
			if (!list.contains(i)) {
				list.add(i);
				getAllSort(result, list, nums);
				list.removeLast();
			}
		}
	}

}
