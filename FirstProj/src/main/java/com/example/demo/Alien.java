package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component() // to create an object in spring container
//@Scope("prototype") // to create no of objects for single class and objects gets created only while call getBean method
public class Alien {

	private int aid;
	private String aname;
	@Autowired // searches laptp object by type of object
	@Qualifier("lap") // searches laptop object by name
	private Laptop lap;

	public int getAid() {
		return aid;
	}

	public Laptop getLaptop() {
		return lap;
	}

	public void setLaptop(Laptop laptop) {
		this.lap= laptop;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}

	public Alien() {
		System.out.println("object created");
		// laptop.getName();

	}

	public void show() {
		lap.getName();
	}

}
