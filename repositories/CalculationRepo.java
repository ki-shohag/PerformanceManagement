package repositories;

import java.sql.*;
import entities.*;
import java.lang.*;
import java.util.ArrayList;

import entities.*;

public class CalculationRepo{
	public CalculationRepo(){}
	
	public double getGPACalculation(Course[] courseArray){
		double totalSemesterPoints=0;
		int totalSemesterCredits=0;
		for(int i=0; i<courseArray.length; i++){
			totalSemesterPoints+=courseArray[i].getFinalPoint();
			totalSemesterCredits+=courseArray[i].getCourseCredit();
		}
		double gpa = (totalSemesterPoints/totalSemesterCredits);
		return gpa;
	}
	public int getCreditsInSemester(Course[] courseArray){
		int takenCredits=0;
		for(int i=0; i<courseArray.length; i++){
			takenCredits+=courseArray[i].getCourseCredit();
		}
		return takenCredits;
	}
	public double getCGPACalculation(){
		CourseRepo cr = new CourseRepo();

		int totalCredits = cr.getTotalCreditsCompleted();
		double totalPoints = cr.getTotalPointsCompleted();
		return (totalPoints/totalCredits
			);
	}
}