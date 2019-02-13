package Convert;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Chart.ChartMain;
import DTO.EmgDTO;
import DiskIO.ExcelIO;
import DiskIO.FileIO;
import Merge.MergeImage;

public class MainConvert {
	final static int MoTwo = 2;
	final static int MoThree = 3;

	public static void main(String[] args) throws IOException {
		long startTimeMs = System.currentTimeMillis( );
		long taskTimeMs;
		System.out.println("==============Phase_1==============");
		System.out.println("Start EMG Conversion");
		
		//Experiment number (file name)
		String file_name = "emg_Ex04_³²_F2";
		
		//Variable to store each emg_list
		ArrayList<EmgDTO> raw_list = new ArrayList<EmgDTO>();
		ArrayList<EmgDTO> abs_list = new ArrayList<EmgDTO>();
		ArrayList<EmgDTO> ma2_list = new ArrayList<EmgDTO>();
		ArrayList<EmgDTO> ma3_list = new ArrayList<EmgDTO>();
		ArrayList<EmgDTO> square_list = new ArrayList<EmgDTO>();
		ArrayList<EmgDTO> rms2_list = new ArrayList<EmgDTO>();
		ArrayList<EmgDTO> rms3_list = new ArrayList<EmgDTO>();
		
		//Disk IO class
		FileIO fio = new FileIO(file_name);
		ExcelIO eio = new ExcelIO(file_name);
		
		//Initial directory creation settings
		fio.mkdir(file_name);
		
		//Read Raw_emg
		raw_list = fio.readEmgRaw();
		
		//Write Raw to file and Excel
		fio.writeRawEmg(raw_list);
		eio.writeRawEmg(raw_list);
		
		//Read from Raw to ABS
		abs_list = fio.readEmgtoABS();
		
		//Write ABS to file and Excel
		fio.writeABSEmg(abs_list);
		eio.writeABSEmg(abs_list);
		
		
		/**
		 * Convert from ABS to MA(Moving Average) 
		 */
		MAConvert ma = new MAConvert();
		int start_ma = 1;
		ArrayList<EmgDTO> one_set_ma = new ArrayList<EmgDTO>();
		for(int i=0; i<abs_list.size(); i++) {
			if(start_ma < abs_list.get(i).getEx_num() || i==abs_list.size()-1) {
				start_ma++;
				ma.MovingAverage(ma2_list, one_set_ma, MoTwo);
				ma.MovingAverage(ma3_list, one_set_ma, MoThree);
				one_set_ma = new ArrayList<EmgDTO>();
			}
			one_set_ma.add(abs_list.get(i));
		}
		//Write MA to file and Excel (Moving=2)
		fio.writeMAEmg2(ma2_list);
		eio.writeMAEmg2(ma2_list);
		//Write MA to file and Excel (Moving=3)
		fio.writeMAEmg3(ma3_list);
		eio.writeMAEmg3(ma3_list);
		
		
		/**
		 * Convert from ABS to Square
		 */
		SquareConvert rms = new SquareConvert();
		square_list = rms.ABStoSquare(abs_list);
		
		
		/**
		 * Convert from Square to RMS(Root Mean Square)
		 */
		int start_rms = 1;
		ArrayList<EmgDTO> one_set_rms = new ArrayList<EmgDTO>();
		for(int i=0; i<square_list.size(); i++) {
			if(start_rms < square_list.get(i).getEx_num() || i==square_list.size()-1) {
				start_rms++;
				ma.MovingAverage(rms2_list, one_set_rms, MoTwo);
				ma.MovingAverage(rms3_list, one_set_rms, MoThree);
				one_set_rms = new ArrayList<EmgDTO>();
			}
			one_set_rms.add(square_list.get(i));
		}
		//Write RMS to file and Excel (Moving=2)
		fio.writeRMSEmg2(rms2_list);
		eio.writeRMSEmg2(rms2_list);
		//Write RMS to file and Excel (Moving=3)
		fio.writeRMSEmg3(rms3_list);
		eio.writeRMSEmg3(rms3_list);
		
		eio.close();
		taskTimeMs = System.currentTimeMillis() - startTimeMs;
		System.out.println("EMG Conversion Complete (CPU_Time: "+taskTimeMs + ")");
		
		
		/**
		 * Store each list in a HashMap
		 */
		System.out.println("==============Phase_2==============");
		System.out.println("Create Chart");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("raw_list", raw_list);
		map.put("abs_list", abs_list);
		map.put("ma2_list", ma2_list);
		map.put("ma3_list", ma3_list);
		map.put("square_list", square_list);
		map.put("rms2_list", rms3_list);
		map.put("rms3_list", rms2_list);
		
		
		/**
		 * Class for creating charts
		 */
		ChartMain cm = new ChartMain(map, file_name);
		cm.start();
		taskTimeMs = System.currentTimeMillis() - startTimeMs;
		System.out.println("Complete Chart Creation (CPU_Time: "+taskTimeMs + ")");
		
		
		/**
		 * Start merging images
		 */
		System.out.println("==============Phase_3==============");
		System.out.println("Start Merging Images");
		
		MergeImage merge = new MergeImage(file_name);
		merge.start();
		taskTimeMs = System.currentTimeMillis() - startTimeMs;
		System.out.println("Image Merge Complete (CPU_Time: "+taskTimeMs + ")");
	}

}
