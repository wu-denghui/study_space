package com.goodhealth.algorithm.LintCode_Array;

public class ShuZuHuaFen {

    public static void main(String[] args){
        ShuZuHuaFen ma = new ShuZuHuaFen();
        int[] nums= {3,2,2,1};
        System.out.println(ma.partitionArray(nums,2));
    }
    public int partitionArray(int[] nums, int k) {
        // write your code here
        int index = 0;
        if (nums.length==0){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            if (nums[i]<k){
                index++;
            }
        }
        return index;
    }
}
