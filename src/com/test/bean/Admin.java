package com.test.bean;

public class Admin extends User{

	public Admin() {}
	
	public Admin(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [Username =" + getUsername() + ", Password= ******]";
	}
	
 
	    
}
