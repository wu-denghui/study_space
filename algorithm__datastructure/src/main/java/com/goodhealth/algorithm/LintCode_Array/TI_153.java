/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 24663
 * @date 2018年9月21日
 * @Description
数字组合 II
给出一组候选数字(C)和目标数字(T),找出C中所有的组合，使组合中数字的和为T。C中每个数字在每个组合中只能使用一次。
样例
给出一个例子，候选数字集合为[10,1,6,7,2,1,5] 和目标数字 8  ,
解集为：[[1,7],[1,2,5],[2,6],[1,1,6]]
 */
public class TI_153 {
	public static void main(String[] args) {
		TI_153 ma=new TI_153();
		int[] candidates={10,1,6,7,2,1,5};
		System.out.println(ma.combinationSum2(candidates, 8));
	}
	
    public List<List<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList< Integer> list=new ArrayList<>();
    	List<List<Integer>> result=new  ArrayList<List<Integer>>();
    	Arrays.sort(num);
    	getList(result,list,num,0,0,target);
		return result;
    	
    }
	private void getList(List<List<Integer>> result, ArrayList<Integer> list, int[] num, int start, int sum, int target) {
		if (sum==target) {
			if (!result.contains(list)) {
				result.add(new ArrayList<>(list));
				return ;
			}
		}
		int temp=sum;
		for (int i = start; i < num.length; i++) {
			sum+=num[i];
			if (sum<=target) {
				list.add(num[i]);
				getList(result, list, num,i+1, sum, target);
				sum=sum-list.get(list.size()-1);
				list.remove(list.size()-1);
			}else{
				sum=temp;
				continue;
			}
		}
	}
}
