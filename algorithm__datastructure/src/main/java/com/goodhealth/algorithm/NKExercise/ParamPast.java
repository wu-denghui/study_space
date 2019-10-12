package com.goodhealth.algorithm.NKExercise;

import java.util.LinkedList;
/*1、对于基本类型参数，在方法体内对参数进行重新赋值，并不会改变原有变量的值。

2、对于引用类型参数，在方法体内对参数进行重新赋予引用，并不会改变原有变量所持有的引用。 

3、方法体内对参数进行运算，不影响原有变量的值。 

4、方法体内对参数所指向对象的属性进行操作，将改变原有变量所指向对象的属性值。

也就是说，对于基本数据类型，实现的是传值，只是个形参，不会改变原有值。对于引用数据类型，对这个引用进行操作，其实也是相当于对形参的操作，不会改变原来的引用。
但是，当对这个引用(数组，实体类的对象）的属性进行操作的时候，相当于CPP中的传址调用，可以改变这个引用的属性的值。
*/

public class ParamPast {
	
//	static int i=9;
//	static String str="yes";
	
	public void change(LinkedList<Integer>  list,LinkedList<String>  list2){
		
	}
	public static void main(String[] args) {
		  int[] an={1,2,3};
		  user s=new user(18);
		LinkedList<Integer>  list=new LinkedList<>();
		LinkedList<String>  list2=new LinkedList<>();
		list.add(2);
		list2.add("no");
		System.out.println(list.get(0));
		System.out.println(list2.get(0));
		ParamPast paramPast=new ParamPast();
		paramPast.change(list,list2);
         System.out.println(s.id);

	}

}


class user{
	int id;
	
	public user(int id) {
		super();
		this.id = id;
	}

	int getId() {
		return id;
	}
	
	void setId(int id) {
		this.id = id;
	}
}