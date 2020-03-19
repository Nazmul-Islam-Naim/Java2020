package com.naim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Loging_form extends JFrame {


	private JPanel contentPane;
	private JTextField txtuserId;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loging_form frame = new Loging_form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Loging_form() {
		setResizable(false);
		setTitle("Student Management");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(420, 130, 624, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new LineBorder(Color.BLACK, 3));
		panel.setBounds(10, 11, 588, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWellcomeToHere = new JLabel("WellCome to here");
		lblWellcomeToHere.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWellcomeToHere.setBounds(226, 11, 158, 14);
		panel.add(lblWellcomeToHere);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(82, 70, 451, 195);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIfYouHave = new JLabel("If you have any account login or creat account first.");
		lblIfYouHave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIfYouHave.setBounds(49, 11, 364, 14);
		panel_1.add(lblIfYouHave);
		
		JLabel lblUserId = new JLabel("User Id:");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserId.setBounds(71, 68, 79, 14);
		panel_1.add(lblUserId);
		
		JLabel lblUserPassword = new JLabel("User Password:");
		lblUserPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserPassword.setBounds(71, 111, 109, 14);
		panel_1.add(lblUserPassword);
		
		txtuserId = new JTextField();
		txtuserId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_DOWN:passwordField.requestFocus();
				}
			}
		});
		txtuserId.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtuserId.setBounds(236, 67, 149, 20);
		panel_1.add(txtuserId);
		txtuserId.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_UP:txtuserId.requestFocus();
				}
			}
		});
		passwordField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(236, 110, 149, 20);
		panel_1.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url="jdbc:mysql://localhost:3306/project2020";
					String user="root";
					String password="root";
					String sql="select *from user_registration where userid='"+txtuserId.getText()+"'and userpassword='"+passwordField.getText().toString()+"'";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(url, user, password);
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(sql);
					if(rs.next()) {
						dispose();
						Home_page_form hp=new Home_page_form();
						hp.show();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong !");
						txtuserId.setText(null);
						passwordField.setText(null);
						txtuserId.requestDefaultFocus();
					}
					con.close();
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnLogin.setBackground(SystemColor.activeCaption);
		btnLogin.setBounds(296, 161, 89, 23);
		panel_1.add(btnLogin);
		
		JButton btnForgetPassword = new JButton("Forget Password ?");
		btnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Forget_password_form fp=new Forget_password_form();
				fp.show();
			}
		});
		btnForgetPassword.setBackground(SystemColor.activeCaption);
		btnForgetPassword.setBounds(71, 161, 149, 23);
		panel_1.add(btnForgetPassword);
		
		JButton btnCreatAccount = new JButton("Creat Account");
		btnCreatAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_account_form uaf=new User_account_form();
				uaf.show();
			}
		});
		btnCreatAccount.setBackground(SystemColor.activeCaption);
		btnCreatAccount.setBounds(408, 287, 129, 23);
		contentPane.add(btnCreatAccount);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\Top-10-Things-to-See-and-Do-in-Iceland.jpg"));
		lblNewLabel.setBounds(0, 0, 618, 331);
		contentPane.add(lblNewLabel);
	}
}
