/**
 * 
 */
package com.goodhealth.design.demo.ObserverPattern;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Tearcher implements Observer {
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("学生"+((Student)o).getName()+"不要在讲话啦");

	}

}
