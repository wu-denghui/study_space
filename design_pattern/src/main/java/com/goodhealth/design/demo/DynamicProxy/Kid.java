package com.goodhealth.design.demo.DynamicProxy;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description  被代理的类
 */
public class Kid implements Person {

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.DynamicProxy.Person#wakeUp()
	 */
	@Override
	public void wakeUp() {
		System.out.println("孩子起床了");
		
	}

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.DynamicProxy.Person#PackBag()
	 */
	@Override
	public void PackBag() {
		System.out.println("整理书包");
		
	}

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.DynamicProxy.Person#GoToSchool()
	 */
	@Override
	public void GoToSchool() {
		System.out.println("孩子上学了");
		
	}



}
