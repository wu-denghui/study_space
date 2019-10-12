/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

/**
 * @author 24663
 * @date 2018年8月24日
 * @Description 给出三个字符串: str1、str2、str3，判断str3是否由str1和str2交叉构成。
 * 
 */
public class CrossString {

	public static void main(String[] args) {
		CrossString crossString = new CrossString();
		String str1 = "aabcc";
		String str2 = "dbbca";
		String str3 = "aadbbcbcac";
		String str4 = "aadbbbaccc";
		System.out.println(crossString.getResult(str1, str2, str4));

	}

	public boolean getResult(String str1, String str2, String str3) {
		// result[i][j]表示 str1的前i个字符 与str2 的前j个字符 能否组成str3的前i+j个字符

		if (str3.length() != str1.length() + str2.length())
			return false;
		if (str1.length() == 0)
			return str2 == str3;
		if (str2.length() == 0)
			return str1 == str3;
		boolean[][] result = new boolean[str1.length() + 1][str2.length() + 1];
		result[0][0]=true;
		for (int i = 1; i < str1.length(); i++) {
			result[i][0] = result[i-1][0]&&str1.charAt(i-1)==str3.charAt(i-1);
		}
		for (int i = 1; i < str2.length(); i++) {
			result[0][i] = result[0][i-1]&&str2.charAt(i-1)==str3.charAt(i-1);
		}
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str3.charAt(i + j+1) == str1.charAt(i)) {
					result[i + 1][j + 1] = result[i][j + 1];
				} else if (str3.charAt(i + j+1) == str2.charAt(j)) {
					result[i + 1][j + 1] = result[i + 1][j];
				}
			}
		}
		return result[str1.length()][str2.length()];
	}

}
