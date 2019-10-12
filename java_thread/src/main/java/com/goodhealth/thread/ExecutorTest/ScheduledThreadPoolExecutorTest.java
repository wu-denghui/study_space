/**
 * 
 */
package com.goodhealth.thread.ExecutorTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 24663
 * @date 2018年12月9日
 * @Description
 */
public class ScheduledThreadPoolExecutorTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledThreadPoolExecutor pool=new ScheduledThreadPoolExecutor(5);
		
		/*十秒后执行线程*/
		pool.schedule(new MyTask(), 10, TimeUnit.SECONDS);
		
		
/*        5秒后执行一次，然后每隔10秒时长，再次执行任务。
		注意，10秒是从任务开始执行算起的。开始执行任务后，
		定时器每隔period时长检查该任务是否完成，如果完成则再次启动任务，
		否则等该任务结束后才再次启动任务*/
		pool.scheduleAtFixedRate(new  MyTask(), 5, 10, TimeUnit.SECONDS);
		
/*		该方法在5秒后第一次执行任务，以后每当任务执行完成后，
		等待10秒时长，再次执行任务*/
		pool.scheduleWithFixedDelay(new  MyTask(), 5, 10, TimeUnit.SECONDS);
                        
        System.out.println( pool.schedule(new MyT(), 2, TimeUnit.SECONDS).get());
		
		
		
		
		
	}

	
	
     static  class  MyT implements Callable<String>{

		/* (non-Javadoc)
		 * @see java.util.concurrent.Callable#call()
		 */
		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			return "史塔克";
		}
    	 
     }
	static  class MyTask  implements  Runnable{

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			System.out.println("现在是北京时间："+ new SimpleDateFormat("hh-mm-ss").format(new Date()));
		}
		
	}
}
