/**
 * 
 */
package com.goodhealth.design.demo.FactoryMethod;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Car_4S {

	public static void main(String[] args) {
		Factory factory=new Factory();
		Car  baoma=factory.createCar(BWM.class);
		baoma.run();
		baoma.singing();
		Car benz=factory.createCar(Benz.class);
		benz.run();
		benz.singing();
	}

}
