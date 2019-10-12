/**
 * 
 */
package com.goodhealth.thread.ExecutorTest;

import javafx.concurrent.ScheduledService;

import javax.swing.plaf.basic.BasicIconFactory;
import java.util.concurrent.*;

/**
 * @author 24663
 * @date 2018年12月8日
 * @Description
 */
public class ExecutorTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(100);
		ExecutorService truePool = new ThreadPoolExecutor(5,200,0L,
				TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1024),new ThreadPoolExecutor.AbortPolicy());
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
		for (int i = 0; i < 1000; i++) {
			pool.execute(new Task());
		}

//		for (int i = 0; i < 1000; i++) {
//			Future<String>  future=pool.submit(new  Tad());
//			System.out.println(future.get());
//		}
	}

	
	
	static  class Tad implements Callable<String> {
		static int i = 0;
		/* (non-Javadoc)
		 * @see java.util.concurrent.Callable#call()
		 */
		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			return  Thread.currentThread().getName() + "  " + ++i;
		}
		
	}
	static class Task implements Runnable {
		static int i = 0;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			synchronized (Task.class) {
				System.out.println(Thread.currentThread().getName() + "  " + ++i);
			}
		}

	}
}
