/**
 * 
 */
package com.goodhealth.design.demo.TemplateMethod;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Staff extends Template {

	/* (non-Javadoc)
	 * @see Template.Template#daka()
	 */
	@Override
	public void daka() {
		// TODO Auto-generated method stub
		System.out.println("我是职员：早上九点打卡");

	}

	/* (non-Javadoc)
	 * @see Template.Template#shangzaoban()
	 */
	@Override
	public void shangzaoban() {
		// TODO Auto-generated method stub
		System.out.println("我是职员：上午班九点上到十二点");

	}

	/* (non-Javadoc)
	 * @see Template.Template#chiwufan()
	 */
	@Override
	public void chiwufan() {
		// TODO Auto-generated method stub
		System.out.println("我是职员：中午十二点吃午饭");

	}

	/* (non-Javadoc)
	 * @see Template.Template#wuxiu()
	 */
	@Override
	public void wuxiu() {
		// TODO Auto-generated method stub
		System.out.println("我是职员：午休到一点");

	}

	/* (non-Javadoc)
	 * @see Template.Template#xiawuban()
	 */
	@Override
	public void xiawuban() {
		// TODO Auto-generated method stub
		System.out.println("我是职员：下午班上到五点");

	}

	/* (non-Javadoc)
	 * @see Template.Template#xiaban()
	 */
	@Override
	public void xiaban() {
		// TODO Auto-generated method stub
		System.out.println("我是职员：下午五点下班");

	}

	/* (non-Javadoc)
	 * @see Template.Template#jiaban()
	 */
	@Override
	public boolean jiaban() {
		// TODO Auto-generated method stub
		return super.jiaban();
	}

}
