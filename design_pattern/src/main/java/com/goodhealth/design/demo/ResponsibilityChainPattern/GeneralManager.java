package com.goodhealth.design.demo.ResponsibilityChainPattern;

public class GeneralManager extends Handler {
	
	public  GeneralManager(){
		super(Handler.GM);
	}

	@Override
	public String echo() {
		// TODO Auto-generated method stub
		return "总经理说了：允许请假";
	}

}
