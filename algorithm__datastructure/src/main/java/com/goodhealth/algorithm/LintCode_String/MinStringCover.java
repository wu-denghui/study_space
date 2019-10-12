package com.goodhealth.algorithm.LintCode_String;

public class MinStringCover {
    public static void main(String[] args){
        MinStringCover ma = new MinStringCover();
        System.out.println(ma.minWindow("ADOBECODEBANC","ABC"));
    }

    public String minWindow(String source , String target) {
        if ("".equals(source) || "".equals(target)) {
            return "";
        }
        String res =source+"111";
        for(int i=0;i<source.length();i++){
            boolean[] bool = new boolean[target.length()];
            for(int j=i;j<source.length();j++){
                char temp = source.charAt(j);
                testIfBelongTarget(target,temp,bool);
                if (allTrue(bool)){
                    String tt =source.substring(i,j+1);
                    if (tt.length()<res.length()){
                        res = tt;
                    }
                    break;
                }
            }
        }
        if ((source+"111").equals(res)){
            return "";
        }
        return res;
    }

    public boolean testIfBelongTarget(String target, char c, boolean[] bool){
        for(int i=0;i<target.length();i++){
            if (target.charAt(i)==c&&bool[i]==false){
                bool[i]=true;
                return true;
            }
        }
        return false;
    }

    public boolean allTrue(boolean[] bool){
        for(int i=0;i<bool.length;i++){
            if (bool[i]==false){
                return false;
            }
        }
        return true;
    }
}
