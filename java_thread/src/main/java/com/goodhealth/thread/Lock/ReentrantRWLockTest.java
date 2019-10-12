/**
 * 
 */
package com.goodhealth.thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 24663
 * @date 2018年11月21日
 * @Description
 */
public class ReentrantRWLockTest {

	static int age = 22;
	static String name = "石原里美";
	static ReentrantReadWriteLock wrLock = new ReentrantReadWriteLock();
	static Lock rLock = wrLock.readLock();
	static Lock wLock = wrLock.writeLock();

	public static void main(String[] args) throws InterruptedException {
/*		Writer cleverlove = new Writer(18, "新垣结衣");
		cleverlove.start();
		Writer cleverlov = new Writer(18, "新垣衣");
		cleverlov.start();
		Writer cleverlo = new Writer(18, "新衣");
		cleverlo.start();*/
		new Reader().start();
		new Reader().start();
		new Reader().start();
		Writer cleverlove = new Writer(18, "新垣结衣");
		cleverlove.start();
	}

	static class Reader extends Thread {
		@Override
		public void run() {
			wrLock.readLock().lock();
			try {
				System.out.println(Thread.currentThread().getName() + "读到的姓名是" + ReentrantRWLockTest.name);
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rLock.unlock();
			}

		}
	}

	static class Writer extends Thread {

		public int age;
		public String name;

		@Override
		public void run() {
			wrLock.writeLock().lock();
			try {
				ReentrantRWLockTest.name = name;
				 System.out.println(Thread.currentThread().getName() + "修改姓名为"
				 + ReentrantRWLockTest.name);
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				wLock.unlock();
			}
		}
		/**
		 * @param age
		 * @param name
		 */
		public Writer(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
	}

}