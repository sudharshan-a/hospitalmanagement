
package bootathonfinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Register {
	
	
		JFrame frame;
		Register(String uuid){
			JLabel l1,l2,l3,l4,l5,l6,l7;
			JPasswordField jp,jp1;
			
			 frame = ObjectFile.getFrame("Register");
		     
			JLabel label = new JLabel("Your Hospital Code is: "+uuid);
			label.setBounds(530, 60, 500, 50);
			label.setFont(new Font("Times New Roman", Font.PLAIN,20));
			frame.add(label);
			l6=new JLabel("District");
			l6.setFont(new Font("Times New Roman",Font.PLAIN,20));
			l7=new JLabel("State");
			l7.setFont(new Font("Times New Roman",Font.PLAIN,20));
			l4=new JLabel("Doctor Password");
			  
			  l4.setFont(new Font("Times New Roman", Font.PLAIN,20));
			l5=new JLabel("Hospital Password");
			l5.setFont(new Font("Times New Roman",Font.PLAIN,20));
			l1=new JLabel("Hospital Name");
		    
		    l1.setFont(new Font("Times New Roman", Font.PLAIN,20));
		    l2=new JLabel("Phone Number");
		    
		    l2.setFont(new Font("Times New Roman", Font.PLAIN,20));
		    l3=new JLabel("Address");
		    
		    jp=new JPasswordField();
		    jp1=new JPasswordField();
		    l3.setFont(new Font("Times New Roman", Font.PLAIN,20));
		    frame.add(l1);
		    frame.add(l2);
		    frame.add(l3);
		    frame.add(l4);
		    
		    JTextField t1 = new JTextField();
		    JTextField t2 =new JTextField();
		    JTextArea t3 =new JTextArea();
		    JTextField t4=new JTextField();
		    JTextField t5=new JTextField();
		    l1.setBounds(430,145,200,20);
	        t1.setBounds(620,145,300,30);
	        t2.setBounds(620,205,300,30);
	        l2.setBounds(430,205,200,20);
	        
	        l4.setBounds(430, 270, 300, 30);
	        jp.setBounds(620, 270, 300, 30);
	        l5.setBounds(430, 330, 300, 30);
	        jp1.setBounds(620, 330, 300, 30);
	        l3.setBounds(430,390,200,50);
	        t3.setBounds(620,390,300,60);
	        l6.setBounds(430, 490, 300, 30);
	        t4.setBounds(620, 490, 300, 30);
	        l7.setBounds(430, 550, 300, 30);
	        t5.setBounds(620, 550, 300, 30);
	        
	       
	       
	        Border border = new LineBorder(Color.BLACK, 1, false);
	        t3.setBorder(border);
	        frame.add(t1);
	        frame.add(t2);
	        frame.add(t3);
	        frame.add(jp);
	        frame.add(jp1);
	        frame.add(l5);
	        frame.add(l7);
	        frame.add(l6);
	        frame.add(l7);
	        frame.add(t4);
	        frame.add(t5);
	       
	        
	        JButton reg = ObjectFile.getButton("Register");
	        
	        reg.setBounds(520, 610, 300, 50);
	        
	        reg.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				String name = t1.getText();
				String number = t2.getText();
				String address = t3.getText();
				
				String doctor_password = String.valueOf(jp.getPassword());
				String hospital_password = String.valueOf(jp1.getPassword());
				
				boolean check = ObjectFile.password_regex(doctor_password) && ObjectFile.password_regex(hospital_password);
				if(check) {
	 			String s=Password.encrypt_password(new String(jp.getPassword()));
				String s1=Password.encrypt_password(new String(jp1.getPassword()));
				
				boolean b=ObjectFile.regex(name, number);
				if(b==true && address!=null)
				{
					registerfunction(name,number,address,s,s1);	
				}
				else
				{
					 JOptionPane.showMessageDialog(frame,"Please Enter Valid Data");
					
				}
					
				}
				else {
					JOptionPane.showMessageDialog(frame,"1 uppercase & lowercase character and number and length should be >6");
				}
				}});
	        frame.add(reg);
	        
	        JPanel panel = ObjectFile.getpanel();
			frame.add(panel);
	        
		}
		public  void registerfunction(String name , String number , String address,String s,String s1) {
			String code = FirstPage.tabelname;
			System.out.println(name+" "+number+" "+address);
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection con = ObjectFile.getjdbc();
			
				Statement st = con.createStatement();
				String query = "insert into Hospital values('"+code+"','"+name+"','"+address+"','"+number+"','"+s+"','"+s1+"')";
				int result = st.executeUpdate(query);
			    if(result == 1) {
			    	JOptionPane.showMessageDialog(frame,"Successfully registered");
			    	frame.dispose();
			    // String que = "create table "+ code +"(patient_code varchar(5),"+"patient_Name varchar(20),"+"patient_phoneNumber varchar(10),"+"patient_address varchar(50))";
			    //	String que = "create table {0}"+"(patient_code varchar(5),patient_Name varchar(20),patient_phoneNumber(10),patient_address varchar(50))";
			    	//String que="create table "+code+"("+pat_code+" varchar("+5+")"+","+pat_name+" varchar2("+20+"),"+pat_num+" number("+range3+")"+")";
			    	
			    	//int val = st.executeUpdate(que);
			    	//System.out.println(que);
			    }
			} catch (Exception e) {
				
				System.out.println(e);
			}
			
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	}

}














