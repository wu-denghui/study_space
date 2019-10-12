/**
 * 
 */
package com.goodhealth.design.demo.TemplateMethod;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Client {
	
	public static void main(String[] args) {
		System.out.println("职员的一天");
		Staff   s=new  Staff();
		s.oneday();
		System.out.println("经理的一天");
		Manager m=new Manager();
		m.setJiab(false);
		m.oneday();
	}
	/*
	 *  输出结果
职员的一天
我是职员：早上九点打卡
我是职员：上午班九点上到十二点
我是职员：中午十二点吃午饭
我是职员：午休到一点
我是职员：下午班上到五点
需要加班
经理的一天
我是经理：上午十点上班打卡
我是经理：上午十点上班上到十二点
我是经理：十二点吃午饭
我是经理：午休到二点
我是经理：下午上班到四点半
我是经理：下午上班到四点半*/

}