/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author 24663
 * @date 2019年2月17日
 * @Description
 */
public class AllSubset {
		public static void main(String[] args) {
			AllSubset subset=new AllSubset();
			int[] nums={1,2,2 };
			System.out.println(subset.subsets(nums));

		}
		/**
		 * @param nums
		 * @return
		 * @Description    得到数组得所有子集，包括空集
		 */
		public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> results = new ArrayList<>();
	        if (nums == null) {
	            return results;
	        }
	        if (nums.length == 0) {
	            results.add(new ArrayList<Integer>());
	            return results;
	        }
	        Arrays.sort(nums);   //将数组排序
	        
	       /*第一次调用时，传入一个空集*/
	        helper(new ArrayList<Integer>(), nums, 0, results);   //递归得到数组的子集
	        return results;
	    }
		
	    private void helper(ArrayList<Integer> subset,int[] nums,int startIndex,List<List<Integer>> results) {
	    	if (!results.contains(subset)) {
	    		results.add(new ArrayList<Integer>(subset));  //把新的子集加入result
			}
	        for (int i = startIndex; i < nums.length; i++) {
	            subset.add(nums[i]);
	            helper(subset, nums, i + 1, results);
	            /*在整个递归的过程中，subset是同一个list，变化的只是内部数据*/
	            subset.remove(subset.size() - 1);
	        }
	    }
	    
	    
	    
}
