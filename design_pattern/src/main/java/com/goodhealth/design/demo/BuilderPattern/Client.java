/**
 * 
 */
package com.goodhealth.design.demo.BuilderPattern;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Client {

	public static void main(String[] args) {
		God di=new God();
		try{
			Chinese  c1=di.getBadChinese();
			c1.toString();
			Chinese  c2=di.getKindChinese();
			c2.toString();
			English  e1=di.getBadEnglish();
			e1.toString();
			English  e2=di.getKindEnglish();
			e2.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
