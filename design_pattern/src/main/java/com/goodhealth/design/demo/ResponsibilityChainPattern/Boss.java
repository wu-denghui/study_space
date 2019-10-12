package com.goodhealth.design.demo.ResponsibilityChainPattern;

public class Boss extends Handler {
	
	public  Boss() {
		// TODO Auto-generated constructor stub
		super(Handler.BS);
	}

	@Override
	public String echo() {
		// TODO Auto-generated method stub
		return "老班说了：不可以，加班吧你";
	}

}
