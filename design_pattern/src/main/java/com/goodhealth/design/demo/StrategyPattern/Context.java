package com.goodhealth.design.demo.StrategyPattern;

/**
 * 环境角色
 */
public class Context {

	/**
	 *  内部拥有策略的引用
	 */
	private IStrategy  strategy;
	
	
	public Context(IStrategy  str){
		this.strategy=str;
	}

	public  void action(){
		this.strategy.doSomething();
	}

	public IStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}

}
