package com.goodhealth.algorithm.LintCode_String;

import java.util.ArrayList;
import java.util.List;

public class 翻转字符串中的单词 {

    public static void main(String[] args){
        翻转字符串中的单词 ma = new 翻转字符串中的单词();
        System.out.println("0123456".substring(1,4));
        System.out.println(ma.reverseWords("  Life  doesn't  always    give     us  the       joys we want."));
    }

    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        String[] arr = getArray(s.trim()+" ");
        for (String ss : arr){
            System.out.print(ss+"-");
        }
        System.out.println();
        int left = 0;
        int right = arr.length-1;
        while (left<right){
            swap(arr,left,right);
            left++;
            right--;
        }
        for(int i=0;i<arr.length;i++){
            if (i!=arr.length-1){
                res.append(arr[i]+" ");
            }else {
                res.append(arr[i]);
            }
        }
        return res.toString();
    }

    private void swap(String[] arr, int left, int right){
        String temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    private String[] getArray(String s){
        List<String> resList = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i=start;i<s.length();i++){
            if (s.charAt(i)==' '&& s.charAt(start)!=' '){
                end = i;
                String res = s.substring(start,end);
                resList.add(res);
                start = i;
            }
            if (s.charAt(i)!=' '&& s.charAt(start)==' '){
                start = i;
            }
        }
        return resList.toArray(new String[resList.size()]);
    }
}
