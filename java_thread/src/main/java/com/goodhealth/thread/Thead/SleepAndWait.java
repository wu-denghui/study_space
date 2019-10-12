/**
 * 
 */
package com.goodhealth.thread.Thead;

import java.util.concurrent.TimeUnit;

/**
 * @author 24663
 * @date 2019年2月22日
 * @Description
 */
public class SleepAndWait {

	static Integer i = 0;

	public static void main(String[] args) {
/*		WWait w = new WWait();
		w.start();
		Wnotiy wn = new Wnotiy();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wn.start();*/
		
		WWaitTi  waitTi=new  WWaitTi();
		waitTi.start();
	}

	/**
	 * @author 24663
	 * @date 2019年2月22日
	 * @Description     sleep
	 */
	static class WSleep extends Thread {

		@Override
		public void run() {
			try {
				if (i > 10) {
					System.out.println("超过10");
				} else {
					System.err.println("睡眠");
					sleep(5000);
					System.out.println("醒来");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author 24663
	 * @date 2019年2月22日
	 * @Description   普通的wait
	 */
	static class WWait extends Thread {

		@Override
		public void run() {
			synchronized (i) {
				try {
					if (i > 10) {
						System.out.println("超过10");
					} else {
						System.err.println("睡眠");
					   i.wait();
						System.out.println("醒来");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @author 24663
	 * @date 2019年2月22日
	 * @Description   超时等待的wait  自醒功能
	 */
	static class WWaitTi extends Thread {

		@Override
		public void run() {
			synchronized (i) {
				try {
					long remain=TimeUnit.SECONDS.toMillis(6);
					long  future=System.currentTimeMillis()+remain;
					while(remain>0){
						System.out.println("睡眠");
						i.wait(remain);
						remain=future-System.currentTimeMillis();
					}
					System.out.println("醒来");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static class Wnotiy extends Thread {

		@Override
		public void run() {
			synchronized (i) {
				try {
					if (i > 10) {
						System.out.println("超过10");
					} else {
					   i.notifyAll();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}