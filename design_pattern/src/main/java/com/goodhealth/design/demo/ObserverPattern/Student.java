/**
 * 
 */
package com.goodhealth.design.demo.ObserverPattern;

import java.util.Observable;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Student extends Observable {
	
	private  String  name;
	
	
	/**
	 * @param name
	 */
	public Student(String name) {
		super();
		this.name = name;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	public  void  say(){
		System.out.println(this.name+"和同桌偷偷聊天");
		super.setChanged();
		super.notifyObservers();
	}

}
