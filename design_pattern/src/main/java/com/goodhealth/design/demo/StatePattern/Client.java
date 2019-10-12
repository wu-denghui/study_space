package com.goodhealth.design.demo.StatePattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description   状态模式
 * 状态模式，又称状态对象模式（Pattern of Objects for States），
 * 状态模式是对象的行为模式。
 * 状态模式允许一个对象在其内部状态改变的时候改变其行为。
 * 这个对象看上去就像是改变了它的类一样。
 */
public class Client {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Context  context=new Context();
		context.setCurrentState(context.stopandclose);
		context.run();
		context.run();
		context.open();
		context.stop();
		context.run();

	}

}
