package com.goodhealth.algorithm.NKExercise;

public class Str {
	public static void main(String[] args) {
		Str str = new Str();
		String source = "apdbnm";
		String targe = "dbn";
		int result = str.strStr(source, targe);
		System.out.println(result);

	}

	public int strStr(String source, String targe) {
		if (source==null||targe==null) {
			return -1;
		}
		char[] s = source.toCharArray();
		char[] t = targe.toCharArray();
		int k = 0, l = 0;
		int temp = 0;
		while (k < t.length && l < s.length) {
			temp = l;
			while ( k < t.length && l < s.length&&s[l] == t[k] ) {
				if (k == t.length - 1 || l == s.length) {
					return temp;
				}
				k++;
				l++;
			}
			l = temp + 1;
			k = 0;
		}

		return -1;
	}
}
