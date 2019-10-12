/**
 * 
 */
package com.goodhealth.design.demo.AdapterPattern;

/**
 * @author 24663
 * @date 2019年2月24日
 * @Description
 */
public class MyIPs2 implements IPs2 {

	/* (non-Javadoc)
	 * @see CommandPattern.AdapterPattern.IPs2#connectByPs2()
	 */
	@Override
	public void connectByPs2() {
		System.out.println("使用ps2连接");

	}

}
