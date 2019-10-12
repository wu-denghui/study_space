package com.goodhealth.algorithm.LintCode_String;

/*给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。*/
public class JiaoChaString {
    public static void main(String[] args){
        JiaoChaString ma = new JiaoChaString();
        System.out.println(ma.isInterleave("","","1"));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[] bo1 = new boolean[s1.length()];
        boolean[] bo2 = new boolean[s2.length()];
        // write your code here
        if (s1.length()+s2.length()!=s3.length()){
            return false;
        }
        for(int i=0;i<s3.length();i++){
            char target = s3.charAt(i);
            System.out.println();
            System.out.print(target+":");
            if(!belongS(s1,target,bo1)){
                belongS(s2,target,bo2);
            }
        }
        String s=s1+s2;
        if (s3.equals(s)&&s3.length()>0){
            return false;
        }
        if (allTrue(bo1)&&allTrue(bo2)){
            return true;
        }
        return false;
    }

    public boolean belongS(String s, char target,boolean[] bool){
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            System.out.print(temp+"-");
            if (temp==target&&bool[i]!=true){
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


    public boolean isInterleaveII(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean [][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
        interleaved[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0])
                interleaved[i][0] = true;
        }

        for (int j = 1; j <= s2.length(); j++) {
            if(s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1])
                interleaved[0][j] = true;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]))
                        || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1]))
                    interleaved[i][j] = true;
            }
        }

        return interleaved[s1.length()][s2.length()];
    }
}
