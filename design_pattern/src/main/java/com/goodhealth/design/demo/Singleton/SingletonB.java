/**
 * 
 */
package com.goodhealth.design.demo.Singleton;

/**
 * @author 24663
 * @date 2018年10月19日
 * @Description   线程安全的饿汉式单例     不是按需加载，直接初始化实例对象
 */
public class SingletonB {
	//访问方式： SingletonB  instance=SingletonB.getInstance();
      private  static   SingletonB  single=new SingletonB();
      
      private SingletonB(){
      }

    public  static SingletonB  getInstance(){
    	return  single;
    }
}


