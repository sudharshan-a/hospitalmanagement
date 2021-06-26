package bootathonfinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

class ViewallPatient
{
	ViewallPatient()
	{
		JFrame f= ObjectFile.getFrame("Patient Details");
        String[] columnNames = {"Patient_id", "Patient_name",};
       
       
        
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
       
        

      
        String Patient_id="";
        String Patient_name="";
       
        try {
        	Connection con=ObjectFile.getjdbc();
        	
        	String Query="select distinct(Patient_name),Patient_id from(Checkup natural join Patients )where Hospital_id='"+FirstPage.hid+"'";
        	Statement st=con.createStatement();
        	
            
            ResultSet rs = st.executeQuery(Query);
            
            int i = 0;
           
            while (rs.next()) {
              
                Patient_id=rs.getString("Patient_id");
                Patient_name = rs.getString("Patient_name");
                
                model.addRow(new Object[]{Patient_id, Patient_name, });
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
        table.setRowHeight(30);
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
	
}