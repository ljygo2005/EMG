package Convert;

import java.io.IOException;
import java.util.ArrayList;

import DTO.EmgDTO;

public class SquareConvert {
	public SquareConvert() throws IOException {
	}

	public ArrayList<EmgDTO> ABStoSquare(ArrayList<EmgDTO> abs_list) {
		ArrayList<EmgDTO> square_list = new ArrayList<EmgDTO>();
		
		for(int i=0; i<abs_list.size(); i++) {
			EmgDTO dto = new EmgDTO();
			
			dto.setTime(abs_list.get(i).getTime());
			dto.setEmg1(abs_list.get(i).getEmg1() * abs_list.get(i).getEmg1());
			dto.setEmg2(abs_list.get(i).getEmg2() * abs_list.get(i).getEmg2());
			dto.setEmg3(abs_list.get(i).getEmg3() * abs_list.get(i).getEmg3());
			dto.setEmg4(abs_list.get(i).getEmg4() * abs_list.get(i).getEmg4());
			dto.setEmg5(abs_list.get(i).getEmg5() * abs_list.get(i).getEmg5());
			dto.setEmg6(abs_list.get(i).getEmg6() * abs_list.get(i).getEmg6());
			dto.setEmg7(abs_list.get(i).getEmg7() * abs_list.get(i).getEmg7());
			dto.setEmg8(abs_list.get(i).getEmg8() * abs_list.get(i).getEmg8());
			dto.setEx_num(abs_list.get(i).getEx_num());
			
			square_list.add(dto);
		}
		
		return square_list;
	}
}
