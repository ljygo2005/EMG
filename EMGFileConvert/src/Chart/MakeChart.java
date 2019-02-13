package Chart;

import java.io.IOException;
import java.util.ArrayList;

import org.jfree.data.xy.XYDataset;

import DTO.EmgDTO;

public class MakeChart {
	String file_name;
	
	public MakeChart(String file_name) {
		this.file_name = file_name;
	}

	@SuppressWarnings("unused")
	public void makeChart(String type, ArrayList<EmgDTO> list) throws IOException {
		double min = 0;
		double max = 0;
		ArrayList<EmgDTO> temp_list = new ArrayList<EmgDTO>();	//Save to temporary list for each unit of experiment
		
		int start = 1;
			for(int i=0; i<list.size(); i++) {
				if(start < list.get(i).getEx_num() || i==list.size()-1) {
					start++;
					/*
					 * Emg1~8 chart
					 */
					Dataset ds = new Dataset();
					XYDataset total_data = ds.createTotalDataset(temp_list);
					XYLineChart_Total raw_total_chart = new XYLineChart_Total("EMG_"+type+"_total", "EMG_"+type+"_total", type,
							file_name, start-1, total_data);
					/*
					 * Generate each emg chart
					 */
					XYDataset emg1_data = ds.createEmg1Dataset(temp_list);
					XYLineChart_OneofSet raw_emg1_chart = new XYLineChart_OneofSet("EMG_"+type+"_1", "EMG_"+type+"_1", type,
															file_name, "emg1", start-1, emg1_data, max, min);
					XYDataset emg2_data = ds.createEmg2Dataset(temp_list);
					XYLineChart_OneofSet raw_emg2_chart = new XYLineChart_OneofSet("EMG_"+type+"_2", "EMG_"+type+"_2", type,
															file_name, "emg2", start-1, emg2_data, max, min);
					XYDataset emg3_data = ds.createEmg3Dataset(temp_list);
					XYLineChart_OneofSet raw_emg3_chart = new XYLineChart_OneofSet("EMG_"+type+"_3", "EMG_"+type+"_3", type,
															file_name, "emg3", start-1, emg3_data, max, min);
					XYDataset emg4_data = ds.createEmg4Dataset(temp_list);
					XYLineChart_OneofSet raw_emg4_chart = new XYLineChart_OneofSet("EMG_"+type+"_4", "EMG_"+type+"_4", type,
															file_name, "emg4", start-1, emg4_data, max, min);
					XYDataset emg5_data = ds.createEmg5Dataset(temp_list);
					XYLineChart_OneofSet raw_emg5_chart = new XYLineChart_OneofSet("EMG_"+type+"_5", "EMG_"+type+"_5", type,
															file_name, "emg5", start-1, emg5_data, max, min);
					XYDataset emg6_data = ds.createEmg6Dataset(temp_list);
					XYLineChart_OneofSet raw_emg6_chart = new XYLineChart_OneofSet("EMG_"+type+"_6", "EMG_"+type+"_6", type,
															file_name, "emg6", start-1, emg6_data, max, min);
					XYDataset emg7_data = ds.createEmg7Dataset(temp_list);
					XYLineChart_OneofSet raw_emg7_chart = new XYLineChart_OneofSet("EMG_"+type+"_7", "EMG_"+type+"_7", type,
															file_name, "emg7", start-1, emg7_data, max, min);
					XYDataset emg8_data = ds.createEmg8Dataset(temp_list);
					XYLineChart_OneofSet raw_emg8_chart = new XYLineChart_OneofSet("EMG_"+type+"_8", "EMG_"+type+"_8", type,
															file_name, "emg8", start-1, emg8_data, max, min);
					
					temp_list = new ArrayList<EmgDTO>();
					min = max = 0;
				}
				temp_list.add(list.get(i));
				
				
				//y축 범위를 설정하기 위해 최대-최소값 찾기
				max = max > list.get(i).getEmg1() ? max : list.get(i).getEmg1();
				max = max > list.get(i).getEmg2() ? max : list.get(i).getEmg2();
				max = max > list.get(i).getEmg3() ? max : list.get(i).getEmg3();
				max = max > list.get(i).getEmg4() ? max : list.get(i).getEmg4();
				max = max > list.get(i).getEmg5() ? max : list.get(i).getEmg5();
				max = max > list.get(i).getEmg6() ? max : list.get(i).getEmg6();
				max = max > list.get(i).getEmg7() ? max : list.get(i).getEmg7();
				max = max > list.get(i).getEmg8() ? max : list.get(i).getEmg8();

				min = min < list.get(i).getEmg1() ? min : list.get(i).getEmg1();
				min = min < list.get(i).getEmg2() ? min : list.get(i).getEmg2();
				min = min < list.get(i).getEmg3() ? min : list.get(i).getEmg3();
				min = min < list.get(i).getEmg4() ? min : list.get(i).getEmg4();
				min = min < list.get(i).getEmg5() ? min : list.get(i).getEmg5();
				min = min < list.get(i).getEmg6() ? min : list.get(i).getEmg6();
				min = min < list.get(i).getEmg7() ? min : list.get(i).getEmg7();
				min = min < list.get(i).getEmg8() ? min : list.get(i).getEmg8();
			}
		}
}
