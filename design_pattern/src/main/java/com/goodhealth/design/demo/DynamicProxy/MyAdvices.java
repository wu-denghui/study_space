/**
 * 
 */
package com.goodhealth.design.demo.DynamicProxy;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description   实现自己业务的通知类
 */
public class MyAdvices implements Advice {

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.DynamicProxy.Advice#exec()
	 */
	@Override
	public void exec() {
		System.out.println("妈妈进来了");

	}

}
