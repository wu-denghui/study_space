/**
 * 
 */
package com.goodhealth.design.demo.AdapterPattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Adapter extends  Usb implements IPs2  {

	/* (non-Javadoc)
	 * @see CommandPattern.AdapterPattern.IPs2#connectByPs2()
	 */
	@Override
	public void connectByPs2() {
		// TODO Auto-generated method stub
		super.connect();
		
	}
	
	

}
