package com.naim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Student_search_form extends JFrame {


	private JPanel contentPane;
	private JTextField txtsid;
	private JPasswordField passwordField;
	private JLabel lblimage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_search_form frame = new Student_search_form();
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
	public Student_search_form() {
		setTitle("Find Your Student");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(420, 130, 749, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 47, 723, 26);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student Id:");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentId.setBounds(10, 0, 72, 26);
		panel.add(lblStudentId);
		
		txtsid = new JTextField();
		txtsid.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtsid.setBounds(107, 0, 193, 26);
		panel.add(txtsid);
		txtsid.setColumns(10);
		
		JLabel lblStudentPassword = new JLabel("Student Password:");
		lblStudentPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentPassword.setBounds(383, 0, 116, 26);
		panel.add(lblStudentPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(522, 0, 201, 26);
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBorder(new LineBorder(new Color(0, 191, 255)));
		panel_1.setBounds(125, 84, 452, 338);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(0, 255, 0));
		textPane.setBackground(new Color(0, 128, 128));
		textPane.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textPane.setBorder(new LineBorder(new Color(0, 191, 255)));
		textPane.setBounds(0, 0, 291, 293);
		panel_1.add(textPane);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(null);
				lblimage.setIcon(null);
			}
		});
		btnNewButton.setBounds(22, 304, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textPane.print();
					
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setBounds(342, 304, 89, 23);
		panel_1.add(btnPrint);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("Where is database.");
				try {
					String url="jdbc:mysql://localhost:3306/project2020";
					String user="root";
					String password="root";
					String driver="com.mysql.jdbc.Driver";
					Class.forName(driver);
					String sql="SELECT *FROM `student_registration` where sid='"+txtsid.getText()+"' ";
					Connection con=DriverManager.getConnection(url,user,password);
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(sql);
					while(rs.next()) {
					textPane.setText("Name : "+
							rs.getString(1)+"\n\n"+"Gender : "+
							rs.getString(2)+"\n\n"+"DOB : "+
							rs.getString(3)+"\\"+
							rs.getString(4)+"\\"+
							rs.getString(5)+"\n\n"+"Birth Place : "+
							rs.getString(6)+"\n\n"+"Institute : "+
							rs.getString(7)+"\n\n"+"ID : "+
							rs.getString(8)+"\n\n"+"Password : "+
							rs.getString(9));
					byte []img=rs.getBytes("simage");
					ImageIcon image=new ImageIcon(img);
					Image getimage=image.getImage();
					Image imagescale=getimage.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon ic=new ImageIcon(imagescale);
					
					lblimage.setIcon(ic);
					
					}
					System.out.println("Conected");
				}catch(Exception ee) {}
				
			}
		});
		btnSearch.setBounds(183, 304, 89, 23);
		panel_1.add(btnSearch);
		
		lblimage = new JLabel("");
		lblimage.setBounds(301, 0, 151, 124);
		panel_1.add(lblimage);
		lblimage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 191, 255), new Color(0, 191, 255)));
		
		JLabel lblPleaseEnterStudent = new JLabel("Please Enter Student Id or Password or Both");
		lblPleaseEnterStudent.setForeground(new Color(51, 153, 153));
		lblPleaseEnterStudent.setBackground(new Color(204, 255, 204));
		lblPleaseEnterStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseEnterStudent.setBounds(174, 11, 360, 25);
		contentPane.add(lblPleaseEnterStudent);
	}
}
