package bootathonfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class DeletePatient {

	
	
  public DeletePatient(JFrame f) {
		
		
	  String id=JOptionPane.showInputDialog(f,"Enter the Patient id");
	  Connection con=ObjectFile.getjdbc();
	  
	  String Query="Select Patient_id from Patients where Patient_id='"+id+"'";
	  Statement st;
	try {
		st = con.createStatement();
	
		ResultSet rs=st.executeQuery(Query);
	
	String s="";
		while(rs.next())
		{
			s=rs.getString("Patient_id");
			System.out.println(s);
			
		}
	
		
		if(s.equals(id))
		{
			System.out.println("Success");
			
			try {
				
				String query="delete from Patients where Patient_id='"+id+"'";
				st.executeUpdate(query);
				con.close();
				
				JOptionPane.showMessageDialog(f, "The Patient is removed Successfully");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(f,"Enter the Valid Patient_id");
			
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
		
			
				
				
			}
		
		
		
		
		


  public static void main(String []args)
  {
	  
  }
}
