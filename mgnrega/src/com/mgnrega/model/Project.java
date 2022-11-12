package com.mgnrega.model;

public class Project {
	private int projId;
	private String projName;
	private int projDuration;
	private String projDesc;
	private String projStartDate;
	
	public Project() {
		
	}

	public Project(int projId, String projName, int projDuration, String projDesc, String projStartDate) {
		super();
		this.projId = projId;
		this.projName = projName;
		this.projDuration = projDuration;
		this.projDesc = projDesc;
		this.projStartDate = projStartDate;
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

	public int getProjDuration() {
		return projDuration;
	}

	public void setProjDuration(int projDuration) {
		this.projDuration = projDuration;
	}

	public String getProjDesc() {
		return projDesc;
	}

	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}

	public String getProjStartDate() {
		return projStartDate;
	}

	public void setProjStartDate(String projStartDate) {
		this.projStartDate = projStartDate;
	}

	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", projDuration=" + projDuration + ", projDesc="
				+ projDesc + ", projStartDate=" + projStartDate + "]";
	}
	
}
