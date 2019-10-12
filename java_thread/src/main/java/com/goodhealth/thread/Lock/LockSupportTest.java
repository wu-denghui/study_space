/**
 * 
 */
package com.goodhealth.thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;


/**
 * @author 24663
 * @date 2018年11月21日
 * @Description  
 * LockSupport是可不重入 的，如果一个线程连续2次调用 LockSupport .park()，那么该线程一定会一直阻塞下去。
 * 线程如果因为调用park而阻塞的话，能够响应中断请求(中断状态被设置成true)，但是不会抛出InterruptedException 。
 */
public class LockSupportTest {
	public static void main(String[] args) {
		XG xg=new XG();
		System.out.println("小刚向阿灿发起语音通话");
		xg.start();
		AC ac=new AC(xg);
		ac.start();
	}
	
	

}

class  XG extends Thread{
	@Override
	public  void run(){
		System.out.println("发起语音电话");
		LockSupport.park();
		System.out.println("语音电话连接成功");
	}
}

class  AC extends  Thread{
	public   Thread  thread;
	

	public  AC(Thread thread){
		this.thread=thread;
	}
	@Override
	public  void  run(){
		try {
			System.out.println("正在呼叫.......");
			TimeUnit.SECONDS.sleep(10);
			LockSupport.unpark(thread); //unpark,唤醒park的线程，调用时需要指定线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}