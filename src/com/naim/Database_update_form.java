package com.naim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Database_update_form extends JFrame {

	String path,gender;
	FileInputStream fin;
	
	String url="jdbc:mysql://localhost:3306/project2020";
	String user="root";
	String password="root";
	String driver="com.mysql.jdbc.Driver";
	Connection con;

	private JPanel contentPane;
	private JTextField txtsname;
	private JTextField txtbirthplace;
	private JTextField txtinstitutename;
	private JTextField txtstudentid;
	private JPasswordField studentpassword;
	private JTextField txtsid;
	private JPasswordField txtspassword;
	private JRadioButton rbtnmale,rbtnfemale,rbtnother;
	private static JLabel imagelabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database_update_form frame = new Database_update_form();
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
	public Database_update_form() {
		setTitle("Update Or Delete");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(420, 130, 749, 421);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlShadow);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 59, 723, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_8 = new JLabel("Student Id:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(10, 0, 72, 37);
		panel.add(label_8);
		
		txtsid = new JTextField();
		txtsid.setColumns(10);
		txtsid.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtsid.setBounds(102, 6, 193, 26);
		panel.add(txtsid);
		
		JLabel label_9 = new JLabel("Student Password:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_9.setBounds(367, 5, 116, 26);
		panel.add(label_9);
		
		txtspassword = new JPasswordField();
		txtspassword.setBounds(493, 6, 207, 26);
		panel.add(txtspassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setBounds(69, 105, 452, 277);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("Student Name:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 11, 101, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Gender:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(10, 46, 101, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Date of Birth:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(10, 82, 101, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Birth Place:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(10, 120, 101, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Institute Name:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(10, 156, 101, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Student Id:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(10, 192, 101, 14);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Student Password:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(10, 226, 131, 14);
		panel_1.add(label_6);
		
		txtsname = new JTextField();
		txtsname.setColumns(10);
		txtsname.setBounds(212, 9, 205, 20);
		panel_1.add(txtsname);
		
		rbtnmale = new JRadioButton("Male");
		rbtnmale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="Male";
				rbtnfemale.setSelected(false);
				rbtnother.setSelected(false);
			}
		});
		rbtnmale.setBounds(212, 43, 56, 23);
		panel_1.add(rbtnmale);
		
		rbtnfemale = new JRadioButton("Female");
		rbtnfemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="Female";
				rbtnmale.setSelected(false);
				rbtnother.setSelected(false);
				
			}
		});
		rbtnfemale.setBounds(281, 43, 65, 23);
		panel_1.add(rbtnfemale);
		
		rbtnother = new JRadioButton("Others");
		rbtnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="Others";
				rbtnmale.setSelected(false);
				rbtnmale.setSelected(false);
				
			}
		});
		rbtnother.setBounds(356, 43, 64, 23);
		panel_1.add(rbtnother);
		
		JComboBox cbdate = new JComboBox();
		cbdate.setModel(new DefaultComboBoxModel(new String[] {"Date", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbdate.setName("Date");
		cbdate.setBounds(212, 80, 56, 20);
		panel_1.add(cbdate);
		
		JComboBox cbmonth = new JComboBox();
		cbmonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbmonth.setBounds(278, 80, 68, 20);
		panel_1.add(cbmonth);
		
		JComboBox cbyear = new JComboBox();
		cbyear.setModel(new DefaultComboBoxModel(new String[] {"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"}));
		cbyear.setBounds(356, 80, 61, 20);
		panel_1.add(cbyear);
		
		txtbirthplace = new JTextField();
		txtbirthplace.setColumns(10);
		txtbirthplace.setBounds(212, 118, 205, 20);
		panel_1.add(txtbirthplace);
		
		txtinstitutename = new JTextField();
		txtinstitutename.setColumns(10);
		txtinstitutename.setBounds(212, 154, 205, 20);
		panel_1.add(txtinstitutename);
		
		txtstudentid = new JTextField();
		txtstudentid.setColumns(10);
		txtstudentid.setBounds(212, 190, 205, 20);
		panel_1.add(txtstudentid);
		
		studentpassword = new JPasswordField();
		studentpassword.setBounds(212, 224, 205, 16);
		panel_1.add(studentpassword);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					fin = new FileInputStream(new File(path));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				String sql="UPDATE student_registration SET sname=?, sgender=?, date=?, month=?, year=?, birthplace=?, institutename=?, spassword=?, simage=? where sid=?";
				try {
					Class.forName(driver);
					System.out.println("Conected");
					con=DriverManager.getConnection(url, user, password);
					
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, txtsname.getText());
					ps.setString(2, gender);
					ps.setString(3, cbdate.getSelectedItem().toString());
					ps.setString(4, cbmonth.getSelectedItem().toString());
					ps.setString(5, cbyear.getSelectedItem().toString());
					ps.setString(6, txtbirthplace.getText());
					ps.setString(7, txtinstitutename.getText());
					ps.setString(8, studentpassword.getText().toString());
					ps.setBlob(9, fin);
					ps.setString(10, txtstudentid.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update Done !");
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(328, 251, 89, 23);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="DELETE from student_registration where sid=?";
				try {
					Class.forName(driver);
					con=DriverManager.getConnection(url, user, password);
					System.out.println("Conected");
					PreparedStatement ps =con.prepareStatement(sql); 
					ps.setString(1, txtsid.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record all ready deleted !");
					txtsid.setText(null);
					rbtnmale.setSelected(false);
					rbtnfemale.setSelected(false);
					rbtnother.setSelected(false);
					cbdate.setSelectedIndex(0);
					cbmonth.setSelectedIndex(0);
					cbyear.setSelectedIndex(0);
					txtbirthplace.setText(null);
					txtinstitutename.setText(null);
					txtstudentid.setText(null);
					studentpassword.setText(null);
					imagelabel.setIcon(null);
					txtsname.setText(null);
					txtsid.requestFocus();
					
				} catch (ClassNotFoundException  | SQLException e1 ) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(10, 251, 89, 23);
		panel_1.add(btnDelete);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName(driver);
					String sql="SELECT *FROM `student_registration` where sid='"+txtsid.getText()+"' ";
					con=DriverManager.getConnection(url,user,password);
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(sql);
					while (rs.next()) {
						txtsname.setText(rs.getString(1));
						String gender=rs.getString(2);
						switch(gender) {
						case "Male":
							rbtnmale.setSelected(true);
							break;
						case "Femal":
							rbtnfemale.setSelected(true);
							break;
						case "Others":
							rbtnother.setSelected(true);;
							break;
							
						}

						cbdate.setSelectedItem(rs.getString(3));
						cbmonth.setSelectedItem(rs.getString(4));
						cbyear.setSelectedItem(rs.getString(5));
						txtbirthplace.setText(rs.getString(6));
						txtinstitutename.setText(rs.getString(7));
						txtstudentid.setText(rs.getString(8));
						studentpassword.setText(rs.getString(9));
						
						
						
						byte []img=rs.getBytes(10);
						ImageIcon image= new ImageIcon(img);
						Image getimage=image.getImage();
						Image scaleimage=getimage.getScaledInstance(imagelabel.getWidth(), imagelabel.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon ic= new ImageIcon(scaleimage);
						imagelabel.setIcon(ic);
						
						
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
				
		
		btnFind.setBounds(179, 251, 89, 23);
		panel_1.add(btnFind);
		
		imagelabel = new JLabel("");
		imagelabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		imagelabel.setBounds(592, 105, 141, 124);
		contentPane.add(imagelabel);
		
		JButton button_2 = new JButton("Add Picture");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser("D:",FileSystemView.getFileSystemView());
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter fnef=new FileNameExtensionFilter("Only jpg and png", "jpg","png");
				jfc.addChoosableFileFilter(fnef);
				int status=jfc.showSaveDialog(null);
				if(status==JFileChooser.APPROVE_OPTION) {
					File f=jfc.getSelectedFile();
					path=f.getAbsolutePath();
					imagelabel.setIcon(resizeImage(path));
					
					
				}
			}
		});
		button_2.setBounds(602, 240, 118, 23);
		contentPane.add(button_2);
		
		JLabel lblYouCanDelete = new JLabel("You Can Delete or Update Your Student Information");
		lblYouCanDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYouCanDelete.setBounds(186, 11, 378, 37);
		contentPane.add(lblYouCanDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtsid.setText(null);
				rbtnmale.setSelected(false);
				rbtnfemale.setSelected(false);
				rbtnother.setSelected(false);
				cbdate.setSelectedIndex(0);
				cbmonth.setSelectedIndex(0);
				cbyear.setSelectedIndex(0);
				txtbirthplace.setText(null);
				txtinstitutename.setText(null);
				txtstudentid.setText(null);
				studentpassword.setText(null);
				imagelabel.setIcon(null);
				txtsname.setText(null);
				txtsid.requestFocus();
			}
		});
		btnReset.setBounds(620, 359, 89, 23);
		contentPane.add(btnReset);
		
		
	}
	public static ImageIcon resizeImage(String imagepath) {
		ImageIcon img=new ImageIcon(imagepath);
		Image image=img.getImage();
		Image imagesize=image.getScaledInstance(imagelabel.getWidth(), imagelabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon processimage=new ImageIcon(imagesize);
		return processimage;
	}
}
