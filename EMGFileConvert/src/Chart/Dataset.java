package Chart;

import java.util.ArrayList;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import DTO.EmgDTO;

public class Dataset {
	
	public Dataset(){}

	public XYDataset createTotalDataset(ArrayList<EmgDTO> list) {
		final XYSeries emg1 = new XYSeries( "emg1" );
		final XYSeries emg2 = new XYSeries( "emg2" );
		final XYSeries emg3 = new XYSeries( "emg3" );
		final XYSeries emg4 = new XYSeries( "emg4" );
		final XYSeries emg5 = new XYSeries( "emg5" );
		final XYSeries emg6 = new XYSeries( "emg6" );
		final XYSeries emg7 = new XYSeries( "emg7" );
		final XYSeries emg8 = new XYSeries( "emg8" );
		for(int i=0; i<list.size(); i++) {
			emg1.add(list.get(i).getTime(), list.get(i).getEmg1());
			emg2.add(list.get(i).getTime(), list.get(i).getEmg2());
			emg3.add(list.get(i).getTime(), list.get(i).getEmg3());
			emg4.add(list.get(i).getTime(), list.get(i).getEmg4());
			emg5.add(list.get(i).getTime(), list.get(i).getEmg5());
			emg6.add(list.get(i).getTime(), list.get(i).getEmg6());
			emg7.add(list.get(i).getTime(), list.get(i).getEmg7());
			emg8.add(list.get(i).getTime(), list.get(i).getEmg8());
		}
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );
		dataset.addSeries( emg1 );
		dataset.addSeries( emg2 );
		dataset.addSeries( emg3 );
		dataset.addSeries( emg4 );
		dataset.addSeries( emg5 );
		dataset.addSeries( emg6 );
		dataset.addSeries( emg7 );
		dataset.addSeries( emg8 );
		return dataset;
	}
	
	public XYDataset createEmg1Dataset(ArrayList<EmgDTO> list) {
		final XYSeries emg = new XYSeries( "emg1" );
		for(int i=0; i<list.size(); i++) {
			emg.add(list.get(i).getTime(), list.get(i).getEmg1());
		}
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );
		dataset.addSeries( emg );
		return dataset;
	}
	
	public XYDataset createEmg2Dataset(ArrayList<EmgDTO> list) {
		final XYSeries emg = new XYSeries( "emg2" );
		for(int i=0; i<list.size(); i++) {
			emg.add(list.get(i).getTime(), list.get(i).getEmg2());
		}
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );
		dataset.addSeries( emg );
		return dataset;
	}
	
	public XYDataset createEmg3Dataset(ArrayList<EmgDTO> list) {
		final XYSeries emg = new XYSeries( "emg3" );
		for(int i=0; i<list.size(); i++) {
			emg.add(list.get(i).getTime(), list.get(i).getEmg3());
		}
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );
		dataset.addSeries( emg );
		return dataset;
	}
	
	public XYDataset createEmg4Dataset(ArrayList<EmgDTO> list) {
		final XYSeries emg = new XYSeries( "emg4" );
		for(int i=0; i<list.size(); i++) {
			emg.add(list.get(i).getTime(), list.get(i).getEmg4());
		}
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );
		dataset.addSeries( emg );
		return dataset;
	}
	
	public XYDataset createEmg5Dataset(ArrayList<EmgDTO> list) {
		final XYSeries emg = new XYSeries( "emg5" );
		for(int i=0; i<list.size(); i++) {
			emg.add(list.get(i).getTime(), list.get(i).getEmg5());
		}
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );
		dataset.addSeries( emg );
		return dataset;
	}
	
	public XYDataset createEmg6Dataset(ArrayList<EmgDTO> list) {
		final XYSeries emg = new XYSeries( "emg6" );
		for(int i=0; i<list.size(); i++) {
			emg.add(list.get(i).getTime(), list.get(i).getEmg6());
		}
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );
		dataset.addSeries( emg );
		return dataset;
	}
	
	public XYDataset createEmg7Dataset(ArrayList<EmgDTO> list) {
		final XYSeries emg = new XYSeries( "emg7" );
		for(int i=0; i<list.size(); i++) {
			emg.add(list.get(i).getTime(), list.get(i).getEmg7());
		}
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );
		dataset.addSeries( emg );
		return dataset;
	}
	
	public XYDataset createEmg8Dataset(ArrayList<EmgDTO> list) {
		final XYSeries emg = new XYSeries( "emg8" );
		for(int i=0; i<list.size(); i++) {
			emg.add(list.get(i).getTime(), list.get(i).getEmg8());
		}
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );
		dataset.addSeries( emg );
		return dataset;
	}
	
}
