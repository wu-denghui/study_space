package com.goodhealth.design.demo.Singleton;

/**
 * @author 24663
 * @date 2019年2月24日
 * @Description
 */
public class Test {
	
	public static void main(String[] args) {
		SingletonA  a =SingletonA.getInstance();
		a.setName("快饿了");
		System.out.println(a.getName());
		SingletonA a2=SingletonA.getInstance();  //  a2等于a   是同一个内存地址     只是另一个引用，两个都可以操作那个实例
		System.out.println(a2.getName());
		System.out.println(a.getName());
		System.out.println(a==a2);
	}

}
