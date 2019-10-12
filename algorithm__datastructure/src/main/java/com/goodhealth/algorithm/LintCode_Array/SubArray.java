/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 24663
 * @date 2018年10月7日
 * @Description
 */
public class SubArray {

	public static void main(String[] args) {
		SubArray ms=new SubArray();
		int[] A={-3, 1, 2, -3, 4};
        System.out.println(ms.subarraySum(A));
	}
    /**
     * @param A
     * @return
     * @Description 41. 最大子数组
给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
样例
给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
     */
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
    
    
    /**
     * @param nums
     * @return
     * @Description 138. 子数组之和
给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
样例
给出 [-3, 1, 2, -3, 4]，返回[0, 2] 或者 [1, 3].
     */
    public List<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int[] s=new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            s[i]=max;
            sum = Math.max(sum, 0);
        }
        for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if (s[i]==s[j]) {
					list.add(i+1);
					list.add(j);
					return list;
				}
			}
		}
        return list;
    }
    
    /**
     * @param nums
     * @return
     * @Description 42. 最大子数组 II
给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
每个子数组的数字在数组中的位置应该是连续的。
返回最大的和。
样例
给出数组 [1, 3, -1, 2, -1, 2]
这两个子数组分别为 [1, 3] 和 [2, -1, 2] 或者 [1, 3, -1, 2] 和 [2]，它们的最大和都是 7
     */
    public int maxTwoSubArrays(List<Integer> nums) {
    	int length=nums.size();
    	//left[i]代表从0到i的最大数组和
    	int[] left=new int[length];
    	//righr[i]代表从length-1到i的最大数组和
    	int[] right=new int[length];
    	//求解数组left
    	int sum=0;
    	int max=Integer.MIN_VALUE;
    	for (int i = 0; i < length; i++) {
			sum+=nums.get(i);
			max=Math.max(max, sum);
			sum=Math.max(0, sum);
			left[i]=max;
		}
    	//求解数组right
    	int sum2=0;
    	int max2=Integer.MIN_VALUE;
    	for (int i = length-1; i >=0; i--) {
			sum2+=nums.get(i);
			max2=Math.max(max2, sum2);
			sum2=Math.max(0, sum2);
			right[i]=max2;
		}
    	//求解两个最大子数组和
    	int result=Integer.MIN_VALUE;
    	for (int i = 0; i +1< length; i++) {
			result=Math.max(result, left[i]+right[i+1]);
		}
		return result;
    }
    
    /**
     * @param nums
     * @return
     * @Description 
     * 给定一个整数数组，找到一个具有最小和的子数组。返回其最小和。
   样例
给出数组[1, -1, -2, 1]，返回 -3
     */
    public int minSubArray(List<Integer> nums) {
    	int[] an=new int[nums.size()];
    	int index=0;
    	//将数据取相反值，求最小值变成求最大值
    	for (int i = 0; i < an.length; i++) {
    		index=nums.get(i);
			an[i]=-index;
		}
    	int sum=0;
    	int max=Integer.MIN_VALUE;
    	for (int i = 0; i < an.length; i++) {
			sum+=an[i];
			max=Math.max(sum, max);
			sum=Math.max(sum, 0);
		}
		return -max;
    }
    
    /**
     * @param nums
     * @return
     * @Description  
描述控制台
45. 最大子数组差
给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组和的差的绝对值|SUM(A) - SUM(B)|最大。
返回这个最大的差值。
样例
给出数组[1, 2, -3, 1]，返回 6
     */
    public int maxDiffSubArrays(int[] nums) {
    	int [] leftMax=new int[nums.length];
    	int [] leftMin=new int[nums.length];
    	int [] rightMax=new int[nums.length];
    	int [] rightMin=new int[nums.length];
    	//求解两边最大值
    	int sum=0;
    	int max=Integer.MIN_VALUE;
    	for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
			max=Math.max(max, sum);
			sum=Math.max(0, sum);
			leftMax[i]=max;
		}
    	int sum2=0;
    	int max2=Integer.MIN_VALUE;
    	for (int i = nums.length-1; i >=0; i--) {
			sum2+=nums[i];
			max2=Math.max(max2, sum2);
			sum2=Math.max(0, sum2);
			rightMax[i]=max2;
		}
    	int[] an=new int[nums.length];
    	//求解两边最小值
    	//将数据取相反值，求最小值变成求最大值
    	for (int i = 0; i < an.length; i++) {
    	      an[i]=-nums[i];
		}
    	int sum3=0;
    	int max3=Integer.MIN_VALUE;
    	for (int i = 0; i < an.length; i++) {
			sum3+=an[i];
			max3=Math.max(sum3, max3);
			sum3=Math.max(sum3, 0);
			leftMin[i]=-max3;
		}
    	int sum4=0;
    	int max4=Integer.MIN_VALUE;
    	for (int i = an.length-1; i >=0; i--) {
			sum4+=an[i];
			max4=Math.max(sum4, max4);
			sum4=Math.max(sum4, 0);
			rightMin[i]=-max4;
		}
    	int result=Integer.MIN_VALUE;
    	for (int i = 0; i+1 < an.length; i++) {
		result=Math.max(result, Math.max(Math.abs(leftMax[i]-rightMin[i+1]),Math.abs(leftMin[i]-rightMax[i+1])));
    	}
		return result;
    }
    public  void print(int[] an){
    	for (int i = 0; i < an.length; i++) {
    		if (i==an.length-1) {
    			System.out.print(an[i]+"\n");
			}else{
				System.out.print(an[i]+" ");
			}
	
		}
    }
}
