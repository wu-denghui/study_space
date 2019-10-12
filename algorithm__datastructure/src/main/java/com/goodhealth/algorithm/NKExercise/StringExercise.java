package com.goodhealth.algorithm.NKExercise;
/*
 * testOne    把一个0-1串（只包含0和1的串）进行排序，你可以交换任意两个位置，问最少交换的次数？
 * testTwo    删除一个字符串所有的a,并且复制所有的b
 * testThere    一个字符串只包含*和数字，请把它的*号都放开头  交换法
 * testFour   一个字符串只包含*和数字，请把它的*号都放开头。 复制法
 * testFive     判断两个字符串是否为变位词
 * testSix       判断给定两个串a和b，问b是否是a的子串的变位词
 * testSeven   字符串分解  spilit
 * testEight    字符串分解 SringToKenizer
 * testNine       字符串的反转
 * */
import java.util.StringTokenizer;

public class StringExercise {
	public static void main(String[] args) {
		StringExercise se=new StringExercise();
		String string="abcbba";
		se.testTwo(string);
	}
	
	// 把一个0-1串（只包含0和1的串）进行排序，你可以交换任意两个位置，问最少交换的次数？
	public int testOne(String string) {
		int count = 0;
		char[] ch = string.toCharArray();
		int i = 0;
		int j = ch.length - 1;
		while (i < j) {
			while (i < j && ch[i] == '0') {
				i++;
			}
			ch[j] = ch[i];
			count++;
			while (i < j && ch[j] == '1') {
				j--;
			}
			ch[i] = ch[j];
			count++;
		}
		return count;
	}

	// 删除一个字符串所有的a,并且复制所有的b
	public void testTwo(String string) {
		int count = 0;
		int numb = 0, numa = 0;
		char[] ch = string.toCharArray();
		int m = ch.length;
		printArrary(ch);
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != 'a') {
				ch[count++] = ch[i];
				numa++;
			}
			if (ch[i] == 'b') {
				numb++;
			}
		}
		System.out.println( );
		for (int i = 0; i < m - numa; i++) {
			ch[m - i - 1] = 0;
		}
		int n = (ch.length) + numb;
		char[] ch2 = new char[n];
		for (int i = 0; i < ch.length; i++) {
			ch2[i] = ch[i];
		}
		for (int j = m - 1, i = n - 1; j >= 0; --j) {
			ch2[i--] = ch2[j];
			if (ch2[j] == 'b') {
				ch2[i--] = 'b';
			}
		}
		printArrary(ch2);
	}

	// 打印数组
	public void printArrary(char[] an) {
		for (int i = 0; i < an.length; i++) {
			System.out.print(an[i]);
		}
	}

	// 交换数据
	public void swap(char a, char b) {
		char temp = a;
		a = b;
		b = temp;
	}

	// 一个字符串只包含*和数字，请把它的*号都放开头。 交换法
	public void testThere(String string) {
		char[] ch = string.toCharArray();
		printArrary(ch);
		System.out.println();
		for (int i = 0, j = 0; j < ch.length; j++) {
			if (ch[j] == '*') {
				char temp = ch[i];
				ch[i] = ch[j];
				ch[j] = temp;
				i++;
			}
		}
		printArrary(ch);
	}

	// 一个字符串只包含*和数字，请把它的*号都放开头。 复制法
	public void testFour(String string) {
		char[] ch = string.toCharArray();
		int n = ch.length;
		int j = n - 1;
		printArrary(ch);
		System.out.println();
		for (int i = n - 1; i >= 0; --i) {
			if (ch[i] != '*') {
				ch[j--] = ch[i];
			}
		}
		for (; j >= 0; --j) {
			ch[j] = '*';
		}
		printArrary(ch);
	}

	// 判断两个字符串是否为变位词
	public boolean testFive(String s1, String s2) {
		int[] nums = new int[26];
		char[] s1_char = s1.toCharArray();
		char[] s2_char = s2.toCharArray();
		int s1_length = s1_char.length;
		int s2_length = s2_char.length;
		if (s1_length != s2_length) {
			return false;
		}
		for (int i = 0; i < s1_length; i++) {
			int index = s1_char[i] - 'a';
			nums[index]++;
		}
		for (int i = 0; i < s1_length; i++) {
			int index = s2_char[i] - 'a';
			nums[index]--;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				return false;
		}
		return true;
	}

	// 判断给定两个串a和b，问b是否是a的子串的变位词。
	public boolean testSix(String str1, String str2) {
		boolean b = false;
		char[] ch = str1.toCharArray();
		int lena = str1.length();
		int lenb = str2.length();
		if (lena < lenb) {
			System.out.println("输入参数出错");
			return false;
		}
		for (int i = 0; i + lenb - 1 < lena; i++) {
			String string = new String(ch, i, lenb);
			b = testFive(string, str2);
			if (b) {
				return b;
			}
		}
		return b;
	}

	// 字符串分解 --------split
	public void testSeven(String string) {
		String regex = " ";
		String[] result = string.split(regex);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}

	// 字符串分解 --------SringToKenizer
	public void testEight(String string) {
		StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
		while (stringTokenizer.hasMoreElements()) {
		System.out.print(stringTokenizer.nextElement() + "——");
		}
	}
	//字符串的反转
	public void testNine(String string) {
		StringBuffer result=new StringBuffer();
		char[] ch=string.toCharArray();
		for (int i = ch.length-1; i>=0; i--) {
			result.append(ch[i]);
		}
		string=result.toString();
		System.out.println(string);
	}
	


}
