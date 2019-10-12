package com.goodhealth.design.demo.CommandPattern;

public class AMatrix extends Command {

	public AMatrix(ISoldiers infantry, ISoldiers cavalry) {
		super(infantry, cavalry);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.cavalry.up();
		super.infantry.down();
		
	}



}
