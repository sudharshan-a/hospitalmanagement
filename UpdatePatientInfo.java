package bootathonfinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;



public class UpdatePatientInfo {
		static int Checkup_id;
		 String [] tablets=new String[100];
		 int i =0;
		UpdatePatientInfo(int Checkup_id){
			this.Checkup_id=Checkup_id;
			JFrame frame = ObjectFile.getFrame("Update patient info");
			
			JLabel dis = new JLabel("Enter the diseases");
			dis.setBounds(380, 100, 200, 30);
			dis.setFont(new Font("Times New Roman", Font.BOLD,20));
			frame.add(dis);
			
			JTextField diseases = new JTextField();
			diseases.setBounds(540, 100, 200, 40);
			frame.add(diseases);
			
			JLabel dru = new JLabel("Enter the drug");
			dru.setBounds(380, 200, 200, 30);
			dru.setFont(new Font("Times New Roman", Font.BOLD,20));
			frame.add(dru);
			
			
			
			
			try {
			Connection con = (Connection) ObjectFile.getjdbc();
			String query = "Select * from Tablet";
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				tablets[i++] = rs.getString("Tablet_name");
			}
			System.out.println(tablets);
			con.close();
			}catch(Exception e) {
				System.out.println("The error found"+e);
			}
		
			JComboBox tablet = new JComboBox(tablets);
			tablet.setBounds(540, 200, 200, 40);
			Border border = new LineBorder(Color.BLACK, 0, false);
			tablet.setBorder(border);
			tablet.setBackground(Color.WHITE);
			frame.add(tablet);
			
			JLabel dose = new JLabel("Enter the dosage");
			dose.setBounds(380, 300, 200, 30);
			dose.setFont(new Font("Times New Roman", Font.BOLD,20));
			frame.add(dose);
			
			JTextField dosage = new JTextField();
			dosage.setBounds(540, 300, 200, 40);
			frame.add(dosage);
			
			JButton addnewdiseases = ObjectFile.getButton("Add ");
			addnewdiseases.setBounds(760, 100, 100, 30);
			//addnewdiseases.setBackground(Color.WHITE);
			frame.add(addnewdiseases);
			
			JButton addnewdrug = ObjectFile.getButton("Add");
			addnewdrug.setBounds(760, 200, 100, 30);
			
			frame.add(addnewdrug);
			
			JButton Update = ObjectFile.getButton("Update patient info");
			Update.setBounds(460, 370, 300, 40);
			
			frame.add(Update);
			JPanel panel = ObjectFile.getpanel();
			frame.add(panel);
			
			
			
			addnewdiseases.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					diseases.setText("");
					
				}
			});
			
			
			Update.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String diseases_info = diseases.getText().toLowerCase();
					
					String drug_info =  (String) tablet.getItemAt(tablet.getSelectedIndex());
					
					String dosage_info = dosage.getText();
					if(diseases.getText().isEmpty()!=true && drug_info.isEmpty()!=true&& dosage.getText().isEmpty()!=true ) {
						
						int temp=0;
						Connection con=(Connection) ObjectFile.getjdbc();
						try {
							Statement st=con.createStatement();
							String Query="Select Tablet_id from Tablet where Tablet_name='"+drug_info+"'";
							ResultSet rs=st.executeQuery(Query);
							while(rs.next())
							{
							temp=rs.getInt("Tablet_id");
							break;
							}
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						update_patient(diseases_info,temp,dosage_info);
					}
					
					else {
						JOptionPane.showMessageDialog(frame,"Please include all the fields");
					
					
				}
			}});
			
			addnewdrug.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					dosage.setText("");
					
				}
			});
			 	
		}
		public static void update_patient(String diseases , int drug , String dosage)  {
			Connection con=(Connection) ObjectFile.getjdbc();
			String query="insert into Prescription (Checkup_id,Tablet_id,Disease,Dosage)values('"+Checkup_id+"',"+drug+",'"+diseases+"','"+dosage+"')";
		    try {
				Statement st=con.createStatement();
				int d=st.executeUpdate(query);
				if(d==1)
				{
					System.out.println("Successfully done!");
					JOptionPane.showMessageDialog(null,"Succesfully updated");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
		}



}

