/**
 * 
 */
package com.goodhealth.design.demo.Singleton;

/**
 * @author 24663
 * @date 2018年10月19日
 * @Description      线程安全的双重校验懒汉式单例
 */
public class SingletonA {
	
	String  name;
	
	//访问方式： SingletonA  instance=SingletonA.getInstance();
	private   static  SingletonA  single=null;
	
	private  SingletonA(){
		
	}
	

	  /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	public   static SingletonA getInstance(){
		  if (single==null) {
			synchronized (SingletonA.class) {   //双重校验加锁，防止线程A执行single=new SingletonA();时，线程B执行single==null（第一个），造成线程不安全
				if (single==null) {
					single=new SingletonA();
				}
			}
		}
		  return  single;
	  }

}



class  SingletonE {
	
	private  static  SingletonE  single=null;
	
	private  SingletonE(){
		
	}
	
	public  static SingletonE   getInstance(){
		
		if (single==null) {
			single=new SingletonE();
		}
		return single;
		
	}
	
}



