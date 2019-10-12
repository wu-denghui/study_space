
package com.goodhealth.thread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 24663
 * @date 2018年11月28日
 * @Description  atomicboolean/long类似于此
 */
public class AtomicIntegerTest {
	
	static  AtomicInteger  x=new AtomicInteger(10);//初始值为10
	static  AtomicInteger  i=new AtomicInteger();//初始值为0
	public static void main(String[] args) {
		System.out.println(x.get());//返回当前值
		System.out.println(i.get());
		System.out.println(x.incrementAndGet());//使当前值+1并返回新值
		System.out.println(x.decrementAndGet());//使当前值-1并返回新值
		//如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。返回boolean值
		System.out.println(x.compareAndSet(10, 20));//true
		System.out.println(x.compareAndSet(10, 20));//false
		System.out.println(x.get());
		System.out.println(x.getAndIncrement());//使当前值+1但是返回的是旧值
		System.out.println(x.get());
		System.out.println(x.getAndAdd(-5));//使当前值+参数值但是返回的是旧值
		System.out.println(x.get());
		System.out.println(x.getAndSet(59));//将其设置为新值原子方式，返回旧值
		System.out.println(x.get());
		System.out.println(x.doubleValue());
		
	}

}
