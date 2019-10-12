/**
 * 
 */
package com.goodhealth.design.demo.Singleton;

/**
 * @author 24663
 * @date 2018年10月19日
 * @Description     枚举式单例
 */
public enum SingletonD {
	//访问方式：SingletonD.instance.method();
	
	instance;
	
	private   SingletonD(){
		
	}
	public void method(){
		
	}

}
