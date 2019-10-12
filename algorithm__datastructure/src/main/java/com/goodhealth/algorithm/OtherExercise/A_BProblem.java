package com.goodhealth.algorithm.OtherExercise;

public class A_BProblem {

    public static void main(String[] args){
//        System.out.println(aplusb(2,12));
        System.out.println(trailingZeros(5));
    }

    public static int aplusb(int a, int b) {
        // write your code here
        while (b != 0){
            int an = a^b;
            int bn = (a&b)<<1;
            a = an;
            b = bn;
        }
        return a;
    }

    public static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        if(n>5){
            return n/5+trailingZeros(n/5);
        }else{
            return 0;
        }
    }
}
