package Chart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import DTO.EmgDTO;

public class ChartMain {
	HashMap<String, Object> map;
	String file_name;
	
	public ChartMain(HashMap<String, Object> map, String file_name){
		this.map = map;
		this.file_name = file_name;
	}

	@SuppressWarnings("unchecked")
	public void start() throws IOException {
		/**
		 * Importing emg_list from a Hash into a ArrayList
		 */
		ArrayList<EmgDTO> raw_list = (ArrayList<EmgDTO>) map.get("raw_list");
		ArrayList<EmgDTO> abs_list = (ArrayList<EmgDTO>) map.get("abs_list");
		ArrayList<EmgDTO> square_list = (ArrayList<EmgDTO>) map.get("square_list");
		ArrayList<EmgDTO> ma2_list = (ArrayList<EmgDTO>) map.get("ma2_list");
		ArrayList<EmgDTO> ma3_list = (ArrayList<EmgDTO>) map.get("ma3_list");
		ArrayList<EmgDTO> rms2_list = (ArrayList<EmgDTO>) map.get("rms2_list");
		ArrayList<EmgDTO> rms3_list = (ArrayList<EmgDTO>) map.get("rms3_list");
		
		/**
		 * Create charts for each list
		 */		
		MakeChart mkchart = new MakeChart(file_name);
		mkchart.makeChart("raw", raw_list);
		System.out.println("Complete raw chart generation");
		mkchart.makeChart("abs", abs_list);
		System.out.println("Complete abs chart generation");
		mkchart.makeChart("square", square_list);
		System.out.println("Complete square chart generation");
		mkchart.makeChart("ma2", ma2_list);
		System.out.println("Complete ma2 chart generation");
		mkchart.makeChart("ma3", ma3_list);
		System.out.println("Complete ma3 chart generation");
		mkchart.makeChart("rms2", rms2_list);
		System.out.println("Complete rms2 chart generation");
		mkchart.makeChart("rms3", rms3_list);
		System.out.println("Complete rms3 chart generation");
		
	}
}
