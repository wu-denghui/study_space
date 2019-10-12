package com.goodhealth.algorithm.OtherExercise;

public class DigitCounts {
    public static void main(String[] args){
        System.out.println(digitCounts(1,12));
//        System.out.println(1/10);
    }

    public static int digitCounts(int k, int n) {
        //计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
        // write your code here
        int res = 0;
        for(int i=k;i<=n;i++){
            if (i==0 && k==0){
                res++;
            }else {
//                int x = i;
                while (i>0){
                    if (i%10 == k){
                        res++;
                    }
                    i = i/10;
                }
            }
        }
        return res;
    }
}
