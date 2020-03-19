package com.naim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Student_registration_form extends JFrame {
	static String gender=null;
	public String path;
	InputStream in;

	private JPanel contentPane;
	private JTextField txtstudentname;
	private JTextField txtbirthplace;
	private JTextField txtinstitutename;
	private JTextField txtstudentid;
	private JPasswordField passwordstudent;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnOthers;
	public static  JLabel lblimage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_registration_form frame = new Student_registration_form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student_registration_form() {
		setTitle("Student Registration Form");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(420, 130, 749, 381);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlShadow);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 723, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFillUpAll = new JLabel("Fill up all requerment ");
		lblFillUpAll.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFillUpAll.setBounds(209, 0, 159, 37);
		panel.add(lblFillUpAll);
		
		JLabel lblTotalStudent = new JLabel("Total Student:");
		lblTotalStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalStudent.setBounds(559, 0, 84, 37);
		panel.add(lblTotalStudent);
		
		JLabel labelts = new JLabel("");
		labelts.setBorder(null);
		labelts.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelts.setBounds(677, 0, 46, 37);
		panel.add(labelts);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_page_form hp=new Home_page_form();
				hp.show();
			}
		});
		btnBack.setBackground(SystemColor.controlShadow);
		btnBack.setBounds(10, 9, 89, 23);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(82, 65, 452, 277);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentName.setBounds(10, 11, 101, 14);
		panel_1.add(lblStudentName);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGender.setBounds(10, 46, 101, 14);
		panel_1.add(lblGender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfBirth.setBounds(10, 82, 101, 14);
		panel_1.add(lblDateOfBirth);
		
		JLabel lblBiethPlace = new JLabel("Birth Place:");
		lblBiethPlace.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBiethPlace.setBounds(10, 120, 101, 14);
		panel_1.add(lblBiethPlace);
		
		JLabel lblInstitueName = new JLabel("Institute Name:");
		lblInstitueName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInstitueName.setBounds(10, 156, 101, 14);
		panel_1.add(lblInstitueName);
		
		JLabel lblStudentId = new JLabel("Student Id:");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentId.setBounds(10, 192, 101, 14);
		panel_1.add(lblStudentId);
		
		JLabel lblStudentPassword = new JLabel("Student Password:");
		lblStudentPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentPassword.setBounds(10, 226, 131, 14);
		panel_1.add(lblStudentPassword);
		
		txtstudentname = new JTextField();
		txtstudentname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key =e.getKeyCode();
				switch(key){
					case KeyEvent.VK_DOWN:txtbirthplace.requestFocus();
					break;
				}
			}
		});
		txtstudentname.setBounds(212, 9, 205, 20);
		panel_1.add(txtstudentname);
		txtstudentname.setColumns(10);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="Male";
				rdbtnFemale.setSelected(false);
				rdbtnOthers.setSelected(false);
			}
		});
		rdbtnMale.setBounds(212, 43, 56, 23);
		panel_1.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="Female";
				rdbtnMale.setSelected(false);
				rdbtnOthers.setSelected(false);
			}
		});
		rdbtnFemale.setBounds(281, 43, 65, 23);
		panel_1.add(rdbtnFemale);
		
		rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="Others";
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
			}
		});
		rdbtnOthers.setBounds(356, 43, 64, 23);
		panel_1.add(rdbtnOthers);
		
		JComboBox comboBoxdate = new JComboBox();
		comboBoxdate.setModel(new DefaultComboBoxModel(new String[] {"Date", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxdate.setName("Date");
		comboBoxdate.setBounds(212, 80, 56, 20);
		panel_1.add(comboBoxdate);
		
		JComboBox comboBoxmonth = new JComboBox();
		comboBoxmonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxmonth.setBounds(278, 80, 68, 20);
		panel_1.add(comboBoxmonth);
		
		JComboBox comboBoxyear = new JComboBox();
		comboBoxyear.setModel(new DefaultComboBoxModel(new String[] {"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"}));
		comboBoxyear.setBounds(356, 80, 61, 20);
		panel_1.add(comboBoxyear);
		
		txtbirthplace = new JTextField();
		txtbirthplace.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key =e.getKeyCode();
				switch(key){
					case KeyEvent.VK_DOWN:txtinstitutename.requestFocus();
					break;
					case KeyEvent.VK_UP:txtstudentname.requestFocus();
					break;
				}
			}
		});
		txtbirthplace.setBounds(212, 118, 205, 20);
		panel_1.add(txtbirthplace);
		txtbirthplace.setColumns(10);
		
		txtinstitutename = new JTextField();
		txtinstitutename.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key =e.getKeyCode();
				switch(key){
					case KeyEvent.VK_DOWN:txtstudentid.requestFocus();
					break;
					case KeyEvent.VK_UP:txtbirthplace.requestFocus();
					break;
				}
			}
		});
		txtinstitutename.setBounds(212, 154, 205, 20);
		panel_1.add(txtinstitutename);
		txtinstitutename.setColumns(10);
		
		txtstudentid = new JTextField();
		txtstudentid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key =e.getKeyCode();
				switch(key){
					case KeyEvent.VK_DOWN:passwordstudent.requestFocus();
					break;
					case KeyEvent.VK_UP:txtinstitutename.requestFocus();
					break;
				}
			}
		});
		txtstudentid.setBounds(212, 190, 205, 20);
		panel_1.add(txtstudentid);
		txtstudentid.setColumns(10);
		
		passwordstudent = new JPasswordField();
		passwordstudent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key =e.getKeyCode();
				switch(key){
					case KeyEvent.VK_DOWN:txtstudentname.requestFocus();
					break;
					case KeyEvent.VK_UP:txtstudentid.requestFocus();
					break;
				}
			}
		});
		passwordstudent.setBounds(212, 224, 205, 16);
		panel_1.add(passwordstudent);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					in=new FileInputStream(new File(path));
				} catch (FileNotFoundException e2) {
					
					e2.printStackTrace();
				} 
					
				
				try {

					String url="jdbc:mysql://localhost:3306/project2020";
					String user="root";
					String password="root";
					String sql="INSERT INTO `student_registration` (`sname`, `sgender`, `date`, `month`, `year`, `birthplace`, `institutename`, `sid`, `spassword`,`simage`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection(url, user, password);
					System.out.println("Connected");
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, txtstudentname.getText());
					ps.setString(2,  gender);
					ps.setString(3, comboBoxdate.getSelectedItem().toString());
					ps.setString(4, comboBoxmonth.getSelectedItem().toString());
					ps.setString(5, comboBoxyear.getSelectedItem().toString());
					ps.setString(6, txtbirthplace.getText());
					ps.setString(7, txtinstitutename.getText());
					ps.setString(8, txtstudentid.getText());
					ps.setString(9, passwordstudent.getText().toString());
					ps.setBlob(10, in);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Inserted");
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(328, 251, 89, 23);
		panel_1.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtstudentname.setText(null);
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
				rdbtnOthers.setSelected(false);
				comboBoxdate.setSelectedIndex(0);
				comboBoxmonth.setSelectedIndex(0);
				comboBoxyear.setSelectedIndex(0);
				txtbirthplace.setText(null);
				txtinstitutename.setText(null);
				txtstudentid.setText(null);
				passwordstudent.setText(null);
				lblimage.setIcon(null);
				txtstudentname.requestDefaultFocus();
				
				
			}
		});
		btnReset.setBounds(10, 251, 89, 23);
		panel_1.add(btnReset);
		
		lblimage = new JLabel("");
		lblimage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblimage.setBounds(592, 59, 141, 124);
		contentPane.add(lblimage);
		
		JButton btnAddPicture = new JButton("Add Picture");
		btnAddPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser("d:", FileSystemView.getFileSystemView());
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter fnef=new FileNameExtensionFilter("Only jpg and png", "png","jpg");
				jfc.addChoosableFileFilter(fnef);
				int status=jfc.showSaveDialog(null);
				if(status==JFileChooser.APPROVE_OPTION) {
					File file=jfc.getSelectedFile();
					path=file.getAbsolutePath();
					lblimage.setIcon(resizeImage(path));
					
					
				}
			}
		});
		btnAddPicture.setBounds(602, 194, 118, 23);
		contentPane.add(btnAddPicture);
	}
	public static ImageIcon resizeImage(String imagepath) {
		ImageIcon img=new ImageIcon(imagepath);
		Image image=img.getImage();
		Image imagesize=image.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon processimage=new ImageIcon(imagesize);
		return processimage;
	}
}
