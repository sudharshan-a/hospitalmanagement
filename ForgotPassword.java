package bootathonfinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ForgotPassword {

	

	
		
	      public ForgotPassword() 
	      {
	    	  JFrame f1=ObjectFile.getFrame("Forgot Password");
	    	 
	    	  JButton b1=new JButton("SUBMIT");
	    	  b1.setBounds(170,200,150,40);    	
	    	  b1.setFont(new Font("Times New Roman",Font.PLAIN+Font.BOLD,20));         
	          b1.setBackground(Color.decode("#5424DA"));
	          b1.setForeground(Color.white);
	          
	          JLabel l1=new JLabel("UUID");
	          l1.setBounds(90,70,150,40);
	          l1.setFont(new Font("Merriweather",Font.PLAIN+Font.BOLD,15));
	          JLabel l2=new JLabel("Phone Number");
	          l2.setBounds(90,120,150,40);
	          l2.setFont(new Font("Merriweather",Font.PLAIN+Font.BOLD,15));
	          
	          TextField tf1=new TextField();
	          tf1.setBounds(220,70,150,30);
	          TextField tf2=new TextField();
	          tf2.setBounds(220,120,150,30);
	          b1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try
						{
							Connection con=ObjectFile.getjdbc();
						
							Statement st=con.createStatement();
							String Query="select Hospital_phonenumber from Hospital where Hospital_id='"+tf1.getText()+"'";
							ResultSet rs=st.executeQuery(Query);
							String ph1=tf2.getText();
							String ph2="";
							while(rs.next())
							{
								ph2=rs.getString("Hospital_phonenumber");
								
							}
							con.close();
							System.out.println(ph1+" "+ph2);
							if(ph1.equals(ph2))
							{
								new NewPassword(tf1.getText());
								f1.dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(f1, "Enter valid details");
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(f1, "Enter valid UUID");
						}
						
						
						
						
					}
				});
	    
	          f1.add(tf1);
	          f1.add(tf2);
	    	  f1.add(b1);
	    	  f1.add(l1);
	    	  f1.add(l2);
	    	  f1.setBounds(700, 350,500,375);
	    	  f1.getContentPane().setBackground(Color.WHITE);
	    	  f1.setLayout(null);
	    	  f1.setVisible(true);
	    	  
	      }
	          public static void main(String[] args) {
	        	  
	        	 
	          }
	

	
}
