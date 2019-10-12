/**
 * 
 */
package com.goodhealth.design.demo.Proxy;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Client {

	public static void main(String[] args) {
		Teacher p=new Teacher();
		Monitor m=new Monitor(p);
		m.receiveHomework();

	}

}
