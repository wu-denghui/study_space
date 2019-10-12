/**
 * 
 */
package com.goodhealth.design.demo.BuilderPattern;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class God {
	
	private  ChineseBuilder cBuilder=new ChineseBuilder();
	
	private   EnglishBuiler eBuilder=new EnglishBuiler();
	
	public  Chinese getKindChinese() throws Exception{
		cBuilder.setPerson("低鼻梁", "黑眼睛", "黄皮肤","心地善良");
		return (Chinese) cBuilder.BuilderPerson();
		
	}
	
	public  Chinese getBadChinese() throws Exception{
		cBuilder.setPerson("低鼻梁", "黑眼睛", "黄皮肤","脾气不好");
		return (Chinese) cBuilder.BuilderPerson();		
	}
	
	public  English getKindEnglish() throws Exception{
		eBuilder.setPerson("高鼻梁", "蓝眼睛", "白皮肤","心地善良");
		return (English) eBuilder.BuilderPerson();
		
	}
	
	public  English  getBadEnglish() throws Exception{
		eBuilder.setPerson("高鼻梁", "蓝眼睛", "白皮肤","脾气不好");
		return (English) eBuilder.BuilderPerson();
		
	}

}
