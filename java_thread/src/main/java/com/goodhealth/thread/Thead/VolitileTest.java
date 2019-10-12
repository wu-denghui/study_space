/**
 * 
 */
package com.goodhealth.thread.Thead;


/**
 * @author 24663
 * @date 2018年12月11日
 * @Description
 */
public class VolitileTest {
	
	  boolean  isMan=false;

	
	public static void main(String[] args) {
/*		VolitileTest vTest=new  VolitileTest();
		for (int i = 0; i < 50; i++) {
			new  Thread(new  TestThread(vTest)).start();
		}
		new  Thread(new  StopThread(vTest)).start();*/
		
      MyThread t1=	new  MyThread();
		t1.start();
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		t1.makeStop();
	}
	
	static  class TestThread implements  Runnable{
		
		
		VolitileTest  vTest=new  VolitileTest();
		
		
		public TestThread(VolitileTest vTest) {
			this.vTest=vTest;
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			while(!vTest.isMan){
				System.out.println(Thread.currentThread().getName()+"女人");
			}
			System.out.println(Thread.currentThread().getName()+"男人");
		}
		
	}
	
	
	static  class StopThread implements  Runnable{
		VolitileTest  vTest=new  VolitileTest();
		
		public StopThread(VolitileTest vTest) {
			this.vTest=vTest;
		}
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {

			vTest.isMan=true;
		}
		
	}
	static class  MyThread extends  Thread{
		
		private    volatile  boolean  isStop=false;
		

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			while (!isStop) {
				System.out.println(Thread.currentThread().getName()+"is  Running");
			}
		}
		
		public  void  makeStop(){
			this.isStop=true;
		}
		
	}

}
