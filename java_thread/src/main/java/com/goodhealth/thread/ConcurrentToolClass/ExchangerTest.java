/**
 * 
 */
package com.goodhealth.thread.ConcurrentToolClass;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author 24663
 * @date 2018年11月29日
 * @Description
 */
public class ExchangerTest {
	
	static Exchanger<String> makeSure = new Exchanger<>();
	
	public static void main(String[] args) {
		new Staff("小王","大张伟").start();
		new Staff("小张","李荣浩").start();
	}
			

static class Staff extends Thread{
	private String name;

	private String aidou;

	public Staff(String name, String aidou) {
		super(name);
		this.name = name;
		this.aidou = aidou;
	}
	@Override
	public void run(){
		try {
			System.out.println("交换之前员工"+name+"的偶像是"+aidou);
			//先调用的线程会等待另一个线程调用exchange之后再继续执行下面的代码
			aidou = makeSure.exchange(aidou);
			System.out.println("交换之后员工"+name+"的偶像是"+aidou);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

}