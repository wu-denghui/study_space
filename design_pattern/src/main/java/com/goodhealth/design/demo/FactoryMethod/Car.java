/**
 * 
 */
package com.goodhealth.design.demo.FactoryMethod;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public  abstract  class Car {

	private  String  jiaochengdipao;
	
	private String   luntai;
	
	private  String  chebiao;
	
	private  String  chesheng;
	
	/**
	 * @return the chebiao
	 */
	public String getChebiao() {
		return chebiao;
	}

	/**
	 * @param chebiao the chebiao to set
	 */
	public void setChebiao(String chebiao) {
		this.chebiao = chebiao;
	}

	/**
	 * @return the chesheng
	 */
	public String getChesheng() {
		return chesheng;
	}

	/**
	 * @param chesheng the chesheng to set
	 */
	public void setChesheng(String chesheng) {
		this.chesheng = chesheng;
	}

	/**
	 * @return the dipan
	 */
	public String getDipan() {
		return jiaochengdipao;
	}

	/**
	 * @param dipan the dipan to set
	 */
	public void setDipan(String dipan) {
		this.jiaochengdipao = dipan;
	}

	/**
	 * @return the luntai
	 */
	public String getLuntai() {
		return luntai;
	}

	/**
	 * @param luntai the luntai to set
	 */
	public void setLuntai(String luntai) {
		this.luntai = luntai;
	}

	
	public abstract void run();
	
	public abstract void singing();

}
