package bootathonfinal;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  

  
    

public class Chart {
	
	    Chart()
	    {
	        JFrame f=ObjectFile.getFrame("");
	      
	       
	        JButton b1=ObjectFile.getButton("Disease wise");
	        b1.setBounds(80, 100, 250, 40);
	        f.add(b1);
	        JButton b2=ObjectFile.getButton("District wise");
	        b2.setBounds(80,170, 250, 40);
	        b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Pie_Chart();
				}
			});
	        b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new BarChart();
				}
			});
	       
	        f.add(b2);
	        JPanel panel = ObjectFile.getpanel();		       
	        f.add(panel);
	    }
	    public static void main(String []args)
	    {
	    	new Chart();
	    }
	    
	}



