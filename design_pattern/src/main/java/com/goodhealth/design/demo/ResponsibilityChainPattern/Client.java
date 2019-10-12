package com.goodhealth.design.demo.ResponsibilityChainPattern;

public class Client {

	public static void main(String[] args) {
		//员工请假由这三位负责
		Handler dmHandler=new DepartmentManager();
		Handler gmHandler=new GeneralManager();
		Handler bsHandler=new Boss();
		dmHandler.setNextHandler(gmHandler);
		gmHandler.setNextHandler(bsHandler);
		Request  xiaosan=new Request();
		//处理员工登级为3的，员工小三的请假要求
		System.out.println(dmHandler.HandlerMessage(xiaosan));

	}

}
