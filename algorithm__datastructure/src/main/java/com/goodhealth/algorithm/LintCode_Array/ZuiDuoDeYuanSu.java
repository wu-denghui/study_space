package com.goodhealth.algorithm.LintCode_Array;

import java.util.*;

public class ZuiDuoDeYuanSu {

    public static void main(String[] args){
        ZuiDuoDeYuanSu ma = new ZuiDuoDeYuanSu();
        Integer[] arrays = {1,1,1,1,2,2,3,3,4,4,4};
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(arrays));
        System.out.println( ma.majorityNumberII(nums));
    }


    public int majorityNumberI_1(List<Integer> nums) {
        List<Integer> list = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        nums.forEach(e->{
            put(map,e);
        });
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iters=set.iterator();
        int max = Integer.MIN_VALUE;
        int res = 0;
        while (iters.hasNext()) {
            Map.Entry<Integer, Integer> entry = iters.next();
            if (entry.getValue()>max){
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public void put(HashMap<Integer, Integer> map, Integer i){
        if(map.containsKey(i)){
            map.put(i, map.get(i)+1);
        }else {
            map.put(i,1);
        }

    }

    public int majorityNumberI_2(ArrayList<Integer> nums) {
        //由于主元素在数组中个数严格大于1/2，所以假设当前元素就是主元素，用count记录当前元素个数与其他元素个数的差值，
        //candidate记录当前元素是什么，最后count一定为正数并且candidate就是主元素
        int count = 0, candidate = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else if (candidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
    public int majorityNumberII(List<Integer> nums) {
        int val1 = 1;
        int key1 = nums.get(0);
        int val2 = 0;
        int key2 = 0;
        for(int i=1;i<nums.size();i++){
            int temp =nums.get(i);
            if (val1==0){
                key1 = temp;
                val1 = 1;
                continue;
            }
            if (val2==0&&temp!=key1&&i+1<nums.size()){
                key2 = temp;
                val2 = 1;
                continue;
            }
            if (temp==key1){
                val1++;
            }
            if (temp==key2){
                val2++;
            }
            if (temp!=key1&&temp!=key2){
                val1--;
                val2--;
            }
        }
        val1 = 0;
        val2 = 0;
        for(int i=0;i<nums.size();i++){
            int temp = nums.get(i);
            if (temp==key1){
                val1++;
            }
            if (temp==key2){
                val2++;
            }
        }
        return val1>val2?key1:key2;
    }
}
