/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;
/**
 * @author 24663
 * @date 2018年9月4日
 * @Description
927. 翻转字符串II
给定输入的字符数组，逐词翻转数组。单词被定义为不包含空格的字符串.
输入字符数组不包含前导或尾部空格，单词总是用单个空格分隔。
样例
给定 s = "the sky is blue",
翻转之后 : "blue is sky the"
挑战
你能在不分配额外空间的情况下原地解决这个问题吗？
 */
public class TI_924 {
	private void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i]=str[j];
            str[j]=temp;
        }
    }
    public char[] reverseWords(char[] str) {
    	int pre=0;
    	int next=0;
    	for (int i = 0; i < str.length; i++) {
			if (str[i]==' '&&pre==0&&next==0) {
				pre=i;
				reverse(str, 0, pre-1);
			}
			if (str[i]==' '&&pre!=0&&next==0) {
				next=i;
				reverse(str, pre+1,next-1);
			}
			if (str[i]==' '&&pre!=0&&next!=0) {
				pre=next;
				next=i;
				reverse(str, pre+1,next-1);
			}
		}
    	reverse(str, next+1, str.length-1);
    	reverse(str,0,str.length-1);
		return str;
    }
}
