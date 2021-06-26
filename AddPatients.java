package bootathonfinal;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
;



public class AddPatients {
	static int temp=1;
	static String uuid;
	static String gender;
	static JFrame f;
	static JTextField tf_1,tf_2,tf_3,tf_4,tf_5;
	static JRadioButton rb_1,rb_2,rb_3;
	static JLabel lb_1,lb_2,lb_3,id,lb_4,uid,lb_5,lb_6;
	static JButton b_1;
	static JTextArea ta_1;
	
	static ButtonGroup g;
	AddPatients()
	{
		f=ObjectFile.getFrame("Add Patients");
		f.setBackground(Color.white);
         UUID();
		
		
		System.out.println(temp);
		admin();
			
	}
	public static void admin()
	{
		tf_1=new  JTextField();
		tf_2=new JTextField();
		tf_4=new JTextField();
		tf_5=new JTextField();
		rb_1=new JRadioButton("Male");
		rb_2=new JRadioButton("Female");
		rb_3=new JRadioButton("Other");
		lb_1=new JLabel("Name:");
		lb_1.setFont(new Font("Times New Roman", Font.BOLD,20));
		lb_2=new JLabel("Phno:");
		lb_3=new JLabel("Gender:");
		lb_4=new JLabel("Address");
		lb_5=new JLabel("District");
		lb_6=new JLabel("State");
		lb_2.setFont(new Font("Times New Roman", Font.BOLD,20));
		lb_3.setFont(new Font("Times New Roman", Font.BOLD,20));
		lb_4.setFont(new Font("Times New Roman", Font.BOLD,20));
		lb_5.setFont(new Font("Times New Roman", Font.BOLD,20));
		lb_6.setFont(new Font("Times New Roman", Font.BOLD,20));
		id=new JLabel("ID    ");
		id.setFont(new Font("Times New Roman", Font.BOLD,20));
		ta_1=new JTextArea();
		uid=new JLabel();
		
		uid.setText(uuid);
		uid.setFont(new Font("Times New Roman", Font.BOLD,22));
		b_1=ObjectFile.getButton("Submit");
		//b_1.setBackground(Color.white);
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
		id.setBounds(400, 100, 300, 40);
		tf_1.setBounds(480,150, 300, 40);
		tf_2.setBounds(480,200, 300, 40);
		ta_1.setBounds(480, 300, 300, 100);
		rb_1.setBounds(480,250, 70, 40);
		rb_2.setBounds(550, 250, 95, 40);
		rb_3.setBounds(640, 250, 100, 40);
		lb_1.setBounds(400,150, 100, 40);
		
		lb_4.setBounds(400, 300,100 ,40 );
		lb_2.setBounds(400,200, 100, 40);
		lb_3.setBounds(400,250, 100, 40);
		lb_5.setBounds(400, 420, 100, 40);
		lb_6.setBounds(400, 470, 100, 40);
		b_1.setBounds(510, 540, 150, 40);
		tf_4.setBounds(480, 420, 300, 40);
		tf_5.setBounds(480, 470, 300, 40);
		uid.setBounds(480, 100, 150,40);
		EditPatient.setForeground(Color.gray);
		DeletePatient.setForeground(Color.gray);
		ViewallPatient.setForeground(Color.gray);
		Donor.setForeground(Color.gray);
		Border border = new LineBorder(Color.BLACK, 1, false);
		
		tf_1.setBorder(border);
		ta_1.setBorder(border);
		
		//ta_1.setBackground(Color.lightGray);
		
		
		g=new ButtonGroup();
		g.add(rb_1);
		

		g.add(rb_2);
		g.add(rb_3);
	
		
		rb_1.addItemListener(
				new ItemListener() {		public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
					ItemSelectable itemselected=e.getItemSelectable();
					if(itemselected==rb_1)
					{
						gender="male";
						
					}
					
				
			}});
		rb_2.addItemListener(
				new ItemListener() {		public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
					ItemSelectable itemselected=e.getItemSelectable();
					if(itemselected==rb_2)
					{
						gender="female";
						
					}
					
					
				
			}});
		rb_3.addItemListener(
				new ItemListener() {		public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
					ItemSelectable itemselected=e.getItemSelectable();
					if(itemselected==rb_3)
					{
						gender="other";
						
					}
										
				
			}});
		b_1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stu
				Connection con=ObjectFile.getjdbc();
				
					boolean b=ObjectFile.regex(tf_1.getText(),tf_2.getText() );
					
					if(b==true  && ta_1.getText().isEmpty()!=true)
					{
						try {
				
					String query="insert into Patients values(?,?,?,?,?,?,?)";
					

		            PreparedStatement pstmt = con.prepareStatement(query);
		            pstmt.setString(1,uuid);
		            pstmt.setString(2,tf_1.getText());
		            pstmt.setString(3,ta_1.getText());
		            pstmt.setString(4,tf_2.getText());
		            
		            
		            pstmt.setString(5,AddPatients.gender);
		            pstmt.setString(6,tf_4.getText().toLowerCase());
		            pstmt.setString(7,tf_5.getText().toLowerCase());
		            pstmt.executeUpdate();
		            con.close();
		            JOptionPane.showMessageDialog(f,"Succefully Added");
		            new GenerateCard(tf_1.getText(),tf_2.getText(),uid.getText(),gender);
		            f.dispose();
		           
		            

					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Please Enter Valid Data");
					}
				
			}
			
		});
		f.add(AddPatient);
		f.add(EditPatient);
		f.add(DeletePatient);
		f.add(Donor);
		f.add(ViewallPatient);
		f.add(ta_1);
		f.add(uid);
		f.add(id);
		f.add(tf_1);
		f.add(tf_2);
	
		f.add(lb_1);
		f.add(lb_2);
		f.add(lb_3);
		f.add(lb_4);
		f.add(lb_5);
		f.add(lb_6);
		f.add(b_1);
		f.add(rb_1);
		f.add(rb_2);
		f.add(rb_3);
		f.add(tf_4);
		f.add(tf_5);
		
		
		
		JPanel panel = ObjectFile.getpanel();
		f.add(panel);
	
	}
	
	
	
	public static void UUID()
	{
		UUID u=UUID.randomUUID();
	        uuid=(String) u.toString().subSequence(9, 13);
	       
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//createTable();
		new AddPatients();
		
		
      
	}
	
	

}
