package com.goodhealth.design.demo.CommandPattern;

public class BMatrix extends Command {

	public BMatrix(ISoldiers infantry, ISoldiers cavalry) {
		super(infantry, cavalry);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.cavalry.left();
		super.infantry.rigth();
	}

}
