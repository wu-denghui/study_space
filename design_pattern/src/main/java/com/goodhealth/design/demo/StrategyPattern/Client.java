package com.goodhealth.design.demo.StrategyPattern;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("猎人上山了，遇到了羊群");
		IStrategy  sheep=new MeetSheep();
		Context  hunter=new Context(sheep);
		hunter.action();
		System.out.println("继续前进，遇到了孤狼");
		IStrategy  wolf=new  MeetWolf();
		hunter=new Context(wolf); 
		hunter.action();
	}

}
