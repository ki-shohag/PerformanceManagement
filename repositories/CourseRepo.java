package repositories;

import java.sql.*;
import entities.*;
import java.lang.*;
import java.util.ArrayList;

public class CourseRepo
{
	DatabaseConnection dbc;
	
	public CourseRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertCourse(Course c)
	{
		String query = "INSERT INTO coursedb VALUES ('"+c.getCourseName()+"','"+c.getMidTermMarks()+"','"+c.getFinalTermMarks()+"','"+c.getFinalMarks()+"','"+c.getCourseType()+"','"+c.getSemesterName()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println("Invalid Course INSERT Exception");
			System.out.println(ex.getMessage());
		}
	}
	public void deleteCourse(String c){
		String query = "DELETE FROM coursedb WHERE courseName='"+c+"';";
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
	public void updateCourse(Course c){
		String query = "UPDATE coursedb SET midTermMarks='"+c.getMidTermMarks()+"', finalTermMarks='"+c.getFinalTermMarks()+"', finalMarks='"+c.getFinalMarks()+"', courseType='"+c.getCourseType()+"', semesterName='"+c.getSemesterName()+"' WHERE courseName='"+c.getCourseName()+"'";
		try{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	public Course searchCourse(String courseName){
		Course c = null;
		String query = "SELECT * FROM coursedb WHERE courseName='"+courseName+"';";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			while(dbc.result.next()){
				c = new Course();
				String CorsName = dbc.result.getString("courseName");
				double midTermMarks = dbc.result.getDouble("midTermMarks");
				double finalTermMarks = dbc.result.getDouble("finalTermMarks");
				double finalMarks = dbc.result.getDouble("finalMarks");
				String courseType  = dbc.result.getString("courseType");
				String semName = dbc.result.getString("semesterName");

				c.setCourseName(CorsName);
				c.setMidTermMarks(midTermMarks);
				c.setFinalTermMarks(finalTermMarks);
				c.setFinalMarks(finalMarks);
				c.setCourseType(courseType);
				c.setSemesterName(semName);
			}
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return c; 
	}
	public int getTotalCreditsCompleted(){
		ArrayList<String> ar = new ArrayList<String>();
		String query = "SELECT courseType FROM coursedb";
		try{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			while(dbc.result.next()){
				String type = dbc.result.getString("courseType");

				ar.add(type);
			}
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		int value=0;
		for(int i=0; i<ar.size(); i++){
			if(ar.get(i).equals("Theory")){
				value+=3;
			}
			else{
				value+=1;
			}
		}
		return value;
	}
	public double getTotalPointsCompleted(){
		ArrayList<Double> ar = new ArrayList<>();
		ArrayList<String> tr  = new ArrayList<String>();
		String query = "SELECT finalMarks,courseType FROM coursedb";
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			while(dbc.result.next()){
				double finalMark = dbc.result.getDouble("finalMarks");
				String type = dbc.result.getString("courseType");
				ar.add(finalMark);
				tr.add(type);
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		double value=0;
		for(int i=0; i<ar.size(); i++){
			if(ar.get(i)<50){
			value+=0;
			}
			else if(ar.get(i)>=50 && ar.get(i)<=59){
				if(tr.get(i).equals("Theory") || tr.get(i)=="Theory"){
					value+=(3*2.25);
				}
				else if(tr.get(i).equals("Lab") || tr.get(i)=="Lab"){
					value+=(1*2.25);
				}
				else{

				}
			}
			else if(ar.get(i)>=60 && ar.get(i)<=64){
				if(tr.get(i).equals("Theory") || tr.get(i)=="Theory"){
					value+=(3*2.50);
				}
				else if(tr.get(i).equals("Lab") || tr.get(i)=="Lab"){
					value+=(1*2.50);
				}
				else{

				}
			}
			else if(ar.get(i)>=65 && ar.get(i)<=69){
				if(tr.get(i).equals("Theory") || tr.get(i)=="Theory"){
					value+=(3*2.75);
				}
				else if(tr.get(i).equals("Lab") || tr.get(i)=="Lab"){
					value+=(1*2.75);
				}
				else{

				}
			}
			else if(ar.get(i)>=70 && ar.get(i)<=74){
				if(tr.get(i).equals("Theory") || tr.get(i)=="Theory"){
					value+=(3*3.0);
				}
				else if(tr.get(i).equals("Lab") || tr.get(i)=="Lab"){
					value+=(1*3.0);
				}
				else{

				}
			}
			else if(ar.get(i)>=75 && ar.get(i)<=79){
				if(tr.get(i).equals("Theory") || tr.get(i)=="Theory"){
					value+=(3*3.25);
				}
				else if(tr.get(i).equals("Lab") || tr.get(i)=="Lab"){
					value+=(1*3.25);
				}
				else{

				}
			}
			else if(ar.get(i)>=80 && ar.get(i)<=84){
				if(tr.get(i).equals("Theory") || tr.get(i)=="Theory"){
					value+=(3*3.50);
				}
				else if(tr.get(i).equals("Lab") || tr.get(i)=="Lab"){
					value+=(1*3.50);
				}
				else{

				}
			}
			else if(ar.get(i)>=85 && ar.get(i)<=89){
				if(tr.get(i).equals("Theory") || tr.get(i)=="Theory"){
					value+=(3*3.75);
				}
				else if(tr.get(i).equals("Lab") || tr.get(i)=="Lab"){
					value+=(1*3.75);
				}
				else{

				}
			}
			else if(ar.get(i)>=90 && ar.get(i)<=100){
				if(tr.get(i).equals("Theory") || tr.get(i)=="Theory"){
					value+=(3*4);
				}
				else if(tr.get(i).equals("Lab") || tr.get(i)=="Lab"){
					value+=(1*4);
				}
				else{
					
				}
			}
		}
		return value;
	}

	public Course[] getBestPerformanceList(){
		Course c=null;
		String query = "SELECT * FROM coursedb ORDER BY finalMarks DESC ";
		ArrayList<Course> bestPerformanceList = new ArrayList<Course>();
		
		try{
			dbc.openConnection();
			dbc.result=dbc.st.executeQuery(query);
			while(dbc.result.next()){
				c = new Course();
				String courseName = dbc.result.getString("courseName");
				double midTermMarks = dbc.result.getDouble("midTermMarks");
				double finalTermMarks = dbc.result.getDouble("finalTermMarks");
				double finalMarks = dbc.result.getDouble("finalMarks");
				String courseType  = dbc.result.getString("courseType");
				String semName = dbc.result.getString("semesterName");

				c.setCourseName(courseName);
				c.setMidTermMarks(midTermMarks);
				c.setFinalTermMarks(finalTermMarks);
				c.setFinalMarks(finalMarks);
				c.setCourseType(courseType);
				c.setSemesterName(semName);

				bestPerformanceList.add(c);
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		Course[] bestPerformanceArray = new Course[bestPerformanceList.size()];
		bestPerformanceList.toArray(bestPerformanceArray);
		return bestPerformanceArray;
	}

	public int getCoursesCompleted(){
		int coursesCompleted=0;
		String query = "SELECT COUNT(*) from coursedb";
		try
		{
			dbc.openConnection();
			dbc.result= dbc.st.executeQuery(query);
			while(dbc.result.next()){
				coursesCompleted = dbc.result.getInt(1);
			}
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return coursesCompleted;
	}


	public int getGradeCounter(int x , int y){
		int count=0;
		String query = "SELECT COUNT(courseName) FROM coursedb WHERE finalMarks BETWEEN "+x+" and "+y+";";
		try
		{
			dbc.openConnection();
			dbc.result= dbc.st.executeQuery(query);
			while(dbc.result.next()){
				count = dbc.result.getInt(1);
			}
			dbc.closeConnection();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return count;
	}

}