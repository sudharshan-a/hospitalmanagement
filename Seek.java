package bootathonfinal;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.event.*;


public class Seek  {

    /**
     * @param args the command line arguments
     */
    static JComboBox cb,cb1;
    static JTable table;
    static Connection con;
    
    public Seek()
    {
                JFrame f=ObjectFile.getFrame("Seek");
                f.setBackground(Color.WHITE);
    JLabel l1,l2;  
    l1=new JLabel("Blood Group:");  
    l1.setBounds(425,200, 100,50);  
    l2=new JLabel("Organ:");  
    l2.setBounds(425,275, 100,50);  
    String Blood_Group[]={"o+","o-","a+","b+","ab-","a-","b-","ab+"};        
    cb=new JComboBox(Blood_Group);    
    cb.setBounds(525,200,150,40); 
    String Oragan[]={"heart","kidney","eyes","liver","lungs"}; 
    cb1=new JComboBox(Oragan);    
    cb1.setBounds(525,275,150,40); 
    JButton b=ObjectFile.getButton("Click");
    b.setBounds(525,350,95,40);
    JButton Adddonor=ObjectFile.getButton("Add Donor");
	JButton Seek=ObjectFile.getButton("Seek Donor");
	JButton Delete=ObjectFile.getButton("Delete Donor");
	Adddonor.setBounds(80, 160, 250, 40);
	
	
	Seek.setBounds(80, 220, 250, 40);
	
	Delete.setBounds(80, 290, 250, 40);
	
	Adddonor.setForeground(Color.gray);
	Delete.setForeground(Color.gray);
    b.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {       
                   String blood_group=String.valueOf(cb.getItemAt(cb.getSelectedIndex()));
                   String organ=String.valueOf(cb1.getItemAt(cb1.getSelectedIndex()));
                   fetchresult(blood_group,organ);
                   
                }  
             });   
    f.add(b);
    f.add(cb);  
    f.add(cb1);
    f.add(l1);
    f.add(l2);
    f.add(Adddonor);
    f.add(Seek);
    f.add(Delete);
      JPanel jp=ObjectFile.getpanel();
	  f.add(jp);
    
    }
        static String Data =" "; 
    static void fetchresult(String blood_group,String organ)
    {
        
        JFrame j1=ObjectFile.getFrame("Details");
        j1.setBackground(Color.WHITE);
        j1.setLayout(new BorderLayout());
        String[] columnNames = {"Hospital_id","Hospital_name","Donor_id","Hospital_phonenumber", "Organ","Blood_group"};
        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        String s4=String.valueOf(cb.getItemAt(cb.getSelectedIndex()));
            String s5=String.valueOf(cb1.getItemAt(cb1.getSelectedIndex()));
           try {
            Connection con = ObjectFile.getjdbc();
            Statement  st = con.createStatement();
            String sql="SELECT * FROM Donor natural join Hospital WHERE Blood_group='"+blood_group+"' AND Organ='"+organ+"'" ;
            System.out.println(sql);
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
                JOptionPane.showMessageDialog(j1, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                System.out.println(i + " Records Found");
            }
            
            con.close();
           }catch (Exception ex) {
            JOptionPane.showMessageDialog(j1, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

           
          
        j1.add(scroll);
        scroll.setVisible(true);
        j1.setSize(1000,700);
        j1.setVisible(true);
    }
    public static void main(String []args)
    {
    	new Seek();
    }

}


