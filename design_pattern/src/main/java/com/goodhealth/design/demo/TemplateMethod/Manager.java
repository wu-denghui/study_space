/**
 * 
 */
package com.goodhealth.design.demo.TemplateMethod;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Manager extends Template {
	
	private boolean jiab=false;

	/* (non-Javadoc)
	 * @see Template.Template#jiaban()
	 */
	@Override
	public boolean jiaban() {
		return this.jiab;
	}

	/**
	 * @param jiab the jiab to set
	 */
	public void setJiab(boolean jiab) {
		this.jiab = jiab;
	}


	/* (non-Javadoc)
	 * @see Template.Template#daka()
	 */
	@Override
	public void daka() {
		// TODO Auto-generated method stub
		System.out.println("我是经理：上午十点上班打卡");

	}

	/* (non-Javadoc)
	 * @see Template.Template#shangzaoban()
	 */
	@Override
	public void shangzaoban() {
		// TODO Auto-generated method stub
		System.out.println("我是经理：上午十点上班上到十二点");

	}

	/* (non-Javadoc)
	 * @see Template.Template#chiwufan()
	 */
	@Override
	public void chiwufan() {
		// TODO Auto-generated method stub
		System.out.println("我是经理：十二点吃午饭");

	}

	/* (non-Javadoc)
	 * @see Template.Template#wuxiu()
	 */
	@Override
	public void wuxiu() {
		// TODO Auto-generated method stub
		System.out.println("我是经理：午休到二点");

	}

	/* (non-Javadoc)
	 * @see Template.Template#xiawuban()
	 */
	@Override
	public void xiawuban() {
		// TODO Auto-generated method stub
		System.out.println("我是经理：下午上班到四点半");

	}

	/* (non-Javadoc)
	 * @see Template.Template#xiaban()
	 */
	@Override
	public void xiaban() {
		// TODO Auto-generated method stub
		System.out.println("我是经理：下午四点半下班了");

	}

}
