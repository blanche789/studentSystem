package com.blanche.model;

public class User {
	private int id;
	private String userName;
	private String password;
	private String right;
	public User() {
		super();
		
	}
	
	public User(int id, String userName, String password, String right) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.right = right;
	}
	
	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
