package com.naim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class About_form extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About_form frame = new About_form();
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
	public About_form() {
		setTitle("About");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(420, 130, 749, 381);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrIHaveJust = new JTextArea();
		txtrIHaveJust.setBackground(Color.PINK);
		txtrIHaveJust.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrIHaveJust.setLineWrap(true);
		txtrIHaveJust.setText("I have just nothing to say. I just want to give some special thanks to My University and University Teachers.And most of love for my Course Teacher.");
		txtrIHaveJust.setBounds(140, 11, 474, 331);
		contentPane.add(txtrIHaveJust);
	}
}
