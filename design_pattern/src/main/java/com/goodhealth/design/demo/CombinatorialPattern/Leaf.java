/**
 * 
 */
package com.goodhealth.design.demo.CombinatorialPattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Leaf extends Node {

	/**
	 * @param name
	 * @param department
	 */
	public Leaf(String name, String department) {
		super(name, department);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see CommandPattern.CombinatorialPattern.Node#introduction()
	 */
	@Override
	public void introduction() {
		// TODO Auto-generated method stub
		System.out.println("我是"+getDepartment()+"的"+getName());

	}

}
