/**
 * 
 */
package com.goodhealth.thread.ThreadCommunication;

import java.util.concurrent.TimeUnit;

/**
 * @author 24663
 * @date 2018年11月18日
 * @Description  超时等待  
 */
public class WaitAndNotify {

	public  static volatile  boolean connect = false;
	private  static final long WAIT_TIME = 10000;
	static  Object obj=new Object();

	public static void main(String[] args){

		Caller tc = new Caller();
		tc.setName("打电话的小刚");
		tc.start();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
/*		synchronized(obj){
			System.out.println(1333);
		}*/
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Receive1 tr=new Receive1();
		tr.setName("接电话的阿灿");
		tr.start();

	}

	static class Caller extends Thread {
		public Caller() {

		}
		@Override
		public void run() {
			synchronized (obj) {
				long future = System.currentTimeMillis() + WAIT_TIME;
				long remain = WAIT_TIME;
				try {
					System.out.println("小刚拨打电话");
					while (!connect && remain > 0) {
						obj.wait(remain);
						remain = future - System.currentTimeMillis();
					}
					if (remain <= 0) {
						System.out.println("未接通电话");
					} else {
						System.out.println("电话接通了");
					}
				} catch (Exception e) {
				}
			}
		}
	}

	static class Receive1 extends Thread {

		public void change() {
			WaitAndNotify.connect = true;
		}

		@Override
		public void run() {
			synchronized (obj) {
				System.out.println("阿灿手机开机");
				this.change();
			    obj.notifyAll();
			}
		}
	}

}