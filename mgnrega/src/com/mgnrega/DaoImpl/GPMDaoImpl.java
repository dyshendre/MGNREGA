package com.mgnrega.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.model.EmpProject;
import com.mgnrega.model.Employee;
import com.mgnrega.model.GPM;
import com.mgnrega.utility.DBUtil;

public class GPMDaoImpl implements GPMDao{

	@Override
	public boolean loginAsGpm(String email, String password) {
		List<GPM> pp = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from mgnregaGPM");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int i=rs.getInt("gpmId");
				String n=rs.getString("gpmName"); 
				String mb=rs.getString("gpmMobile");
				String add=rs.getString("gpmAddress"); 
				String em=rs.getString("gpmEmail"); 
				String aadhar=rs.getString("gpmAadhar");
				String pass=rs.getString("gpmPassword");
				pp.add(new GPM(i,n,mb,add,em,aadhar,pass));
			}


			for(GPM g: pp) {
				if(g.getGpmEmail().equals(email) && g.getGpmPassword().equals(password)) {
					return true;
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}



		return false;
	}

	@Override
	public String addEmployee(int empId, String empName, String empMobile, String empPass, String empEmail,
			String empAddress, String empAadhar, int empWages, int empTotalDays) {
		String res = "------ Employee  Not inserted. Please try again !---------";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"insert into mgnregaEmp (empId,empName,empMobile,empEmail,empPass,empAddress,empAadhar,empWages,empTotalDays) values(?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, empId);
			ps.setString(2, empName);
			ps.setString(3, empMobile);
			ps.setString(4, empEmail);
			ps.setString(5, empPass);
			ps.setString(6, empAddress);
			ps.setString(7, empAadhar);
			ps.setInt(8, empWages);
			ps.setInt(9, empTotalDays);
			

			int r = ps.executeUpdate();

			if (r > 0) {
				res = "************ Employee created successfully..... ************";
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return res;
	}

	@Override
	public Employee viewEmployeeDetail(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignEmployeeToProject(int projId, int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpProject> viewTotalEmpWorkedInProject(int empId) {
		// TODO Auto-generated method stub
		return null;
	}


}
