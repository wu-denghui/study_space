
/**
 * 
 */
package com.goodhealth.thread.MyThreadPool;


/**
 * @author 24663
 * @date 2018年11月18日
 * @Description
 */
public class Server {
	
	public static void main(String[] args) {
		MyThreadPool pool=new  MyThreadPool();
		for (int i = 0; i < 100; i++) {
			Task task=new  Task();
			pool.execute(task);
		}
	}

}
