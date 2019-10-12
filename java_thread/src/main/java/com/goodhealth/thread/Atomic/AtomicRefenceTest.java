/**
 * 
 */
package com.goodhealth.thread.Atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 24663
 * @date 2018年11月28日
 * @Description
 */
public class AtomicRefenceTest {

/*
 * AtomicReference() 
          使用 null 初始值创建新的 AtomicReference。
AtomicReference(V initialValue) 
          使用给定的初始值创建新的 AtomicReference。
 * 	boolean	compareAndSet(V expect, V update) 
    如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。
V	get() 
    获取当前值。
V	getAndSet(V newValue) 
    以原子方式设置为给定值，并返回旧值。
void	lazySet(V newValue) 
    最终设置为给定值。
void	set(V newValue) 
    设置为给定值。
String	toString() 
    返回当前值的字符串表示形式。
boolean	weakCompareAndSet(V expect, V update) 
    如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。*/
	public static void main(String[] args) {
		GL  fGl=new GL("佟丽娅");
		GL  lGl=new GL("迪丽热巴");
		AtomicReference<GL>  agl=new  AtomicReference<GL>();
		AtomicReference<GL>  vgl=new  AtomicReference<GL>(fGl);
		System.out.println(vgl.get().name);
		System.out.println(vgl.getAndSet(lGl).name);
		System.out.println(vgl.get().name);
		

	}

}
class   GL{
	
	String  name;

	/**
	 * @param name
	 */
	public GL(String name) {
		super();
		this.name = name;
	}
	
	
}