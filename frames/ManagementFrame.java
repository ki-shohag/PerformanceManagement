package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;


import repositories.*;
import entities.*;



public class ManagementFrame extends JFrame implements ActionListener{
	private JPanel panel;

	public SemesterRepo sr;
	public CourseRepo cr;
	public CalculationRepo cal;

	private JLabel titleLabel,msgLabel, semesterLabel ,dataLabel,midGPALabel,cgpaLabel,semesterGPALabel,
	courseLabel1, courseNameLabel1, courseMidMarksLabel1, courseMidGradeLabel1, courseFinalMarks1, courseFinalGrade1 ,courseType1,
	courseLabel2, courseNameLabel2, courseMidMarksLabel2, courseMidGradeLabel2, courseFinalMarks2, courseFinalGrade2 ,courseType2,
	courseLabel3, courseNameLabel3, courseMidMarksLabel3, courseMidGradeLabel3, courseFinalMarks3, courseFinalGrade3 ,courseType3,
	courseLabel4, courseNameLabel4, courseMidMarksLabel4, courseMidGradeLabel4, courseFinalMarks4, courseFinalGrade4 ,courseType4,
	courseLabel5, courseNameLabel5, courseMidMarksLabel5, courseMidGradeLabel5, courseFinalMarks5, courseFinalGrade5 ,courseType5,
	courseLabel6, courseNameLabel6, courseMidMarksLabel6, courseMidGradeLabel6, courseFinalMarks6, courseFinalGrade6 ,courseType6,
	showLabel,infoLabel,studentIDLabel,studentNameLabel,studentCGPALabel,studentTotalCreditsCompletedLabel,studentRemainingCreditsLabel;

	private JTextField 
	courseNameTF1,courseMidMarksTF1,courseMidGradeTF1, courseFinalMarksTF1, courseFinalGradeTF1,
	courseNameTF2,courseMidMarksTF2,courseMidGradeTF2, courseFinalMarksTF2, courseFinalGradeTF2,
	courseNameTF3,courseMidMarksTF3,courseMidGradeTF3, courseFinalMarksTF3, courseFinalGradeTF3,
	courseNameTF4,courseMidMarksTF4,courseMidGradeTF4, courseFinalMarksTF4, courseFinalGradeTF4,
	courseNameTF5,courseMidMarksTF5,courseMidGradeTF5, courseFinalMarksTF5, courseFinalGradeTF5,
	courseNameTF6,courseMidMarksTF6,courseMidGradeTF6, courseFinalMarksTF6, courseFinalGradeTF6,
	semesterTF;

	private JComboBox courseTypeCombo1,
	courseTypeCombo2,
	courseTypeCombo3,
	courseTypeCombo4,
	courseTypeCombo5,
	courseTypeCombo6,
	semesterCombo,
	showCombo;

	public  DecimalFormat df = new DecimalFormat("0.00");
	

	private JTable semesterTable;
	private JScrollPane semesterTableSP;
	private JButton addBtn,removeBtn, updateBtn, exitBtn, backBtn, searchBtn,clearBtn,goBtn,midGPA,profileBtn;
	private Font myFont,comicFont,headerFont,labelFont,boldFont;
	private Color backGroundColor,buttonColor,yellowColor,comboColor;
	
	private JLabel titleLabel1, titleLabel2, titleLabel3, titleLabel4;
	public String showBySemesterArray[];
	
