package com.goodhealth.algorithm.Algorithm;

import java.util.Scanner;  
//约瑟夫杀人问题

public class JosephusKill {  
	
    public static void main(String[] args){  
        Scanner sc=new Scanner(System.in);  
        int m=sc.nextInt();
        int n=sc.nextInt();
        int loc=0;
        int tur=1;
        int count=m;
          
        boolean []flag=new boolean[m];  
        while(count>1){  
            if(flag[loc%m]==false){
                if(tur%n==0){
                	int deadth=loc%m;
                    flag[deadth]=true;  
                    loc++;  
                    tur=1;  
                    count--;
                }  
                else{  
                    loc++;  
                    tur++;  
                }  
            }  
            else{  
                loc++;  
            }  
              
        }  
        for(int i=0;i<m;i++){  
            if(flag[i]==false){  
                System.out.print((i+1)+" ");  
            }  
        }  
          
    }  
}  