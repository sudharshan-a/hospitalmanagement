package bootathonfinal;
import java.awt.Color;

import javax.swing.*;

public class PopUp {

	PopUp(JFrame frame)
	{
		
		 JPanel panel = new JPanel();
			JTextField tf1 = new JTextField(20);
			tf1.setBounds(250, 200, 200,30);
		panel.setBounds(200, 150, 300, 150);
		panel.setBackground(Color.white); 
		
  JButton btn = new JButton("Ok",new ImageIcon("tic.png"));
		  btn.setMnemonic('O');
      btn.setBounds(250, 250, 80, 30);
      frame.add(btn);
      JButton btn1 = new JButton("Cancel");
      
		btn1.setBounds(350, 250, 80, 30);
		btn1.setBackground(Color.RED);
		btn1.setForeground(Color.WHITE);
		frame.add(tf1);	
		frame.add(btn1);
		frame.add(panel);
		
		//frame.setResizable(false);
	}
	public static void main(String []args)
	{
		
	}
}

