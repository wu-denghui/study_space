package com.goodhealth.design.demo.CommandPattern;

public class Cavalry extends ISoldiers {

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("步兵向前列阵");

	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("步兵向后列阵");

	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("步兵向左列阵");
	}

	@Override
	public void rigth() {
		// TODO Auto-generated method stub
		System.out.println("步兵向右列阵");

	}

}
