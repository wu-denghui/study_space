/**
 * 
 */
package com.goodhealth.design.demo.Singleton;

/**
 * @author 24663
 * @date 2018年10月19日
 * @Description     线程安全的内部类式饿汉单例    可以实现按需加载
 */
public class SingletonC {
    //访问方式： SingletonC.getInstance();
	
	
	static class inner{
		private static  SingletonC  single=new SingletonC();
	}
	
	private SingletonC(){
		
	}
	
	public     static  SingletonC getInstance(){
		  return  inner.single;
	}

}
