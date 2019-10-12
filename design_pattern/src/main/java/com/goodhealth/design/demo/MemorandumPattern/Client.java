/**
 * 
 */
package com.goodhealth.design.demo.MemorandumPattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Client {

	/**
	 * @param args
	 * @Description
	 */
	public static void main(String[] args) {
		Caretaker taker = new Caretaker();
		GasStation day = new GasStation(1, 150);
		day.describe();
		taker.intoBook(day.createMemenro());
		day = new GasStation(2, 140);
		day.describe();
		taker.intoBook(day.createMemenro());
		day = new GasStation(3, 155);
		day.describe();
		taker.intoBook(day.createMemenro());
		day = new GasStation(4, 160);
		day.describe();
		taker.intoBook(day.createMemenro());
		System.out.println("我想知道星期2的油价");
		day.back(taker.back(2));
		day.describe();

	}

}
