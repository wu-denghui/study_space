/**
 * 
 */
package com.goodhealth.thread.MyThreadPool;


/**
 * @author 24663
 * @date 2018年11月29日
 * @Description    一个线程队列，里面有一定数量的任务执行者(线程），当线程池中有任务时，
 * 里面的执行者会自动执行任务。这里的任务是固定的。若想执行其他任务，需创建另一个单独的线程池。
 * 
 */
public interface ThreadPool<T> {
	
	/**
	 * @param task
	 * @Description   线程池中加入一个任务
	 */
	public  void  execute(T  t);
	
	/**
	 * 
	 * @Description  阻止所有的执行者执行任务 但是线程不会消亡
	 */
	public  void  shutDown();
	
	/**
	 * @param num
	 * @Description  增加执行者的数量
	 */
	public  void  addWorker(int num);
	
	/**
	 * @param num
	 * @Description  减少执行者的数量
	 */
	public void  removeWorker(int  num);
	
	/**
	 * @return
	 * @Description 获得当前线程池中的执行者的数量
	 */
	public  int  getWorkerNum();
	
	
	/**
	 * @return
	 * @Description 获得当前线程池中待执行的任务数
	 */
	public  int  getTaskNum();

}
