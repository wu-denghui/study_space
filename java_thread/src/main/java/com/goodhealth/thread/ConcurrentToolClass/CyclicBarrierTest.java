/**
 * 
 */
package com.goodhealth.thread.ConcurrentToolClass;

import java.util.concurrent.CyclicBarrier;

/**
 * @author 24663
 * @date 2018年12月15日
 * @Description     CyclicBarrier一个同步屏障，线程到达同步点时阻塞，只有所有的线程都到达同步点时
 * ，之前阻塞的线程才会继续执行
 */
public class CyclicBarrierTest {

	static final int M = 5;
	/**
	 * @Fields      屏障撤销前先执行构造方法中的线程再撤销屏障
	 */
	static CyclicBarrier cBarrier = new CyclicBarrier(M,new Runnable() {
		@Override
		public void run() {
			System.out.println("所有选手就绪");
		}
	});

	public static void main(String[] args) {
		System.out.println("比赛准备开始");
		for (int i = 0; i < M; i++) {
			new  Thread(new  Worker(i)).start();
		}
	}

	static class Worker implements Runnable {
		int index;
		/**
		 * @param index
		 */
		public Worker(int index) {
			super();
			this.index = index;
		}
		@Override
		public void run() {
			System.out.println(index+1 + "号选手就位");
			try {
				cBarrier.await();  //到达屏障  等待所有线程就位
//				Thread.sleep(3000);
//				System.out.println(index+1 + "号选手出发");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
		

}
