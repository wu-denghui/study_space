/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 24663
 * @date 2018年8月18日
 * @Description
 */
public class Palindrome {

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		String str = "pllldclcdlll0";
		int result = palindrome.getLongestPalindrome(str, str.length());
		System.out.println(result);
	}

	public int getLongestPalindrome(String A, int n) {
		int count = 0;
		int result = 0;
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		char[] an = A.toCharArray();
       		for (int i = 0; i < an.length; i++) {
			if (!map.isEmpty()) {
				if (!map.containsValue(an[i])) {
					map.put(i, an[i]);

				} else {
					count = getPalindromeLength(an, map, i);
					if (count >= result) {
						result = count;
					}
				}
			} else {
				map.put(i, an[i]);
			}
		}
		return result;
	}

	public int getPalindromeLength(char[] an, Map<Integer, Character> map, int index) {
		char value = an[index];
		int left = -1;
		for (int i = index-1; i >=0; i--) {
			if (an[i]==value) {
				left=i;
				break;
			}
		}
		while (true) {
			if (map.get(left) == map.get(index)) {
				left--;
				index++;
			} else {
				left++;
				index--;
				break;
			}
		}
			return index - left;
	}


}
