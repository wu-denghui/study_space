/**
 * 
 */
package com.goodhealth.algorithm.LintCode_String;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author 24663
 * @date 2018年9月21日
 * @Description
给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
返回s所有可能的回文串分割方案。
您在真实的面试中是否遇到过这个题？  是
题目纠错
样例
给出 s = "aab"，返回
[
  ["aa", "b"],
  ["a", "a", "b"]
]
 */
public class TI_136 {
	public static void main(String[] args) {
		Hashtable<Integer, Integer> hashtable=new Hashtable<>();
		TI_136 ma=new TI_136();
		System.out.println(ma.partition("aab"));
	}
    public List<List<String>> partition(String s) {
    	ArrayList< String> list=new ArrayList<>();
    	List<List<String>> result=new  ArrayList<List<String>>();
    	getList(result,list,s,0,0,s.length());
		return result;
    }

	private void getList(List<List<String>> result, ArrayList< String> list,String s ,int start,int index,int length) {
		if (index==length) {
			result.add(new ArrayList<>(list));
			return ;
		}
		String str;
		for (int i = start+1; i <= s.length(); i++) {
			    str=s.substring(start, i);
//			    System.out.println(str);
			    if (isPar(str)) {
					list.add(str);
//					System.out.println(s.substring(i,s.length()));
//					System.out.println(i-start+index);
//					System.out.println(list);
//					System.out.println("--------------------------");
					getList(result, list, s.substring(i,s.length()), 0,i-start+index, length);
					list.remove(list.size()-1);
				}
		}
	}


	private boolean isPar(String str) {
		int left=0;
		int right=str.length()-1;
		while (left<right) {
			if (str.charAt(left)==str.charAt(right)) {
				left++;
				right--;
			}else{
				return false;
			}
		}
		return true;
	}

}
