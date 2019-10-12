package com.goodhealth.algorithm.Algorithm;

//分治算法解决循环赛制问题
public class DivideandConqueDemo {
	
	
	public void circleGame(int[][]an,int n){
		if (n==1) {
			an[0][0]=1;
		}else {
			int m=n/2;
			circleGame(an, m);
			for (int i = 0; i < m; i++) {
				for (int j = m; j < n; j++) {
					an[i][j]=an[i][j-m]+m;
				}
			}
			for (int j = 0; j < m; j++) {
			    for (int i = m; i < n; i++) {
					an[i][j]=an[i-m][j]+m;
				}
			}
			for (int i = m; i < n; i++) {
				for (int j = m; j < n; j++) {
					an[i][j]=an[i-m][j-m];
				}
			}
		}
	}
	public static void main(String[] args) {
        DivideandConqueDemo demo=new DivideandConqueDemo();
        int n=8;
        int[][] an=new int[n][n];
        demo.circleGame(an, n);
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(an[i][j]+" ");
			}
			System.out.println();
		}
	}
}
