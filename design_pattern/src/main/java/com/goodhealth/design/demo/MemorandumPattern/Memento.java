/**
 * 
 */
package com.goodhealth.design.demo.MemorandumPattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Memento {
	
	
	private  int  day;
	
	private  int    price;
	

	/**
	 * @param day
	 * @param price
	 */
	public Memento(int day, int price) {
		super();
		this.day = day;
		this.price = price;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	


}
