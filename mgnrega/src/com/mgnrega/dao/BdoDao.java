package com.mgnrega.dao;
import java.util.List;
import com.mgnrega.model.*;
import com.mgnrega.model.Bdo;

public interface BdoDao {
//	public String registerBdo(Bdo bdo)throws BdoException;
	
//	public Bdo signIn(String email,String password)throws BdoException;
	
	public String addProject(int projId, String projName, String projDesc, int projDuration, String projStartDate) ;

	public List<Project> viewListOfProject();

	public String addGPM(int gpmId,String gpmName, String gpmMobile, String gpmEmail, String gpmAddress, String gpmAadhar, String gpmPassword);

	public List<GPM> viewAllGPM();

	public String allocateProjectToGpm(int projId, int gpmId);

	public List<EmpProject> listOfEmpOnProject(String projName);
}
