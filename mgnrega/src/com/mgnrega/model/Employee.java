package com.mgnrega.model;

public class Employee {
	
	private int empId;
	private String empName;
	private String empEmail;
	private String empPassword;
	private String empMobile;
	private String empAadhar;
	private String empAddress;
	private int empWages;
	private int empTotalDays;
	
	
	public Employee() {
		
	}


	public Employee(int empId, String empName, String empEmail, String empPassword, String empMobile, String empAadhar,
			String empAddress, int empWages, int empTotalDays) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.empMobile = empMobile;
		this.empAadhar = empAadhar;
		this.empAddress = empAddress;
		this.empWages = empWages;
		this.empTotalDays = empTotalDays;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpEmail() {
		return empEmail;
	}


	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}


	public String getEmpPassword() {
		return empPassword;
	}


	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}


	public String getEmpMobile() {
		return empMobile;
	}


	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}


	public String getEmpAadhar() {
		return empAadhar;
	}


	public void setEmpAadhar(String empAadhar) {
		this.empAadhar = empAadhar;
	}


	public String getEmpAddress() {
		return empAddress;
	}


	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}


	public int getEmpWages() {
		return empWages;
	}


	public void setEmpWages(int empWages) {
		this.empWages = empWages;
	}


	public int getEmpTotalDays() {
		return empTotalDays;
	}


	public void setEmpTotalDays(int empTotalDays) {
		this.empTotalDays = empTotalDays;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empPassword="
				+ empPassword + ", empMobile=" + empMobile + ", empAadhar=" + empAadhar + ", empAddress=" + empAddress
				+ ", empWages=" + empWages + ", empTotalDays=" + empTotalDays + "]";
	}

	
	
	
}
