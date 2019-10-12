/**
 * 
 */
package com.goodhealth.design.demo.CombinatorialPattern;

import java.util.LinkedList;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Composite extends Node {
	
	
	private  LinkedList<Node>  nodes=new LinkedList<Node>();
	
	
	public  void add(Node node){
		nodes.add(node);
	}
	public  void remove(Node node){
		nodes.remove(node);
	}

	public LinkedList<Node>  getSubordinates(){
		return  this.nodes;
	}
	/**
	 * @param name
	 * @param department
	 */
	public Composite(String name, String department) {
		super(name, department);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see CommandPattern.CombinatorialPattern.Node#introduction()
	 */
	@Override
	public void introduction() {
		// TODO Auto-generated method stub
		System.out.println("我是"+getDepartment()+"的"+getName()+"经理");

	}

}
