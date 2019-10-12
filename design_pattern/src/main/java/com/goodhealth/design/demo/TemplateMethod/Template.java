/**
 * 
 */
package com.goodhealth.design.demo.TemplateMethod;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public   abstract  class Template {
	//基本方法
	public   abstract void  daka();
	
	public  abstract  void   shangzaoban();
	
	public  abstract  void   chiwufan();
	
	public  abstract  void   wuxiu();
	
	public  abstract  void   xiawuban();
	
	public  abstract  void   xiaban();
	
	//模板方法
	public  void  oneday(){
		   this.daka();
		   this.shangzaoban();
		   this.chiwufan();
		   this.wuxiu();
		   this.xiawuban();
		   //钩子方法   对模板方法的执行造成影响
		   if (jiaban()) {
			System.out.println("需要加班");
		}else{
			this.xiaban();
		}
	}
	
	//钩子方法
	public   boolean  jiaban(){
		return  true;
	}
	

}
