package entities;
import java.lang.*;
public class Semester{
	private String semesterName;
	private String c1,c2,c3,c4,c5,c6;
	private double GPA_Semester;
	private double CGPA_Semester;
	private int takenCredits;
	
	public Semester(){}
	public Semester(String semesterName, String c1,String c2,String c3,String c4,String c5,String c6, double GPA_Semester, double CGPA_Semester, int takenCredits){
		this.semesterName=semesterName;
		this.c1=c1;
		this.c2=c2;
		this.c3=c3;
		this.c4=c4;
		this.c5=c5;
		this.c6=c6;
		this.GPA_Semester= GPA_Semester;
		this.CGPA_Semester=CGPA_Semester;
		this.takenCredits=takenCredits;
	}

	public void setSemesterName(String semesterName){
		this.semesterName=semesterName;
	}
	public void setCourse1(String c1){
		this.c1=c1;
	}
	public void setCourse2(String c2){
		this.c2=c2;
	}
	public void setCourse3(String c3){
		this.c3=c3;
	}
	public void setCourse4(String c4){
		this.c4=c4;
	}
	public void setCourse5(String c5){
		this.c5=c5;
	}
	public void setCourse6(String c6){
		this.c6=c6;
	}
	public void setGPA_Semester(double GPA_Semester){
		this.GPA_Semester=GPA_Semester;
	}
	public void setCGPA_Semester(double CGPA_Semester){
		this.CGPA_Semester=CGPA_Semester;
	}
	public void setTakenCredits(int takenCredits){
		this.takenCredits=takenCredits;
	}

	public String getSemesterName(){
		return semesterName;
	}
	public String getCourse1(){
		return c1;
	}
	public String getCourse2(){
		return c2;
	}
	public String getCourse3(){
		return c3;
	}

	public String getCourse4(){
		return c4;
	}
	public String getCourse5(){
		return c5;
	}
	public String getCourse6(){
		return c6;
	}
	public double getGPA_Semester(){
		return this.GPA_Semester;
	}
	public double getCGPA_Semester(){
		return this.CGPA_Semester;
	}
	public int getTakenCredits(){
		return this.takenCredits;
	}
}