	public ManagementFrame(){
		super("ManagementFrame");
		this.setResizable(false);
		this.setSize(1355,678);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.backGroundColor = new Color(197,193,192);
		this.buttonColor = new Color(26,41,48);
		this.yellowColor = new Color(247,206,62);
		this.comboColor = new Color(167,210,203);
		this.myFont = new Font("Cambria", Font.ITALIC,18);
		this.comicFont = new Font("Comic Sans MS", Font.PLAIN, 12);
		this.labelFont = new Font("Comic Sans MS", Font.PLAIN, 14);
		this.boldFont = new Font("Comic Sans MS", Font.BOLD, 16);
		this.headerFont = new Font("Bauhaus 93", Font.BOLD, 34);	

		sr = new SemesterRepo();
		cr = new CourseRepo();

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(backGroundColor);

		titleLabel1 = new JLabel("Performance Management");
		titleLabel1.setBounds(0,0,462,100);
		titleLabel1.setFont(headerFont);
		titleLabel1.setForeground(yellowColor);
		titleLabel1.setBackground(buttonColor);
		titleLabel1.setOpaque(true);
		panel.add(titleLabel1);

		titleLabel2 = new JLabel();
		titleLabel2.setBounds(463,0,462,100);
		titleLabel2.setBackground(yellowColor);
		titleLabel2.setOpaque(true);
		panel.add(titleLabel2);		

		titleLabel3 = new JLabel();
		titleLabel3.setBounds(926,0,462,100);
		titleLabel3.setBackground(buttonColor);
		titleLabel3.setOpaque(true);
		panel.add(titleLabel3);		

		titleLabel4 = new JLabel();
		titleLabel4.setBounds(1388,0,462,100);
		titleLabel4.setBackground(yellowColor);
		titleLabel4.setOpaque(true);
		panel.add(titleLabel4);		


		String courseTypeArray[] = new String[] {"Theory", "Lab"}; 
		String semesterArray[] = new String[] {"Spring-Test","Summer-Test","Fall-Test"};
		showBySemesterArray = sr.getCurrentSemesterNames();	
		
		semesterLabel = new JLabel("Semester: ");
		semesterLabel.setBounds(10,140,150,30);	
		semesterLabel.setBackground(buttonColor);
		semesterLabel.setForeground(Color.BLACK);
		//semesterLabel.setOpaque(true);
		semesterLabel.setFont(boldFont);
		panel.add(semesterLabel);

		semesterGPALabel = new JLabel("");
		semesterGPALabel.setBounds(1250,400,100,35);
		semesterGPALabel.setFont(boldFont);
		semesterGPALabel.setForeground(Color.BLACK);
		panel.add(semesterGPALabel);

		semesterTF = new JTextField();
		semesterTF.setBounds(95,140,150,30);
		semesterTF.setBackground(comboColor);
		semesterTF.setForeground(Color.BLACK);
		semesterTF.setFont(labelFont);	
		panel.add(semesterTF);


		showLabel = new JLabel("Show     : ");
		showLabel.setBounds(510,140,150,30);
		showLabel.setFont(boldFont);
		showLabel.setBackground(buttonColor);
		showLabel.setForeground(Color.BLACK);
		panel.add(showLabel);

		showCombo = new JComboBox(showBySemesterArray);
		showCombo.setBounds(595,140,150,30);
		showCombo.setBackground(comboColor);
		showCombo.setFont(labelFont);
		showCombo.setForeground(Color.BLACK);
		panel.add(showCombo);

		goBtn = new JButton("Go");
		goBtn.setBounds(750,140,60,30);
		goBtn.setBackground(buttonColor);
		goBtn.setForeground(Color.WHITE);
		goBtn.setFont(boldFont);
		goBtn.addActionListener(this);
		panel.add(goBtn);

		profileBtn = new JButton("Profile");
		profileBtn.setBounds(1200,140,150,30);
		profileBtn.setBackground(buttonColor);
		profileBtn.setForeground(Color.WHITE);
		profileBtn.setFont(boldFont);
		profileBtn.addActionListener(this);
		panel.add(profileBtn);

		infoLabel = new JLabel("Data and Info : ");
		infoLabel.setBounds(760,180,150,35);
		infoLabel.setFont(boldFont);
		infoLabel.setForeground(Color.BLACK);
		panel.add(infoLabel);

		studentIDLabel = new JLabel("Student ID                         :");
		studentIDLabel.setBounds(760,215,400,30);
		studentIDLabel.setFont(labelFont);
		studentIDLabel.setForeground(Color.BLACK);
		panel.add(studentIDLabel);

		studentNameLabel = new JLabel("Student Name                   :");
		studentNameLabel.setBounds(760,245,400,30);
		studentNameLabel.setFont(labelFont);
		studentNameLabel.setForeground(Color.BLACK);
		panel.add(studentNameLabel);

		studentCGPALabel = new JLabel("CGPA                                  : ");
		studentCGPALabel.setBounds(760,275,400,30);
		studentCGPALabel.setFont(labelFont);
		studentCGPALabel.setForeground(Color.BLACK);
		panel.add(studentCGPALabel);

		cgpaLabel = new JLabel("");
		cgpaLabel.setBounds(937,275,400,30);
		cgpaLabel.setFont(headerFont);
		cgpaLabel.setForeground(buttonColor);
		panel.add(cgpaLabel);		


		studentTotalCreditsCompletedLabel = new JLabel("Total Credits Completed :");
		studentTotalCreditsCompletedLabel.setBounds(760,305,400,30);
		studentTotalCreditsCompletedLabel.setFont(labelFont);
		studentTotalCreditsCompletedLabel.setForeground(Color.BLACK);
		panel.add(studentTotalCreditsCompletedLabel);		
		
		cal = new CalculationRepo();
		cr = new CourseRepo();
		studentIDLabel.setText("Student ID                        : "+"18-36587-1");
		studentNameLabel.setText("Student Name                   : "+"SHOHAG, KOUSHIKUR ISLAM");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		cgpaLabel.setText(df.format(cal.getCGPACalculation()));
		//studentCGPALabel.setText("Student Name                   : "+df.format(cal.getCGPACalculation()));
		studentTotalCreditsCompletedLabel.setText("Total Credits Completed  : "+cr.getTotalCreditsCompleted());

		courseLabel1 = new JLabel("Course-1:");
		courseLabel1.setBounds(10,180,120,35);
		courseLabel1.setFont(boldFont);
		courseLabel1.setForeground(Color.BLACK);
		panel.add(courseLabel1);

		courseNameLabel1 = new JLabel("Course : ");
		courseNameLabel1.setBounds(10,215,80,30);
		courseNameLabel1.setFont(labelFont);
		panel.add(courseNameLabel1);

		courseNameTF1 = new JTextField();
		courseNameTF1.setBounds(95,215,150,30);
		panel.add(courseNameTF1);

		courseMidMarksLabel1 = new JLabel("MT Marks :");
		courseMidMarksLabel1.setBounds(10,250,80,30);
		courseMidMarksLabel1.setFont(labelFont);
		panel.add(courseMidMarksLabel1);

		courseMidMarksTF1 = new JTextField();
		courseMidMarksTF1.setBounds(95,250,150,30);
		panel.add(courseMidMarksTF1);



		courseFinalMarks1 = new JLabel("FT Marks :");
		courseFinalMarks1.setBounds(10,285,80,30);
		courseFinalMarks1.setFont(labelFont);
		panel.add(courseFinalMarks1);

		courseFinalMarksTF1 = new JTextField();
		courseFinalMarksTF1.setBounds(95,285,150,30);
		panel.add(courseFinalMarksTF1);


		courseType1 = new JLabel("Type :");
		courseType1.setBounds(10,320,80,30);
		courseType1.setFont(labelFont);
		panel.add(courseType1);

		courseTypeCombo1 = new JComboBox(courseTypeArray);
		courseTypeCombo1.setBounds(95,320,150,30);
		courseTypeCombo1.setBackground(comboColor);
		courseTypeCombo1.setFont(labelFont);
		courseTypeCombo1.setForeground(Color.BLACK);
		panel.add(courseTypeCombo1);



		courseLabel2 = new JLabel("Course-2:");
		courseLabel2.setBounds(260,180,120,35);
		courseLabel2.setFont(boldFont);
		courseLabel2.setForeground(Color.BLACK);
		panel.add(courseLabel2);

		courseNameLabel2 = new JLabel("Course : ");
		courseNameLabel2.setBounds(260,215,80,30);
		courseNameLabel2.setFont(labelFont);
		panel.add(courseNameLabel2);

		courseNameTF2 = new JTextField();
		courseNameTF2.setBounds(345,215,150,30);
		panel.add(courseNameTF2);

		courseMidMarksLabel2 = new JLabel("MT Marks :");
		courseMidMarksLabel2.setBounds(260,250,80,30);
		courseMidMarksLabel2.setFont(labelFont);
		panel.add(courseMidMarksLabel2);

		courseMidMarksTF2 = new JTextField();
		courseMidMarksTF2.setBounds(345,250,150,30);
		panel.add(courseMidMarksTF2);


		courseFinalMarks2 = new JLabel("FT Marks :");
		courseFinalMarks2.setBounds(260,285,80,30);
		courseFinalMarks2.setFont(labelFont);
		panel.add(courseFinalMarks2);

		courseFinalMarksTF2 = new JTextField();
		courseFinalMarksTF2.setBounds(345,285,150,30);
		panel.add(courseFinalMarksTF2);

		courseType2 = new JLabel("Type :");
		courseType2.setBounds(260,320,80,30);
		courseType2.setFont(labelFont);
		panel.add(courseType2);

		courseTypeCombo2 = new JComboBox(courseTypeArray);
		courseTypeCombo2.setBounds(345,320,150,30);
		courseTypeCombo2.setBackground(comboColor);
		courseTypeCombo2.setFont(labelFont);
		courseTypeCombo2.setForeground(Color.BLACK);
		panel.add(courseTypeCombo2);



		courseLabel3 = new JLabel("Course-3:");
		courseLabel3.setBounds(510,180,120,35);
		courseLabel3.setFont(boldFont);
		courseLabel3.setForeground(Color.BLACK);
		panel.add(courseLabel3);

		courseNameLabel3 = new JLabel("Course : ");
		courseNameLabel3.setBounds(510,215,80,30);
		courseNameLabel3.setFont(labelFont);
		panel.add(courseNameLabel3);

		courseNameTF3 = new JTextField();
		courseNameTF3.setBounds(595,215,150,30);
		panel.add(courseNameTF3);

		courseMidMarksLabel3 = new JLabel("MT Marks :");
		courseMidMarksLabel3.setBounds(510,250,80,30);
		courseMidMarksLabel3.setFont(labelFont);
		panel.add(courseMidMarksLabel3);

		courseMidMarksTF3 = new JTextField();
		courseMidMarksTF3.setBounds(595,250,150,30);
		panel.add(courseMidMarksTF3);

		courseFinalMarks3 = new JLabel("FT Marks :");
		courseFinalMarks3.setBounds(510,285,80,30);
		courseFinalMarks3.setFont(labelFont);
		panel.add(courseFinalMarks3);

		courseFinalMarksTF3 = new JTextField();
		courseFinalMarksTF3.setBounds(595,285,150,30);
		panel.add(courseFinalMarksTF3);


		courseType3 = new JLabel("Type :");
		courseType3.setBounds(510,320,80,30);
		courseType3.setFont(labelFont);
		panel.add(courseType3);

		courseTypeCombo3 = new JComboBox(courseTypeArray);
		courseTypeCombo3.setBounds(595,320,150,30);
		courseTypeCombo3.setBackground(comboColor);
		courseTypeCombo3.setFont(labelFont);
		courseTypeCombo3.setForeground(Color.BLACK);
		panel.add(courseTypeCombo3);




		courseLabel4 = new JLabel("Course-4:");
		courseLabel4.setBounds(10,400,150,35);
		courseLabel4.setFont(boldFont);
		courseLabel4.setForeground(Color.BLACK);
		panel.add(courseLabel4);

		courseNameLabel4 = new JLabel("Course : ");
		courseNameLabel4.setBounds(10,435,80,30);
		courseNameLabel4.setFont(labelFont);
		panel.add(courseNameLabel4);

		courseNameTF4 = new JTextField();
		courseNameTF4.setBounds(95,435,150,30);
		panel.add(courseNameTF4);

		courseMidMarksLabel4 = new JLabel("MT Marks :");
		courseMidMarksLabel4.setBounds(10,470,80,30);
		courseMidMarksLabel4.setFont(labelFont);
		panel.add(courseMidMarksLabel4);

		courseMidMarksTF4 = new JTextField();
		courseMidMarksTF4.setBounds(95,470,150,30);
		panel.add(courseMidMarksTF4);


		courseFinalMarks4 = new JLabel("FT Marks :");
		courseFinalMarks4.setBounds(10,505,80,30);
		courseFinalMarks4.setFont(labelFont);
		panel.add(courseFinalMarks4);

		courseFinalMarksTF4 = new JTextField();
		courseFinalMarksTF4.setBounds(95,505,150,30);
		panel.add(courseFinalMarksTF4);


		courseType4 = new JLabel("Type :");
		courseType4.setBounds(10,540,80,30);
		courseType4.setFont(labelFont);
		panel.add(courseType4);

		courseTypeCombo4 = new JComboBox(courseTypeArray);
		courseTypeCombo4.setBounds(95,540,150,30);
		courseTypeCombo4.setBackground(comboColor);
		courseTypeCombo4.setFont(labelFont);
		courseTypeCombo4.setForeground(Color.BLACK);
		panel.add(courseTypeCombo4);







		courseLabel5 = new JLabel("Course-5:");
		courseLabel5.setBounds(260,400,150,35);
		courseLabel5.setFont(boldFont);
		courseLabel5.setForeground(Color.BLACK);
		panel.add(courseLabel5);

		courseNameLabel5 = new JLabel("Course : ");
		courseNameLabel5.setBounds(260,435,80,30);
		courseNameLabel5.setFont(labelFont);
		panel.add(courseNameLabel5);

		courseNameTF5 = new JTextField();
		courseNameTF5.setBounds(345,435,150,30);
		panel.add(courseNameTF5);

		courseMidMarksLabel5 = new JLabel("MT Marks :");
		courseMidMarksLabel5.setBounds(260,470,80,30);
		courseMidMarksLabel5.setFont(labelFont);
		panel.add(courseMidMarksLabel5);

		courseMidMarksTF5 = new JTextField();
		courseMidMarksTF5.setBounds(345,470,150,30);
		panel.add(courseMidMarksTF5);


		courseFinalMarks5 = new JLabel("FT Marks :");
		courseFinalMarks5.setBounds(260,505,80,30);
		courseFinalMarks5.setFont(labelFont);
		panel.add(courseFinalMarks5);

		courseFinalMarksTF5 = new JTextField();
		courseFinalMarksTF5.setBounds(345,505,150,30);
		panel.add(courseFinalMarksTF5);


		courseType5 = new JLabel("Type :");
		courseType5.setBounds(260,540,80,30);
		courseType5.setFont(labelFont);
		panel.add(courseType5);

		courseTypeCombo5 = new JComboBox(courseTypeArray);
		courseTypeCombo5.setBounds(345,540,150,30);
		courseTypeCombo5.setBackground(comboColor);
		courseTypeCombo5.setFont(labelFont);
		courseTypeCombo5.setForeground(Color.BLACK);
		panel.add(courseTypeCombo5);

	


		courseLabel6 = new JLabel("Course-6:");
		courseLabel6.setBounds(510,400,120,35);
		courseLabel6.setFont(boldFont);
		courseLabel6.setForeground(Color.BLACK);
		panel.add(courseLabel6);

		courseNameLabel6 = new JLabel("Course : ");
		courseNameLabel6.setBounds(510,435,80,30);
		courseNameLabel6.setFont(labelFont);
		panel.add(courseNameLabel6);

		courseNameTF6 = new JTextField();
		courseNameTF6.setBounds(595,435,150,30);
		panel.add(courseNameTF6);

		courseMidMarksLabel6 = new JLabel("MT Marks :");
		courseMidMarksLabel6.setBounds(510,470,80,30);
		courseMidMarksLabel6.setFont(labelFont);
		panel.add(courseMidMarksLabel6);

		courseMidMarksTF6 = new JTextField();
		courseMidMarksTF6.setBounds(595,470,150,30);
		panel.add(courseMidMarksTF6);


		courseFinalMarks6 = new JLabel("FT Marks :");
		courseFinalMarks6.setBounds(510,505,80,30);
		courseFinalMarks6.setFont(labelFont);
		panel.add(courseFinalMarks6);

		courseFinalMarksTF6 = new JTextField();
		courseFinalMarksTF6.setBounds(595,505,150,30);
		panel.add(courseFinalMarksTF6);

		courseType6 = new JLabel("Type :");
		courseType6.setBounds(510,540,80,30);
		courseType6.setFont(labelFont);
		panel.add(courseType6);

		courseTypeCombo6 = new JComboBox(courseTypeArray);
		courseTypeCombo6.setBounds(595,540,150,30);
		courseTypeCombo6.setBackground(comboColor);
		courseTypeCombo6.setFont(labelFont);
		courseTypeCombo6.setForeground(Color.BLACK);
		panel.add(courseTypeCombo6);


		dataLabel = new JLabel("Marks and Grades :");
		dataLabel.setBounds(760,400,400,35);
		dataLabel.setFont(boldFont);
		dataLabel.setForeground(Color.BLACK);
		panel.add(dataLabel);

		String data[][]={{"","","","","","",""}};
		String head[]={"Couse Name","MT Marks", "MT Grade","FT Marks","FT Grade","Final Marks","Final Grade"};
		semesterTable = new JTable(data,head);
		semesterTableSP = new JScrollPane(semesterTable);
		semesterTableSP.setBounds(760,435,585,135);	
		semesterTableSP.setBackground(yellowColor);
		semesterTableSP.setForeground(yellowColor);
		semesterTable.setEnabled(false);
		semesterTable.setBackground(comboColor);
		semesterTable.setForeground(Color.BLACK);
		semesterTable.setGridColor(yellowColor);
		//semesterTableSP.setGridColor(Color.YELLOW);
		semesterTable.getTableHeader().setBackground(yellowColor);
		semesterTable.getTableHeader().setForeground(Color.BLACK);
		semesterTable.setBackground(buttonColor);
		semesterTable.getColumnModel().getColumn(0).setPreferredWidth(200);

		semesterTable.setFont(labelFont);
		panel.add(semesterTableSP);
		panel.revalidate();
		panel.repaint();


		updateBtn = new JButton("Udpate");
		updateBtn.setBounds(227,600,226,50);
		updateBtn.setBackground(buttonColor);
		updateBtn.setForeground(Color.WHITE);
		updateBtn.setFont(boldFont);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);

