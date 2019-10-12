/**
 * 
 */
package com.goodhealth.design.demo.FactoryMethod;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public   abstract  class  AbstractCarFactory {
	
	public  abstract  <T extends Car>  T  createCar(Class<T> c);



}
