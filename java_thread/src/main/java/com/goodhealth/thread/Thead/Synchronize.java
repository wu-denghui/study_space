/**
 * 
 */
package com.goodhealth.thread.Thead;

/**
 * @author 24663
 * @date 2018年11月20日
 * @Description
 */
public class Synchronize {
	Object obj;	
	static int a =10;
	static int b=5;
	int  x=0;
	
	public  void   syI(){
		synchronized (obj) {
			
		}
	}

	/**
	 * 
	 * @Description 多线程不安全的原因之数据竞争（多个线程同时访问一块内存区域，且存在写的操作。
	 * 由于无法确定他们的访问顺序，可能造成不同结果
	 */
	public  static void Test() {
		b=5;
		System.out.println(b+"=b");
		b=10;
	}


	
	/**
	 * @return
	 * @Description 多线程不安全原因之竞态条件（计算的正确性取决于相对时间或调度器所控制的多线程分叉）
	 */
	public  static  int   getA(){
		return  a++;
	}
	
	
	public static void main(String[] args) {
		final Synchronize  sy=new  Synchronize();
		for (int i = 0; i <100; i++) {
			new  Thread(new  Runnable() {
				
				@Override
				public void run() {
					synchronized (sy) {
						Synchronize.Test();
					}
				}
			}).start();

		}
	}

}
