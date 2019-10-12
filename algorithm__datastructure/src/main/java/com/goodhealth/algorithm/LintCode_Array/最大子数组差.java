package com.goodhealth.algorithm.LintCode_Array;

public class 最大子数组差 {
    public int maxDiffSubArrays(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int leftSum = 0;
        int rightSum = 0;
        int temp ;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            leftSum += nums[i];
            rightSum = sum-leftSum;
            temp = Math.abs(leftSum-rightSum);
            if (max<temp){
                max = temp;
            }
        }
        return max;
    }


    public int maxDiffSubArraysII(int[] nums) {
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
}
