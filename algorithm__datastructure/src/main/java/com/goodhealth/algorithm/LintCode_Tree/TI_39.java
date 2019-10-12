/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

import java.util.List;

/**
 * @author 24663
 * @date 2018年9月4日
 * @Description
39. 恢复旋转排序数组
给定一个旋转排序数组，在原地恢复其排序。
样例
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
挑战
使用O(1)的额外空间和O(n)时间复杂度
说明
什么是旋转数组？
比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 */
public class TI_39 {

	 private void reverse(List<Integer> nums, int start, int end) {
	        for (int i = start, j = end; i < j; i++, j--) {
	            int temp = nums.get(i);
	            nums.set(i, nums.get(j));
	            nums.set(j, temp);
	        }
	    }

	    public void recoverRotatedSortedArray(List<Integer> nums) {
	        for (int index = 0; index < nums.size() - 1; index++) {
	            if (nums.get(index) > nums.get(index + 1)) {
	            	//三步反转法
	                reverse(nums, 0, index);
	                reverse(nums, index + 1, nums.size() - 1);
	                reverse(nums, 0, nums.size() - 1);
	                return;
	            }
	        }
	    }
}
