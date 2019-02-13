package Chart;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class LineChart_AWT extends ApplicationFrame{
	private static final long serialVersionUID = 1L;

	public LineChart_AWT(String applicationTitle, String chartTitle, String dir_name, DefaultCategoryDataset chart_dataset) throws IOException {
		super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(
				chartTitle,
				"Time",
				"Pressure",
				chart_dataset,
				PlotOrientation.VERTICAL,
				true, true, false);
		
		
		ChartPanel chartPanel = new ChartPanel( lineChart );
		chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		setContentPane( chartPanel );
		
		
		int width = 640;    /* Width of the image */
		int height = 480;   /* Height of the image */ 
		File image = new File( "e:/EmgData/"+dir_name+"/image/LineChart.jpeg" ); 
		ChartUtilities.saveChartAsJPEG(image ,lineChart, width ,height);
	}
}
