package com.goodhealth.algorithm.Algorithm;

//贪心算法解决背包问题
public class Package {  
 
    public static void main(String[] args) {  
        int w=11;
        int n=5;
        int[] value={1,6,18,22,28};
        int[] weight={1,2,5,6,7};
        System.out.println(findMaxValue(w,n,weight,value));  
    }  
  
    private static int findMaxValue(int w,int n, int[] weight, int[] value) {  
        int[][]max=new int[n+1][w+1];  
          
        for(int i=0;i<=w;i++)//M[n,W]  
            max[0][i]=0;  
        for(int i=0;i<=n;i++)//M[n,W]  
        	max[i][0]=0;  
        for(int j=1;j<=n;j++) {
            for(int k=1;k<=w;k++){
                if(weight[j-1]>k){
                    max[j][k]=max[j-1][k];
                }else{  
                    int a=max[j-1][k];
                    int b=value[j-1]+max[j-1][k-weight[j-1]];
                    max[j][k]=a>b ? a:b;
                } 
        }
    }
          
        for (int[] is : max) {  
            for (int i : is) {  
                System.out.print(i+"  ");  
            }  
            System.out.println();  
        }  
        return max[n][w];  
          
    }  
  
  
}  