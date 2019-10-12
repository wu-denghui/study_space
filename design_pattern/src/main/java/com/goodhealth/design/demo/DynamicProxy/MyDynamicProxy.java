/**
 * 
 */
package com.goodhealth.design.demo.DynamicProxy;

import java.lang.reflect.InvocationHandler;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description   包含了业务逻辑的动态代理类
 */
public class MyDynamicProxy extends DynamicProxy {
	
	public  static <T> T newProxyInstance(Object object){
		//获得ClassLoader
		ClassLoader  loader=object.getClass().getClassLoader();
		//获得接口数组
		Class<?>[] classes =object.getClass().getInterfaces();
		//获得Handler
		InvocationHandler h=new MyInvocationHandler(object);
		
		return newProxyInstance(loader,classes,h);
		
	}

}
