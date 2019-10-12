package com.goodhealth.design.demo.BuilderPattern;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class English extends Person {

	/* (non-Javadoc)
	 * @see Builder.Person#ability()
	 */
	@Override
	public void ability() {
		System.out.println("英国人会踢足球");
	}

}
