package bootathonfinal;
import java.awt.*;
import java.sql.DriverManager;
import java.util.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset; 
import java.sql.*;


public class Pie_Chart {

	public Pie_Chart() {
		 LinkedHashMap<String,Integer> hm=new LinkedHashMap<String,Integer>();
	        System.out.println("hi");
	        try
	        {
	            
	        Connection con = ObjectFile.getjdbc();
	        Statement  st = con.createStatement();
	        String query="select disease,count(*) as Total from Prescription group by disease";
	        ResultSet result = st.executeQuery(query);
	        String disease=" ";
	        int num=0;
	        while(result.next())
	        {
	            disease=result.getString("disease");
	            num=result.getInt("Total");
	            hm.put(disease,num);
	           
	        }
	        con.close();
	        
	        }  
	        
	        catch(Exception e)
	        {
	            
	        }
	        DefaultPieDataset pie=new DefaultPieDataset();
	        Set<Map.Entry<String,Integer>>map=hm.entrySet();
	        for(Map.Entry<String,Integer>matp :map)
	        {
	            String name=matp.getKey();
	            int num=matp.getValue();
	             pie.setValue(name ,num); 
	        }
	        JFreeChart chart=ChartFactory.createPieChart("Pie chart",pie,true,true,true);
	        chart.getPlot().setBackgroundPaint( Color.WHITE );        
	        PiePlot p=(PiePlot)chart.getPlot();
	        ChartFrame f=new ChartFrame("Pie Chart",chart);
	        f.setVisible(true);
	        f.setLocationRelativeTo(null);
	        f.setBounds(820, 208, 650, 710);
	        f.setLayout(null);
	        
	   
	}
    public static void main(String[]args) {
    	new Pie_Chart();
    }
}
