package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import repositories.*;
import entities.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class ShowFrame extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel titleLabel, idLabel1,idLabel2,nameLabel1,nameLabel2, creditCompletedLabel1, creditCompletedLabel2, cgpaLabel1,cgpaLabel2, semesterLabel,
	studentInfoLabel, remainingCreditsLabel,courseCompletedLabel,profilePicLabel,bestPerformanceLabel,worstPerformanceLabel,gradesChartLabel,mailLabel,bloodGroupLabel
	, gradesCounterLabel, aPlusCounterLabel, aCounterLabel, bPlusCounterLabel, bCounterLabel, cPlusCounterLabel, cCounterLabel, dPlusCounterLabel, dCounterLabel, semesterGPALabel;
	private JComboBox semesterCombo;
	private JTable semesterTable;
	private JScrollPane semesterTableSP;
	private JButton  goBtn,exitBtn,backBtn;
	private Font myFont,comicFont,headerFont;
	private Color backGroundColor,buttonColor,yellowColor,comboColor;
	private JLabel titleLabel1, titleLabel2, titleLabel3, titleLabel4;
	private ImageIcon profilePicIcon;

	private CourseRepo cr;
	private SemesterRepo sr;
	private CalculationRepo cal;

	public  DecimalFormat df = new DecimalFormat("0.00");
	
	public ShowFrame(){
		super("ShowFrame");
		this.setResizable(true);
		this.setSize(1355,730);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.backGroundColor = new Color(197,193,192);
		this.buttonColor = new Color(26,41,48);
		this.yellowColor = new Color(247,206,62);
		this.comboColor = new Color(167,210,203);
		this.myFont = new Font("Comic Sans MS", Font.BOLD,16);
		this.comicFont = new Font("Comic Sans MS", Font.PLAIN, 14);
		this.headerFont = new Font("Bauhaus 93", Font.BOLD, 34);

		cr = new CourseRepo();
		sr = new SemesterRepo();
		cal = new CalculationRepo();


		panel = new JPanel();
		panel.setLayout(null);

		//String semesterArray[] = new String[] {"Spring-Test","Summer-Test","Fall-Test"};
		
		
		String[] semesterArray = sr.getCurrentSemesterNames();

		titleLabel1 = new JLabel("Performance Management");
		titleLabel1.setBounds(0,0,452,100);
		titleLabel1.setFont(headerFont);
		titleLabel1.setForeground(yellowColor);
		titleLabel1.setBackground(buttonColor);
		titleLabel1.setOpaque(true);
		panel.add(titleLabel1);

		titleLabel2 = new JLabel();
		titleLabel2.setBounds(453,0,452,100);
		titleLabel2.setBackground(yellowColor);
		titleLabel2.setOpaque(true);
		panel.add(titleLabel2);		

		titleLabel3 = new JLabel();
		titleLabel3.setBounds(905,0,452,100);
		titleLabel3.setBackground(buttonColor);
		titleLabel3.setOpaque(true);
		panel.add(titleLabel3);


		studentInfoLabel = new JLabel("Student Info : ");
		studentInfoLabel.setBounds(5,90,150,40);
		studentInfoLabel.setFont(myFont);
		panel.add(studentInfoLabel);

		profilePicIcon = new ImageIcon("ProPic.jpg");
		profilePicLabel = new JLabel(profilePicIcon);
		profilePicLabel.setBounds(10,122,130,160);
		panel.add(profilePicLabel);

		nameLabel1 = new JLabel("Student Name        : ");
		nameLabel1.setBounds(10,273,500,30);
		nameLabel1.setFont(myFont);
		panel.add(nameLabel1);

		nameLabel1.setText("Student Name        : "+"SHOHAG, KOUSHIKUR ISLAM");

		mailLabel = new JLabel("Mail                    : ");
		mailLabel.setBounds(10,305,500,30);
		mailLabel.setFont(myFont);
		panel.add(mailLabel);

		mailLabel.setText("Mail                    : "+"koushikur.aiub@gmail.com");

		bloodGroupLabel = new JLabel("Blood Group           : ");
		bloodGroupLabel.setBounds(10,340,500,30);
		bloodGroupLabel.setFont(myFont);
		panel.add(bloodGroupLabel);

		bloodGroupLabel.setText("Blood Group           : "+"O (+/pos)");

		idLabel1 = new JLabel("Student ID           : ");
		idLabel1.setBounds(10,375,500,30);
		idLabel1.setFont(myFont);
		panel.add(idLabel1);

		idLabel1.setText("Student ID           : "+"18-36587-1");

		cgpaLabel1 = new JLabel("CGPA                  : ");
		cgpaLabel1.setBounds(10,410,500,30);
		cgpaLabel1.setFont(myFont);
		panel.add(cgpaLabel1);

		df.setRoundingMode(RoundingMode.HALF_EVEN);
		cgpaLabel1.setText("CGPA                  : "+df.format(cal.getCGPACalculation()));

		creditCompletedLabel1 = new JLabel("Credits Completed   : ");
		creditCompletedLabel1.setBounds(10,445,500,30);
		creditCompletedLabel1.setFont(myFont);
		panel.add(creditCompletedLabel1);

		creditCompletedLabel1.setText("Credits Completed   : "+cr.getTotalCreditsCompleted());

		remainingCreditsLabel = new JLabel("Remaining Credits    : ");
		remainingCreditsLabel.setBounds(10,480,500,30);
		remainingCreditsLabel.setFont(myFont);
		panel.add(remainingCreditsLabel);

		remainingCreditsLabel.setText("Remaining Credits    : "+(148-cr.getTotalCreditsCompleted()));

		courseCompletedLabel = new JLabel("Course Completed    : ");
		courseCompletedLabel.setBounds(10,515,500,30);
		courseCompletedLabel.setFont(myFont);
		panel.add(courseCompletedLabel);

		courseCompletedLabel.setText("Course Completed    : "+cr.getCoursesCompleted());

		bestPerformanceLabel = new JLabel("Best Performance    : ");
		bestPerformanceLabel.setBounds(10,545,750,30);
		bestPerformanceLabel.setFont(myFont);
		panel.add(bestPerformanceLabel);

		Course[] bestCourseArray= cr.getBestPerformanceList();
		bestPerformanceLabel.setText("Best Performance    : "+bestCourseArray[0].getCourseName()+", ["+bestCourseArray[0].getFinalMarks()+"]");
		
		worstPerformanceLabel = new JLabel("Worst Performance  : ");
		worstPerformanceLabel.setBounds(10,580,750,30);
		worstPerformanceLabel.setFont(myFont);
		panel.add(worstPerformanceLabel);

		worstPerformanceLabel.setText("Worst Performance  : "+bestCourseArray[(bestCourseArray.length)-1].getCourseName()+", ["+bestCourseArray[(bestCourseArray.length)-1].getFinalMarks()+"]");

		semesterLabel = new JLabel("Semester  : ");
		semesterLabel.setBounds(640,305,150,30); 
		semesterLabel.setFont(myFont);
		panel.add(semesterLabel);

		semesterGPALabel = new JLabel("GPA : ");
		semesterGPALabel.setBounds(1230,305,150,30);
		semesterGPALabel.setFont(myFont);
		panel.add(semesterGPALabel);



		gradesCounterLabel = new JLabel("Grades Counter : ");
		gradesCounterLabel.setBounds(640,545,150,30);
		gradesCounterLabel.setFont(myFont);
		panel.add(gradesCounterLabel);

		aPlusCounterLabel = new JLabel("A+ : ");
		aPlusCounterLabel.setBounds(640,580,80,30);
		aPlusCounterLabel.setFont(comicFont);
		panel.add(aPlusCounterLabel);

		aPlusCounterLabel.setText("A+ : "+cr.getGradeCounter(90,100));

		aCounterLabel = new JLabel("A : ");
		aCounterLabel.setBounds(720,580,80,30);
		aCounterLabel.setFont(comicFont);
		panel.add(aCounterLabel);

		aCounterLabel.setText("A : "+cr.getGradeCounter(85,89));

		bPlusCounterLabel = new JLabel("B+ : ");
		bPlusCounterLabel.setBounds(780,580,80,30);
		bPlusCounterLabel.setFont(comicFont);
		panel.add(bPlusCounterLabel);

		bPlusCounterLabel.setText("B+ : "+cr.getGradeCounter(80,84));

		bCounterLabel = new JLabel("B : ");
		bCounterLabel.setBounds(840,580,80,30);
		bCounterLabel.setFont(comicFont);
		panel.add(bCounterLabel);

		bCounterLabel.setText("B : "+cr.getGradeCounter(75,79));

		cPlusCounterLabel = new JLabel("C+ : ");
		cPlusCounterLabel.setBounds(900,580,80,30);
		cPlusCounterLabel.setFont(comicFont);
		panel.add(cPlusCounterLabel);

		cPlusCounterLabel.setText("C+ : "+cr.getGradeCounter(70,74));

		cCounterLabel = new JLabel("C : ");
		cCounterLabel.setBounds(960,580,80,30);
		cCounterLabel.setFont(comicFont);
		panel.add(cCounterLabel);

		cCounterLabel.setText("C : "+cr.getGradeCounter(65,69));

		dPlusCounterLabel = new JLabel("D+ : ");
		dPlusCounterLabel.setBounds(1020,580,80,30);
		dPlusCounterLabel.setFont(comicFont);
		panel.add(dPlusCounterLabel);

		dPlusCounterLabel.setText("D+ : "+cr.getGradeCounter(60,64));

		dCounterLabel = new JLabel("D : ");
		dCounterLabel.setBounds(1080,580,80,30);
		dCounterLabel.setFont(comicFont);
		panel.add(dCounterLabel);

		dCounterLabel.setText("D : "+cr.getGradeCounter(50,59));

		
		semesterCombo = new JComboBox(semesterArray);
		semesterCombo.setBounds(740,305,150,30);
		semesterCombo.setBackground(comboColor);
		semesterCombo.setForeground(Color.BLACK);
		semesterCombo.setFont(comicFont);
		panel.add(semesterCombo);

		semesterCombo.setModel(new DefaultComboBoxModel(semesterArray));

		goBtn = new JButton("Search");
		goBtn.setBounds(453,645,452,50);
		goBtn.setBackground(yellowColor);
		goBtn.setForeground(Color.BLACK);
		goBtn.setFont(myFont);
		goBtn.addActionListener(this);
		panel.add(goBtn);

		backBtn = new JButton("Manage Performance");
		backBtn.setBounds(0,645,452,50);
		backBtn.addActionListener(this);
		backBtn.setBackground(buttonColor);
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(myFont);
		panel.add(backBtn);

		exitBtn = new JButton("Exit");
		exitBtn.setBounds(905,645,452,50);
		exitBtn.addActionListener(this);
		exitBtn.setBackground(buttonColor);
		exitBtn.setForeground(Color.WHITE);
		exitBtn.setFont(myFont);
		panel.add(exitBtn);


		String data[][]={{"","","","","","",""}};
		String head[]={"Couse Name","MT Marks", "MT Grade","FT Marks","FT Grade","Final Marks","Final Grade"};
		semesterTable = new JTable(data,head);
		semesterTableSP = new JScrollPane(semesterTable);
		semesterTableSP.setBounds(640,345,700,135);	
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
		semesterTable.getColumnModel().getColumn(0).setPreferredWidth(350);

		semesterTable.setFont(comicFont);
		panel.add(semesterTableSP);
		panel.revalidate();
		panel.repaint();

		this.add(panel);
	}	

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();

		if(command.equals(exitBtn.getText())){
			System.exit(0);
		}
		else if(command.equals(backBtn.getText())){
			ManagementFrame mf = new ManagementFrame();
			mf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(goBtn.getText())){
			String semName=null;
				Semester sem=null;
				Course newc1=null,newc2=null,newc3=null,newc4=null,newc5=null,newc6=null;
				ArrayList<Course> ar = new ArrayList<Course>();

				//dataLabel.setText("Marks and Grades : "+semesterCombo.getSelectedItem().toString());

				if(semesterCombo.getSelectedItem()==null){
					JOptionPane.showMessageDialog(this,"No Semester to Show!");
				}
				else{
					semName = semesterCombo.getSelectedItem().toString();
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

					semesterGPALabel.setText( "GPA : "+sr.getCurrentSemesterGPA(semesterCombo.getSelectedItem().toString()));

					String data[][]=dataInfo;
					String head[]={"Couse Name","MT Marks", "MT Grade","FT Marks","FT Grade","Final Marks","Final Grade"};
					panel.remove(semesterTableSP);
					semesterTable = new JTable(data,head);
					semesterTable.setEnabled(false);
					semesterTableSP = new JScrollPane(semesterTable);
					semesterTableSP.setBounds(640,345,700,135);		
					semesterTableSP.setBackground(yellowColor);
					semesterTableSP.setForeground(Color.BLACK);
					semesterTable.setGridColor(yellowColor);
					//semesterTableSP.setGridColor(yellowColor);
					semesterTable.setBackground(buttonColor);
					semesterTable.setForeground(Color.WHITE);
					semesterTable.setFont(comicFont);
					semesterTable.getTableHeader().setBackground(yellowColor);
					semesterTable.getTableHeader().setForeground(Color.BLACK);
					semesterTable.getColumnModel().getColumn(0).setPreferredWidth(350);
					panel.add(semesterTableSP);
				
					panel.revalidate();
					panel.repaint();
					
		}
		else{

		}
	}
}
}