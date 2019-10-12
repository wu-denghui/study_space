package com.goodhealth.design.demo.CommandPattern;

public abstract class ISoldiers {
	
	private   String  name;
	
	private   String  rank;
	
	private   String  sexy;
	
	public   abstract void   up();
	public   abstract void   down();
	public   abstract void   left();
	public   abstract void   rigth();
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getRank() {
		return rank;
	}



	public void setRank(String rank) {
		this.rank = rank;
	}



	public String getSexy() {
		return sexy;
	}



	public void setSexy(String sexy) {
		this.sexy = sexy;
	}




} 
