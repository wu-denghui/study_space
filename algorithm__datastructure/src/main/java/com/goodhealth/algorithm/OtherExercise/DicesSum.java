package com.goodhealth.algorithm.OtherExercise;

/*扔 n 个骰子，向上面的数字之和为 S。给定 n，请列出所有可能的 S 值及其相应的概率。*/
public class DicesSum {
    public static void main(String[] args){
        System.out.println(dicesSum(2));
    }

    public static double dicesSum(int n) {
        double[][] res = new double[n+1][n*6+1];
        for(int i=1;i<7;i++){
            res[1][i] = 0.17;
        }
        for(int i=2;i<=n;i++){
            for(int j=i;j<=6*n;j++){
                for(int k=1;k<=6;k++){
                    if (j > k) {
                        res[i][j] += res[i - 1][j - k];
                    }
                    res[i][j] /= 6.0;
                }
            }
        }
        return res[n][n];
    }
}
