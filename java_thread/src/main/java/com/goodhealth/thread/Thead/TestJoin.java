/**
 * 
 */
package com.goodhealth.thread.Thead;

/**
 * @author 24663
 * @date 2018年11月11日
 * @Description   t.join  正在执行的线程中断工作转去执行线程t，等线程t的结束后再回来执行t.join后的代码
 */
public class TestJoin {
	public static void main(String[] args) {
		Object oo = new Object();
		MyThread12 t1 = new MyThread12("线程t1--", oo);
		t1.start();
		try {
			for(int i = 0; i < 1000; i++){
				if (i==50){
					t1.join();
				}
				System.out.println("com/goodhealth/thread/main" + i);
			}
//			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}


	class MyThread12 extends Thread{
		private String name;
		private Object oo;
		public MyThread12(String name, Object oo){
			this.name = name;
			this.oo = oo;
		}
		@Override
		public void run() {
			synchronized (oo) {
				for(int i = 0; i < 1000; i++){
					System.out.println(name + i);
				}
			}
		}
	}


/*	public static void main(String[] args) {
//		System.out.println("主线程开始执行");
//		MyThread12  t1=new MyThread12();
//		ThreadRun  threadR=new ThreadRun();
//		Thread t2=new  Thread(threadR);
//		t1.start();
//		t2.start();
//		System.out.println("主线程结束");

//		主线程开始执行
//		主线程结束
//		线程（通过继承Thread类）正在执行
//		线程（通过实现Runnable接口）正在执行



		System.out.println("主线程开始执行");
		MyThread12  t1=new MyThread12();
		ThreadRun threadR=new ThreadRun();
		Thread t2=new  Thread(threadR);
		try {
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主线程结束");
	}*/



	
