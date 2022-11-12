package com.mgnrega.model;

public class EmpProject {
	private int empId;
	private String empName;
	private String empEmail;
	private String empMobile;
	private String empAadhar;
	private String empAddress;
	private int empWages;
	private int empTotalDays;



	private int projId;
	private String projName;
	private String projDesc;
	private int projDduration;
	private String projStartDate;
	
	public EmpProject() {
		
	}

	public EmpProject(int empId, String empName, String empEmail, String empMobile, String empAadhar, String empAddress,
			int empWages, int empTotalDays, int projId, String projName, String projDesc, int projDduration,
			String projStartDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empMobile = empMobile;
		this.empAadhar = empAadhar;
		this.empAddress = empAddress;
		this.empWages = empWages;
		this.empTotalDays = empTotalDays;
		this.projId = projId;
		this.projName = projName;
		this.projDesc = projDesc;
		this.projDduration = projDduration;
		this.projStartDate = projStartDate;
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

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjDesc() {
		return projDesc;
	}

	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}

	public int getProjDduration() {
		return projDduration;
	}

	public void setProjDduration(int projDduration) {
		this.projDduration = projDduration;
	}

	public String getProjStartDate() {
		return projStartDate;
	}

	public void setProjStartDate(String projStartDate) {
		this.projStartDate = projStartDate;
	}

	@Override
	public String toString() {
		return "EmpProject [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empMobile="
				+ empMobile + ", empAadhar=" + empAadhar + ", empAddress=" + empAddress + ", empWages=" + empWages
				+ ", empTotalDays=" + empTotalDays + ", projId=" + projId + ", projName=" + projName + ", projDesc="
				+ projDesc + ", projDduration=" + projDduration + ", projStartDate=" + projStartDate + "]";
	}

	
	
	
}
