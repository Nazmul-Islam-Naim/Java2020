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
import javax.swing.border.LineBorder;

public class User_account_form extends JFrame {


	private JPanel contentPane;
	private JTextField txtusernameR;
	private JTextField txtusernidR;
	private JTextField txtuseridR;
	private JPasswordField userpassR;
	private JPasswordField userpassrR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_account_form frame = new User_account_form();
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
	public User_account_form() {
		setTitle("User registration form");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(420, 130, 624, 359);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 588, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFillAllBlank = new JLabel("Fill all blank box below");
		lblFillAllBlank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFillAllBlank.setBounds(191, 11, 166, 14);
		panel.add(lblFillAllBlank);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(85, 53, 449, 227);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(35, 12, 86, 17);
		panel_1.add(lblUserName);
		
		JLabel lblUserNid = new JLabel("User NID:");
		lblUserNid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserNid.setBounds(35, 48, 86, 17);
		panel_1.add(lblUserNid);
		
		JLabel lblUserId = new JLabel("User Id:");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserId.setBounds(35, 84, 86, 17);
		panel_1.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(35, 120, 86, 17);
		panel_1.add(lblPassword);
		
		JLabel lblRepassword = new JLabel("Re-Password:");
		lblRepassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRepassword.setBounds(35, 156, 86, 17);
		panel_1.add(lblRepassword);
		
		txtusernameR = new JTextField();
		txtusernameR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_DOWN:txtusernidR.requestFocus();
				break;
				
				}
			
			}
		});
		txtusernameR.setBounds(183, 12, 192, 20);
		panel_1.add(txtusernameR);
		txtusernameR.setColumns(10);
		
		txtusernidR = new JTextField();
		txtusernidR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_DOWN:txtuseridR.requestFocus();
				break;
				
				case KeyEvent.VK_UP:txtusernameR.requestFocus();
				break;
				}
			}
		});
		txtusernidR.setColumns(10);
		txtusernidR.setBounds(183, 48, 192, 20);
		panel_1.add(txtusernidR);
		
		txtuseridR = new JTextField();
		txtuseridR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_DOWN:userpassR.requestFocus();
				break;
				
				case KeyEvent.VK_UP:txtusernidR.requestFocus();
				break;
				}
			}
		});
		txtuseridR.setColumns(10);
		txtuseridR.setBounds(183, 84, 192, 20);
		panel_1.add(txtuseridR);
		
		userpassR = new JPasswordField();
		userpassR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_DOWN:userpassrR.requestFocus();
				break;
				
				case KeyEvent.VK_UP:txtuseridR.requestFocus();
				break;
				}
			}
		});
		userpassR.setBounds(183, 115, 192, 20);
		panel_1.add(userpassR);
		
		userpassrR = new JPasswordField();
		userpassrR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_DOWN:txtusernameR.requestFocus();
				break;
				
				case KeyEvent.VK_UP:userpassR.requestFocus();
				break;
				}
			}
		});
		userpassrR.setBounds(183, 156, 192, 20);
		panel_1.add(userpassrR);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtusernameR.setText(null);
				txtusernidR.setText(null);
				txtuseridR.setText(null);
				userpassR.setText(null);
				userpassrR.setText(null);
				txtusernameR.requestDefaultFocus();
			}
		});
		btnReset.setBounds(35, 193, 89, 23);
		panel_1.add(btnReset);
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						String url="jdbc:mysql://localhost:3306/project2020";
						String user="root";
						String password="root";
						String query="INSERT INTO `user_registration` (`username`, `usernid`, `userid`, `userpassword`, `userrepassword`) VALUES ( ?, ?, ?, ?, ?)";
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection(url,user,password);
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, txtusernameR.getText());
						ps.setString(2, txtusernidR.getText());
						ps.setString(3, txtuseridR.getText());
						ps.setString(4, userpassR.getText().toString());
						ps.setString(5, userpassrR.getText().toString());
						ps.executeUpdate();
						con.close();
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				dispose();
				Loging_form lf=new Loging_form();
				JOptionPane.showMessageDialog(null, "Successfully done !");
				lf.show();
				}
			
			
		});
		btnSubmit.setBounds(288, 193, 89, 23);
		panel_1.add(btnSubmit);
	}
}
