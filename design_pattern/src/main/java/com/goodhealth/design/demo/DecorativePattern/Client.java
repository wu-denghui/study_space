/**
 * 
 */
package com.goodhealth.design.demo.DecorativePattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Client {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IStore  myStore=new MyStore();
		myStore.sell();
		System.out.println("------------------使用装饰类ShoseDecorator");
		myStore=new ShoseDecorator(myStore);
		myStore.sell();
		System.out.println("------------------又使用装饰类HatDecorator");
		myStore=new HatDecorator(myStore);
		myStore.sell();

	}

}
