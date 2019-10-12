/**
 * 
 */
package com.goodhealth.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 24663
 * @date 2018年12月1日
 * @Description   三步倒转法       helloworld     olleh  dlrow       world  hello
 */
public class ThereStepReverse {
	public static void main(String[] args) {
		ThereStepReverse reverString=new ThereStepReverse();
		BufferedReader  reader=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		try {
			str = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		char[] an=str.toCharArray();
		reverString.therestepreverse(an,an.length,4);
		System.out.println(new String(an));


	}
	public   void    therestepreverse(char[]  an,int length,int index){
		reverse(an, 0, index);
		reverse(an, index+1, length-1);
		reverse(an, 0, length-1);
	}
	
	public   void  reverse(char[] an,int  left,int  right){
		while (left<right) {
			char  temp=an[left];
			an[left]=an[right];
			an[right]=temp;
			left++;
			right--;
		}
	}

}
