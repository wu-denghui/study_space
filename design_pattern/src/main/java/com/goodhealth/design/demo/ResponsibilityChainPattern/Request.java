package com.goodhealth.design.demo.ResponsibilityChainPattern;

public class Request {
	
	private  final  int   RequestLevel  =  3;

	public int getRequestLevel() {
		return RequestLevel;
	}
	
	public  void   request(){
		System.out.println("员工想请假");
	}

}
