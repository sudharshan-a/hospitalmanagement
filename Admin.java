package bootathonfinal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
class Admin
{

	Admin()
	{
		JFrame f=ObjectFile.getFrame("Admin Page");
		//JPanel jp=ObjectFile.getpanel();
		//f.setLayout(new BorderLayout());
		//f.add(jp,BorderLayout.WEST);
		JButton AddPatient=ObjectFile.getButton("Add Patient");
		
		JButton EditPatient=ObjectFile.getButton("Edit Patient");
		
		JButton DeletePatient=ObjectFile.getButton("Delete Patient");

		JButton ViewallPatient=ObjectFile.getButton("View all Patient");

		JButton Donor=ObjectFile.getButton("Donor");
		
		AddPatient.setBounds(80, 100, 250, 40);
		EditPatient.setBounds(80, 170, 250, 40);
		DeletePatient.setBounds(80, 240, 250, 40);
		ViewallPatient.setBounds(80, 310, 250, 40);
		Donor.setBounds(80, 380, 250, 40);
	
		f.add(EditPatient);
		f.add(DeletePatient);
		f.add(Donor);
		f.add(ViewallPatient);
		JPanel panel = ObjectFile.getpanel();
		f.add(panel);
		
		f.add(AddPatient);
		EditPatient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=JOptionPane.showInputDialog(f,"Enter the Patient Id");
				Connection con=ObjectFile.getjdbc();
				 String s="";
				 String Patient_name="";
				 String Address="";
				 String Phonenumber="";
				 String District="";
				 String State="";
			
				 try {
					Statement st =con.createStatement();
					String Query="Select * from Patients where Patient_id='"+name+"'";
					ResultSet rs=st.executeQuery(Query);
				
					while(rs.next())
					{
						s=rs.getString("Patient_id");
						Patient_name=rs.getString("Patient_name");
						Address=rs.getString("Patient_address");
						Phonenumber=rs.getString("Patient_phonenumber");
						District=rs.getString("District");
						State=rs.getString("State");
						
						System.out.println(s);
						
					}
					
					if(s.equals(name))
					{
						System.out.println("Success");
						new EditPatient(s,Patient_name,Phonenumber,Address,District,State);
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
		ViewallPatient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ViewallPatient();
				
			}
		});
		AddPatient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddPatients();
				
			}
		});
		DeletePatient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DeletePatient(f);
				
			}
		});
		Donor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Donor();
				
			}
		});
		
	}
	public static void main (String []args)
	{
		new Admin();
	}
	
}