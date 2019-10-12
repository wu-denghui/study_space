/**
 * 
 */
package com.goodhealth.design.demo.MemorandumPattern;

import java.util.HashMap;


/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Caretaker {

	private  HashMap<Integer,Memento>  book=new HashMap<>();
	
	
	
	public   void  intoBook(Memento men){
		this.book.put(men.getDay(), men);
	}
	
	
	
	public  Memento  back(int key){
		
		return this.book.get(key);
		
	}

	/**
	 * @return the book
	 */
	public HashMap<Integer,Memento> getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(HashMap<Integer,Memento> book) {
		this.book = book;
	}
		



}
