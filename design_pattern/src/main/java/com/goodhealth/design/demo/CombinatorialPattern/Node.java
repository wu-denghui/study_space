/**
 * 
 */
package com.goodhealth.design.demo.CombinatorialPattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public abstract class Node {
	
	private String  name;
	
	private  String sexy;
	
	private  String  department;
	
	
	public abstract void  introduction();
	

	/**
	 * @param name
	 * @param department
	 */
	public Node(String name, String department) {
		super();
		this.name = name;
		this.department = department;
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

	/**
	 * @return the sexy
	 */
	public String getSexy() {
		return sexy;
	}

	/**
	 * @param sexy the sexy to set
	 */
	public void setSexy(String sexy) {
		this.sexy = sexy;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
		

}
