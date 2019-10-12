/**
 * 
 */
package com.goodhealth.design.demo.Proxy;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Teacher implements Person {

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.Proxy.Person#receiveHomework()
	 */
	@Override
	public void receiveHomework() {
		System.out.println("老师开始收作业啦");

	}

}
