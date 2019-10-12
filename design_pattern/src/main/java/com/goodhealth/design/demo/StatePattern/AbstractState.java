/**
 * 
 */
package com.goodhealth.design.demo.StatePattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public abstract class AbstractState implements State {

	protected  Context context;

	public  void  setContext(Context context){
		this.context=context;
	}

}
