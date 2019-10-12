/**
 * 
 */
package com.goodhealth.design.demo.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description   动态代理类，在这里切入通知
 */
public class DynamicProxy {
	
	public static <T> T newProxyInstance(ClassLoader loader,Class<?>[] interfaces, InvocationHandler h){
		if (true) {
			(new MyAdvices()).exec();
		}
		return (T)Proxy.newProxyInstance(loader, interfaces, h);
		
	}
}
