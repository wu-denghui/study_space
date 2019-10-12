/**
 * 
 */
package com.goodhealth.thread.ConcurrentToolClass;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 24663
 * @date 2018年12月15日
 * @Description  CountDownLatch  倒计时门禁 可用于控制线程执行顺序
 * 使得某个线程等待其他线程(可以是多个)完成之后再执行自己  类似于join()
 */
public class CountDownLatchTest {
	
	  static  final int  M=5;
	  static  CountDownLatch startLatch = new CountDownLatch(1);
	  static  CountDownLatch endLatch = new CountDownLatch(M);
	  
	  public static void main(String[] args) {
		  System.out.println("开始做准备工作");
		  new  Thread(new PerpareThread()).start();
		  try {
			startLatch.await();//等待PerpareThread先完成在执行main线程
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		  ExecutorService   threadPool=Executors.newFixedThreadPool(M);
		  for (int i = 0; i < M; i++) {
			threadPool.execute(new WorkerThread());
		}
		try {
			endLatch.await();//等所有的WorkerThread完成后在执行main线程
			System.out.println("等到所有的工作完成之后退出");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	  static class WorkerThread implements Runnable{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"开始正式工作");
			//.......................
			endLatch.countDown();//  工作完成countdown 计数减一
			System.out.println(Thread.currentThread().getName()+"工作完成");
		}
		  
	  }
	  
	  
	static  class  PerpareThread implements Runnable{
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				//......................
				startLatch.countDown();   //工作完成countdown 计数减一
				System.out.println("准备工作做好了");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
