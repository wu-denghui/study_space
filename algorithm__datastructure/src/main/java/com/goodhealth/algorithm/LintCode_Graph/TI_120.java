/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Graph;


import java.util.*;

/**
 * @author 24663
 * @date 2018年9月22日
 * @Description   单词接龙   给出两个单词（start和end）和一个字典，找到从start到end的最短转换序列
 * 给出数据如下：
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
一个最短的变换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog"，
返回它的长度 5
 */
public class TI_120 {
	
	public static void main(String[] args) {
		TI_120 ma=new TI_120();
		String[] c={"hot","dot","dog","lot","log"};
		Set<String> dict=new  HashSet<String>();
		for (String string : c) {
			dict.add(string);
		}
//		System.out.println(dict);
//		String  com.goodhealth.design.demo="xvx";
//		System.out.println(com.goodhealth.design.demo.charAt(0)==com.goodhealth.design.demo.charAt(2));
		
		System.out.println(ma.getNextWords("cog", dict));
	}
	
	
	    public int ladderLength(String start, String end, Set<String> dict) {
	        if (dict == null) {
	            return 0;
	        }

	        if (start.equals(end)) {
	            return 1;
	        }
	        
	        dict.add(start);
	        dict.add(end);

	        HashSet<String> hash = new HashSet<String>();
	        Queue<String> queue = new LinkedList<String>();
	        queue.offer(start);
	        hash.add(start);
	        
	        int length = 1;
	        while(!queue.isEmpty()) {
	            length++;
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                String word = queue.poll();
	                for (String nextWord: getNextWords(word, dict)) {
	                    if (hash.contains(nextWord)) {
	                        continue;
	                    }
	                    if (nextWord.equals(end)) {
	                        return length;
	                    }
	                    
	                    hash.add(nextWord);
	                    queue.offer(nextWord);
	                }
	            }
	        }
	        return 0;
	    }

	    private ArrayList<String> getNextWords(String word, Set<String> dict) {
	        ArrayList<String> nextWords = new ArrayList<String>();
	        for (String  str : dict) {
	        	int count=0;
	            for (int i = 0; i < word.length(); i++) {
	                if ( word.charAt(i)==str.charAt(i)) {
	                    continue;
	                }else{
	                	count++;
	                }
	                if (count>1) {
						break;
					}
	            }
	            if (count==1) {
					nextWords.add(str);
				}
	        }
	        return nextWords;
	    }

}
