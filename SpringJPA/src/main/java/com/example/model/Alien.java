package com.example.model;

public class Alien {

	private int aId;
	private String aName;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	@Override
	public String toString() {
		return "Alien [aId=" + aId + ", aName=" + aName + "]";
	}
	
}
