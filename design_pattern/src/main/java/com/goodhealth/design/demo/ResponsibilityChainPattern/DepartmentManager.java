package com.goodhealth.design.demo.ResponsibilityChainPattern;

public class DepartmentManager extends Handler {

	public DepartmentManager() {
		super(Handler.DM);
	}

	@Override
	public String echo() {
		return "部门经理说了:允许请假";
	}

}
