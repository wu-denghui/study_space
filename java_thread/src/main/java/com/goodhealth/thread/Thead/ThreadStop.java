/**
 * 
 */
package com.goodhealth.thread.Thead;

import java.util.concurrent.TimeUnit;

/**
 * @author 24663
 * @date 2018年11月15日
 * @Description
 */

public class ThreadStop {
	
	public static void main(String[] args) throws InterruptedException {
		
		Count  demo=new  Count();	
		demo.start();
		TimeUnit.SECONDS.sleep(1);
		demo.cancel();
		
	}

}


class   Count  extends  Thread{
	
	//决定线程是否执行
	private  volatile  boolean  on=true;
	
	private int result;
	
	@Override
	public  void  run(){
		//通过对on的判断决定是否结束线程的工作
		while(on&&!Thread.currentThread().isInterrupted()){
			for (int i = 0; i < 10; i++) {
				result++;
				System.out.println(result);
			}
		}
		System.out.println("运行完这句话，线程就结束了");
	}
	
	public  void  cancel(){
		
		this.on=false;
	}
	
}