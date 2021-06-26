package bootathonfinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



class ViewPatient
 {
	JFrame f;
	static JTextField jt;
	static int Checkup;
	
	 public ViewPatient() {
		// TODO Auto-generated constructor stub
		  f=ObjectFile.getFrame("Patient records");
		   jt=new JTextField();
		  JLabel jl=new JLabel("Patients_id");
		  jl.setFont(new Font("Times New Roman", Font.BOLD,24));
		  jl.setBounds(400,200, 200, 30);
		  jt.setBounds(530, 200, 250, 40);
		  
		  JButton jb2=ObjectFile.getButton("View");
		 

		  JButton jb=ObjectFile.getButton("Update Patients info");
		  

		  jb.setBounds(580,260 , 300, 40);
		  jb2.setBounds(460,260, 100, 40);
		  JButton ViewPatient=ObjectFile.getButton("View Patient");
			
			
			JButton ViewallPatient=ObjectFile.getButton("View all Patient");
			
			JButton chart1 = ObjectFile.getButton("Diseases Analysis");
			
		
			
			ViewPatient.setBounds(60, 160, 270, 40);
		

			chart1.setBounds(60, 280, 270, 40);
			
			
			ViewallPatient.setBounds(60, 220, 270, 40);
			ViewallPatient.setForeground(Color.gray);
			chart1.setForeground(Color.gray);
		  jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!jt.getText().isEmpty() && jt.getText().length()==4)
				{
					
				Connection con=ObjectFile.getjdbc();
				
				 String s="";
			
				 try {
					Statement st =con.createStatement();
					String Query="Select Patient_id from Patients where Patient_id='"+jt.getText()+"'";
					ResultSet rs=st.executeQuery(Query);
				
					while(rs.next())
					{
						s=rs.getString("Patient_id");
						System.out.println(s);
						
					}
					
					if(s.equals(jt.getText()))
					{
						System.out.println("Success");
						 try {
								Statement st1 =con.createStatement();
								String Query1="insert into Checkup(Hospital_id,Patient_id) values('"+FirstPage.hid+"','"+jt.getText()+"')";
								System.out.println(Query1);
								int d=st1.executeUpdate(Query1);
								if(d==1)
								
								
								con.close();
								desc();
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Enter the Valid Patient_id");
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				
			}
				else
				{
					JOptionPane.showMessageDialog(f, "Enter valid Patient id");
				}
			}
		});
		  jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub\
				Connection con=ObjectFile.getjdbc();
				 String s="";
			
				 try {
					Statement st =con.createStatement();
					String Query="Select Patient_id from Patients where Patient_id='"+jt.getText()+"'";
					ResultSet rs=st.executeQuery(Query);
				
					while(rs.next())
					{
						s=rs.getString("Patient_id");
						System.out.println(s);
						
					}
					
					if(s.equals(jt.getText()))
					{
						System.out.println("Success");
						new SinglePatientRecords(s);
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Enter the Valid Patient_id");
						
					}
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		  f.add(ViewallPatient);
		  f.add(chart1);
		  f.add(ViewPatient);
		  f.add(jb);
		  f.add(jb2);
		  f.add(jl);
		  f.add(jt);
		 		  
		  JPanel panel = ObjectFile.getpanel();
			f.add(panel);
		 
	}
	 public static void  desc()
	 {
		 Connection con=ObjectFile.getjdbc();

		 try {
			Statement st =con.createStatement();
			String Query="select  Checkup_id from Checkup where Patient_id='"+jt.getText()+"' and Hospital_id='"+FirstPage.hid+"' ORDER BY Checkup_id DESC";
			System.out.println(Query);
			ResultSet rs=st.executeQuery(Query);
			while(rs.next())
			{
				int d=rs.getInt("Checkup_id");
				new UpdatePatientInfo(d);
				break;
			}
			
			
			con.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 
	 }
	 public static void main(String []args)
	 {
		 new ViewPatient();
	 }
 }

