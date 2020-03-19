package com.naim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Forget_password_form extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forget_password_form frame = new Forget_password_form();
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
	public Forget_password_form() {
		setResizable(false);
		setTitle("Register your account again");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(420, 130, 327, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 299, 151);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserId = new JLabel("User Id:");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserId.setBounds(10, 28, 62, 14);
		panel.add(lblUserId);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewPassword.setBounds(10, 67, 107, 14);
		panel.add(lblNewPassword);
		
		textField = new JTextField();
		textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField.setBounds(146, 26, 132, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		passwordField.setBounds(146, 57, 132, 20);
		panel.add(passwordField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url="jdbc:mysql://localhost:3306/project2020";
					String user="root";
					String password="root";
					String sql="UPDATE user_registration SET userpassword=?,userrepassword=? where userid=?";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(url, user, password);
					System.out.println("Connected");
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, passwordField.getText().toString());
					ps.setString(2, passwordField_1.getText().toString());
					ps.setString(3, textField.getText());
					JOptionPane.showMessageDialog(null, "Update Successfule");
					dispose();
					Loging_form lf=new Loging_form();
					lf.show();
					ps.executeUpdate();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(189, 119, 89, 23);
		panel.add(btnSubmit);
		
		JLabel lblRepassword = new JLabel("Re-Password:");
		lblRepassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRepassword.setBounds(10, 92, 107, 14);
		panel.add(lblRepassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		passwordField_1.setBounds(146, 88, 132, 20);
		panel.add(passwordField_1);
	}
}
