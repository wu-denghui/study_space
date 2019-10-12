/**
 * 
 */
package com.goodhealth.design.demo.FactoryMethod;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Factory extends AbstractCarFactory {


	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.FactoryMethod.AbstractCarFactory#createCar(java.lang.Class)    传入的是产品类的.class对象
	 */
	@Override
	public  <T extends Car>  T  createCar(Class<T> c){
		Car product = null;
		try{
			product=(Car)Class.forName(c.getName()).newInstance();  //反射机制
		}catch (Exception e) {
			e.printStackTrace();
		}
		return (T) product;
	}

}
