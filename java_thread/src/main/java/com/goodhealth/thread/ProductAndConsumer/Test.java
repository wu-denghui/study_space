/**
 * 
 */
package com.goodhealth.thread.ProductAndConsumer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 24663
 * @date 2018年12月13日
 * @Description
 */
public class Test {

	public static void main(String[] args) {
		ExecutorService threadPool = null;
		Future<Person> future;
		try {
			Test test = new Test();
			new Thread(new Product(test, 10, "王校长", "男")).start();
			threadPool = Executors.newSingleThreadExecutor();
			future = threadPool.submit(new Consumer(test));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			threadPool.shutdown();
		}

	}

	/**
	 * @Fields 是否是最新的数据 当isUpdate为false时，代表数据已经被读取了 当isUpdate为true时，代表数据刚更新，未被读取
	 */
	private volatile boolean isUpdate = true;

	private Person principal = new Person();

	/**
	 * @return the principal
	 */
	public synchronized Person getPrincipal(Test t) {
		try {
			while (!isUpdate) {  //fasle   之前设置的值已被读取 ，新的值还未被设置 ，不允许读值
				System.out.println("不让读取");
				t.wait();
				System.out.println(1);
			}
			this.isUpdate = false;
			System.out.println(2);
			t.notifyAll();
			System.out.println(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return principal;
	}

	/**
	 * @param principal
	 *            the principal to set
	 */
	public synchronized void setPrincipal(Person principal,Test t) {
		try {
			while (isUpdate) {
				//true  之前设置的值还没被读取  不允许更新
				System.out.println("不让更新");
				t.wait();
			}
			this.principal = principal;
			System.out.println(4);
			this.isUpdate = true;
			t.notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static class Product extends Person implements Runnable {

		final private Test t;
		/**
		 * @param
		 */
		public Product(Test t, int age, String name, String sexy) {
			super(age, name, sexy);
			this.t = t;
		}
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			t.setPrincipal((Person) this,t);
		}

	}

	static class Consumer implements Callable<Person> {

		private Test t;
		/**
		 * @param t
		 */
		public Consumer(Test t) {
			super();
			this.t = t;
		}
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.concurrent.Callable#call()
		 */
		@Override
		public Person call() throws Exception {
			// TODO Auto-generated method stub
			return t.getPrincipal(t);
		}
	}
}

class Person {
	public int age;
	public String name;
	public String sexy;
	/**
	 * @param age
	 * @param name
	 * @param sexy
	 */
	public Person(int age, String name, String sexy) {
		super();
		this.age = age;
		this.name = name;
		this.sexy = sexy;
	}

	public Person() {
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sexy
	 */
	public String getSexy() {
		return sexy;
	}
	/**
	 * @param sexy
	 *            the sexy to set
	 */
	public void setSexy(String sexy) {
		this.sexy = sexy;
	}
}