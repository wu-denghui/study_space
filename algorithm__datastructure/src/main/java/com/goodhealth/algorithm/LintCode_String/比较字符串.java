package com.goodhealth.algorithm.LintCode_String;

public class 比较字符串 {
    public static void main(String[] args){
        比较字符串 ma = new 比较字符串();
        System.out.println(ma.compareStrings("ABCD","AABC"));
//        Arrays.sort();
    }


    public boolean compareStrings(String A, String B) {
        if (B.length()==0){
            return true;
        }
        if (A.length()==0){
            return false;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        boolean[] booa = new boolean[a.length];
        boolean[] boob = new boolean[b.length];
        for(int i=0;i<b.length;i++){
            for(int j= 0;j<a.length;j++){
                if (b[i]==a[j]&&booa[j]==false&&boob[i]==false){
                    booa[j] = true;
                    boob[i] = true;
                }
            }
        }
        for (boolean bo :boob){
            if (bo==false){
                return false;
            }
        }
        return true;
    }
}
