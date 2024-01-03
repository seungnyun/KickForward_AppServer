package com.jang.biz.model;

import javax.validation.constraints.NotEmpty;

public class User {
	
	private int no = 0;
	private String id = "";
	private String pass = "";
	private String name = "";
	private String phone = "";
	private String email = "";
	
	private String license = "";
	private String billingKey = "";
	private char in_use;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getBillingKey() {
		return billingKey;
	}
	public void setBillingKey(String billingKey) {
		this.billingKey = billingKey;
	}
	public char getIn_use() {
		return in_use;
	}
	public void setIn_use(char in_use) {
		this.in_use = in_use;
	}
	

	
	
	
}
