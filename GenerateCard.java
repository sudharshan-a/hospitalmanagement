package bootathonfinal;


	

	import java.awt.*;
	import javax.swing.*;
	import java.awt.event.*;  
	public class GenerateCard {
	
	
	    
	    GenerateCard(String name,String number,String id,String gender) {
	        JFrame f=new JFrame();
	        JPanel panel = new JPanel();
	        panel.setSize(140,300);
	        f.add(panel);
	        panel.setBackground(Color.decode("#5424BA"));
	        JLabel l1=new JLabel("Care+ Community Hospital Portal");
	        l1.setFont(new Font("Times New Roman",Font.PLAIN,20));
	        l1.setBounds(150,20,400,50);
	        l1.setForeground(Color.BLACK);
	        JLabel l2=new JLabel("Patient Card");
	        l2.setFont(new Font("Times New Roman",Font.PLAIN,17));
	        l2.setBounds(250,50,400,50);
	        l2.setForeground(Color.BLACK);
	        JLabel l3,l4,l5,l6,l7;
	        l3=new JLabel("Patient name      :"+name);
	        l4=new JLabel("Patient number   :"+number);
	        l5=new JLabel("Gender               :"+gender);
	        l6=new JLabel("Register at          :"+FirstPage.hname);
	        l7=new JLabel("Pateint ID           :"+id);
	        l7.setFont(new Font("Arial",Font.PLAIN,13));
	        l7.setBounds(200,90,400,30);
	        l7.setForeground(Color.BLACK);
	        l3.setFont(new Font("Arial",Font.PLAIN,13));
	        l3.setBounds(200,120,400,30);
	        l3.setForeground(Color.BLACK);
	        l4.setFont(new Font("Arial",Font.PLAIN,13));
	        l4.setBounds(200,150,400,30);
	        l4.setForeground(Color.BLACK);
	        l5.setFont(new Font("Arial",Font.PLAIN,13));
	        l5.setBounds(200,180,400,30);
	        l5.setForeground(Color.BLACK);
	        l6.setFont(new Font("Arial",Font.PLAIN,13));
	        l6.setBounds(200,210,400,30);
	        l6.setForeground(Color.BLACK);
	        f.getContentPane().setBackground(Color.WHITE);
	        f.add(l1);
	        f.add(l2);
	        f.add(l3);
	        f.add(l4);
	        f.add(l5);
	        f.add(l6);
	        f.add(l7);
	        f.setBounds(800, 300,500,300);
	        f.setLayout(null);
	        f.setVisible(true);   
	    }
	    public static void main(String args[])
	    {
	    	new GenerateCard("subash", "1234567875", "1234", "male");
	    }
	    
	}


