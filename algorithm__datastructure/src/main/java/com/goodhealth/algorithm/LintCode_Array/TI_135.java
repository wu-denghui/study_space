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
描述控制台
数字组合
给出一个候选数字的set(C)和目标数字(T),找到C中所有的组合，使找出的数字和为T。C中的数字可以无限制重复被选取。
例如,给出候选数组[2,3,6,7]和目标数字7，所求的解为：
[7]，
[2,2,3]
 */
public class TI_135 {
	
	public static void main(String[] args) {
		TI_135 ma=new TI_135();
		int[] candidates={2,3,6,7};
		System.out.println(ma.combinationSum(candidates, 7));
	}

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList< Integer> list=new ArrayList<>();
    	List<List<Integer>> result=new  ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	getList(result,list,candidates,0,0,target);
		return result;
    }
	private void getList(List<List<Integer>> result, ArrayList<Integer> list, int[] candidates,int start,int sum,int target) {
		if (sum==target) {
			if (!result.contains(list)) {
				result.add(new ArrayList<>(list));
				return ;
			}
		}
		int temp=sum;
		for (int i = start; i < candidates.length; i++) {
			sum+=candidates[i];
			if (sum<=target) {
				list.add(candidates[i]);
				getList(result, list, candidates,i, sum, target);
				sum=sum-list.get(list.size()-1);
				list.remove(list.size()-1);
			}else{
				sum=temp;
				continue;
			}
		}
	}
}
