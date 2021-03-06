package Chart;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.BasicStroke; 

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.ui.ApplicationFrame; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;


public class XYLineChart_OneofSet extends ApplicationFrame {
	private static final long serialVersionUID = 1L;

	public XYLineChart_OneofSet(String applicationTitle, String chartTitle, String type, String dir_name,
							String emg_num, int ex_num, XYDataset chart_dataset, double max, double min) throws IOException {
		super(applicationTitle);
		JFreeChart xylineChart = ChartFactory.createXYLineChart(
		     chartTitle ,
		     "Time" ,
		     "EmgPressure" ,
		     chart_dataset ,
		     PlotOrientation.VERTICAL ,
		     true , true , false);
		     
		ChartPanel chartPanel = new ChartPanel( xylineChart );
		chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		final XYPlot plot = xylineChart.getXYPlot( );
		
		/**
		 * y축 범위 설정 코드
		 */		
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setRange( min*1.15, max*1.15);
		//rangeAxis.setTickUnit(new NumberTickUnit(10));
		

		  
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
		renderer.setSeriesPaint( 0 , Color.RED );
		renderer.setSeriesPaint( 1 , Color.GREEN );
		renderer.setSeriesPaint( 2 , Color.YELLOW );
		renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
		renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
		renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
		plot.setRenderer( renderer ); 
		setContentPane( chartPanel ); 
		
		
		//draw
		File dir = new File("e:/EmgData/"+dir_name+"/image/raw/ex"+ex_num);
		if(!dir.isDirectory())
			dir.mkdirs();

		int width = 640;
		int height = 480;
		File image = new File( "e:/EmgData/"+dir_name+"/image/"+type+"/ex"+ex_num+"/"+type+"_"+emg_num+"_ex"+ex_num+".jpeg");
		ChartUtilities.saveChartAsJPEG(image ,xylineChart, width ,height);
   }
	
}