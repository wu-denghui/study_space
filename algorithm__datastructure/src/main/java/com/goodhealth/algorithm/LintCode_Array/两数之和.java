package com.goodhealth.algorithm.LintCode_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 两数之和 {

    public static void main(String[] args){
        两数之和 ma = new 两数之和();
        int[] num = {-8,-0,-7,-101,-123,-1,-2,1,1,4,-2,0,-1,0,-1111,0,-1,-2,-3,-4,-5,-6,-100,-98,-111,-11};
        System.out.println(ma.fourSum(num,-111));


    }


    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] res = new int[2];
        int temp;
        for(int i=0;i<numbers.length;i++){
            temp = target-numbers[i];
            for(int j=i+1;j<numbers.length;j++){
                if (temp==numbers[j]){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
/*                if (temp<numbers[j]){
                    break;
                }*/
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] numbers, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numbers.length<4){
            return res;
        }
        List<List<Integer>> contain;
        List<Integer> list2;
        Integer[] temp;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
/*            if (numbers[i]>target){
                break;
            }*/
            contain = threeSum(numbers, target-numbers[i],i+1);
            if (!contain.isEmpty()){
                for (List<Integer> list: contain) {
                    list.add(numbers[i]);
                    temp = list.toArray(new Integer[list.size()]);
                    Arrays.sort(temp);
                    list2 = new ArrayList<>(Arrays.asList(temp));
                    if (!res.contains(list2)){
                        res.add(list2);
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] numbers,int target,int left) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list ;
        Arrays.sort(numbers);
        int  twoSum = 0;
        int  one = 0;
        for(int i=left;i<numbers.length;i++){
            twoSum = target-numbers[i];
            for (int j = i+1; j <numbers.length ; j++) {
                one = twoSum-numbers[j];
                if (numbers[j]>twoSum){
                    break;
                }
                for (int k = j+1; k < numbers.length; k++) {
                    if (numbers[k]==one){
                        list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        if (!res.contains(list)){
                            res.add(list);
                        }
                    }
                    if (numbers[k]>one){
                        break;
                    }
                }
            }
        }
        return res;
    }

    public int[] twoSumII(int[] numbers, int target) {
        //用一个hashmap来记录，key记录target-numbers[i]的值，value记录numbers[i]的i的值，如果碰到一个
        //numbers[j]在hashmap中存在，那么说明前面的某个numbers[i]和numbers[j]的和为target，i和j即为答案
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = {map.get(numbers[i]), i};
                return result;
            }
            map.put(target - numbers[i], i);
        }

        int[] result = {};
        return result;
    }


    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list ;
        Arrays.sort(numbers);
        System.out.println(numbers[0]);
        int  twoSum = 0;
        int  one = 0;
        for(int i=0;i<numbers.length;i++){
            twoSum = 0-numbers[i];
            for (int j = i+1; j <numbers.length ; j++) {
                one = twoSum-numbers[j];
                if (numbers[j]>twoSum){
                    break;
                }
                for (int k = j+1; k < numbers.length; k++) {
                    if (numbers[k]==one){
                        list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        if (!res.contains(list)){
                            res.add(list);
                        }
                    }
                    if (numbers[k]>one){
                        break;
                    }
                }
            }
        }
        return res;
    }
}
