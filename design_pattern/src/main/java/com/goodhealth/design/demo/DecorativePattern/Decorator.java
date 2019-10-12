/**
 * 
 */
package com.goodhealth.design.demo.DecorativePattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description 抽象装饰类
 */
public  abstract class Decorator extends IStore {
	
	private  IStore  store;
	

	/**
	 * @param store
	 */
	public Decorator(IStore store) {
		super();
		this.store = store;
	}
   //在这个方法中定义新功能
	public  abstract void      exe();

	/* (non-Javadoc)
	 * @see CommandPattern.DecorativePattern.IStore#selll()
	 */
	@Override
	public void sell() {
		// TODO Auto-generated method stub
		this.exe();
		this.store.sell();

	}

}
