package com.example.demo.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Size(min = 2, message = "size should be greater than 2")
	private String name;
	@Past
	private Date date;

	@OneToMany(mappedBy = "user")
	private List<Post> post;

	

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public User() {
		super();
	}

	public User(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + ", post=" + post + "]";
	}

}
