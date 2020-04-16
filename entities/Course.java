package entities;
import java.lang.*;
public class Course{
	private String courseName;
	private double midTermMarks;
	private double finalTermMarks;
	private double finalMarks;
	private String courseType;
	private String semesterName;

	private String finalGrade;
	private String midTermGrade;
	private String finalTermGrade;
	private double finalPoint;
	private int courseCredit;

	public Course(){}
	public Course(String courseName, double midTermMarks, double finalTermMarks,double finalMarks, String courseType, String semesterName){
		this.courseName = courseName;
		this.midTermMarks = midTermMarks;
		this.finalTermMarks = finalTermMarks;
		this.finalMarks=finalMarks;
		this.courseType = courseType;
		this.semesterName = semesterName;
		setMidTermGrade();
		setFinalTermGrade();
		setCourseCredit();
	}

	public void setCourseName(String courseName){
		this.courseName=courseName;
	}
	public void setMidTermMarks(double midTermMarks){
		this.midTermMarks=midTermMarks;
		setMidTermGrade();
	}
	public void setFinalTermMarks(double finalTermMarks){
		this.finalTermMarks=finalTermMarks;
		setFinalTermGrade();
	}
	public void setFinalMarks(double finalMarks){
		this.finalMarks=finalMarks;
	}
	public void setCourseType(String courseType){
		this.courseType=courseType;
		setCourseCredit();
	}
	public void setSemesterName(String semesterName){
		this.semesterName=semesterName;
	}

	public String getCourseName(){
		return this.courseName;
	}
	public double getMidTermMarks(){
		return this.midTermMarks;
	}
	public double getFinalTermMarks(){
		return this.finalTermMarks;
	}
	public double getFinalMarks(){
		return this.finalMarks;
	}
	public String getCourseType(){
		return this.courseType;
	}
	public String getSemesterName(){
		return this.semesterName;
	}

	public String getFinalGrade(){
		if(this.finalMarks<50){
			this.finalGrade="F";
		}
		else if(this.finalMarks>=50 && this.finalMarks<=59){
			this.finalGrade="D";
		}
		else if(this.finalMarks>=60 && this.finalMarks<=64){
			this.finalGrade="D+";
		}
		else if(this.finalMarks>=65 && this.finalMarks<=69){
			this.finalGrade="C";
		}
		else if(this.finalMarks>=70 && this.finalMarks<=74){
			this.finalGrade="C+";
		}
		else if(this.finalMarks>=75 && this.finalMarks<=79){
			this.finalGrade="B";
		}
		else if(this.finalMarks>=80 && this.finalMarks<=84){
			this.finalGrade="B+";
		}
		else if(this.finalMarks>=85 && this.finalMarks<=89){
			this.finalGrade="A";
		}
		else if(this.finalMarks>=90 && this.finalMarks<=100){
			this.finalGrade="A+";
		}
		else
		{

		}
		return this.finalGrade;
	}
	public double getFinalPoint(){
		if(this.finalMarks<50){
			this.finalPoint=0;
		}
		else if(this.finalMarks>=50 && finalMarks<=59){
			if(this.courseType.equals("Theory") || this.courseType=="Theory"){
				this.finalPoint=(3*2.25);
			}
			else if(this.courseType.equals("Lab") || this.courseType=="Lab"){
				this.finalPoint=(1*2.25);
			}
			else{

			}
		}
		else if(this.finalMarks>=60 && finalMarks<=64){
			if(this.courseType.equals("Theory") || this.courseType=="Theory"){
				this.finalPoint=(3*2.50);
			}
			else if(this.courseType.equals("Lab") || this.courseType=="Lab"){
				this.finalPoint=(1*2.50);
			}
			else{

			}
		}
		else if(this.finalMarks>=65 && finalMarks<=69){
			if(this.courseType.equals("Theory") || this.courseType=="Theory"){
				this.finalPoint=(3*2.75);
			}
			else if(this.courseType.equals("Lab") || this.courseType=="Lab"){
				this.finalPoint=(1*2.75);
			}
			else{

			}
		}
		else if(this.finalMarks>=70 && finalMarks<=74){
			if(this.courseType.equals("Theory") || this.courseType=="Theory"){
				this.finalPoint=(3*3.0);
			}
			else if(this.courseType.equals("Lab") || this.courseType=="Lab"){
				this.finalPoint=(1*3.0);
			}
			else{

			}
		}
		else if(this.finalMarks>=75 && finalMarks<=79){
			if(this.courseType.equals("Theory") || this.courseType=="Theory"){
				this.finalPoint=(3*3.25);
			}
			else if(this.courseType.equals("Lab") || this.courseType=="Lab"){
				this.finalPoint=(1*3.25);
			}
			else{

			}
		}
		else if(this.finalMarks>=80 && finalMarks<=84){
			if(this.courseType.equals("Theory") || this.courseType=="Theory"){
				this.finalPoint=(3*3.50);
			}
			else if(this.courseType.equals("Lab") || this.courseType=="Lab"){
				this.finalPoint=(1*3.50);
			}
			else{

			}
		}
		else if(this.finalMarks>=85 && finalMarks<=89){
			if(this.courseType.equals("Theory") || this.courseType=="Theory"){
				this.finalPoint=(3*3.75);
			}
			else if(this.courseType.equals("Lab") || this.courseType=="Lab"){
				this.finalPoint=(1*3.75);
			}
			else{

			}
		}
		else if(this.finalMarks>=90 && finalMarks<=100){
			if(this.courseType.equals("Theory") || this.courseType=="Theory"){
				this.finalPoint=(3*4);
			}
			else if(this.courseType.equals("Lab") || this.courseType=="Lab"){
				this.finalPoint=(1*4);
			}
			else{
				
			}
		}
		return this.finalPoint;
	}

