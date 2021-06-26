package bootathonfinal;
import java.awt.*;
import java.sql.DriverManager;
import java.util.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset; 
import java.sql.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class BarChart {

		
	    BarChart() {
	        LinkedHashMap<String,Integer> hm=new LinkedHashMap<String,Integer>();
	                try
	        {
	            
	        Connection con = ObjectFile.getjdbc();
	        Statement  st = con.createStatement();
	        String query="select District,count(*) as Total from (Patients NATURAL JOIN Prescription natural join Checkup) group by District";
	        ResultSet result = st.executeQuery(query);
	        String disease=" ";
	        int num=0;
	        while(result.next())
	        {
	            disease=result.getString("District");
	            num=result.getInt("Total");
	            System.out.println(disease+" "+num);
	            
	            hm.put(disease,num);
	           
	        }
	        con.close();
	        
	        }  
	        
	        catch(Exception e)
	        {
	            
	        }
	        DefaultCategoryDataset pie=new DefaultCategoryDataset();
	        Set<Map.Entry<String,Integer>>map=hm.entrySet();
	        for(Map.Entry<String,Integer>matp :map)
	        {
	            String name=matp.getKey();
	            int num=matp.getValue();
	             pie.setValue(num,"Count",name); 
	        }
	        JFreeChart chart=ChartFactory.createBarChart("Affected areas","Place","No of disease",pie,PlotOrientation.VERTICAL,false,true,false);
	        chart.getPlot().setBackgroundPaint( Color.WHITE );        
	        CategoryPlot p=(CategoryPlot)chart.getCategoryPlot();
	        p.setRangeGridlinePaint(Color.BLACK);
	        ChartFrame f=new ChartFrame("Bar Chart",chart);
	        f.setVisible(true);
	        f.setBounds(820, 208, 650, 710);
	        //f.setSize(600,600);

	    } 
	    public static void main(String  []args)
	    {
	    	new BarChart();
	    }
	
}
