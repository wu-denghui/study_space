/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author 24663
 * @date 2018年8月11日
 * @Description 关于数组的编程练习题
 */
public class ArraryExercise {

	public static void main(String[] args) {
		ArraryExercise arraryExercise = new ArraryExercise();
		int[] an = { 5, 4, 3, 2, 2, 1, 6, 6, 6, 6 };
		System.out.println(arraryExercise.getUnityone(an, an.length));
		System.out.println(arraryExercise.getUnity(an, an.length));
	}
	/**
	 * @param ch
	 * @return
	 * @Description   char[] 转化为String
	 */
	public String change(char[] ch){
		String str=new String(ch);
//	String str=String.valueOf(ch);
		return  str;
	}
	/**
	 * @param str
	 * @return
	 * @Description    String 转化为char[]
	 */
	public char[] change(String str){
//		char[] ch=str.toCharArray();
		    char[] ch=new char[str.length()];
		    for (int i = 0; i < ch.length; i++) {
				ch[i]=str.charAt(i);
			}
		return ch;
		
	}
	/**
	 * @param str
	 * @return
	 * @Description  String[] 转化为String
	 */
	public String change(String[] str){
//		String result=Arrays.toString(str);    输出结果带有[     ]
            StringBuffer buffer=new StringBuffer();		
		    for (int i = 0; i < str.length; i++) {
				buffer.append(str[i]);
			}
		    String result=new String(buffer);//结果为无间隔字符串
		     return result;
	
	}
	
	
	// 将map排序取得数组中的众数
	public int getUnityone(int[] an, int a) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < an.length; i++) {
			if (map.containsKey(an[i])) {
				map.put(an[i], map.get(an[i]) + 1);
			} else {
				map.put(an[i], 1);
			}
		}
		// 将map<Integer,Integer> 转化为ArryList,但list里面的元素为Entry<Integer,Integer>
				List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
				Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
					@Override
					public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
						int flag = o1.getValue().compareTo(o2.getValue());
						if (flag == 0) {
							return o1.getKey().compareTo(o2.getKey());
						}
						return flag;
					}
				});

				return list.get(list.size() - 1).getKey();

		}
	// 循环遍历map取得数组中的众数
	public int getUnity(int[] an, int a) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < an.length; i++) {
			if (map.containsKey(an[i])) {
				map.put(an[i], map.get(an[i]) + 1);
			} else {
				map.put(an[i], 1);
			}
		}
		 Iterator<Integer> iterator=map.values().iterator();
		 int count=0;
		 while (iterator.hasNext()) {
		 Integer integer = (Integer) iterator.next();
		 if (integer>count) {
		 count=integer;
		 }
		 }
		 Integer result=getKey(map, count);
		 return  result;
	}
	// 根据map的value获取map的key
	public  int getKey(Map<Integer, Integer> map, Integer value) {
		int key = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				key = entry.getKey();
			}
		}
		return key;
	}

}
