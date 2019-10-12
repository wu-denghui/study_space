/**
 * 
 */
package com.goodhealth.design.demo.AbstractFactoryMethod;

/**
 * @author 24663
 * @date 2019年2月24日
 * @Description
 */
public class BenZ implements Car {

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.FactoryMethod.Car#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("90迈的奔驰");

	}

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.FactoryMethod.Car#staop()
	 */
	@Override
	public void singing() {
		// TODO Auto-generated method stub
		System.out.println("滴滴");

	}

}