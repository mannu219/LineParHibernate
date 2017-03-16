package com.test.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public   class User {
	@NotEmpty
	@Length(min=6,max=15)
    private String username;
	@NotEmpty
	@Length(min=2,max=15)
    private String password;
    
	 public User(){}
	 
    public User(String username, String password) {
//		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
