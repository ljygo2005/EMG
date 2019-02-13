package Convert;
import DTO.EmgDTO;

public class ABSConvert {
	public ABSConvert(){}
	
	public EmgDTO rawtoABS(String[] value) {
		EmgDTO dto = new EmgDTO();
		
		if(value.length == 10) {
			dto.setTime(Long.parseLong(value[0]));
			dto.setEmg1(Math.abs(Integer.parseInt(value[1])));
			dto.setEmg2(Math.abs(Integer.parseInt(value[2])));
			dto.setEmg3(Math.abs(Integer.parseInt(value[3])));
			dto.setEmg4(Math.abs(Integer.parseInt(value[4])));
			dto.setEmg5(Math.abs(Integer.parseInt(value[5])));
			dto.setEmg6(Math.abs(Integer.parseInt(value[6])));
			dto.setEmg7(Math.abs(Integer.parseInt(value[7])));
			dto.setEmg8(Math.abs(Integer.parseInt(value[8])));
			dto.setEx_num(Integer.parseInt(value[9]));
		}
		
		return dto;
	}
}
