package bootathonfinal;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
public class ObjectFile {
	private static Connection con;
	public static JFrame getFrame(String name) {
		JFrame frame = new JFrame(name);
		frame.setSize(1000, 700); 
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#f6f1f1"));
		frame.setVisible(true);
		//sframe.setResizable(false);
		return frame;
	}
	
	public static JButton getButton(String name) {
		JButton b1 = new JButton(name);
		b1.setFont(new Font("Garamond", Font.BOLD+Font.ITALIC,22));
		b1.setForeground(Color.white);
		b1.setBackground(Color.decode("#5424BA"));
		
		//Border border = new LineBorder(Color.decode("#ff69b4"), 2, false);
		b1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		       // b1.setBackground(Color.decode("#ff69b4"));
		        //b1.setForeground(Color.BLACK);
		       // Border border1 = new LineBorder(Color.white, 2, false);
		        //b1.setBorder(border1);
		       
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        //b1.setBackground(Color.white);
		        //b1.setForeground(Color.BLACK);
		        //Border border1 = new LineBorder(Color.decode("#ff69b4"), 2, false);
		       // b1.setBorder(border1);
		       
		    }
		});
		//b1.setBorder(border);
		return b1;
	}
	
	public static Connection getjdbc() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/CarePlus", "root","password");
		    return con;
			//Statement stmt = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return null;
	}
	
	public static JTextField gettext() {
		JTextField text = new JTextField();
		
		return text;
	}
	public static JPanel getpanel()
	{
		  JPanel panel = new JPanel();
		  panel.setSize(350,700);
		  panel.setBackground(Color.decode("#5424BA"));
		return panel;

	}
	public static boolean regex(String hospitalName, String phoneNumber) {
        boolean Name = Pattern.matches("[a-zA-Z\\s]{2,20}", hospitalName);
        boolean Number = Pattern.matches("[0-9]{10}", phoneNumber);
        
        
        if (Name && Number ) {
            return true;
        } else {
            return false;
        }
}
	public static boolean regex1(String u)
	{
		
		boolean l=Pattern.matches("^[a-zA-Z0-9]{4}", u);
		return l;
		
	}
	public static boolean password_regex(String password) {
		String regex ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_*])(?=\\S+$).{6,15}$"; 
		boolean res = Pattern.matches(regex, password);
		return res;
	}
	

	
}

