package bootathonfinal;
import java.awt.*;  
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.sql.*;

public class Hospital extends Canvas{
	  

	Hospital(String s)
	{
	
		JFrame frame =ObjectFile.getFrame("Hospital");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel circleLabel = new JLabel();
		JLabel circleLabel2 = new JLabel();
		CircleButton circleButton1 = new CircleButton("Admin");
		circleButton1.setFont(new Font("Merriweather",Font.PLAIN,30));
		circleButton1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Admin");
					new Admin();
				}
		});
		CircleButton circleButton2 = new CircleButton("Doctor");
		circleButton2.setFont(new Font("Merriweather",Font.PLAIN,30));
		circleButton2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Admin");
					Password();
				}
		});
		
		JPanel panel = new JPanel();
		
	    panel.setSize(1000,100);
	    panel.setBackground(Color.decode("#5424BA"));
	    JLabel label=new JLabel();
	    label.setText("Care+ Community Hospital Portal");
	    label.setBounds(450,600,200,200);
	    label.setFont(new Font("Times New Roman", Font.BOLD, 40));
	    label.setForeground(Color.WHITE);
	    JLabel l3=new JLabel();
	    l3.setText("Welcome "+s);
	    l3.setBounds(170,100,500,200);
	    l3.setFont(new Font("Merriweather", Font.BOLD, 40));
	    frame.add(l3);
        panel.add(label);
	    circleButton2.setBounds(550,300,200,200);
	    circleLabel2.setBounds(550,300,200,200);
		frame.add(circleLabel);
		frame.add(circleButton1);
		circleButton1.setBounds(200,300,200,200);
	    circleLabel.setBounds(200,300,200,200);
		frame.add(circleLabel2);
		frame.add(circleButton2);
		frame.add(panel);
    	frame.setSize(1000,700); 
        frame.setLayout(null);
	    frame.setVisible(true);
	    panel.add(label);
	    
	    JLabel l1=new JLabel();
	    l1.setBounds(700,-120,500,500);
	    
	    frame.add(l1);
	    ImageIcon ii=new ImageIcon("/home/subash54/Desktop/tri.png");  
	    Image image= ii.getImage().getScaledInstance(500,400,Image.SCALE_SMOOTH);
	    ii=new ImageIcon(image);
	    l1.setIcon(ii);
	    
	    JLabel l2=new JLabel();
	    l2.setBounds(-80,370,500,500);
	    ImageIcon i=new ImageIcon("/home/subash54/Desktop/tri1.png");  
	    Image img= i.getImage().getScaledInstance(500,400,Image.SCALE_SMOOTH);
	    i=new ImageIcon(img);
	    l2.setIcon(i);
	    frame.add(l2);
		
	}
	public static void Password()
	{
		JFrame f1=new JFrame("Password");
		JPasswordField jp=new JPasswordField();
		JLabel jl=new JLabel("Enter the Password");
		jl.setBounds(50, 30, 200, 30);
		jp.setBounds(50, 60, 250, 30);
		JButton jb=ObjectFile.getButton("Ok");
		
		jb.setBounds(75,  120,145, 30);
		f1.add(jb);
		f1.add(jp);
		f1.add(jl);
		f1.setSize(400,200);
		f1.setLocationRelativeTo(null);
		f1.setLayout(null);
		f1.getContentPane().setBackground(Color.white);
		f1.setVisible(true);
		f1.setResizable(false);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String password=new String(jp.getPassword());
				String password1=pass();
				System.out.println(password+" "+password1);
				if(password1.equals(password))
				{
					new Doctor();
				}
				else
				{
					JOptionPane.showMessageDialog(f1, "Password is incorrect");
				}
				
				
			}
		});
		
	}
	private static String pass()
	{
		String db="";
		Connection con=ObjectFile.getjdbc();
		try {
			Statement st=con.createStatement();
			String query="select Doctor_password from Hospital where Hospital_id='"+FirstPage.hid+"'";
			ResultSet rs=	st.executeQuery(query);
			
			while(rs.next())
			{
			db=rs.getString("Doctor_password");
			break;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Password.decrypt_password(db);
		
		
	}
	
	 
}
