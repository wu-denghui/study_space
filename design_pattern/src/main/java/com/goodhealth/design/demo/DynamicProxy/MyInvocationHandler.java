/**
 * 
 */
package com.goodhealth.design.demo.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * @author 24663
 * @date 2018年10月21日
 * @Description   动态代理的Handler，在这里实现对方法的映射
 */
public class MyInvocationHandler implements InvocationHandler{
	
	private  Object  target=null;

	/**
	 * @param target
	 */
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(this.target, args);
	}


}
