package Convert;

import java.io.IOException;
import java.util.ArrayList;

import DTO.EmgDTO;

public class MAConvert {
	public MAConvert() throws IOException {
	}

	public void MovingAverage(ArrayList<EmgDTO> total, ArrayList<EmgDTO> abs_list, int m) throws IOException {
		if (m > abs_list.size()) {
			throw new IllegalArgumentException();
		}
		
		for(int i = m-1; i < abs_list.size(); i++) {
			EmgDTO dto = new EmgDTO();
			double[] sum = new double[8];
			
			for(int j = 0; j < m; j++) {
				sum[0] += abs_list.get(i-j).getEmg1();
				sum[1] += abs_list.get(i-j).getEmg2();
				sum[2] += abs_list.get(i-j).getEmg3();
				sum[3] += abs_list.get(i-j).getEmg4();
				sum[4] += abs_list.get(i-j).getEmg5();
				sum[5] += abs_list.get(i-j).getEmg6();
				sum[6] += abs_list.get(i-j).getEmg7();
				sum[7] += abs_list.get(i-j).getEmg8();
			}
			dto.setTime(abs_list.get(i).getTime());
			dto.setEmg1(sum[0] / m);
			dto.setEmg2(sum[1] / m);
			dto.setEmg3(sum[2] / m);
			dto.setEmg4(sum[3] / m);
			dto.setEmg5(sum[4] / m);
			dto.setEmg6(sum[5] / m);
			dto.setEmg7(sum[6] / m);
			dto.setEmg8(sum[7] / m);
			dto.setEx_num(abs_list.get(i).getEx_num());
			
			total.add(dto);
		}
	}

}