	public void setMidTermGrade(){
		if(this.midTermMarks<50){
			this.midTermGrade="F";
		}
		else if(this.midTermMarks>=50 && this.midTermMarks<=59){
			this.midTermGrade="D";
		}
		else if(this.midTermMarks>=60 && this.midTermMarks<=64){
			this.midTermGrade="D+";
		}
		else if(this.midTermMarks>=65 && this.midTermMarks<=69){
			this.midTermGrade="C";
		}
		else if(this.midTermMarks>=70 && this.midTermMarks<=74){
			this.midTermGrade="C+";
		}
		else if(this.midTermMarks>=75 && this.midTermMarks<=79){
			this.midTermGrade="B";
		}
		else if(this.midTermMarks>=80 && this.midTermMarks<=84){
			this.midTermGrade="B+";
		}
		else if(this.midTermMarks>=85 && this.midTermMarks<=89){
			this.midTermGrade="A";
		}
		else if(this.midTermMarks>=90 && this.midTermMarks<=100){
			this.midTermGrade="A+";
		}
	}
	public void setFinalTermGrade(){
		if(this.finalTermMarks<50){
			this.finalTermGrade="F";
		}
		else if(this.finalTermMarks>=50 && this.finalTermMarks<=59){
			this.finalTermGrade="D";
		}
		else if(this.finalTermMarks>=60 && this.finalTermMarks<=64){
			this.finalTermGrade="D+";
		}
		else if(this.finalTermMarks>=65 && this.finalTermMarks<=69){
			this.finalTermGrade="C";
		}
		else if(this.finalTermMarks>=70 && this.finalTermMarks<=74){
			this.finalTermGrade="C+";
		}
		else if(this.finalTermMarks>=75 && this.finalTermMarks<=79){
			this.finalTermGrade="B";
		}
		else if(this.finalTermMarks>=80 && this.finalTermMarks<=84){
			this.finalTermGrade="B+";
		}
		else if(this.finalTermMarks>=85 && this.finalTermMarks<=89){
			this.finalTermGrade="A";
		}
		else if(this.finalTermMarks>=90 && this.finalTermMarks<=100){
			this.finalTermGrade="A+";
		}
	}

	public void setCourseCredit(){
		if(this.courseType.equals("Theory") || this.courseType=="Theory"){
			this.courseCredit=3;
		}
		else if(this.courseType.equals("Lab") || this.courseType=="Lab"){
			this.courseCredit=1;
		}
	}
	public int getCourseCredit(){
		return this.courseCredit;
	}

/*	public double getFinalPoint(){
		return this.finalPoint;
	}
	*/
}
