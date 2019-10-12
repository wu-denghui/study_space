/**
 * 
 */
package com.goodhealth.thread.Thead;

import java.util.concurrent.*;

/**
 * @author 24663
 * @date 2018年11月11日
 * @Description  线程的三种创建方法
 */
public class CreateThread {
	
	public static void main(String[] args) throws  InterruptedException {
		MyThread t1=new MyThread();
		ThreadRun threadR=new ThreadRun();
		Thread t2=new  Thread(threadR);
		Thread t3=new Thread(new Runnable(){
			
			@Override
			public void run() {
				System.out.println("线程（通过内部匿名类）正在执行");
				
			}
		});
		ExecutorService pool = null;
		try {
			 pool= Executors.newFixedThreadPool(2);
			System.out.println(pool.submit(new ThreadRun()).get());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally {
			pool.shutdown();
		}

		//isAlive() 返回boolean型，表示线程是否存活，即是否调用了start
		System.out.println(t1.isAlive());
		//getState()返回线程的执行状态
		System.out.println(t1.getState());
		//set/getPriority() 设置/返回线程的优先级 一般不使用容易出错
		System.out.println(t1.getPriority());
		t1.setPriority(7);
		t2.setPriority(8);
		t3.setPriority(9);
		t1.start();
		t2.start();
		t3.start();
		System.out.println(t1.getPriority());
		System.out.println(t1.isAlive());
		System.out.println(t1.getState());
		
		
/*    输出结果不一定如下		
 *     线程（通过继承Thread类）正在执行
		线程（通过实现Runnable接口）正在执行
		线程（通过内部匿名类）正在执行
		因为线程调用start后，并不是马上开始执行run方法，所以三个线程得到cpu的时间顺序是不一定的
		*/
		
	}
	
	

}


class  MyThread extends Thread{
	
	@Override
	public void  run(){
		System.out.println("线程（通过继承Thread类）正在执行");
	}
	
}

class ThreadRun implements Runnable{
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("线程（通过实现Runnable接口）正在执行");
		
	}
}

class ThreadCall implements Callable{

	@Override
	public String call() throws Exception {
		return "线程（通过实现Callable）正在执行" + Math.random() * 10 + 1+"";
	}
}