package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
import repositories.*;
import entities.*;
import java.time.LocalTime; 
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class HomeFrame extends JFrame implements ActionListener,MouseListener{
	private JPanel panel;
	private JLabel label,imageIconLabel,timeLabel,dateLabel,greetingLabel,dateTimeIconLabel,welcomeLabel,passwordIconLabel,faceIconLabel;
	private JButton manageBtn;
	private Font myFont,comicFont,headerFont,sansFont;
	private Color backGroundColor,buttonColor,yellowColor;
	private ImageIcon imageIcon,dateTimeIcon,welcomeImageIcon,passImageIcon,faceIcon;
	private JPasswordField passTF;
	
	public HomeFrame(){
		super("HomeFrame");
		this.setResizable(false);
		this.setSize(1355,678);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.backGroundColor = new Color(197,193,192);
		this.buttonColor = new Color(26,41,48);
		this.yellowColor = new Color(247,206,62);
		this.myFont = new Font("Comic Sans MS", Font.BOLD,18);
		this.comicFont = new Font("Comic Sans MS", Font.BOLD, 26);
		this.headerFont = new Font("Bauhaus 93", Font.BOLD, 42);
		this.sansFont = new Font("Comic Sans MS",Font.BOLD,28);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(yellowColor);

		label = new JLabel("Performance Management");
		label.setBounds(440,140,600,120);
		label.setFont(headerFont);
		label.setForeground(buttonColor);
		panel.add(label);

		manageBtn = new JButton(" Manage Performance!");
		manageBtn.setBounds(0,540,1355,120);
		manageBtn.addActionListener(this);
		manageBtn.setBackground(buttonColor);
		manageBtn.setForeground(yellowColor);
		manageBtn.setFont(comicFont);
		manageBtn.setFocusable(false);
		panel.add(manageBtn);

		faceIcon = new ImageIcon("FaceIcon.png");
		faceIconLabel = new JLabel(faceIcon);
		faceIconLabel.setBounds(2,2,45,45);
		panel.add(faceIconLabel);

		imageIcon = new ImageIcon("result-512.png");
		imageIconLabel = new JLabel(imageIcon);
		imageIconLabel.setBounds(325,145,100,125);
		panel.add(imageIconLabel);

		dateTimeIcon = new ImageIcon("Datetime-512-1.png");
		dateTimeIconLabel = new JLabel(dateTimeIcon);
		dateTimeIconLabel.setBounds(1095,0,40,40);
		panel.add(dateTimeIconLabel);

		passImageIcon = new ImageIcon("password-512.png");
		passwordIconLabel = new JLabel(passImageIcon);
		passwordIconLabel.setBounds(505,250,70,70);
		panel.add(passwordIconLabel);

		passTF = new JPasswordField();
		passTF.setBounds(575,270,230,40);
		passTF.setBackground(Color.BLACK);
		passTF.setForeground(yellowColor);
		passTF.setFont(sansFont);
		panel.add(passTF);

		welcomeLabel = new JLabel("Welcome, Shohag!");
		welcomeLabel.setBounds(48,2,500,50);
		welcomeLabel.setForeground(Color.BLACK);
		welcomeLabel.setFont(sansFont);
		panel.add(welcomeLabel);




		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		//System.out.println(localTime);
		//System.out.println(Integer.parseInt(localTime.toString().substring(0,2)));
		timeLabel = new JLabel(localTime.format(dateTimeFormatter));
		timeLabel.setBounds(1255,2,100,30);
		timeLabel.setFont(myFont);
		timeLabel.setForeground(Color.BLACK);
		panel.add(timeLabel);

		Date date=java.util.Calendar.getInstance().getTime();  
    	String currDate = date.toString().substring(0,10);
		//System.out.println(currDate);    	
    	dateLabel = new JLabel(currDate+", ");
    	dateLabel.setBounds(1132,2,120,30);
    	dateLabel.setForeground(Color.BLACK);
    	dateLabel.setFont(myFont);
    	panel.add(dateLabel);

    	if(Integer.parseInt(localTime.toString().substring(0,2)) >= 0 &&  Integer.parseInt(localTime.toString().substring(0,2))<=3 ){
    		welcomeLabel.setText("Good Evening, Shohag!");
    	}
    	else if(Integer.parseInt(localTime.toString().substring(0,2)) >= 3 &&  Integer.parseInt(localTime.toString().substring(0,2))<12 ){
    		welcomeLabel.setText("Good Morning, Shohag!");
    	}
    	else if(Integer.parseInt(localTime.toString().substring(0,2)) >= 12 &&  Integer.parseInt(localTime.toString().substring(0,2))<14 ){
    		welcomeLabel.setText("Good Noon, Shohag!");
    	}
    	else if(Integer.parseInt(localTime.toString().substring(0,2)) >= 14 &&  Integer.parseInt(localTime.toString().substring(0,2))<19 ){
    		welcomeLabel.setText("Good Afternoon, Shohag!");
    	}
    	else if((Integer.parseInt(localTime.toString().substring(0,2))) >= 19 &&  (Integer.parseInt(localTime.toString().substring(0,2))) <= 24 ){
    		welcomeLabel.setText("Good Evening, Shohag!");
    	}


		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(command.equals(manageBtn.getText())){
			if(passTF.getText().equals("") || passTF.getText()==null){
				JOptionPane.showMessageDialog(this,"Please Enter The Pass Code!");
			}
			else if(passTF.getText().equals("123456")){
				ShowFrame sf = new ShowFrame();
				sf.setVisible(true);
				this.setVisible(false);

			}
			else{
				JOptionPane.showMessageDialog(this,"Incorrect Pass Code!");
				passTF.setText("");
			}
		}
		else{

		}
	}


	public void mousePressed(MouseEvent me){
		if(me.getSource()==manageBtn){
			manageBtn.setBackground(buttonColor);
			manageBtn.setForeground(yellowColor);
		}
	}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){
		if(me.getSource()==manageBtn){
			manageBtn.setBackground(buttonColor);
			manageBtn.setForeground(yellowColor);
		}	
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
}