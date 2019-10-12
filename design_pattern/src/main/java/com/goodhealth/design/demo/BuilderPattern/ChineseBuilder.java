/**
 * 
 */
package com.goodhealth.design.demo.BuilderPattern;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class ChineseBuilder extends Builder {
	
	Chinese chinese=null;

	/* (non-Javadoc)
	 * @see Builder.Builder#setPerson()
	 */
	@Override
	public void  setPerson(String nose, String eyes, String skin,String character){
		this.chinese=new Chinese();
		this.chinese.setEyes(eyes);
		this.chinese.setNose(nose);
		this.chinese.setSkin(skin);
		this.chinese.setCharacter(character);
	}

	/* (non-Javadoc)
	 * @see Builder.Builder#BuilderPerson()
	 */
	@Override
	public Person BuilderPerson() throws Exception {
		if (this.chinese==null) {
			throw new Exception("请先构造Person");
		}else{
			return this.chinese;
		}
	}

}
