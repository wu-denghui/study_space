/**
 * 
 */
package com.goodhealth.design.demo.DecorativePattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class HatDecorator extends Decorator {

	/**
	 * @param store
	 */
	public HatDecorator(IStore store) {
		super(store);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see CommandPattern.DecorativePattern.Decorator#exe()
	 * 在这里实现一个新的功能-卖帽子
	 */
	@Override
	public void exe() {
		// TODO Auto-generated method stub
		System.out.println("店里卖帽子");

	}

}
