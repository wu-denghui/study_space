/**
 * 
 */
package com.goodhealth.thread.MyThreadPool;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 24663
 * @date 2018年11月18日
 * @Description
 */
public class MyThreadPool implements ThreadPool<Task> {

	

	/**
	 * @Fields  最大执行者的数量
	 */
	static final int MAX_WORKER_NUMBER = 10;

	/**
	 * @Fields 创建线程池时默认的执行者的数量
	 */
	static final int DEFAULT_WORKER_NUMBER = 5;

	/**
	 * @Fields  最小执行者的数量
	 */
	static final int MIN_WORKER_NUMBER = 1;

	// 待执行的任务列表 里面有元素(工作)时，工作者队列里的工作者就会开始工作
	private final LinkedList<Task> taskList = new LinkedList<>();

	// 执行者队列
	private final List<Worker> workerList = Collections.synchronizedList(new ArrayList<Worker>());

	// 线程池中当前执行者的数量
	private int workerNumber = DEFAULT_WORKER_NUMBER;

	// 执行者的线程编码  创建线程时从0开始自动增长  
	private AtomicLong threadNum = new AtomicLong();


	public MyThreadPool() {
		initWorkerList(MIN_WORKER_NUMBER);
	}

	/**
	 * @param defaultWorkerNumber
	 * @Description
	 */
	private void initWorkerList(int num) {
		for (int i = 0; i < num; i++) {
			Worker worker = new Worker();
			workerList.add(worker);
			Thread thread = new Thread(worker, "ThreadPool-Woker-" + threadNum.incrementAndGet());
			thread.start();
		}

	}

	/*
	 * (non-Javadoc)
	 * @see ThreadPool.ThreadPool#execute(ThreadPool.Task)
	 */
	@Override
	public void execute(Task task) {
		if (task != null) {
			synchronized (taskList) {
				taskList.add(task);
				taskList.notify();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ThreadPool.ThreadPool#shutDown()
	 */
	@Override
	public void shutDown() {
		for (Worker woker : workerList) {
			woker.shutDown();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ThreadPool.ThreadPool#addWorker(int)
	 */
	@Override
	public void addWorker(int num) {
		synchronized (workerList) {
			if (num > MAX_WORKER_NUMBER - this.workerNumber) {
				num = MAX_WORKER_NUMBER - this.workerNumber;
			}
			initWorkerList(num);
			this.workerNumber += num;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ThreadPool.ThreadPool#removeWorker(int)
	 * 减少工作者队列的工作者，但并不是将工作线程销毁，只是让它进入等待状态
	 */
	@Override
	public void removeWorker(int num) {
		//对synchronizedList加锁是因为，返回的list获得的Iterator仍然是线程不安全的
		//Collections.synchronizedXX这种做法，适合不需要使用Iterator、对性能要求也不高的情况。
		synchronized (workerList) {
			if (num > this.workerNumber) {
				num = this.workerNumber;
			}
			int count=0;
			while (count<num) {
				Worker worker = workerList.get(count);
				if (workerList.remove(worker)) {
					worker.shutDown();
					count++;
				}
			}
			this.workerNumber -= count;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ThreadPool.ThreadPool#getWorkerNumber()
	 */
	@Override
	public int getWorkerNum() {
		return workerNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ThreadPool.ThreadPool#getTaskNum()
	 */
	@Override
	public int getTaskNum() {
		return taskList.size();
	}

	/**
	 * @author 24663
	 * @date 2018年11月29日
	 * @Description  执行者线程
	 */
	class Worker  implements Runnable {

		public  volatile boolean Running = true;

		@Override
		public void run() {
			while (Running) {
				Task task = null;
				synchronized (taskList) {
					while (taskList.isEmpty()) {//如果taskList为空，没有待执行的任务，线程进入等待状态
						try {
							taskList.wait();
						} catch (Exception e) {
							e.printStackTrace();
							Thread.currentThread().interrupt();
							return;
						}
					}
					task=taskList.removeFirst();//从taskList队头拿出一个任务出来执行
				}
				if (task!=null) {
					task.action();
				}
			}
		}

		/**
		 * 
		 * @Description
		 */
		public void shutDown() {
			this.Running = false;

		}
	}
}
