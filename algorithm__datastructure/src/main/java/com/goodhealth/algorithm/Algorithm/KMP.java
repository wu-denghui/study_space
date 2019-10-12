/**
 * 
 */
package com.goodhealth.algorithm.Algorithm;

import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年8月11日
 * @Description kmp算法-------字符串匹配
 */
public class KMP {
	
	public static void main(String[] args) {
		KMP kmp = new KMP();
		Scanner read = new Scanner(System.in);
		String ts = read.nextLine();
		String ps;
		while (read.hasNext()) {
			 ps = read.next();
			if (kmp.getKMP(ts, ps) != -1) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	public int getKMP(String ts, String ps) {
		if (ts == null || ps == null) {
			return -1;
		}
		char[] t = ts.toCharArray();
		char[] p = ps.toCharArray();
		int i = 0; // 主串的位置
		int j = 0; // 模式串的位置
		int[] next = getNext(ps);
		while (i < t.length && j < p.length) {
			if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
				i++;
				j++;
			} else {
				// i不需要回溯了
				// i = i - j + 1;
				j = next[j]; // j回到指定位置
			}
		}
		if (j == p.length) {
			return i ;
		} else {
			return -1;
		}
	}

	public int[] getNext(String ps) {
		char[] p = ps.toCharArray();
		int[] next = new int[p.length];
		next[0] = -1;
		int j = 0;
		int k = -1;
		while (j < p.length - 1) {
			if (k == -1 || p[j] == p[k]) {
				if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
					next[j] = next[k];
				} else {
					next[j] = k;
				}
			} else {
				k = next[k];
			}
		}
		return next;
	}
}
