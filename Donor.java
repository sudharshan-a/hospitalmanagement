package bootathonfinal;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Donor {
	
	Donor()
	{

	JFrame f=ObjectFile.getFrame("Donors Page");
	f.setBackground(Color.WHITE);
	//JPanel jp=ObjectFile.getpanel();
	//f.setLayout(new BorderLayout());
	//f.add(jp,BorderLayout.WEST);
	JButton Adddonor=ObjectFile.getButton("Add Donor");
	JButton Seek=ObjectFile.getButton("Seek Donor");
	JButton Delete=ObjectFile.getButton("Delete Donor");

	
	
	Adddonor.setBounds(80, 160, 250, 40);
	
	
	Seek.setBounds(80, 220, 250, 40);
	
	Delete.setBounds(80, 290, 250, 40);
	
	Delete.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new DeleteDonor();
			
		}
	});
	Adddonor.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AddDonor();
			
		}
	});
	Seek.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Seek();
			
		}
	});
	
	
	f.add(Adddonor);
	f.add(Seek);
	f.add(Delete);
	JPanel panel = ObjectFile.getpanel();
	f.add(panel);
	
	
	}
	public static void main(String []args)
	{
		new Donor();
	}

}
