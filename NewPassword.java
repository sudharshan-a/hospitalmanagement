package bootathonfinal;


	import javax.swing.*;
	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


		public class NewPassword {
		
	      public NewPassword(String id){
	    	  JFrame f1=ObjectFile.getFrame("New Password");
	    	 
	    	  JButton b1=new JButton("SUBMIT");
	    	  b1.setBounds(170,200,150,40);    	
	    	  b1.setFont(new Font("Times New Roman",Font.PLAIN+Font.BOLD,20));         
	          b1.setBackground(Color.decode("#5424DA"));
	          b1.setForeground(Color.white);
	          
	          JLabel l1=new JLabel("New Password");
	          l1.setBounds(60,70,150,40);
	          l1.setFont(new Font("Merriweather",Font.PLAIN+Font.BOLD,15));
	          JLabel l2=new JLabel("Confirm Password");
	          l2.setBounds(60,120,150,40);
	          l2.setFont(new Font("Merriweather",Font.PLAIN+Font.BOLD,15));
	          
	          JPasswordField tf1=new JPasswordField();
	          tf1.setBounds(220,70,150,30);
	          JPasswordField tf2=new JPasswordField();
	          tf2.setBounds(220,120,150,30);
	          b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String s1=new String(tf1.getPassword());
					String s2=new String(tf2.getPassword());
					System.out.println(s1+" "+s2);
					if(s1.equals(s2) && ObjectFile.password_regex(s1))
					
					{
						String s3=Password.encrypt_password(s1);
						Connection con=ObjectFile.getjdbc();
						try {
							Statement st=con.createStatement();
							String Query="update Hospital set Hospital_password = '"+s3+"' where Hospital_id = '"+id+"'";
							int d=st.executeUpdate(Query);
							if(d==1)
							{
								JOptionPane.showMessageDialog(f1, "Succesfully updated!!");
								f1.dispose();
							}
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(f1, "Enter valid Hospital id and Password");
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
