/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

/**
 * @author 24663
 * @date 2018年8月24日
 * @Description
 * 
 * 有一个机器人的位于一个 m × n 个网格左上角。
   机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
   问有多少条不同的路径？
 */
public class Path {

	public static void main(String[] args) {
		int n=9;
		int m=1;
		int sum=n+m;
		int fm=1;
		int fz=1;
		for (int i = sum-n+1; i <=sum; i++) {
			fz=fz*i;
		}
		System.out.println(fz);
		for (int i = 1; i <=n; i++) {
			fm=i*fm;
		}
		System.out.println(fm);
       int result=fz/fm;
       System.out.println(result);
	}

}
