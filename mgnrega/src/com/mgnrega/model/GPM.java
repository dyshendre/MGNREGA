package com.mgnrega.model;

public class GPM {
 private int gpmId;
 private String gpmName;
 private String gpmMobile;
 private String gpmAddress;
 private String gpmEmail;
 private String gpmAadhar;
 private String gpmPassword;
 
 public GPM() {
	 
 }

public GPM(int gpmId, String gpmName, String gpmMobile, String gpmAddress, String gpmEmail, String gpmAadhar,
		String gpmPassword) {
	super();
	this.gpmId = gpmId;
	this.gpmName = gpmName;
	this.gpmMobile = gpmMobile;
	this.gpmAddress = gpmAddress;
	this.gpmEmail = gpmEmail;
	this.gpmAadhar = gpmAadhar;
	this.gpmPassword = gpmPassword;
}

public int getGpmId() {
	return gpmId;
}

public void setGpmId(int gpmId) {
	this.gpmId = gpmId;
}

public String getGpmName() {
	return gpmName;
}

public void setGpmName(String gpmName) {
	this.gpmName = gpmName;
}

public String getGpmMobile() {
	return gpmMobile;
}

public void setGpmMobile(String gpmMobile) {
	this.gpmMobile = gpmMobile;
}

public String getGpmAddress() {
	return gpmAddress;
}

public void setGpmAddress(String gpmAddress) {
	this.gpmAddress = gpmAddress;
}

public String getGpmEmail() {
	return gpmEmail;
}

public void setGpmEmail(String gpmEmail) {
	this.gpmEmail = gpmEmail;
}

public String getGpmAadhar() {
	return gpmAadhar;
}

public void setGpmAadhar(String gpmAadhar) {
	this.gpmAadhar = gpmAadhar;
}

public String getGpmPassword() {
	return gpmPassword;
}

public void setGpmPassword(String gpmPassword) {
	this.gpmPassword = gpmPassword;
}

@Override
public String toString() {
	return "GPM [gpmId=" + gpmId + ", gpmName=" + gpmName + ", gpmMobile=" + gpmMobile + ", gpmAddress=" + gpmAddress
			+ ", gpmEmail=" + gpmEmail + ", gpmAadhar=" + gpmAadhar + ", gpmPassword=" + gpmPassword + "]";
}
 
}
