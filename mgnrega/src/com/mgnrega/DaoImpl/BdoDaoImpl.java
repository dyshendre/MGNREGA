package com.mgnrega.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.dao.BdoDao;
import com.mgnrega.exception.BdoException;
import com.mgnrega.model.Bdo;
import com.mgnrega.model.EmpProject;
import com.mgnrega.model.GPM;
import com.mgnrega.model.Project;
import com.mgnrega.utility.DBUtil;

public class BdoDaoImpl implements BdoDao{

	@Override
	public String addProject(int projId, String projName, String projDesc, int projDuration, String projStartDate) {
		String res = "------Project Not inserted. Please try again !---------";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into mgnregaProject values(?,?,?,?,?)");

			ps.setInt(1, projId);
			ps.setString(2, projName);
			ps.setNString(3, projDesc);
			ps.setInt(4, projDuration);
			ps.setString(5, projStartDate);

			int r = ps.executeUpdate();

			if (r > 0) {
				res = "************ Project created successfully..... ************";
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return res;
	}

	@Override
	public List<Project> viewListOfProject() {
		List<Project> list = new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from mgnregaProject");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int i=rs.getInt("projId"); 
				String n=rs.getString("projName"); 
				int d=rs.getInt("projDuration"); 
				String d2=rs.getString("projDesc");
				String d3=rs.getString("projStartDate");
				list.add(new Project(i,n,d,d2,d3));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public String addGPM(int gpmId,String gpmName, String gpmMobile, String gpmEmail, String gpmAddress, String gpmAadhar,
			String gpmPassword) {
		String msg = "------ Gram Panchayat Member not inserted. Try again-------";
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement(
					"insert into mgnregaGPM (gpmId,gpmName,gpmMobile,gpmEmail,gpmAddress,gpmAadhar,gpmPassword) values(?,?,?,?,?,?,?)");

			ps.setInt(1, gpmId);
			ps.setString(2, gpmName);
			ps.setString(3, gpmMobile);
			ps.setString(4, gpmEmail);
			ps.setString(5, gpmAddress);
			ps.setString(6, gpmAadhar);
			ps.setString(7, gpmPassword);

			int r = ps.executeUpdate();

			if (r > 0) {
				msg = "------ Gram Panchayat Member registered successfully-----";
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public List<GPM> viewAllGPM() {
		List<GPM> list2 = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from mgnregaGPM");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int i=rs.getInt("gpmId"); 
				String n=rs.getString("gpmName"); 
				String mb=rs.getString("gpmMobile");
				String em=rs.getString("gpmEmail"); 
				String add=rs.getString("gpmAddress");
				String aadhar=rs.getString("gpmAadhar");
				String pass=rs.getString("gpmPassword");
				list2.add(new GPM(i,n,mb,em,add,aadhar, pass));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list2;
	}

	@Override
	public String allocateProjectToGpm(int projId, int gpmId) {
		String msg = "------Not allocated. Please try again !---------";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into mgnregaGpmProject values(?,?)");

			ps.setInt(1, projId);
			ps.setInt(2, gpmId);

			int r = ps.executeUpdate();

			if (r > 0) {
				msg = "----Gram panchayat Member (" + gpmId + ") allocated to the project (" + projId
						+ ") successfully-----";
			}

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public List<EmpProject> listOfEmpOnProject(String projName) {
		List<EmpProject> list3 = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"select mp.projName, me.empName,me.empAddress,me.empMobile,me.empWages  from mgnregaEmp me inner join mgnregaProject mp inner join mgnregaEmpProject mep on mep.projId = mp.projId and mep.empId = me.empId where mp.projName = ?");
			ps.setString(1, projName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EmpProject epp = new EmpProject();

				epp.setProjName(rs.getString("projName"));
				epp.setEmpName(rs.getString("empName"));
				epp.setEmpAddress(rs.getString("empAddress"));
				epp.setEmpMobile(rs.getString("empMobile"));
//				epp.setEmpTotalDays(rs.getInt("totalDays"));
				epp.setEmpWages(rs.getInt("empWages"));

				list3.add(epp);

				System.out.println(epp);
			}

		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list3;
	}

	

	
//	@Override
//	public String registerBdo(Bdo bdo) throws BdoException {
//		String result="-----Not Inserted...-----";
//		
//		try(Connection conn=DBUtil.provideConnection()) {
//			PreparedStatement ps=conn.prepareStatement("insert into bdoProfile(name,address,email,password)values (?,?,?,?)");
//			
//			ps.setString(1, bdo.getName());
//			ps.setString(2, bdo.getAddress());
//			ps.setString(3, bdo.getEmail());
//			ps.setString(4, bdo.getPassword());
//			
//			int x=ps.executeUpdate();
//			
//			if(x>0)
//			{
//				result="-----BDO registered Successfully....-----";
//			}
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			throw new BdoException(e.getMessage());
//		}
//		return result;
//	}

//	@Override
//	public Bdo signIn(String email, String password) throws BdoException {
//		Bdo bdo=null;
//		
//		try(Connection conn=DBUtil.provideConnection()){
//			PreparedStatement ps=conn.prepareStatement("select * from bdoProfile where email=? AND password=?");
//			ps.setString(1, email);
//			ps.setString(2, password);
//			
//			
//			ResultSet rs=ps.executeQuery();
//			
//			if(rs.next())
//			{
//				int r=rs.getInt("srNum");
//				String n= rs.getString("name");
//				String a= rs.getString("address");
//				String e= rs.getString("email");
//				String p= rs.getString("password");
//				
//				bdo= new Bdo(r,n,a,e,p);
//				
//			}else
//				throw new BdoException("Invalid Username or password..");
//			
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			throw new BdoException(e.getMessage());
//		}
//		return bdo;
//	}

	

	
}
