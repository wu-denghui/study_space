/**
 * 
 */
package com.goodhealth.design.demo.MemorandumPattern;


/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class GasStation {
	
	private  int  day;
	
	private  int    price;
	
	public  Memento  createMemenro(){
		
		return  new Memento(this.day,this.price);
 	}
	
	public  void   back(Memento men){
		this.day=men.getDay();
		
		this.price=men.getPrice();
	}
	
	public  void    describe(){
		System.out.println("星期"+day+"的油价是"+price);
	}

	/**
	 * @param day
	 * @param price
	 */
	public GasStation(int day, int price) {
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
