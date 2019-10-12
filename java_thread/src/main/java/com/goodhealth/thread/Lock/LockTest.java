/**
 * 
 */
package com.goodhealth.thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 24663
 * @date 2018年11月20日
 * @Description
 */
public class LockTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new textThread().start();
		}
		for (int i = 0; i < 10; i++) {
			new text().start();
		}
	}

}

/**
 * @author 24663
 * @date 2019年2月22日
 * @Description     具有时间限制的活动,定时锁同样有用.超时后程序提前返回.
 */
class text extends Thread {
	ReentrantLock lock = new ReentrantLock();
	@Override
	public void run() {
		try {
			test();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void test() throws InterruptedException {
		if (!lock.tryLock(10, TimeUnit.SECONDS)) {
			System.out.println("获取失败");
			return ;   //失败就结束了23
		}
		try {
			System.out.println("获取成功");
		} finally {
			lock.unlock();
		}
	}
}

/**
 * @author 24663
 * @date 2019年2月22日
 * @Description 一般式获取锁
 */
class textThread extends Thread {

	MyLock lock = new MyLock();

	@Override
	public void run() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName());
		} finally {
			lock.unlock();
		}

	}
}

/**
 * @author 24663
 * @date 2019年2月22日
 * @Description 可以中断的获取锁
 */
class LockInterruptibly extends Thread {
	
/*    Thread t = new Thread(new Blocked2());
    t.start();
    TimeUnit.SECONDS.sleep(1);
    System.out.println("Issuing t.interrupt()");
    t.interrupt();*/

	MyLock lock = new MyLock();

	@Override
	public void run() {
		try {
			test();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
		}

	}

	public void test() throws InterruptedException {
		lock.lockInterruptibly();
		try {
			System.out.println(Thread.currentThread().getName());
		} finally {
			lock.unlock();
		}
	}

}