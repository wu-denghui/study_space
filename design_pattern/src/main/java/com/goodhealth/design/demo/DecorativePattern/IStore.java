/**
 * 
 */
package com.goodhealth.design.demo.DecorativePattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public abstract class IStore {
	
	private String  name;
	
	private String   address;
	
	private  String  info;
	
	
	public  abstract  void   sell();


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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}


	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
