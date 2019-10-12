/**
 * 
 */
package com.goodhealth.design.demo.ObserverPattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Client {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student  yue=new Student("马云");
		Tearcher li=new  Tearcher();
		yue.addObserver(li);
		yue.say();

	}

}
