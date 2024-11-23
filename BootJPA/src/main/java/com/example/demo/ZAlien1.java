package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Entity
public class ZAlien1 {
	
	@Id
	private int aId;
	private String name;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Alien1 [aId=" + aId + ", name=" + name + "]";
	}

}
