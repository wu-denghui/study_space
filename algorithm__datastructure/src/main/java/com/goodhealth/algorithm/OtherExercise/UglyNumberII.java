package com.goodhealth.algorithm.OtherExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UglyNumberII {
    public static void main(String[] args){
//        System.out.println(nthUglyNumber(10));
//        System.out.println(isUglyNumber(145));
        UglyNumberII ma = new UglyNumberII();
        int[] nums={1,4,4,5,7,7,8,9,9,10};
        System.out.println(ma.nthUglyNumber(41));
        List<Integer> uglyNumber = new ArrayList<>();
        uglyNumber.add(1);
        uglyNumber.add(2);
        uglyNumber.add(3);
        uglyNumber.add(4);
        uglyNumber.add(5);
        System.out.println(uglyNumber.subList(1,5));


    }

    public  int nthUglyNumber(int n) {
        List<Integer> uglyNumber = new ArrayList<>();
        uglyNumber.add(1);
        uglyNumber.add(2);
        uglyNumber.add(3);
        uglyNumber.add(4);
        uglyNumber.add(5);
        if (n < 4) {
            return uglyNumber.get(n-1);
        }
        int index = 1;
        int start = 1;
        int end = 5;
        while (true){
            Integer[] arr = uglyNumber.subList(start,end).toArray(new Integer[end-start]);
            while (index<arr.length){
                if (!isUglyNumber(uglyNumber,arr[index]*2)){
                    uglyNumber.add(arr[index]*2);
                }
                index++;
            }
            index=1;
            while (index<arr.length){
                if (!isUglyNumber(uglyNumber,arr[index]*3)){
                    uglyNumber.add(arr[index]*3);
                }
                index++;
            }
            index=1;
            while (index<arr.length){
                if (!isUglyNumber(uglyNumber,arr[index]*5)){
                    uglyNumber.add(arr[index]*5);
                }
                index++;
            }
            Collections.sort(uglyNumber);
            if (uglyNumber.size()>n){
                break;
            }
            start = end;
            end = uglyNumber.size();
        }
        return uglyNumber.get(n-1);
    }
    private boolean isUglyNumber(List<Integer> nums, int target) {
        return nums.contains(target);
    }

    /*private boolean isUglyNumber(int[]nums, int target) {
        int left = 0;
        int mid = 0;
        int right = nums.length-1;
        while(left+1<right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid ;
            } else if (nums[mid] > target) {
                right = mid ;
            } else {
                right = mid;
            }
        }
        if (nums[left]==target||nums[right]==target) {
            return true;
        }
        return false;
    }*/


    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int mid = 0;
        int right = nums.length-1;
        while(left+1<right){
            mid = (left+right)/2;
            if(nums[mid]<target){
                left=mid;
            }else if(nums[mid]>target){
                right=mid;
            }else{
                right=mid;
            }
            if (nums[left]==target&&left-1>0&&nums[left]==nums[left-1]){
                 left--;
            }else {
                return left;
            }
            if (nums[right]==target&&nums[right-1]==nums[right]){
                 right--;
            }else{
                return right;
            }
        }
        return -1;
    }


    public int reverseInteger(int number) {
        // write your code here
        String str = String.valueOf(number);
        str = new StringBuffer(str).reverse().toString();
        return Integer.parseInt(str);
    }
}
