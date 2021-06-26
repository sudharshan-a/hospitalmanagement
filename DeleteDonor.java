package bootathonfinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.*;
import java.awt.event.*;  
import javax.swing.*;    
import javax.swing.event.*;
import javax.swing.table.*;
public class DeleteDonor{
    static String Data;
      static JFrame f;
        DeleteDonor()
        {
              f=ObjectFile.getFrame("Delete Organ");
              
              DeleteDonor.deleteorgan();
              JOptionPane.showMessageDialog(f,"Click the Donor ID to Delete");
    
        
        }
        static void deleteorgan()
        {
                    
        
        f.setLayout(new BorderLayout());
        String[] columnNames = {"Hospital_id","Hospital_name","Donor_id","Hospital_phonenumber", "Organ","Blood_group"};
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
           try {
            Connection con =ObjectFile.getjdbc();
            Statement  st = con.createStatement();
            String sql="SELECT * FROM Donor natural join Hospital WHERE hospital_id='"+FirstPage.hid+"'" ;
            ResultSet rs=st.executeQuery(sql);
            int i=0;
            while(rs.next())
            {
            	String Hospital_id = rs.getString("Hospital_id");
                String name = rs.getString("Hospital_name");
                String Hospitalno=rs.getString("Hospital_phonenumber");
                int did=rs.getInt("Donor_id");
                String organs = rs.getString("Organ");
                String blood=rs.getString("Blood_group");
                System.out.println(name+" "+organs+" "+blood);
                model.addRow(new Object[]{Hospital_id,name,did,Hospitalno, organs,blood});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(f, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                System.out.println(i + " Records Found");
            }
            
            con.close();
           }catch (Exception ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
           table.setCellSelectionEnabled(true); 
            ListSelectionModel select= table.getSelectionModel();  
           select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
            select.addListSelectionListener(new ListSelectionListener() {  
              public void valueChanged(ListSelectionEvent e) {  
                 
                int[] row = table.getSelectedRows();  
                int[] columns = table.getSelectedColumns();  
                for (int i = 0; i < row.length; i++) {  
                  for (int j = 0; j < columns.length; j++) {  
                    Data =String.valueOf(table.getValueAt(row[i], columns[j]));
                    

                  } }
                try{
            Connection con1=ObjectFile.getjdbc();
            Statement  st = con1.createStatement();   
            String name=Data;
         String query="delete from Donor where Donor_id='"+name+"'";

            int result = st.executeUpdate(query);
            
            con1.close();
            JOptionPane.showMessageDialog(f,"Successfully deleted");
            f.dispose();
            System.out.println("Success!"); 
            }
            catch(Exception a)
            {
                    System.out.println("  Exception   -->" + a);
    
            }
                System.out.println("Table element selected is: " + Data);    
              }       
            }); 
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
    public static void main(String a[])
    {
    	
    	
        
    }
    
}

