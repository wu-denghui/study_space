/**
 * 
 */
package com.goodhealth.design.demo.BuilderPattern;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public abstract class Builder {
	
	public abstract void  setPerson(String nose, String eyes, String skin,String character);
	
	public abstract  Person     BuilderPerson()throws Exception ;



}
