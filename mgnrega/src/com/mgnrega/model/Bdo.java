package com.mgnrega.model;

public class Bdo {
	private int srNum;
	private String name;
	private String address;
	private String email;
	private String password;
	
	public Bdo(int srNum, String name, String address, String email, String password) {
		super();
		this.srNum = srNum;
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	public Bdo() {
	
	}
	public int getSrNum() {
		return srNum;
	}
	public void setSrNum(int srNum) {
		this.srNum = srNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Bdo [srNum=" + srNum + ", name=" + name + ", address=" + address + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}
