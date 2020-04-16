package repositories;

import java.sql.*;
import entities.*;
import java.lang.*;
import java.util.ArrayList;

public class SemesterRepo 
{
	DatabaseConnection dbc;
	
	public SemesterRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertSemester(Semester s)
	{
		String query = "INSERT INTO semesterdb VALUES ('"+s.getSemesterName()+"','"+s.getCourse1()+"','"+s.getCourse2()+"','"+s.getCourse3()+"','"+s.getCourse4()+"','"+s.getCourse5()+"','"+s.getCourse6()+"','"+s.getGPA_Semester()+"','"+s.getCGPA_Semester()+"',"+s.getTakenCredits()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println("Invalid Semester Insertion Exception");
			System.out.println(ex.getMessage());
		}
	}

	public void deleteSemester(String s){
		String query = "DELETE FROM semesterdb WHERE semesterName='"+s+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	public void updateSemester(Semester s){
		String query="UPDATE semesterdb SET c1='"+s.getCourse1()+"',c2='"+s.getCourse2()+"',c3='"+s.getCourse3()+"',c4='"+s.getCourse4()+"',c5='"+s.getCourse5()+"',c6='"+s.getCourse6()+"',GPA_Semester='"+s.getGPA_Semester()+"',CGPA_Semester='"+s.getCGPA_Semester()+"',takenCredits="+s.getTakenCredits()+" WHERE semesterName='"+s.getSemesterName()+"';";
		try{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	public Semester searchSemester(String semesterName){
		Semester sem=null;
		String query = "SELECT * FROM semesterdb WHERE semesterName='"+semesterName+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			while(dbc.result.next()){
				sem = new Semester();
				String semName = dbc.result.getString("semesterName");
				String course1 = dbc.result.getString("c1");
				String course2 = dbc.result.getString("c2");
				String course3 = dbc.result.getString("c3");
				String course4 = dbc.result.getString("c4");
				String course5 = dbc.result.getString("c5");
				String course6 = dbc.result.getString("c6");
				double GPA = dbc.result.getDouble("GPA_Semester");
				double CGPA = dbc.result.getDouble("CGPA_Semester");
				int takenCredits = dbc.result.getInt("takenCredits");

 				sem.setSemesterName(semName);
				sem.setCourse1(course1);
				sem.setCourse2(course2);
				sem.setCourse3(course3);
				sem.setCourse4(course4);
				sem.setCourse5(course5);
				sem.setCourse6(course6);
				sem.setGPA_Semester(GPA);
				sem.setCGPA_Semester(CGPA);
				sem.setTakenCredits(takenCredits);
			}
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		dbc.closeConnection();
		return sem; 
	}
	public String[] getCurrentSemesterNames(){
		String query = "SELECT semesterName FROM semesterdb";
		ArrayList<String> semesterNameList = new ArrayList<String>();
		
		try{
			dbc.openConnection();
			dbc.result=dbc.st.executeQuery(query);
			while(dbc.result.next()){
				String semName = dbc.result.getString("semesterName");
				semesterNameList.add(semName);
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		String[] semesterNameArray = new String[semesterNameList.size()];
		semesterNameList.toArray(semesterNameArray);
		return semesterNameArray;
	}

	public double getCurrentSemesterGPA(String s){
		double gpa=0;
		String query = "SELECT GPA_Semester FROM semesterdb WHERE semesterName='"+s+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			while(dbc.result.next()){
				double GPA = dbc.result.getDouble("GPA_Semester");
				gpa=GPA;
			}
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return gpa;
	}

	public double getCurrentSemesterCGPA(String s){
		double gpa=0;
		String query = "SELECT CGPA_Semester FROM semesterdb WHERE semesterName='"+s+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			while(dbc.result.next()){
				double CGPA = dbc.result.getDouble("CGPA_Semester");
				gpa=CGPA;
			}
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return gpa;
	}
}
