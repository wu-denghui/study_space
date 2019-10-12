/**
 * 
 */
package com.goodhealth.thread.Thead;

import java.util.concurrent.TimeUnit;

/**
 * @author 24663
 * @date 2018年12月14日
 * @Description    InheritableThreadLocal  -----可以在父线程与子线程传递的ThreadLocal
 */
public class InheritableThreadLocal_Test {
	private    volatile   static    InheritableThreadLocal<String>  ihlocal=new  InheritableThreadLocal<>();
	public static void main(String[] args) {
		new   FThread().start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	static  class   FThread extends Thread{
		@Override
		public  void   run(){
			ihlocal.set("王者");
			Thread son=new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(ihlocal.get());
				}
			});
			son.start();
		}
	}

}
