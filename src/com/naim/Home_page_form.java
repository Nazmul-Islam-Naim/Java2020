package com.naim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Home_page_form extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_page_form frame = new Home_page_form();
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
	public Home_page_form() {
		setTitle("Home");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 130, 624, 359);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		panel.setBorder(new LineBorder(SystemColor.desktop, 2));
		panel.setBounds(10, 11, 598, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcomToOur = new JLabel("Welcome To Our Institute ");
		lblWelcomToOur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcomToOur.setBounds(188, 0, 221, 38);
		panel.add(lblWelcomToOur);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 51));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(89, 60, 462, 231);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnStudentRegistration = new JButton("Student Registration");
		btnStudentRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Student_registration_form sr=new Student_registration_form();
				sr.show();
			}
		});
		btnStudentRegistration.setForeground(new Color(204, 102, 102));
		btnStudentRegistration.setBackground(new Color(0, 51, 51));
		btnStudentRegistration.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnStudentRegistration.setBounds(116, 11, 198, 23);
		panel_1.add(btnStudentRegistration);
		
		JButton btnStudentSearch = new JButton("Student Search");
		btnStudentSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_search_form ss =new Student_search_form();
				ss.show();
			}
		});
		btnStudentSearch.setBackground(new Color(0, 51, 51));
		btnStudentSearch.setForeground(new Color(204, 102, 102));
		btnStudentSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnStudentSearch.setBounds(116, 65, 198, 23);
		panel_1.add(btnStudentSearch);
		
		JButton btnDatabaseUpdate = new JButton("Database Update");
		btnDatabaseUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database_update_form du=new Database_update_form();
				du.show();
			}
		});
		btnDatabaseUpdate.setBackground(new Color(0, 51, 51));
		btnDatabaseUpdate.setForeground(new Color(204, 102, 102));
		btnDatabaseUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDatabaseUpdate.setBounds(116, 121, 198, 23);
		panel_1.add(btnDatabaseUpdate);
		
		JButton btnHelp = new JButton("About");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About_form af=new About_form();
				af.show();
			}
		});
		btnHelp.setBackground(new Color(0, 51, 51));
		btnHelp.setForeground(new Color(204, 102, 102));
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHelp.setBounds(116, 173, 198, 23);
		panel_1.add(btnHelp);
	}
}
