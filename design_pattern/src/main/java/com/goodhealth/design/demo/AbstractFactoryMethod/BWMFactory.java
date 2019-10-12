/**
 * 
 */
package com.goodhealth.design.demo.AbstractFactoryMethod;

import com.goodhealth.design.demo.FactoryMethod.Car;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class BWMFactory extends AbstractFactory{

	/* (non-Javadoc)
	 * @see CommandPattern.AbstractFactoryMethod.AbstractFactory#createSUV()
	 */
	@Override
	public Car createSUV() {
		// TODO Auto-generated method stub
		return new BWMSuv();
	}

	/* (non-Javadoc)
	 * @see CommandPattern.AbstractFactoryMethod.AbstractFactory#cteateMVP()
	 */
	@Override
	public Car cteateMVP() {
		// TODO Auto-generated method stub
		return new BWMMvp();
	}

}
