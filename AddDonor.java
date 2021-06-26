package bootathonfinal;
import java.sql.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class AddDonor {

	AddDonor()
	{
	JFrame f= ObjectFile.getFrame("Donate");
    
        JTextField t1,t2;
        JComboBox cb,cb1,cb3;
        t1=new JTextField();
        t2=new JTextField();
        
        
        
        t1.setBounds(600,50,200,40); 
        t2.setBounds(600,125,200,40); 
        
        
        JLabel l1,l2,l3,l4,l5;  
        l1=new JLabel("Name");  
        l1.setFont(new Font("Times New Roman", Font.BOLD,20));
        l1.setBounds(400,50,100,40);  
        l2=new JLabel("Phone number");  
        l2.setBounds(400,125,200,40); 
        l2.setFont(new Font("Times New Roman", Font.BOLD,20));
        l3=new JLabel("Gender");  
        l3.setBounds(400,200,100,40);  
        l3.setFont(new Font("Times New Roman", Font.BOLD,20));
        l4=new JLabel("Organ");  
        l4.setFont(new Font("Times New Roman", Font.BOLD,20));
        l4.setBounds(400,275,100,40);  
        l5=new JLabel("Blood group");  
        l5.setFont(new Font("Times New Roman", Font.BOLD,20));
        l5.setBounds(400,350,200,40);  
        String Blood_Group[]={"O+","O-","A+","B+","AB-","A-","B-","AB+"};        
        cb=new JComboBox(Blood_Group);  
        String Gender[]= {"male","female","other"};
        cb3=new JComboBox(Gender);
        cb3.setBounds(600,200,200,40); 
        
        String Oragan[]={"heart","kidney","eyes","liver","lungs"}; 
        cb1=new JComboBox(Oragan);    
        JButton Adddonor=ObjectFile.getButton("Add Donor");
    	JButton Seek=ObjectFile.getButton("Seek Donor");
    	JButton Delete=ObjectFile.getButton("Delete Donor");
    	Adddonor.setBounds(80, 160, 250, 40);
    	
    	
    	Seek.setBounds(80, 220, 250, 40);
    	
    	Delete.setBounds(80, 290, 250, 40);
    	
		Seek.setForeground(Color.gray);
		Delete.setForeground(Color.gray);
		
    	
        cb1.setBounds(600,275,200,40); 
        cb.setBounds(600,350,200,40);
        
        f.add(l1); 
        f.add(l2); 
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(Adddonor);
        f.add(Seek);
        f.add(Delete);
       
        JButton b=ObjectFile.getButton("Donate");  
       
        b.setBounds(500,450,125,40);  
        f.add(b);  
        f.add(t1);
        f.add(t2);
        
        f.add(cb1);
        f.add(cb);
        f.add(cb3);
        b.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {       
                   String name=t1.getText();
                   String phone=t2.getText();
                   if(ObjectFile.regex(name, phone)==true)
                   {
                   String gender=(String) cb3.getItemAt(cb3.getSelectedIndex());
                   String organ=(String) cb1.getItemAt(cb1.getSelectedIndex());
                   String blood_group=(String) cb.getItemAt(cb.getSelectedIndex());
                   insert(name,phone,gender,organ,blood_group);
                   JOptionPane.showMessageDialog(null, "Done");
                   f.dispose();
                   }
                   else
                   {
                	   JOptionPane.showMessageDialog(f,"Please Enter Valid Data");
                   }
                }  
             }); 
          
        JPanel panel = ObjectFile.getpanel();
		f.add(panel);
    }
     void insert(String name,String phone,String gender,String organ,String blood_group) 
    {  try{
        Connection con = ObjectFile.getjdbc();
      
           
            Statement st = con.createStatement();
            
            String query1 = "insert into Donor (Organ,Blood_group,Hospital_id) values('"+organ+"','"+blood_group+"','"+FirstPage.hid+"')";

            System.out.println(query1);
            st.executeUpdate(query1);
            System.out.println("Value INserted  "+name+" "+phone+" "+gender+" "+organ+" "+blood_group);
            con.close();
            st.close();
        } catch (Exception ex) {
            System.out.println("  Exception   -->" + ex);
        }



}
     public static void main(String []args)
     {
    	 new AddDonor();
     }
}
