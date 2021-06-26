package bootathonfinal;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.util.*;
public class FirstPage {
	
  public static String tabelname;
  static String hid="";
static String hname="";
static String hno="";
static String address="";
	public static void main(String[] args) {
		JFrame f1 = ObjectFile.getFrame("First Page");
   	 JPanel panel = ObjectFile.getpanel();
   	 f1.add(panel);
   	 // care+ label
   	 JLabel l1 = new JLabel("Care+ Community Hospital portal");
   	 l1.setBounds(400, 30, 500, 50);
   	 l1.setForeground(Color.decode("#5424BA"));
   	 l1.setFont(new Font("Times New Roman",Font.PLAIN,34));
   	 f1.add(l1);
   	 
   	 // Sign in label
   	 JLabel l2 = new JLabel("Sign in");
   	 l2.setBounds(590, 120, 500, 50);
   	 //l1.setForeground(Color.decode("#5424BA"));
   	 l2.setFont(new Font("Times New Roman",Font.PLAIN,34));
   	 f1.add(l2);
   	 
   	 // uuid label
   	 JLabel l3 = new JLabel("UUID");
   	 l3.setBounds(400, 220, 500, 50);
   	 //l1.setForeground(Color.decode("#5424BA"));
   	 l3.setFont(new Font("Times New Roman",Font.PLAIN,24));
   	 f1.add(l3);
   	 
   	 //uuid TextField
   	 
   	 JTextField t1 = new JTextField();
   	 t1.setBounds(500, 230, 300, 40);
   	 f1.add(t1);
   	 
   	 // password label
   	 JLabel l4 = new JLabel("Password");
   	 l4.setBounds(400,300, 500, 50);
   	 //l1.setForeground(Color.decode("#5424BA"));
   	 l4.setFont(new Font("Times New Roman",Font.PLAIN,24));
   	 f1.add(l4);
   	 
   	 //password TextField
   	 
   	 JPasswordField t2 = new JPasswordField();
   	 t2.setBounds(500, 310, 300, 40);
   	 f1.add(t2);
   	 
   	 //Button
   	 
   	 JButton login = ObjectFile.getButton("Login");
   	 login.setBounds(650, 400, 150, 50);
   	 f1.add(login);
   	 
   	 //forget
   	 JLabel forget = new JLabel("Forget Password ?");
   	 forget.setBounds(450,400, 500, 50);
   	 forget.setForeground(Color.decode("#5424BA"));
   	 forget.setFont(new Font("Times New Roman",Font.PLAIN,24));
   	 f1.add(forget);
   	 forget.addMouseListener(new MouseAdapter() {
   		public void mouseClicked(MouseEvent e) {
   			new ForgotPassword();
   		 }
   		 
	} );
   	 
   	 //not register
   	 JLabel not_register = new JLabel("Not Registered");
   	 not_register.setBounds(480,500, 500, 50);
   	 not_register.setFont(new Font("Times New Roman",Font.PLAIN,24));
   	 f1.add(not_register);
   	 
   	 //register Here
   	 JLabel register_here = new JLabel("Register Here");
   	 register_here.setForeground(Color.decode("#5424BA"));
   	 register_here.setBounds(650,500, 500, 50);
   	 register_here.setFont(new Font("Times New Roman",Font.PLAIN,24));
   	 f1.add(register_here);
   	 
   	 
   	 //Action listener
   	 
   	 login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Login part
				String s1=new String(t2.getPassword());
				String s2=pass(t1.getText());
				boolean status = ObjectFile.password_regex(s2);
				System.out.println(s1+" "+s2);
				if( !s1.isEmpty() && !t1.getText().isEmpty() &&s1.equals(s2))
				{
					Connection con=ObjectFile.getjdbc();
					try {
						Statement st=con.createStatement();
						String query="select * from Hospital where Hospital_id='"+t1.getText()+"'";
						ResultSet rs=	st.executeQuery(query);
						
						while(rs.next())
						{
						hid=rs.getString("Hospital_id");
						hname=rs.getString("Hospital_name");
						hno=rs.getString("Hospital_phonenumber");
						address=rs.getString("Hospital_Address");
						break;
						}
						new Hospital(hname);
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "Enter valid Hospital id and Password");
				}
				
				
				
			}
		});
   	 
   	 
   	 // register listener
   	 register_here.addMouseListener(new MouseAdapter()
   	 {
   		 public void mouseClicked(MouseEvent e) {
   			UUID uuid=UUID.randomUUID();
			String u =String.valueOf(uuid);
		     String unique = u.substring(9,13);
		     FirstPage.tabelname = unique;
		     System.out.println(unique);
		     System.out.println(tabelname);
		    Register r1 = new Register(unique);
   		 }
		});
   	 
		
		
		
	
		
				
		

	}
	private static String pass(String id)
	{
		
		String db="";
		Connection con=ObjectFile.getjdbc();
		try {
			Statement st=con.createStatement();
			String query="select Hospital_password from Hospital where Hospital_id='"+id+"'";
			ResultSet rs=	st.executeQuery(query);
			
			while(rs.next())
			{
			db=rs.getString("Hospital_password");
			break;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Password.decrypt_password(db);
		
		
	}
	
	

}
