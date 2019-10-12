/**
 * 
 */
package com.goodhealth.design.demo.DynamicProxy;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Client {

	public static void main(String[] args) {
		Kid  mh=new Kid();
		//被代理对象类的借口可以成为mh的代理对象
		Person mama=MyDynamicProxy.newProxyInstance(mh);
		//执行方法时，执行路线如下：MyDynamicProxy类中的newProxyInstance
		mama.PackBag();

	}

}

