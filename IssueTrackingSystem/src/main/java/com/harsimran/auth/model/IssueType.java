package com.harsimran.auth.model;

public enum IssueType {

	IT_ISSUE("IT ISSUE"), 
	ADMIN_ISSUE("ADMIN ISSUE"), 
	HR_ISSUE("HR ISSUE"), 
	SEATING_ISSUE("SEATING ISSUE"),
	PAYROLL_ISSUE("PAYROLL ISSUE"), 
	LEAVE_ISSUE("LEAVE ISSUE"), 
	UNASSIGNED("UNASSIGNED");

	private final String name;

	IssueType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	

}
