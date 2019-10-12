/**
 * 
 */
package com.goodhealth.thread.Atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author 24663
 * @date 2018年11月28日
 * @Description
 */
public class AtomicFieldUpdate {
	/*
	 * AtomicReferenceFieldUpdater------------原子更新引用类型里的字段
	 * protected	AtomicReferenceFieldUpdater() 
    受保护的无操作构造方法，供子类使用。  
abstract  boolean	compareAndSet(T obj, V expect, V update) 
    如果当前值 == 预期值，则以原子方式将此更新器管理的给定对象的字段设置为给定的更新值。
abstract  V	get(T obj) 
    获取由此更新器管理的在给定对象的字段中保持的当前值。
V	getAndSet(T obj, V newValue) 
    将此更新器管理的给定对象的字段自动设置为给定值，并返回旧值。
abstract  void	lazySet(T obj, V newValue) 
    最终将此更新器管理的给定对象的字段设置为给定更新值。
static
<U,W> AtomicReferenceFieldUpdater<U,W>	newUpdater(Class<U> tclass, Class<W> vclass, String fieldName) 
    使用给定的字段为对象创建和返回一个更新器。
abstract  void	set(T obj, V newValue) 
    将此更新器管理的给定对象的字段设置为给定更新值。
abstract  boolean	weakCompareAndSet(T obj, V expect, V update) 
    如果当前值 == 预期值，则以原子方式将此更新器管理的给定对象的字段设置为给定的更新值。
	*/

	
	
/*	    AtomicIntegerFieldUpdater------------原子更新整型字段的更新器
 * protected	AtomicIntegerFieldUpdater() 
          受保护的无操作构造方法，供子类使用。  
 int	addAndGet(T obj, int delta) 
          以原子方式将给定值添加到此更新器管理的给定对象的字段当前值。
abstract  boolean	compareAndSet(T obj, int expect, int update) 
          如果当前值 == 预期值，则以原子方式将此更新器所管理的给定对象的字段值设置为给定的更新值。
 int	decrementAndGet(T obj) 
          以原子方式将此更新器管理的给定对象的字段的当前值减 1。
abstract  int	get(T obj) 
          获取此更新器管理的在给定对象的字段中保持的当前值。
 int	getAndAdd(T obj, int delta) 
          以原子方式将给定值添加到此更新器管理的给定对象的当前值。
 int	getAndDecrement(T obj) 
          以原子方式将此更新器管理的给定对象的当前值减 1。
 int	getAndIncrement(T obj) 
          以原子方式将此更新器管理的给定对象的当前值加 1。
 int	getAndSet(T obj, int newValue) 
          以原子方式将此更新器管理的给定对象的字段设置为给定值，并返回旧值。
 int	incrementAndGet(T obj) 
          以原子方式将此更新器管理的给定对象的字段的当前值加 1。
abstract  void	lazySet(T obj, int newValue) 
          最后将此更新器管理的给定对象的字段设置为给定更新值。
static
<U> AtomicIntegerFieldUpdater<U>	newUpdater(Class<U> tclass, String fieldName) 
          使用给定字段为对象创建和返回一个更新器。
abstract  void	set(T obj, int newValue) 
          将此更新器管理的给定对象的字段设置为给定更新值。
abstract  boolean	weakCompareAndSet(T obj, int expect, int update) 
          如果当前值 == 预期值，则以原子方式将此更新器所管理的给定对象的字段值设置为给定的更新值。
 * */
	
	private static AtomicReferenceFieldUpdater<Teacher, String> arfu=
			AtomicReferenceFieldUpdater.newUpdater(Teacher.class, String.class, "name");
	private  static AtomicIntegerFieldUpdater<Teacher>  aifu=
			AtomicIntegerFieldUpdater.newUpdater(Teacher.class, "age");
	
	public static void main(String[] args) {
		Teacher lz=new Teacher("张", 25);
		Teacher lw=new Teacher("王", 18);
		System.out.println(arfu.get(lw));
		System.out.println(arfu.getAndSet(lw, "王三"));
		System.out.println(arfu.get(lw));
		System.out.println(arfu.compareAndSet(lz, "张", "张三"));
		System.out.println(arfu.get(lz));
		System.out.println(aifu.get(lz));
		System.out.println(aifu.getAndAdd(lz, 50));
		System.out.println(aifu.get(lz));
		
	}
	
	

}
class  Teacher{
	
	public   volatile String  name;
	
	public  volatile  int  age;

	/**
	 * @param name
	 * @param age
	 */
	public Teacher(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}