/**
 * 
 */
package com.goodhealth.thread.Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author 24663
 * @date 2018年11月28日
 * @Description
 */
public class AtomicIntegerArrayTest {
	public static void main(String[] args) {
		AtomicIntegerArray   an=new AtomicIntegerArray(10);//长度为10的AtomicIntegerArray
		int[]  xx={1,3,5,7,9};
		AtomicIntegerArray xn=new AtomicIntegerArray(xx);//复制了数组xx的AtomicIntegerArray
		System.out.println(xn.get(1));
		System.out.println(an.getAndAdd(1, 10));//将数组位置i的值+参数值，并返回旧值
		System.out.println(an.get(1));
		System.out.println(an.addAndGet(0, 5));//将数组位置i的值+参数值，并返回新值
		System.out.println(an.getAndSet(1, 9));//将数组位置i的值更新为参数值，并返回旧值
		System.out.println(an.get(1));
		System.out.println(an.compareAndSet(1, 9, 15));
		System.out.println(an.get(1));
	}

}
