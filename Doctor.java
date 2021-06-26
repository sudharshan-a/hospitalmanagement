package bootathonfinal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
class Doctor
{

	public Doctor()
	{
		JFrame f=ObjectFile.getFrame("Doctors Page");
		//JPanel jp=ObjectFile.getpanel();
		//f.setLayout(new BorderLayout());
		//f.add(jp,BorderLayout.WEST);
		JButton ViewPatient=ObjectFile.getButton("View Patient");
		
		
		JButton ViewallPatient=ObjectFile.getButton("View all Patient");
		
		JButton chart1 = ObjectFile.getButton("Diseases Analysis");
		
		//JButton chart1 = ObjectFile.getButton("Di Analysis");
		
		ViewPatient.setBounds(60, 160, 270, 40);
	

		chart1.setBounds(60, 280, 270, 40);
		
		
		ViewallPatient.setBounds(60, 220, 270, 40);
		
		ViewPatient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 new ViewPatient();
				 
				 
			}
		});
		ViewallPatient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ViewallPatient();
				
			}
		});
		chart1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Chart();
				
			}
		});
		
	    
	  
		f.add(chart1);
		f.add(ViewPatient);
		
		f.add(ViewallPatient);
		
		JPanel panel = ObjectFile.getpanel();
		f.add(panel);
		
	
			
	}
	public static void main (String []args)
	{
		new Doctor();
	}
	
}