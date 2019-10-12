/**
 * 
 */
package com.goodhealth.design.demo.BuilderPattern;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class EnglishBuiler extends Builder {
	
	   English english=null;

	/* (non-Javadoc)
	 * @see Builder.Builder#setPerson()
	 */
	@Override
		public void  setPerson(String nose, String eyes, String skin,String character){
			this.english=new English();
			this.english.setEyes(eyes);
			this.english.setNose(nose);
			this.english.setSkin(skin);
			this.english.setCharacter(character);
		}

		/* (non-Javadoc)
		 * @see Builder.Builder#BuilderPerson()
		 */
		@Override
		public Person BuilderPerson() throws Exception {
			if (this.english==null) {
				throw new Exception("请先构造Person");
			}else{
				return this.english;
			}
		}

}
