package com.goodhealth.algorithm.LintCode_String;

public class 字符大小写排序 {

    public static void main(String[] args){
        字符大小写排序 ma = new 字符大小写排序();
        char[] chars ={'a','b','A','c','D'};
        ma.sortLetters(chars);
        System.out.println(chars[3]);
    }

    public void sortLetters(char[] chars) {
        // write your code here
        int left = 0;
        char temp;
        int right = chars.length-1;
        while (left<right){
            temp = chars[left];
            while (left<right&&chars[right]>=97){
                right--;
            }
            chars[left] = chars[right];
            while (left<right&&chars[left]<97){
                left++;
            }
            chars[right]=temp;
        }
    }
}
