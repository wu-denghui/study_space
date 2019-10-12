/**
 * 
 */
package com.goodhealth.thread.ConcurrentToolClass;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 24663
 * @date 2018年12月15日
 * @Description Semaphore 计数信号量 用于控制资源的访问数
 */
public class SemaphoreTest {

	static  Semaphore manager = new Semaphore(2);

	private static String name="使命召唤";

	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 10, 0L, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(1));

		for (int i = 0; i < 10; i++) {
			pool.execute(new WThread());
		}

	}

	static class WThread implements Runnable {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			try {
				manager.acquire();
				System.out.println(name);
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				manager.release();
			}
		}

	}
}
