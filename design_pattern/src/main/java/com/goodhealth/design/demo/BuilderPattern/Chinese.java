/**
 * 
 */
package com.goodhealth.design.demo.BuilderPattern;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Chinese extends Person {

	/* (non-Javadoc)
	 * @see Builder.Person#ability()
	 */
	@Override
	public void ability() {
		System.out.println("中国人会做生意");
	}

}
