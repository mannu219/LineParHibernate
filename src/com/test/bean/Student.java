package com.test.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Student extends User{
	 
	@NotEmpty 
     private String name;
	 @NotEmpty
	@Length(min=10,max=10)
     private String phone;
	@Email @NotEmpty
     private String email;
	public Student(){}
	
	public Student(String username, String password, String name, String phone, String email) {
		super(username, password);
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	 
 
 
	
     
}
