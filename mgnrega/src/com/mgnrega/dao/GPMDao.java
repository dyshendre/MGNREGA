package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.model.*;


public interface GPMDao {
	public boolean loginAsGpm(String email,String password);

	public String addEmployee(int empId,String empName, String empEmail, String empPass,  String empMobile,String empAddress, String empAadhar,
			int empWages, int empTotalDays);

	public Employee viewEmployeeDetail(String empName);

	public String assignEmployeeToProject(int projId, int empId);

	public List<EmpProject> viewTotalEmpWorkedInProject(int empId);
}
