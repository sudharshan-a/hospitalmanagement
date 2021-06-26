package bootathonfinal;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class StrongAES  {
   public static void main(String[] args) {
       JFrame frame = new JFrame();
  ImageIcon ii=new ImageIcon("/home/subash54/Desktop/logo.png");  
  Image image= ii.getImage().getScaledInstance(150,60,Image.SCALE_SMOOTH);
  ii=new ImageIcon(image);
  JLabel j1=new JLabel();
  j1.setBounds(200,10,200,70);
  j1.setIcon(ii);
  frame.add(j1);
  
  frame.setSize(400,400);
  
  frame.setLocationRelativeTo(null);
	frame.setLayout(null);
	
	frame.setVisible(true);
	
   }
}