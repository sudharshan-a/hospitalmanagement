package bootathonfinal;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class EditPatient {
	  EditPatient(String id,String name,String Phonenumber,String Address,String District,String State)
	
	  {
		  JFrame f=ObjectFile.getFrame("Edit patients");
		 JTextField tf_1=new  JTextField();
		JTextField	tf_2=new JTextField();
		JTextField	tf_3=new JTextField();
		JTextField	tf_4=new JTextField();
	 	JLabel lb_1=new JLabel("Name:");
		JLabel lb_2=new JLabel("Phno:");
		JLabel lb_4=new JLabel("Address");
		JLabel lb_5 = new JLabel("District :");
	    JLabel lb_6 = new JLabel("State :");
		lb_1.setFont(new Font("Times New Roman",Font.PLAIN,20));
		lb_2.setFont(new Font("Times New Roman",Font.PLAIN,20));
		lb_4.setFont(new Font("Times New Roman",Font.PLAIN,20));
	    lb_5.setFont(new Font("Times New Roman",Font.PLAIN,20));
	    lb_6.setFont(new Font("Times New Roman",Font.PLAIN,20));
	    
		JTextArea ta_1=new JTextArea();
		JButton jb=ObjectFile.getButton("Update");
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

		tf_1.setBounds(480,150, 300, 40);
		tf_2.setBounds(480,200, 300, 40);
		tf_3.setBounds(480,340, 300, 40);
		tf_4.setBounds(480,400, 300, 40);
		lb_1.setBounds(400,150, 100, 40);
		lb_2.setBounds(400,200, 100, 40);
		lb_4.setBounds(400, 260,100 ,40 );
		lb_5.setBounds(400, 340, 100, 40);
		lb_6.setBounds(400, 400, 100, 40);
		ta_1.setBounds(480, 260, 300, 60);
		jb.setBounds(580, 450, 180, 40);
		AddPatient.setForeground(Color.gray);
		DeletePatient.setForeground(Color.gray);
		ViewallPatient.setForeground(Color.gray);
		Donor.setForeground(Color.gray);
	Border border = new LineBorder(Color.BLACK, 1, false);
		
		tf_1.setText(name);
		tf_2.setText(Phonenumber);
		ta_1.setText(Address);
		ta_1.setBorder(border);
		tf_3.setText(District);
		tf_4.setText(State);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean num=ObjectFile.regex(tf_1.getText(),tf_2.getText());
				if(num==true&&tf_1.getText().isEmpty() !=true&& tf_2.getText().isEmpty()!=true&& ta_1.getText().isEmpty()!=true  )
				{
					
					Connection con=ObjectFile.getjdbc();
					try {
						Statement st=con.createStatement();
						String Query="Update Patients set Patient_name='"+tf_1.getText()+"' ,Patient_Phonenumber='"+tf_2.getText()+"',Patient_Address='"+ta_1.getText()+"',District='"+tf_3.getText().toLowerCase()+"',State='"+tf_4.getText()+"' where Patient_id='"+id+"'";
						int k=st.executeUpdate(Query);
						if(k==1)
						{
							JOptionPane.showMessageDialog(f,"Succcess fully updated ");
							f.dispose();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				
				else
				{
				
					JOptionPane.showMessageDialog(f,"Please Enter the Valid data ");
				
					
				}
			}
				
				
				
			
		});
		f.add(AddPatient);
		f.add(ViewallPatient);
		f.add(DeletePatient);
		f.add(EditPatient);
		f.add(Donor);
	
		f.add(tf_1);
		f.add(tf_2);
		f.add(ta_1);
		f.add(tf_3);
		f.add(tf_4);
		f.add(lb_1);
		f.add(lb_2);
		f.add(lb_4);
		f.add(lb_5);
		f.add(lb_6);
		f.add(jb);
		JPanel panel = ObjectFile.getpanel();
		f.add(panel);
	
		
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}