package com.mgnrega.usecases;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mgnrega.DaoImpl.*;
import com.mgnrega.dao.*;
import com.mgnrega.model.*;

public class App {
	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter email: ");
//		String name=sc.next();
//		
//		System.out.println("Enter password: ");
//		String password=sc.next();
//		
//		BdoDao dao=new BdoDaoImpl();
//		
//		try {
//		 	Bdo bdo= dao.signIn(name, password);
//			
//		 	System.out.println("Welcome "+bdo.getName());
//		 	
//		 		
//		 	
//			}catch (BdoException e) {
//				System.out.println(e.getMessage());
//			}
			
		Scanner sc = new Scanner(System.in);
		try {

			BdoDaoImpl obj1 = new BdoDaoImpl();
			GPMDaoImpl obj2 = new GPMDaoImpl();
			String choice = "";

			System.out.println("-----Welcome to MGNREGA App-------");
			System.out.println();
			System.out.println();

			System.out.println("Press 1 for Login as a BDO.");
			System.out.println("Press 2 for Login as a GPM.");

			String x = sc.next();

			if (x.equals("1")) {
				System.out.println("Enter designation: ");
				String username = sc.next();
				System.out.println("Enter password: ");
				String password = sc.next();

				if (username.equalsIgnoreCase("BDO") && password.equalsIgnoreCase("12345")) 
				{
					choice = "1";
				} 
				else 
				{
					System.out.println("Incorrect username or password.");
				}
			} 
			else if (x.equals("2")) {

				System.out.println("Enter Email Id Of GPM: ");
				String username = sc.next();
				System.out.println("Enter Password: ");
				String password = sc.next();

				if (obj2.loginAsGpm(username, password)) {
					choice = "2";
				} else {
					System.out.println("Incorrect Username OR Password.....");
				}
			}
			
			
			if (choice.equals("1")) {

				while (true) {

					System.out.println("\n Press 1 to Create a project");
					System.out.println("\n press 2 to View List Of project");
					System.out.println("\n prees 3 to Creating Gram Panchayat Member");
					System.out.println("\n press 4 to View all GPM's");
					System.out.println("\n press 5 to Allocate project to GPM's");
					System.out.println("\n Press 6 to List of Employee working on that Project and their wages.");
					System.out.println("\n press 0 to Exit");

					int bd = sc.nextInt();

					if (bd == 1) {
						try {
							System.out.println("Enter project ID :");
							int projId = sc.nextInt();

							System.out.println("Enter project Name :");
							sc.nextLine();
							String projName = sc.nextLine();

							System.out.println("Enter the project description :");
							String projDesc = sc.nextLine();

							System.out.println("Enter the project duration (Number of months) :");
							int projDuration = sc.nextInt();

							System.out.println("Enter the project starting date in the form of yyyy-mm-dd :");
							String projStartDate = sc.next();

							System.out.println();
							System.out.println();
							System.out.println("<------------------------------------------------------->");
							System.out.println(obj1.addProject(projId, projName, projDesc, projDuration, projStartDate));
							System.out.println("<------------------------------------------------------->");
							System.out.println();
							System.out.println();

						} catch (InputMismatchException e) {
							System.out.println("<------------------------------------------------------->");
							System.out.println("-------------------Please Enter Valid Data---------------");
							System.out.println("<------------------------------------------------------->");
							break;
						}

					} 
					
					else if (bd == 2) {

						List<Project> pp = obj1.viewListOfProject();

						for (Project p : pp) {
							System.out.println("<------------------------------------------------------->");
							System.out.println("Project Id is            : " + p.getProjId());
							System.out.println("Project name is          : " + p.getProjName());
							System.out.println("Project description is   : " + p.getProjDesc());
							System.out.println("Project duration is      : " + p.getProjDuration());
							System.out.println("Project starting date is : " + p.getProjStartDate());
							System.out.println("<------------------------------------------------------->");
						}
					
					}
					 else if (bd == 3) {
							try {
								System.out.println("Enter GPM Id :");
								int gpmId = sc.nextInt();
								
								System.out.println("Enter GPM name :");
								String gpmName = sc.next();

								System.out.println("Enter the GPM Mobile :");
								String gpmMobile = sc.next();

								System.out.println("Enter the GPM email address :");
								String gpmEmail = sc.next();

								System.out.println("Enter the village name :");
								String gpmAddress = sc.next();

								System.out.println("Enter the GPM aadhar no. :");
								String gpmAadhar = sc.next();

								System.out.println("Enter the GPM password :");
								String gpmPassword = sc.next();


								System.out.println("<------------------------------------------------------->");
								System.out.println(obj1.addGPM(gpmId,gpmName, gpmMobile, gpmEmail, gpmAddress, gpmAadhar, gpmPassword));
								System.out.println("<------------------------------------------------------->");


							} catch (InputMismatchException e) {
								System.out.println("<------------------------------------------------------->");
								System.out.println("-------------------Please Enter Valid Data---------------");
								System.out.println("<------------------------------------------------------->");
								break;
							}
						} 
					
					 else if (bd == 4) {

							List<GPM> gg = obj1.viewAllGPM();

							for (GPM g : gg) {
								System.out.println("<------------------------------------------------------->");
								System.out.println("GPM Id is           : " + g.getGpmId());
								System.out.println("GPM name is         : " + g.getGpmName());
								System.out.println("GPM Mobile no  is   : " + g.getGpmMobile());
								System.out.println("GPM email  is       : " + g.getGpmEmail());
								System.out.println("GPM village name is : " + g.getGpmAddress());
								System.out.println("GPM Aadhar no is    : " + g.getGpmAadhar());
								System.out.println("GPM Password is    : " + g.getGpmPassword());
								System.out.println("<------------------------------------------------------->");

							}
					 }
					
					 else if (bd == 5) {
							try {
								System.out.println("\n Enter the project Id in which you want to Allocate the GPM :");
								int projId = sc.nextInt();

								System.out.println("\n Enter the GPM Id whom you want to Allocate in the above project :");
								int gpmId = sc.nextInt();

								System.out.println("<------------------------------------------------------->");
								System.out.println(obj1.allocateProjectToGpm(projId, gpmId));
								System.out.println("<------------------------------------------------------->");

							} catch (InputMismatchException e) {
								System.out.println("<------------------------------------------------------->");
								System.out.println("-------------------Please Enter Valid Data---------------");
								System.out.println("<------------------------------------------------------->");
								break;
							}
					 }
					 else if (bd == 6) {

							System.out.println("\n Enter Project Name to View total number of days Employee worked in a project and also their wages. ");

							String proj = sc.nextLine();
							sc.nextLine();

							List<EmpProject> ep = obj1.listOfEmpOnProject(proj);
							for (EmpProject em : ep) {
								System.out.println("<------------------------------------------------------->");
								System.out.println("Project name is            : " + em.getProjName());
								
								System.out.println("Employee name is           : " + em.getEmpName());
								System.out.println("Employee name is           : " + em.getEmpEmail());
								System.out.println("Employee address is        : " + em.getEmpAddress());
								System.out.println("Employee mobile is         : " + em.getEmpMobile());
								System.out.println("Total days employee worked : " + em.getEmpTotalDays());
								System.out.println("Employee wages is          : " + em.getEmpWages());
								System.out.println("<------------------------------------------------------->");

							}

						} else if (bd == 0) {
							System.out.println("<---------------\n Thanks for visting.------------------->");
							break;
						} else {
							System.out.println("<------------------------------------------------------->");
							System.out.println("-----------------------Invalid choice--------------------");
							System.out.println("<------------------------------------------------------->");
						}

					

				}//while
				
			}//global if
			 else if (choice.equals("2")) {
			
				 while (true) {

						System.out.println("\n Press 1 for create a Employee");
						System.out.println("\n press 2 for View the details of employee");
						System.out.println("\n prees 3 for Assign employee to a project");
						System.out.println("\n press 4 for View total number of days Employee worked in a project and also their wages.");
						System.out.println("\n press 0 for Exit");

						int num = sc.nextInt();

						if (num == 1) 
						{
							try {
								System.out.println("Enter Employee's Id :");
								sc.nextLine();
								int id = sc.nextInt();
								
								System.out.println("Enter Employee's Name :");
								String name = sc.nextLine();

								System.out.println("Enter Employee's email :");
								String email = sc.nextLine();
								
								System.out.println("Enter Employee's password :");
								String pass = sc.nextLine();
								
								System.out.println("Enter Employee's Mobile :");
								String mobile = sc.nextLine();

								System.out.println("Enter Employee's Address :");
								String address = sc.nextLine();

								System.out.println("Enter Employee's Aadhar no. :");
								String aadhar = sc.nextLine();

								System.out.println("Enter Employee's Daily Wages :");
								int empwages = sc.nextInt();

								System.out.println("Enter total number of days Employee worked :");
								int totalDays = sc.nextInt();

								

								System.out.println(obj2.addEmployee(id,name, email,pass, mobile,address, aadhar, empwages,
										totalDays));

							} catch (InputMismatchException e) {
								System.out.println("<------------------------------------------------------->");
								System.out.println("-----------------------Invalid choice--------------------");
								System.out.println("<------------------------------------------------------->");
								break;
							}
							
						}//if
						else if (num == 2) {

							System.out.println("Enter the name of employee to see details of employee...");
							String name = sc.next();
							Employee em = obj2.viewEmployeeDetail(name);
							
							System.out.println("<------------------------------------------------------->");
							System.out.println(" The Employee ID is             : " + em.getEmpId());
							System.out.println(" The Employee Name is           : " + em.getEmpName());
							System.out.println(" The Employee Email is          : " + em.getEmpEmail());
							System.out.println(" The Employee Password is       : " + em.getEmpPassword());
							System.out.println(" The Employee Mobile no.is      : " + em.getEmpMobile());
							System.out.println(" The Employee Address is        : " + em.getEmpAddress());
							System.out.println(" The Employee Aadhar Number is  : " + em.getEmpAadhar());
							System.out.println(" The Employee Wages is          : " + em.getEmpWages());
							System.out.println(" The Total Days Employee Worked : " + em.getEmpTotalDays());
							
							System.out.println("<------------------------------------------------------->");

						}
			
				 }//while
			
			 }//else if
		}//try
		catch (InputMismatchException e) {
			System.out.println("<------------------------------------------------------->");
			System.out.println("-----------------------Invalid choice--------------------");
			System.out.println("<------------------------------------------------------->");
		}
	
		
	}
}
