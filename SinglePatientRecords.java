package bootathonfinal;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.*;
public class SinglePatientRecords {

	
	public SinglePatientRecords(String Patient_id) 
		// TODO Auto-generated constructor stub
	{

        JFrame f= ObjectFile.getFrame("Patient Details");
        String[] columnNames = {"Patient_id", "Patient_name", "Hospital_id", "Hospital_name","Disease","Drug","Dosage","Date"};
       
       
        
       // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        JTable table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
       
        

        String Hospital_id = "";
        String Hospital_name = "";
        String Patient_id1="";
        String Patient_name="";
        String Disease="";
        String Drug="";
        String Dosage="";
        Date D;

        try {
        	Connection con=ObjectFile.getjdbc();
        	System.out.println(Patient_id);
        	String Query="select * from (Hospital natural join Patients natural join Checkup natural join Tablet natural join Prescription)where Patient_id='"+Patient_id+"' order by Date ";
        	Statement st=con.createStatement();
        	
            
            ResultSet rs = st.executeQuery(Query);
            
            int i = 0;
           
            while (rs.next()) {
                Hospital_id = rs.getString("Hospital_id");
                Hospital_name=rs.getString("Hospital_name");
                Patient_id1=rs.getString("Patient_id");
                Patient_name = rs.getString("Patient_name");
                Disease= rs.getString("Disease");
                Drug =rs.getString("Tablet_name");
                Dosage=rs.getString("Dosage");
                D=rs.getDate("Date");
                model.addRow(new Object[]{Patient_id, Patient_name, Hospital_id, Hospital_name,Disease,Drug,Dosage,D});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                System.out.println(i + " Record Found");
          
               
            }
            con.close();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        table.setRowHeight(60);
        JTableHeader header = table.getTableHeader();
       header.setBackground(Color.decode("#5424DA"));
       header.setForeground(Color.white);
       table.setPreferredScrollableViewportSize(new Dimension(450,63));
       table.setFillsViewportHeight(true);

 table.setFont(new Font("Merriweather",Font.PLAIN,20));

             table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
     {
     @Override
          public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
             {
         final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
         c.setBackground(row % 2 != 0 ? Color.decode("#5424DA") : Color.WHITE);
         c.setForeground(row % 2 == 0 ? Color.BLACK : Color.WHITE);
         return c;
             }
 });   
             header.setFont(new Font("Merriweather",Font.PLAIN,20));

        f.add(scroll);
        
    }
	public static void main(String []args)
	{
		//new SinglePatientRecords('')
	}

}
