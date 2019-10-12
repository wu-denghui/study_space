/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

/**
 * @author 24663
 * @date 2018年9月1日
 * @Description
 */
public class SearchA2DMatrix {
	
	/**
	 * @param an
	 * @param target
	 * @return
	 * @Description 
	 * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
     这个矩阵具有以下特性：
     每行中的整数从左到右是排序的。
     每一列的整数从上到下是排序的。
     在每一行或每一列中没有重复的整数。
	 */
	public int searchMatirx(int[][] an,int target){
		int left=an.length-1;
		int right=0;
		int count=0;
		while(left>=0&&right<an[0].length){
			if (an[left][right]==target) {
				count++;	
				right++;
				left--;
			continue;
			}else if (an[left][right]<target) {
				right++;
			}else{
				left--;
			}
		}
		return count;
	}

}
