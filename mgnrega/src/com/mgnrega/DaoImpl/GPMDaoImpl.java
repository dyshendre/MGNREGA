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
	public String addEmployee(int empId,String empName, String empEmail, String empPass, String empMobile, String empAddress,
			String empAadhar, int empWages, int empTotalDays) {
		String res = "------ Employee not inserted. Please try again---------";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"insert into mgnregaEmp (empId,empName,empEmail,empPass,empMobile,empAddress,empAadhar,empWages,empTotalDays) values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, empId);
			ps.setString(2, empName);	
			ps.setString(3, empEmail);
			ps.setString(4, empPass);
			ps.setString(5, empMobile);
			ps.setString(6, empAddress);
			ps.setString(7, empAadhar);
			ps.setInt(8, empWages);
			ps.setInt(9, empTotalDays);
			

			int r = ps.executeUpdate();

			if (r > 0) {
				res = "-------------- Employee created successfully----------";
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return res;
	}


	

	@Override
	public Employee viewEmployeeDetail(String empName) {
		Employee em = null;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(" select * from mgnregaEmp where empName = ?");

			ps.setString(1, empName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int i = rs.getInt("empId");
				String n = rs.getString("empName");
				String e = rs.getString("empemail");
				String p = rs.getString("empPass");
				String m = rs.getString("empMobile");
				
				String a = rs.getString("empAddress");
				String ad = rs.getString("empAadhar");
				int w = rs.getInt("empWages");
				int td = rs.getInt("empTotalDays");
				

				em = new Employee(i,n,e,p,m,a,ad,w,td);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return em;
	}

	@Override
	public String assignEmployeeToProject(int projId, int empId) {
		String res = "------ Not allocated. Please try again !---------";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into mgnregaEmpProject values(?,?)");

			ps.setInt(1, projId);
			ps.setInt(2, empId);

			int r = ps.executeUpdate();

			if (r > 0) {
				res = "**** Employee (" + empId + ") allocated to the project (" + projId + ") successfully...*** ";
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return res;
	}

	@Override
	public List<EmpProject> viewTotalEmpWorkedInProject(int empId) {
		List<EmpProject> list4 = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"select e.empId ,e.empName,e.empTotalDays,e.empTotalDays*e.empWages TotalWages,p.projName,p.projId from mgnregaEmp e inner join mgnregaProject p inner join mgnregaEmpProject mep on mep.projId=p.projid and mep.empId=e.empId where e.empId=?");

			ps.setInt(1, empId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				EmpProject em = new EmpProject();

				em.setEmpId(rs.getInt("empId"));
				em.setEmpName(rs.getString("empName"));
				em.setEmpTotalDays(rs.getInt("empTotalDays"));
				em.setEmpWages(rs.getInt("TotalWages"));
				em.setProjName(rs.getString("projName"));
				em.setProjId(rs.getInt("projId"));

				list4.add(em);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list4;

	}




	



}