		addBtn = new JButton("Insert");
		addBtn.setBounds(0,600,226,50);
		addBtn.setBackground(yellowColor);
		addBtn.setForeground(Color.BLACK);
		addBtn.setFont(boldFont);
		addBtn.addActionListener(this);
		panel.add(addBtn);

		removeBtn = new JButton("Delete");
		removeBtn.setBounds(681,600,226,50);
		removeBtn.setBackground(buttonColor);
		removeBtn.setForeground(Color.WHITE);
		removeBtn.setFont(boldFont);
		removeBtn.addActionListener(this);
		panel.add(removeBtn);

		searchBtn = new JButton("Search");
		searchBtn.setBounds(454,600,226,50);
		searchBtn.setBackground(yellowColor);
		searchBtn.setForeground(Color.BLACK);
		searchBtn.setFont(boldFont);
		searchBtn.addActionListener(this);
		panel.add(searchBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(908,600,226,50);
		backBtn.setBackground(yellowColor);
		backBtn.setForeground(Color.BLACK);
		backBtn.addActionListener(this);
		backBtn.setFont(boldFont);
		panel.add(backBtn);

/*
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(1132,600,226,50);
		exitBtn.setBackground(yellowColor);
		exitBtn.setForeground(Color.BLACK);
		exitBtn.addActionListener(this);
		exitBtn.setFont(boldFont);
		panel.add(exitBtn);
*/
		clearBtn = new JButton("Clear");
		clearBtn.setBounds(1135,600,226,50);
		clearBtn.setBackground(buttonColor);
		clearBtn.setForeground(Color.WHITE);
		clearBtn.addActionListener(this);
		clearBtn.setFont(boldFont);
		panel.add(clearBtn);

		midGPA = new JButton("Get Mid GPA!");
		midGPA.setBounds(1200,215,150,120);
		midGPA.setBackground(buttonColor);
		midGPA.setForeground(Color.WHITE);
		midGPA.setFont(boldFont);
		midGPA.addActionListener(this);
		panel.add(midGPA);

	

		this.add(panel);
	}
	public boolean isNumeric(String str){
		String regex = "[+-]?[0-9][0-9]*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if(m.find() && m.group().equals(str)){
			return true;
		}
		else {
			return false;
		}
	}
	public void clearFrame(){
					midGPA.setText("Get Mid GPA!");
					semesterGPALabel.setText("");

					courseNameTF1.setEditable(true);
					courseNameTF2.setEditable(true);
					courseNameTF3.setEditable(true);
					courseNameTF4.setEditable(true);
					courseNameTF5.setEditable(true);
					courseNameTF6.setEditable(true);

					dataLabel.setText("Marks and Grades : ");
					
					semesterTF.setEditable(true);
				courseNameTF1.setText("");
				courseMidMarksTF1.setText("");
				courseFinalMarksTF1.setText("");
				
				courseNameTF2.setText("");
				courseMidMarksTF2.setText("");
				courseFinalMarksTF2.setText("");
				
				courseNameTF3.setText("");
				courseMidMarksTF3.setText("");
				courseFinalMarksTF3.setText("");
				
				courseNameTF4.setText("");
				courseMidMarksTF4.setText("");
				courseFinalMarksTF4.setText("");
				
				courseNameTF5.setText("");
				courseMidMarksTF5.setText("");
				courseFinalMarksTF5.setText("");
				
				courseNameTF6.setText("");
				courseMidMarksTF6.setText("");
				courseFinalMarksTF6.setText("");

				courseTypeCombo1.setSelectedIndex(0);
				courseTypeCombo2.setSelectedIndex(0);
				courseTypeCombo3.setSelectedIndex(0);
				courseTypeCombo4.setSelectedIndex(0);
				courseTypeCombo5.setSelectedIndex(0);
				courseTypeCombo6.setSelectedIndex(0);

				
				semesterTF.setText("");

				showBySemesterArray = sr.getCurrentSemesterNames();
				showCombo.setModel(new DefaultComboBoxModel(showBySemesterArray));

	String data[][]={{"","","","","","",""}};
		String head[]={"Couse Name","MT Marks", "MT Grade","FT Marks","FT Grade","Final Marks","Final Grade"};
		panel.remove(semesterTableSP);
		semesterTable = new JTable(data,head);
		semesterTableSP = new JScrollPane(semesterTable);
		semesterTableSP.setBounds(760,435,585,135);	
		semesterTableSP.setBackground(yellowColor);
		semesterTableSP.setForeground(yellowColor);
		semesterTable.setGridColor(yellowColor);
		//semesterTableSP.setGridColor(yellowColor);
		semesterTable.setEnabled(true);
		semesterTable.setBackground(comboColor);
		semesterTable.setForeground(Color.BLACK);
		semesterTable.setFont(labelFont);
		semesterTable.setBackground(buttonColor);
		semesterTable.getTableHeader().setBackground(yellowColor);
		semesterTable.getTableHeader().setForeground(Color.BLACK);
		semesterTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		panel.add(semesterTableSP);
		panel.revalidate();
		panel.repaint();

	}

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(command.equals(backBtn.getText())){
			ShowFrame sf = new ShowFrame();
			sf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(midGPA.getText())){
			ArrayList<Double> pointsArray = new ArrayList<>();
			ArrayList<Integer> creditsArray = new ArrayList<>();

			double totalMidPoints=0;
			int totalMidCredits=0;



			if(courseMidMarksTF1.getText()==null || courseMidMarksTF1.getText().equals("")){
				//JOptionPane.showMessageDialog(this,"Invalid Mid Term Marks For Course-1");
			}
			else if(courseMidMarksTF1.getText()!=null || !courseMidMarksTF1.getText().equals("")){

				if(courseTypeCombo1.getSelectedItem().toString().equals("Theory")){

					creditsArray.add(3);

					if( (Double.parseDouble(courseMidMarksTF1.getText())) < 50 ){
						pointsArray.add(3.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >=50 && (Double.parseDouble(courseMidMarksTF1.getText()))<= 59 ){
						pointsArray.add(3*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >=60  && (Double.parseDouble(courseMidMarksTF1.getText())) <= 64 ){
						pointsArray.add(3*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF1.getText())) <=69 ){
						pointsArray.add(3*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 70  && (Double.parseDouble(courseMidMarksTF1.getText())) <= 74 ){
						pointsArray.add(3.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF1.getText())) <= 79){
						pointsArray.add(3*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 80 && (Double.parseDouble(courseMidMarksTF1.getText())) <= 84 ){
						pointsArray.add(3*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 85 && (Double.parseDouble(courseMidMarksTF1.getText())) <=89 ){
						pointsArray.add(3*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 90  && (Double.parseDouble(courseMidMarksTF1.getText())) <= 100){
						pointsArray.add(3.0*4);
					}
				}
				else if(courseTypeCombo1.getSelectedItem().toString().equals("Lab")){
					creditsArray.add(1);


					if( (Double.parseDouble(courseMidMarksTF1.getText())) < 50 ){
						pointsArray.add(1.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >=50  && (Double.parseDouble(courseMidMarksTF1.getText()))<= 59 ){
						pointsArray.add(1*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >=60  && (Double.parseDouble(courseMidMarksTF1.getText())) <= 64 ){
						pointsArray.add(1*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF1.getText())) <=69 ){
						pointsArray.add(1*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 70  &&  (Double.parseDouble(courseMidMarksTF1.getText())) <= 74 ){
						pointsArray.add(1.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF1.getText())) <= 79){
						pointsArray.add(1*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 80  && (Double.parseDouble(courseMidMarksTF1.getText())) <= 84 ){
						pointsArray.add(1*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 85  && (Double.parseDouble(courseMidMarksTF1.getText())) <=89 ){
						pointsArray.add(1*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF1.getText())) >= 90  && (Double.parseDouble(courseMidMarksTF1.getText())) <= 100){
						pointsArray.add(1.0*4);
					}
				}
			}



			if(courseMidMarksTF2.getText()==null || courseMidMarksTF2.getText().equals("")){
				//JOptionPane.showMessageDialog(this,"Invalid Mid Term Marks For Course-2");
			}
			else if(courseMidMarksTF2.getText()!=null || !courseMidMarksTF2.getText().equals("")){

				if(courseTypeCombo2.getSelectedItem().toString().equals("Theory")){
					
					creditsArray.add(3);

					if( (Double.parseDouble(courseMidMarksTF2.getText())) < 50 ){
						pointsArray.add(3.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >=50  && (Double.parseDouble(courseMidMarksTF2.getText()))<= 59 ){
						pointsArray.add(3*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >=60 && (Double.parseDouble(courseMidMarksTF2.getText())) <= 64 ){
						pointsArray.add(3*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF2.getText())) <=69 ){
						pointsArray.add(3*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 70  && (Double.parseDouble(courseMidMarksTF2.getText())) <= 74 ){
						pointsArray.add(3.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF2.getText())) <= 79){
						pointsArray.add(3*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 80 && (Double.parseDouble(courseMidMarksTF2.getText())) <= 84 ){
						pointsArray.add(3*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 85 && (Double.parseDouble(courseMidMarksTF2.getText())) <=89 ){
						pointsArray.add(3*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 90  && (Double.parseDouble(courseMidMarksTF2.getText())) <= 100){
						pointsArray.add(3.0*4);
					}
				}
				else if(courseTypeCombo2.getSelectedItem().toString().equals("Lab")){
					creditsArray.add(1);


					if( (Double.parseDouble(courseMidMarksTF2.getText())) < 50 ){
						pointsArray.add(1.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >=50  && (Double.parseDouble(courseMidMarksTF2.getText()))<= 59 ){
						pointsArray.add(1*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >=60  && (Double.parseDouble(courseMidMarksTF2.getText())) <= 64 ){
						pointsArray.add(1*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF2.getText())) <=69 ){
						pointsArray.add(1*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 70  && (Double.parseDouble(courseMidMarksTF2.getText())) <= 74 ){
						pointsArray.add(1.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF2.getText())) <= 79){
						pointsArray.add(1*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 80  && (Double.parseDouble(courseMidMarksTF2.getText())) <= 84 ){
						pointsArray.add(1*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 85 && (Double.parseDouble(courseMidMarksTF2.getText())) <=89 ){
						pointsArray.add(1*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF2.getText())) >= 90  && (Double.parseDouble(courseMidMarksTF2.getText())) <= 100){
						pointsArray.add(1.0*4);
					}
				}
			}



			if(courseMidMarksTF3.getText()==null || courseMidMarksTF3.getText().equals("")){
				//JOptionPane.showMessageDialog(this,"Invalid Mid Term Marks For Course-3");
			}
			else if(courseMidMarksTF3.getText()!=null || !courseMidMarksTF3.getText().equals("")){

				if(courseTypeCombo3.getSelectedItem().toString().equals("Theory")){
					
					creditsArray.add(3);

					if( (Double.parseDouble(courseMidMarksTF3.getText())) < 50 ){
						pointsArray.add(3.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >=50  && (Double.parseDouble(courseMidMarksTF3.getText()))<= 59 ){
						pointsArray.add(3*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >=60  && (Double.parseDouble(courseMidMarksTF3.getText())) <= 64 ){
						pointsArray.add(3*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF3.getText())) <=69 ){
						pointsArray.add(3*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 70 && (Double.parseDouble(courseMidMarksTF3.getText())) <= 74 ){
						pointsArray.add(3.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF3.getText())) <= 79){
						pointsArray.add(3*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 80 && (Double.parseDouble(courseMidMarksTF3.getText())) <= 84 ){
						pointsArray.add(3*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 85  && (Double.parseDouble(courseMidMarksTF3.getText())) <=89 ){
						pointsArray.add(3*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 90  && (Double.parseDouble(courseMidMarksTF3.getText())) <= 100){
						pointsArray.add(3.0*4);
					}
				}
				else if(courseTypeCombo3.getSelectedItem().toString().equals("Lab")){
					creditsArray.add(1);


					if( (Double.parseDouble(courseMidMarksTF3.getText())) < 50 ){
						pointsArray.add(1.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >=50  && (Double.parseDouble(courseMidMarksTF3.getText()))<= 59 ){
						pointsArray.add(1*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >=60  && (Double.parseDouble(courseMidMarksTF3.getText())) <= 64 ){
						pointsArray.add(1*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF3.getText())) <=69 ){
						pointsArray.add(1*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 70  && (Double.parseDouble(courseMidMarksTF3.getText())) <= 74 ){
						pointsArray.add(1.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF3.getText())) <= 79){
						pointsArray.add(1*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 80  && (Double.parseDouble(courseMidMarksTF3.getText())) <= 84 ){
						pointsArray.add(1*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 85 && (Double.parseDouble(courseMidMarksTF3.getText())) <=89 ){
						pointsArray.add(1*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF3.getText())) >= 90  && (Double.parseDouble(courseMidMarksTF3.getText())) <= 100){
						pointsArray.add(1.0*4);
					}
				}
			}


			if(courseMidMarksTF4.getText()==null || courseMidMarksTF4.getText().equals("")){
				//JOptionPane.showMessageDialog(this,"Invalid Mid Term Marks For Course-4");
			}
			else if(courseMidMarksTF4.getText()!=null || !courseMidMarksTF4.getText().equals("")){

				if(courseTypeCombo4.getSelectedItem().toString().equals("Theory")){
					
					creditsArray.add(3);

					if( (Double.parseDouble(courseMidMarksTF4.getText())) < 50 ){
						pointsArray.add(3.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >=50  && (Double.parseDouble(courseMidMarksTF4.getText()))<= 59 ){
						pointsArray.add(3*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >=60  && (Double.parseDouble(courseMidMarksTF4.getText())) <= 64 ){
						pointsArray.add(3*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF4.getText())) <=69 ){
						pointsArray.add(3*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 70 && (Double.parseDouble(courseMidMarksTF4.getText())) <= 74 ){
						pointsArray.add(3.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF4.getText())) <= 79){
						pointsArray.add(3*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 80  && (Double.parseDouble(courseMidMarksTF4.getText())) <= 84 ){
						pointsArray.add(3*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 85  && (Double.parseDouble(courseMidMarksTF4.getText())) <=89 ){
						pointsArray.add(3*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 90  && (Double.parseDouble(courseMidMarksTF4.getText())) <= 100){
						pointsArray.add(3.0*4);
					}
				}
				else if(courseTypeCombo4.getSelectedItem().toString().equals("Lab")){
					creditsArray.add(1);


					if( (Double.parseDouble(courseMidMarksTF4.getText())) < 50 ){
						pointsArray.add(1.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >=50  && (Double.parseDouble(courseMidMarksTF4.getText()))<= 59 ){
						pointsArray.add(1*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >=60  && (Double.parseDouble(courseMidMarksTF4.getText())) <= 64 ){
						pointsArray.add(1*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF4.getText())) <=69 ){
						pointsArray.add(1*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 70  && (Double.parseDouble(courseMidMarksTF4.getText())) <= 74 ){
						pointsArray.add(1.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF4.getText())) <= 79){
						pointsArray.add(1*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 80  && (Double.parseDouble(courseMidMarksTF4.getText())) <= 84 ){
						pointsArray.add(1*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 85  && (Double.parseDouble(courseMidMarksTF4.getText())) <=89 ){
						pointsArray.add(1*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF4.getText())) >= 90 && (Double.parseDouble(courseMidMarksTF4.getText())) <= 100){
						pointsArray.add(1.0*4);
					}
				}
			}



			if(courseMidMarksTF5.getText()==null || courseMidMarksTF5.getText().equals("")){
				//JOptionPane.showMessageDialog(this,"Invalid Mid Term Marks For Course-5");
			}
			else if(courseMidMarksTF5.getText()!=null || !courseMidMarksTF5.getText().equals("")){

				if(courseTypeCombo5.getSelectedItem().toString().equals("Theory")){
					
					creditsArray.add(3);

					if( (Double.parseDouble(courseMidMarksTF5.getText())) < 50 ){
						pointsArray.add(3.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >=50  && (Double.parseDouble(courseMidMarksTF5.getText()))<= 59 ){
						pointsArray.add(3*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >=60  && (Double.parseDouble(courseMidMarksTF5.getText())) <= 64 ){
						pointsArray.add(3*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF5.getText())) <=69 ){
						pointsArray.add(3*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 70  && (Double.parseDouble(courseMidMarksTF5.getText())) <= 74 ){
						pointsArray.add(3.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF5.getText())) <= 79){
						pointsArray.add(3*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 80  && (Double.parseDouble(courseMidMarksTF5.getText())) <= 84 ){
						pointsArray.add(3*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 85  && (Double.parseDouble(courseMidMarksTF5.getText())) <=89 ){
						pointsArray.add(3*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 90  && (Double.parseDouble(courseMidMarksTF5.getText())) <= 100){
						pointsArray.add(3.0*4);
					}
				}
				else if(courseTypeCombo5.getSelectedItem().toString().equals("Lab")){
					creditsArray.add(1);


					if( (Double.parseDouble(courseMidMarksTF5.getText())) < 50 ){
						pointsArray.add(1.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >=50  && (Double.parseDouble(courseMidMarksTF5.getText()))<= 59 ){
						pointsArray.add(1*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >=60  && (Double.parseDouble(courseMidMarksTF5.getText())) <= 64 ){
						pointsArray.add(1*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF5.getText())) <=69 ){
						pointsArray.add(1*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 70  && (Double.parseDouble(courseMidMarksTF5.getText())) <= 74 ){
						pointsArray.add(1.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF5.getText())) <= 79){
						pointsArray.add(1*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 80  &&  (Double.parseDouble(courseMidMarksTF5.getText())) <= 84 ){
						pointsArray.add(1*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 85 && (Double.parseDouble(courseMidMarksTF5.getText())) <=89 ){
						pointsArray.add(1*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF5.getText())) >= 90  && (Double.parseDouble(courseMidMarksTF5.getText())) <= 100){
						pointsArray.add(1.0*4);
					}
				}
			}


			if(courseMidMarksTF6.getText()==null || courseMidMarksTF6.getText().equals("")){
				//JOptionPane.showMessageDialog(this,"Invalid Mid Term Marks For Course-6!");
			}
			else if(courseMidMarksTF6.getText()!=null || !courseMidMarksTF6.getText().equals("")){

				if(courseTypeCombo6.getSelectedItem().toString().equals("Theory")){
					
					creditsArray.add(3);

					if( (Double.parseDouble(courseMidMarksTF6.getText())) < 50 ){
						pointsArray.add(3.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >=50  && (Double.parseDouble(courseMidMarksTF6.getText()))<= 59 ){
						pointsArray.add(3*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >=60  && (Double.parseDouble(courseMidMarksTF6.getText())) <= 64 ){
						pointsArray.add(3*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF6.getText())) <=69 ){
						pointsArray.add(3*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 70  && (Double.parseDouble(courseMidMarksTF6.getText())) <= 74 ){
						pointsArray.add(3.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 75 && (Double.parseDouble(courseMidMarksTF6.getText())) <= 79){
						pointsArray.add(3*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 80  && (Double.parseDouble(courseMidMarksTF6.getText())) <= 84 ){
						pointsArray.add(3*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 85  && (Double.parseDouble(courseMidMarksTF6.getText())) <=89 ){
						pointsArray.add(3*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 90  && (Double.parseDouble(courseMidMarksTF6.getText())) <= 100){
						pointsArray.add(3.0*4);
					}
				}
				else if(courseTypeCombo6.getSelectedItem().toString().equals("Lab")){
					creditsArray.add(1);


					if( (Double.parseDouble(courseMidMarksTF6.getText())) < 50 ){
						pointsArray.add(1.0*0);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >=50  && (Double.parseDouble(courseMidMarksTF6.getText()))<= 59 ){
						pointsArray.add(1*2.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >=60  && (Double.parseDouble(courseMidMarksTF6.getText())) <= 64 ){
						pointsArray.add(1*2.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 65  && (Double.parseDouble(courseMidMarksTF6.getText())) <=69 ){
						pointsArray.add(1*2.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 70  && (Double.parseDouble(courseMidMarksTF6.getText())) <= 74 ){
						pointsArray.add(1.0*3);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 75  && (Double.parseDouble(courseMidMarksTF6.getText())) <= 79){
						pointsArray.add(1*3.25);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 80  && (Double.parseDouble(courseMidMarksTF6.getText())) <= 84 ){
						pointsArray.add(1*3.50);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 85  && (Double.parseDouble(courseMidMarksTF6.getText())) <=89 ){
						pointsArray.add(1*3.75);
					}
					else if( (Double.parseDouble(courseMidMarksTF6.getText())) >= 90 && (Double.parseDouble(courseMidMarksTF6.getText())) <= 100){
						pointsArray.add(1.0*4);
					}
				}
			}


			for(int i=0; i<pointsArray.size(); i++){
				totalMidPoints+=pointsArray.get(i);
			}
			for(int i=0; i<creditsArray.size(); i++){
				totalMidCredits+=creditsArray.get(i);
			}

			midGPA.setText(df.format(totalMidPoints/totalMidCredits));
			//midGPALabel.setText(df.format(totalMidPoints/totalMidCredits));
			if(courseMidMarksTF1.getText().equals("") && courseMidMarksTF2.getText().equals("") && courseMidMarksTF3.getText().equals("") && courseMidMarksTF4.getText().equals("")  && courseMidMarksTF5.getText().equals("")  && courseMidMarksTF6.getText().equals("")){
				JOptionPane.showMessageDialog(this,"No Marks Is Given!");
				midGPA.setText("Get Mid GPA!");
			}

		}
		else if(command.equals(addBtn.getText())){

			Course c1=null,c2=null,c3=null,c4=null,c5=null,c6=null;
			Semester sem=null;
			ArrayList<Course> courseList = new ArrayList<Course>(6);
			Semester sem2 = null;
			sem2 = sr.searchSemester(semesterTF.getText());

			
			if(semesterTF.getText().equals("") || semesterTF.getText().length()==0){
				JOptionPane.showMessageDialog(this,"Semester Name Is Empty!");
			}
			else if(semesterTF.getText().length()>20 || semesterTF.getText().length()<5){
				JOptionPane.showMessageDialog(this,"Semester Length Too Short or Long!");
			}
			else if(sem2!=null){
				JOptionPane.showMessageDialog(this,"Semester Already Exists!");
			}
			else if(courseNameTF1.getText().equals("") && courseNameTF2.getText().equals("") && courseNameTF3.getText().equals("") && courseNameTF4.getText().equals("") && courseNameTF5.getText().equals("") && courseNameTF6.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Please Insert At Least One Course!");
			}
			else{
				sem = new Semester();
				sem.setSemesterName(semesterTF.getText());
				if(!courseNameTF1.getText().equals("") || courseNameTF1.getText().length()!=0){
					if(!courseMidMarksTF1.getText().equals("")){
						if(!courseFinalMarksTF1.getText().equals("")){
							c1 = new Course();
							c1.setCourseName(courseNameTF1.getText());
							c1.setMidTermMarks(Double.parseDouble(courseMidMarksTF1.getText()));
							c1.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF1.getText()));
							c1.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF1.getText())*0.40) + (Double.parseDouble(courseFinalMarksTF1.getText())*0.60))));
							c1.setCourseType(courseTypeCombo1.getSelectedItem().toString());
							c1.setSemesterName(semesterTF.getText());
							sem.setCourse1(courseNameTF1.getText());
							courseList.add(c1);
							cr.insertCourse(c1);
						}
						else{
							JOptionPane.showMessageDialog(this,"Final Term Marks Empty For Course-1!");
						}
						
					}
					else{
						JOptionPane.showMessageDialog(this,"Mid Term Marks Empty For Course-1!");
					}
				}

				if(!courseNameTF2.getText().equals("") || courseNameTF2.getText().length()!=0){
					c2 = new Course();
					c2.setCourseName(courseNameTF2.getText());
					c2.setMidTermMarks(Double.parseDouble(courseMidMarksTF2.getText()));
					c2.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF2.getText()));
					c2.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF2.getText())*0.40) + (Double.parseDouble(courseFinalMarksTF2.getText())*0.60))));
					c2.setCourseType(courseTypeCombo2.getSelectedItem().toString());
					c2.setSemesterName(semesterTF.getText());
					sem.setCourse2(courseNameTF2.getText());
					courseList.add(c2);
					cr.insertCourse(c2);
				}
				if(!courseNameTF3.getText().equals("") || courseNameTF3.getText().length()!=0){
					c3 = new Course();
					c3.setCourseName(courseNameTF3.getText());
					c3.setMidTermMarks(Double.parseDouble(courseMidMarksTF3.getText()));
					c3.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF3.getText()));
					c3.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF3.getText())*0.40) + (Double.parseDouble(courseFinalMarksTF3.getText())*0.60))));
					c3.setCourseType(courseTypeCombo3.getSelectedItem().toString());
					c3.setSemesterName(semesterTF.getText());
					sem.setCourse3(courseNameTF3.getText());
					courseList.add(c3);
					cr.insertCourse(c3);
				}
				if( !courseNameTF4.getText().equals("") || courseNameTF4.getText().length()!=0){
					c4 = new Course();
					c4.setCourseName(courseNameTF4.getText());
					c4.setMidTermMarks(Double.parseDouble(courseMidMarksTF4.getText()));
					c4.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF4.getText()));
					c4.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF4.getText())*0.40) + (Double.parseDouble(courseFinalMarksTF4.getText())*0.60))));
					c4.setCourseType(courseTypeCombo4.getSelectedItem().toString());
					c4.setSemesterName(semesterTF.getText());
					sem.setCourse4(courseNameTF4.getText());
					courseList.add(c4);
					cr.insertCourse(c4);
				}
				if(!courseNameTF5.getText().equals("") || courseNameTF5.getText().length()!=0){
					c5 = new Course();
					c5.setCourseName(courseNameTF5.getText());
					c5.setMidTermMarks(Double.parseDouble(courseMidMarksTF5.getText()));
					c5.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF5.getText()));
					c5.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF5.getText())*0.40) + (Double.parseDouble(courseFinalMarksTF5.getText())*0.60))));
					c5.setCourseType(courseTypeCombo5.getSelectedItem().toString());
					c5.setSemesterName(semesterTF.getText());
					sem.setCourse5(courseNameTF5.getText());
					courseList.add(c5);
					cr.insertCourse(c5);
				}
				if(!courseNameTF6.getText().equals("") || courseNameTF6.getText().length()!=0){
					c6 = new Course();
					c6.setCourseName(courseNameTF6.getText());
					c6.setMidTermMarks(Double.parseDouble(courseMidMarksTF6.getText()));
					c6.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF6.getText()));
					c6.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF6.getText())*0.40) + (Double.parseDouble(courseFinalMarksTF6.getText())*0.60))));
					c6.setCourseType(courseTypeCombo6.getSelectedItem().toString());
					c6.setSemesterName(semesterTF.getText());
					sem.setCourse6(courseNameTF6.getText());
					courseList.add(c6);
					cr.insertCourse(c6);
				}
				cal = new CalculationRepo();
				Course[] courseArray = new Course[courseList.size()];
				courseList.toArray(courseArray);
				sem.setGPA_Semester(cal.getGPACalculation(courseArray));
				sem.setTakenCredits(cal.getCreditsInSemester(courseArray));
				sem.setCGPA_Semester(cal.getCGPACalculation());
				sr.insertSemester(sem);
				panel.revalidate();
				panel.repaint();
				showBySemesterArray = sr.getCurrentSemesterNames();
				showCombo.setModel(new DefaultComboBoxModel(showBySemesterArray));
			//	clearFrame();
				cgpaLabel.setText(df.format(cal.getCGPACalculation()));
				studentTotalCreditsCompletedLabel.setText("Total Credits Completed  : "+cr.getTotalCreditsCompleted());
				JOptionPane.showMessageDialog(this, "New Semester Added!");
				
			}
		}

		else if(command.equals(searchBtn.getText()))
			{
				Semester newsem = null;
				Course newc1=null, newc2=null, newc3=null, newc4=null, newc5=null, newc6=null;
				try{
					newsem=sr.searchSemester(showCombo.getSelectedItem().toString());	
				}
				catch(Exception ex){

				}

				
				
				if(showCombo.getSelectedItem().toString().equals("") || showCombo.getSelectedItem().toString().length()==0 || showCombo.getSelectedItem()==null){
					JOptionPane.showMessageDialog(this,"Semester Name Is Empty!");
				}
				else if(newsem==null){
					JOptionPane.showMessageDialog(this,"Semester Doesn't Exists!");
				}
				else{
					String x = showCombo.getSelectedItem().toString();
					//clearFrame();
					showCombo.setSelectedItem(x);
					semesterTF.setEditable(false);
					courseNameTF1.setEditable(false);
					courseNameTF2.setEditable(false);
					courseNameTF3.setEditable(false);
					courseNameTF4.setEditable(false);
					courseNameTF5.setEditable(false);
					courseNameTF6.setEditable(false);

					newc1=cr.searchCourse(newsem.getCourse1());
					newc2=cr.searchCourse(newsem.getCourse2());
					newc3=cr.searchCourse(newsem.getCourse3());
					newc4=cr.searchCourse(newsem.getCourse4());
					newc5=cr.searchCourse(newsem.getCourse5());
					newc6=cr.searchCourse(newsem.getCourse6());


					semesterTF.setText(newsem.getSemesterName().toString());

					if(newc1!=null){
						courseNameTF1.setText(newc1.getCourseName());	
						courseMidMarksTF1.setText(Double.toString(newc1.getMidTermMarks()));
						courseFinalMarksTF1.setText(Double.toString(newc1.getFinalTermMarks()));
						courseTypeCombo1.setSelectedItem(newc1.getCourseType().toString());
					}
					if(newc2!=null){
						courseNameTF2.setText(newc2.getCourseName());
						courseMidMarksTF2.setText(Double.toString(newc2.getMidTermMarks()));
						courseFinalMarksTF2.setText(Double.toString(newc2.getFinalTermMarks()));
						courseTypeCombo2.setSelectedItem(newc2.getCourseType().toString());
					}
					if(newc3!=null){
						courseNameTF3.setText(newc3.getCourseName());
						courseMidMarksTF3.setText(Double.toString(newc3.getMidTermMarks()));
						courseFinalMarksTF3.setText(Double.toString(newc3.getFinalTermMarks()));
						courseTypeCombo3.setSelectedItem(newc3.getCourseType().toString());
					}
					if(newc4!=null){
						courseNameTF4.setText(newc4.getCourseName());
						courseMidMarksTF4.setText(Double.toString(newc4.getMidTermMarks()));
						courseFinalMarksTF4.setText(Double.toString(newc4.getFinalTermMarks()));
						courseTypeCombo4.setSelectedItem(newc4.getCourseType().toString());
					}
					if(newc5!=null){
						courseNameTF5.setText(newc5.getCourseName());
						courseMidMarksTF5.setText(Double.toString(newc5.getMidTermMarks()));
						courseFinalMarksTF5.setText(Double.toString(newc5.getFinalTermMarks()));
						courseTypeCombo5.setSelectedItem(newc5.getCourseType().toString());
					}
					if(newc6!=null){
						courseNameTF6.setText(newc6.getCourseName());
						courseMidMarksTF6.setText(Double.toString(newc6.getMidTermMarks()));
						courseFinalMarksTF6.setText(Double.toString(newc6.getFinalTermMarks()));
						courseTypeCombo6.setSelectedItem(newc6.getCourseType().toString());
					}
				}
			}
			else if(command.equals(clearBtn.getText())){
				clearFrame();
			}
			else if(command.equals(removeBtn.getText())){
				Semester s = null;
				s=sr.searchSemester(semesterTF.getText());
				if(semesterTF.getText().equals("") || semesterTF.getText().length()==0){
					JOptionPane.showMessageDialog(this,"Semester Name Is Empty!");
				}
				else if(sr.searchSemester(semesterTF.getText())==null){
					JOptionPane.showMessageDialog(this,"Semester Name Doesn't Exist!");
				}
				else {
					sr.deleteSemester(semesterTF.getText());
					cr.deleteCourse(s.getCourse1());
					cr.deleteCourse(s.getCourse2());
					cr.deleteCourse(s.getCourse3());
					cr.deleteCourse(s.getCourse4());
					cr.deleteCourse(s.getCourse5());
					cr.deleteCourse(s.getCourse6());
					showBySemesterArray = sr.getCurrentSemesterNames();
					showCombo.setModel(new DefaultComboBoxModel(showBySemesterArray));
					clearFrame();
					CalculationRepo cal = new CalculationRepo();
					cgpaLabel.setText(df.format(cal.getCGPACalculation()));
					studentTotalCreditsCompletedLabel.setText("Total Credits Completed  : "+cr.getTotalCreditsCompleted());
					JOptionPane.showMessageDialog(this,"Semester Deleted!");

				}
			}
			else if(command.equals(updateBtn.getText())){
				Semester sem = null;
				Course newc1=null, newc2=null,newc3=null,newc4=null,newc5=null,newc6=null;
				sem=sr.searchSemester(semesterTF.getText());
				ArrayList<Course> courseList = new ArrayList<Course>();
				if(sem==null){
					JOptionPane.showMessageDialog(this,"Semester Doesn't Exist!");
				}
				else if(sem!=null){
					newc1 = cr.searchCourse(sem.getCourse1());
					newc2 = cr.searchCourse(sem.getCourse2());
					newc3 = cr.searchCourse(sem.getCourse3());
					newc4 = cr.searchCourse(sem.getCourse4());
					newc5 = cr.searchCourse(sem.getCourse5());
					newc6 = cr.searchCourse(sem.getCourse6());

					if(!courseNameTF1.getText().equals("") || courseNameTF1.getText().length()!=0){
						if(!courseMidMarksTF1.getText().equals("") || courseMidMarksTF1.getText().length()!=0){
							if(courseFinalMarksTF1.getText().equals("") || courseFinalMarksTF1.getText().length()!=0){
								if(newc1==null){
									newc1 = new Course();
									newc1.setCourseName(courseNameTF1.getText());
									newc1.setMidTermMarks(Double.parseDouble(courseMidMarksTF1.getText()));
									newc1.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF1.getText()));
									newc1.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF1.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF1.getText()))*0.60)));
									newc1.setCourseType(courseTypeCombo1.getSelectedItem().toString());
									cr.updateCourse(newc1);
									courseList.add(newc1);
									sem.setCourse1(newc1.getCourseName());
								}
								else{
									newc1.setCourseName(courseNameTF1.getText());
									newc1.setMidTermMarks(Double.parseDouble(courseMidMarksTF1.getText()));
									newc1.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF1.getText()));
									newc1.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF1.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF1.getText()))*0.60)));
									newc1.setCourseType(courseTypeCombo1.getSelectedItem().toString());
									cr.updateCourse(newc1);
									courseList.add(newc1);
									sem.setCourse1(newc1.getCourseName());
								}
							}
							else{
								//JOptionPane.showMessageDialog(this,"Final Term Marks Empty For Course-1!");
							}
						}
						else{
							//JOptionPane.showMessageDialog(this,"Mid Term Marks Empty For Course-1!");
						}
					}
					else{
						//JOptionPane.showMessageDialog(this,"Course Name Is Empty For Course-1!");
					}



					if(!courseNameTF2.getText().equals("") || courseNameTF2.getText().length()!=0){
						if(!courseMidMarksTF2.getText().equals("") || courseMidMarksTF2.getText().length()!=0){
							if(courseFinalMarksTF2.getText().equals("") || courseFinalMarksTF2.getText().length()!=0){
								if(newc2==null){
									newc2 = new Course();
									newc2.setCourseName(courseNameTF2.getText());
									newc2.setMidTermMarks(Double.parseDouble(courseMidMarksTF2.getText()));
									newc2.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF2.getText()));
									newc2.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF2.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF2.getText()))*0.60)));
									newc2.setCourseType(courseTypeCombo2.getSelectedItem().toString());
									cr.updateCourse(newc2);
									courseList.add(newc2);
									sem.setCourse2(newc2.getCourseName());
								}
								else{
									newc2.setCourseName(courseNameTF2.getText());
									newc2.setMidTermMarks(Double.parseDouble(courseMidMarksTF2.getText()));
									newc2.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF2.getText()));
									newc2.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF2.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF2.getText()))*0.60)));
									newc2.setCourseType(courseTypeCombo2.getSelectedItem().toString());
									cr.updateCourse(newc2);
									courseList.add(newc2);
									sem.setCourse2(newc2.getCourseName());
								}
							}
							else{
								//JOptionPane.showMessageDialog(this,"Final Term Marks Empty For Course-2!");
							}
						}
						else{
							//JOptionPane.showMessageDialog(this,"Mid Term Marks Empty For Course-2!");
						}
					}
					else{
						//JOptionPane.showMessageDialog(this,"Course Name Is Empty For Course-2!");
					}


					if(!courseNameTF3.getText().equals("") || courseNameTF3.getText().length()!=0){
						if(!courseMidMarksTF3.getText().equals("") || courseMidMarksTF3.getText().length()!=0){
							if(courseFinalMarksTF3.getText().equals("") || courseFinalMarksTF3.getText().length()!=0){
								if(newc3==null){
									newc3 = new Course();
									newc3.setCourseName(courseNameTF3.getText());
									newc3.setMidTermMarks(Double.parseDouble(courseMidMarksTF3.getText()));
									newc3.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF3.getText()));
									newc3.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF3.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF3.getText()))*0.60)));
									newc3.setCourseType(courseTypeCombo3.getSelectedItem().toString());
									cr.updateCourse(newc3);
									courseList.add(newc3);
									sem.setCourse3(newc3.getCourseName());
								}
								else{
									newc3.setCourseName(courseNameTF3.getText());
									newc3.setMidTermMarks(Double.parseDouble(courseMidMarksTF3.getText()));
									newc3.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF3.getText()));
									newc3.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF3.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF3.getText()))*0.60)));
									newc3.setCourseType(courseTypeCombo3.getSelectedItem().toString());
									cr.updateCourse(newc3);
									courseList.add(newc3);
									sem.setCourse3(newc3.getCourseName());
								}
							}
							else{
								//JOptionPane.showMessageDialog(this,"Final Term Marks Empty For Course-3!");
							}
						}
						else{
							//JOptionPane.showMessageDialog(this,"Mid Term Marks Empty For Course-3!");
						}
					}
					else{
						//JOptionPane.showMessageDialog(this,"Course Name Is Empty For Course-3!");
					}


					if(!courseNameTF4.getText().equals("") || courseNameTF4.getText().length()!=0){
						if(!courseMidMarksTF4.getText().equals("") || courseMidMarksTF4.getText().length()!=0){
							if(courseFinalMarksTF4.getText().equals("") || courseFinalMarksTF4.getText().length()!=0){
								if(newc4==null){
									newc4 = new Course();
									newc4.setCourseName(courseNameTF4.getText());
									newc4.setMidTermMarks(Double.parseDouble(courseMidMarksTF4.getText()));
									newc4.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF4.getText()));
									newc4.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF4.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF4.getText()))*0.60)));
									newc4.setCourseType(courseTypeCombo4.getSelectedItem().toString());
									cr.updateCourse(newc4);
									courseList.add(newc4);
									sem.setCourse4(newc4.getCourseName());
								}
								else{
									newc4.setCourseName(courseNameTF4.getText());
									newc4.setMidTermMarks(Double.parseDouble(courseMidMarksTF4.getText()));
									newc4.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF4.getText()));
									newc4.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF4.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF4.getText()))*0.60)));
									newc4.setCourseType(courseTypeCombo4.getSelectedItem().toString());
									cr.updateCourse(newc4);
									courseList.add(newc4);
									sem.setCourse4(newc4.getCourseName());
								}
							}
							else{
								//JOptionPane.showMessageDialog(this,"Final Term Marks Empty For Course-4!");
							}
						}
						else{
							//JOptionPane.showMessageDialog(this,"Mid Term Marks Empty For Course-4!");
						}
					}
					else{
						//JOptionPane.showMessageDialog(this,"Course Name Is Empty For Course-4!");
					}


					if(!courseNameTF5.getText().equals("") || courseNameTF5.getText().length()!=0){
						if(!courseMidMarksTF5.getText().equals("") || courseMidMarksTF5.getText().length()!=0){
							if(courseFinalMarksTF5.getText().equals("") || courseFinalMarksTF5.getText().length()!=0){
								if(newc5==null){
									newc5 = new Course();
									newc5.setCourseName(courseNameTF5.getText());
									newc5.setMidTermMarks(Double.parseDouble(courseMidMarksTF5.getText()));
									newc5.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF5.getText()));
									newc5.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF5.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF5.getText()))*0.60)));
									newc5.setCourseType(courseTypeCombo5.getSelectedItem().toString());
									cr.updateCourse(newc5);
									courseList.add(newc5);
									sem.setCourse5(newc5.getCourseName());
								}
								else{
									newc5.setCourseName(courseNameTF5.getText());
									newc5.setMidTermMarks(Double.parseDouble(courseMidMarksTF5.getText()));
									newc5.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF5.getText()));
									newc5.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF5.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF5.getText()))*0.60)));
									newc5.setCourseType(courseTypeCombo5.getSelectedItem().toString());
									cr.updateCourse(newc5);
									courseList.add(newc5);
									sem.setCourse5(newc5.getCourseName());
								}
							}
							else{
								//JOptionPane.showMessageDialog(this,"Final Term Marks Empty For Course-5!");
							}
						}
						else{
							//JOptionPane.showMessageDialog(this,"Mid Term Marks Empty For Course-5!");
						}
					}
					else{
						//JOptionPane.showMessageDialog(this,"Course Name Is Empty For Course-5!");
					}


					if(!courseNameTF6.getText().equals("") || courseNameTF6.getText().length()!=0){
						if(!courseMidMarksTF6.getText().equals("") || courseMidMarksTF6.getText().length()!=0){
							if(courseFinalMarksTF6.getText().equals("") || courseFinalMarksTF6.getText().length()!=0){
								if(newc6==null){
									newc6 = new Course();
									newc6.setCourseName(courseNameTF6.getText());
									newc6.setMidTermMarks(Double.parseDouble(courseMidMarksTF6.getText()));
									newc6.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF6.getText()));
									newc6.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF6.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF6.getText()))*0.60)));
									newc6.setCourseType(courseTypeCombo6.getSelectedItem().toString());
									cr.updateCourse(newc6);
									courseList.add(newc6);
									sem.setCourse6(newc6.getCourseName());
								}
								else{
									newc6.setCourseName(courseNameTF6.getText());
									newc6.setMidTermMarks(Double.parseDouble(courseMidMarksTF6.getText()));
									newc6.setFinalTermMarks(Double.parseDouble(courseFinalMarksTF6.getText()));
									newc6.setFinalMarks(Math.ceil(((Double.parseDouble(courseMidMarksTF6.getText()))*0.40) +  ((Double.parseDouble(courseFinalMarksTF6.getText()))*0.60)));
									newc6.setCourseType(courseTypeCombo6.getSelectedItem().toString());
									cr.updateCourse(newc6);
									courseList.add(newc6);
									sem.setCourse6(newc6.getCourseName());
								}
							}
							else{
								//JOptionPane.showMessageDialog(this,"Final Term Marks Empty For Course-1!");
							}
						}
						else{
							//JOptionPane.showMessageDialog(this,"Mid Term Marks Empty For Course-1!");
						}
					}
					else{
						//JOptionPane.showMessageDialog(this,"Course Name Is Empty For Course-1!");
					}

					cal = new CalculationRepo();
					Course[] courseArray = new Course[courseList.size()];
					courseList.toArray(courseArray);
					sem.setGPA_Semester(cal.getGPACalculation(courseArray));
					sem.setTakenCredits(cal.getCreditsInSemester(courseArray));
					sr.updateSemester(sem);
					//panel.revalidate();
					//panel.repaint();
					/*
					showBySemesterArray = sr.getCurrentSemesterNames();
					showCombo.setModel(new DefaultComboBoxModel(showBySemesterArray));
					*/

					
					//clearFrame();
					String z = showCombo.getSelectedItem().toString();
					cgpaLabel.setText(df.format(cal.getCGPACalculation()));
					studentTotalCreditsCompletedLabel.setText("Total Credits Completed  : "+cr.getTotalCreditsCompleted());
					showBySemesterArray = sr.getCurrentSemesterNames();
					showCombo.setModel(new DefaultComboBoxModel(showBySemesterArray));
					showCombo.setSelectedItem(z);
					JOptionPane.showMessageDialog(this,"Semester Upated!");
				}

			}
			else if(command.equals(goBtn.getText())){

				String semName=null;
				Semester sem=null;
				Course newc1=null,newc2=null,newc3=null,newc4=null,newc5=null,newc6=null;
				ArrayList<Course> ar = new ArrayList<Course>();

				dataLabel.setText("Marks and Grades : "+showCombo.getSelectedItem().toString());

				if(showCombo.getSelectedItem()==null){
					JOptionPane.showMessageDialog(this,"No Semester to Show!");
				}
				else{
					semName = showCombo.getSelectedItem().toString();
				}

				sem = sr.searchSemester(semName);
				
				 if(sem!=null){
					newc1 = cr.searchCourse(sem.getCourse1());
					newc2 = cr.searchCourse(sem.getCourse2());
					newc3 = cr.searchCourse(sem.getCourse3());
					newc4 = cr.searchCourse(sem.getCourse4());
					newc5 = cr.searchCourse(sem.getCourse5());
					newc6 = cr.searchCourse(sem.getCourse6());

					if(newc1!=null){
						ar.add(newc1);
					}
					if(newc2!=null){
						ar.add(newc2);
					}
					if(newc3!=null){
						ar.add(newc3);
					}
					if(newc4!=null){
						ar.add(newc4);
					}
					if(newc5!=null){
						ar.add(newc5);
					}
					if(newc6!=null){
						ar.add(newc6);
					}

					Object obj[] = ar.toArray();
					String dataInfo[][] = new String [ar.size()][7];

					for(int i=0; i<obj.length; i++){

						dataInfo[i][0] = ((Course)obj[i]).getCourseName();
						dataInfo[i][1] = (Double.toString(((Course)obj[i]).getMidTermMarks()));

						if(Double.parseDouble(dataInfo[i][1])<50){
							dataInfo[i][2]="F";
						}
						else if(Double.parseDouble(dataInfo[i][1])>=50 && Double.parseDouble(dataInfo[i][1])<=59){
							dataInfo[i][2]="D";
						}
						else if(Double.parseDouble(dataInfo[i][1])>=60 && Double.parseDouble(dataInfo[i][1])<=64){
							dataInfo[i][2]="D+";
						}
						else if(Double.parseDouble(dataInfo[i][1])>=65 && Double.parseDouble(dataInfo[i][1])<=69){
							dataInfo[i][2]="C";
						}
						else if(Double.parseDouble(dataInfo[i][1])>=70 && Double.parseDouble(dataInfo[i][1])<=74){
							dataInfo[i][2]="C+";
						}
						else if(Double.parseDouble(dataInfo[i][1])>=75 && Double.parseDouble(dataInfo[i][1])<=79){
							dataInfo[i][2]="B";
						}
						else if(Double.parseDouble(dataInfo[i][1])>=80 && Double.parseDouble(dataInfo[i][1])<=84){
							dataInfo[i][2]="B+";
						}
						else if(Double.parseDouble(dataInfo[i][1])>=85 && Double.parseDouble(dataInfo[i][1])<=89){
							dataInfo[i][2]="A";
						}
						else if(Double.parseDouble(dataInfo[i][1])>=90 && Double.parseDouble(dataInfo[i][1])<=100){
							dataInfo[i][2]="A+";
						}
						else{
							System.out.println("Invalid Mid Term Grade!");
						}
						dataInfo[i][3] = (Double.toString(((Course)obj[i]).getFinalTermMarks()));
						if(Double.parseDouble(dataInfo[i][3])<50){
							dataInfo[i][4]="F";
						}
						else if(Double.parseDouble(dataInfo[i][3])>=50 && Double.parseDouble(dataInfo[i][3])<=59){
							dataInfo[i][4]="D";
						}
						else if(Double.parseDouble(dataInfo[i][3])>=60 && Double.parseDouble(dataInfo[i][3])<=64){
							dataInfo[i][4]="D+";
						}
						else if(Double.parseDouble(dataInfo[i][3])>=65 && Double.parseDouble(dataInfo[i][3])<=69){
							dataInfo[i][4]="C";
						}
						else if(Double.parseDouble(dataInfo[i][3])>=70 && Double.parseDouble(dataInfo[i][3])<=74){
							dataInfo[i][4]="C+";
						}
						else if(Double.parseDouble(dataInfo[i][3])>=75 && Double.parseDouble(dataInfo[i][3])<=79){
							dataInfo[i][4]="B";
						}
						else if(Double.parseDouble(dataInfo[i][3])>=80 && Double.parseDouble(dataInfo[i][3])<=84){
							dataInfo[i][4]="B+";
						}
						else if(Double.parseDouble(dataInfo[i][3])>=85 && Double.parseDouble(dataInfo[i][3])<=89){
							dataInfo[i][4]="A";
						}
						else if(Double.parseDouble(dataInfo[i][3])>=90 && Double.parseDouble(dataInfo[i][3])<=100){
							dataInfo[i][4]="A+";
						}
						else{
							System.out.println("Invalid Final Term Grade!");
						}
						dataInfo[i][5] = (Double.toString(((Course)obj[i]).getFinalMarks()));	
						if(Double.parseDouble(dataInfo[i][5])<50){
							dataInfo[i][6]="F";
						}
						else if(Double.parseDouble(dataInfo[i][5])>=50 && Double.parseDouble(dataInfo[i][5])<=59){
							dataInfo[i][6]="D";
						}
						else if(Double.parseDouble(dataInfo[i][5])>=60 && Double.parseDouble(dataInfo[i][5])<=64){
							dataInfo[i][6]="D+";
						}
						else if(Double.parseDouble(dataInfo[i][5])>=65 && Double.parseDouble(dataInfo[i][5])<=69){
							dataInfo[i][6]="C";
						}
						else if(Double.parseDouble(dataInfo[i][5])>=70 && Double.parseDouble(dataInfo[i][5])<=74){
							dataInfo[i][6]="C+";
						}
						else if(Double.parseDouble(dataInfo[i][5])>=75 && Double.parseDouble(dataInfo[i][5])<=79){
							dataInfo[i][6]="B";
						}
						else if(Double.parseDouble(dataInfo[i][5])>=80 && Double.parseDouble(dataInfo[i][5])<=84){
							dataInfo[i][6]="B+";
						}
						else if(Double.parseDouble(dataInfo[i][5])>=85 && Double.parseDouble(dataInfo[i][5])<=89){
							dataInfo[i][6]="A";
						}
						else if(Double.parseDouble(dataInfo[i][5])>=90 && Double.parseDouble(dataInfo[i][5])<=100){
							dataInfo[i][6]="A+";
						}
						else{
							System.out.println("Invalid Final Grade!");
						}
					}

					semesterGPALabel.setText( "GPA : "+sr.getCurrentSemesterGPA(showCombo.getSelectedItem().toString()));

					String data[][]=dataInfo;
					String head[]={"Couse Name","MT Marks", "MT Grade","FT Marks","FT Grade","Final Marks","Final Grade"};
					panel.remove(semesterTableSP);
					semesterTable = new JTable(data,head);
					semesterTable.setEnabled(false);
					semesterTableSP = new JScrollPane(semesterTable);
					semesterTableSP.setBounds(760,435,585,135);		
					semesterTableSP.setBackground(yellowColor);
					semesterTableSP.setForeground(Color.BLACK);
					semesterTable.setGridColor(yellowColor);
					//semesterTableSP.setGridColor(yellowColor);
					semesterTable.setBackground(buttonColor);
					semesterTable.setForeground(Color.WHITE);
					semesterTable.setFont(labelFont);
					semesterTable.getTableHeader().setBackground(yellowColor);
					semesterTable.getTableHeader().setForeground(Color.BLACK);
					semesterTable.getColumnModel().getColumn(0).setPreferredWidth(200);
					panel.add(semesterTableSP);
				
					panel.revalidate();
					panel.repaint();
					

				}
				else{
					//JOptionPane.showMessageDialog(this,"Semester Not Found!");
				}
			}
			else if(command.equals(profileBtn.getText())){
				ShowFrame sf = new ShowFrame();
				sf.setVisible(true);
				this.setVisible(false);
			}
			else{

			}
		}		
}