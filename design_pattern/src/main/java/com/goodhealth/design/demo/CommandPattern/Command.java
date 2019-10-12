package com.goodhealth.design.demo.CommandPattern;

public abstract class Command {
	
	protected  ISoldiers   infantry;
	
	protected  ISoldiers   cavalry;
	
	public  abstract void  execute();
	
	

	public Command(ISoldiers infantry, ISoldiers cavalry) {
		super();
		this.infantry = infantry;
		this.cavalry = cavalry;
	}



	public ISoldiers getInfantry() {
		return infantry;
	}

	public void setInfantry(ISoldiers infantry) {
		this.infantry = infantry;
	}

	public ISoldiers getCavalry() {
		return cavalry;
	}

	public void setCavalry(ISoldiers cavalry) {
		this.cavalry = cavalry;
	}
	

	

}
