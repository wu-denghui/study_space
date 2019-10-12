package com.goodhealth.design.demo.CommandPattern;

public class Client {

	public static void main(String[] args) {
		Invoker  siling=new Invoker();
		AMatrix  Ajihua=new  AMatrix(new Infantry(), new Cavalry());
		System.out.println("司令下命令，军队摆A阵列");
		siling.setCommand(Ajihua);
		siling.action();
		System.out.println("司令下命令，军队摆B阵列");
		BMatrix  bjihua=new  BMatrix(new Infantry(), new Cavalry());
		siling.setCommand(bjihua);
		siling.action();
	}

}
