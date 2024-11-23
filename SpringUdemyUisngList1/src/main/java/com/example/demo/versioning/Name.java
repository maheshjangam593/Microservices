package com.example.demo.versioning;

public class Name {

	private String fName;
	private String lName;
	public Name(String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
	}
	public Name() {
		super();
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
}
