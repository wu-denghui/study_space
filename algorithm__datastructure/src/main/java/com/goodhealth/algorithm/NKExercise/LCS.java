package com.goodhealth.algorithm.NKExercise;

import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年8月23日
 * @Description
 * 最长公共子序列的定义：
最长公共子序列问题是在一组序列（通常2个）中找到最长公共子序列（注意：不同于子串，LCS不需要是连续的子串）。该问题是典型的计算机科学问题，是文件差异比较程序的基础，在生物信息学中也有所应用。
https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
样例
给出"ABCD" 和 "EDCA"，这个LCS是 "A" (或 D或C)，返回1
给出 "ABCD" 和 "EACB"，这个LCS是"AC"返回 2
 */
public class LCS {
    
	public static void main(String[] args) {
		Scanner next=new Scanner(System.in);
		LCS lcs=new LCS();
		String str1="ABCD";
		String str2="EDCA";
		System.out.println(lcs.getLCS(str1, str2));
	}
	
	public int getLCS(String str1,String str2){
		char[] string1=str1.toCharArray();
		char[] string2=str2.toCharArray();
		//result[i][j]代表着 str1前i个字符与str2前j个字符匹配的lcs，result[0][0]代表前0个字符，所以长度加一
		int[][] result=new int[string1.length+1][string2.length+1];
		for (int i = 0; i < result.length; i++) {
			result[0][i]=0;
		}
		for (int i = 0; i < result.length; i++) {
			result[i][0]=0;
		}
		for (int i = 0; i < string1.length; i++) {
			for (int j = 0; j < string2.length; j++) {
				if (string1[i]==string2[j]) {
					result[i+1][j+1]=result[i][j]+1;
				}else{
					result[i+1][j+1]=Math.max(result[i+1][j], result[j][i+1]);
				}
			}
		}
		return result[string1.length][string2.length];
		
	}
	
	
}
