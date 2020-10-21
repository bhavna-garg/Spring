package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// table - User

@Entity 
public class User {
	
	// id is primary key and is generated automatically
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String role;
	
	protected User() {
		super();
	}
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}

}
