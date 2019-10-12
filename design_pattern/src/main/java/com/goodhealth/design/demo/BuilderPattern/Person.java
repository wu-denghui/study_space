/**
 * 
 */
package com.goodhealth.design.demo.BuilderPattern;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public abstract class Person {
	
	private  String  nose;
	
	private   String  skin;
	
	private   String   eyes;
	
	
	private  String  character;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		System.out.println("Person [nose=" + nose + ", skin=" + skin + ", eyes=" + eyes + ", character=" + character + "]");
		return "Person [nose=" + nose + ", skin=" + skin + ", eyes=" + eyes + ", character=" + character + "]";
	}

	/**
	 * @return the character
	 */
	public String getCharacter() {
		return character;
	}

	/**
	 * @param character the character to set
	 */
	public void setCharacter(String character) {
		this.character = character;
	}

	/**
	 * @return the nose
	 */
	public String getNose() {
		return nose;
	}

	/**
	 * @param nose the nose to set
	 */
	public void setNose(String nose) {
		this.nose = nose;
	}

	/**
	 * @return the skin
	 */
	public String getSkin() {
		return skin;
	}

	/**
	 * @param skin the skin to set
	 */
	public void setSkin(String skin) {
		this.skin = skin;
	}

	/**
	 * @return the eyes
	 */
	public String getEyes() {
		return eyes;
	}

	/**
	 * @param eyes the eyes to set
	 */
	public void setEyes(String eyes) {
		this.eyes = eyes;
	} 
	
	  public  abstract  void   ability();

}
