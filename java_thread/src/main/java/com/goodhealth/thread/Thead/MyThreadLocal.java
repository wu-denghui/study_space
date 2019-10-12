/**
 * 
 */
package com.goodhealth.thread.Thead;

/**
 * @author 24663
 * @date 2018年11月17日
 * @Description
 */
public class MyThreadLocal {

	private  static final  ThreadLocal<String>   classmate=new  ThreadLocal<>();
	
	public  void set(String name){
		classmate.set(name);
	}
	
	
	public  String  get(){
		return classmate.get();
	}
	
	/**
	 * @param args
	 * @Description 
	 */
	public static void main(String[] args) {
		
		Thread t1=new Thread(){
			public void run() {
				Thread t2=new Thread(){
					public void run() {
						classmate.set("李四");
						System.out.println(classmate.get());
					};
				};
				try {
					classmate.set("张三");
					t2.start();
					t2.join();
					System.out.println(classmate.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		};
		t1.start();
	}
	
}

