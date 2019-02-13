package DiskIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Convert.ABSConvert;
import DTO.EmgDTO;

public class FileIO {
	String file_name;
	
	public FileIO(String file_name) throws IOException {
		this.file_name = file_name;
	}
	
	/*
	 * Initial directory creation settings
	 */
	public void mkdir(String file_name) {
		File f = new File("e:/EmgData/"+file_name);
		if(!f.isDirectory()) {
			f.mkdirs();
		}
		
		File img_f = new File("e:/EmgData/"+file_name+"/image");
		if(!img_f.isDirectory()) {
			img_f.mkdirs();
		}
		
		File raw_f = new File("e:/EmgData/"+file_name+"/image/raw");
		if(!raw_f.isDirectory()) {
			raw_f.mkdirs();
		}
		
		File abs_f = new File("e:/EmgData/"+file_name+"/image/abs");
		if(!abs_f.isDirectory()) {
			abs_f.mkdirs();
		}
		
		File square_f = new File("e:/EmgData/"+file_name+"/image/square");
		if(!square_f.isDirectory()) {
			square_f.mkdirs();
		}
		
		File ma2_f = new File("e:/EmgData/"+file_name+"/image/ma2");
		if(!ma2_f.isDirectory()) {
			ma2_f.mkdirs();
		}
		
		File ma3_f = new File("e:/EmgData/"+file_name+"/image/ma3");
		if(!ma3_f.isDirectory()) {
			ma3_f.mkdirs();
		}
		
		File rms2_f = new File("e:/EmgData/"+file_name+"/image/rms2");
		if(!rms2_f.isDirectory()) {
			rms2_f.mkdirs();
		}
		
		File rms3_f = new File("e:/EmgData/"+file_name+"/image/rms3");
		if(!rms3_f.isDirectory()) {
			rms3_f.mkdirs();
		}
	}
	
	/**
	 * Read EMG
	 */
	public ArrayList<EmgDTO> readEmgRaw() throws IOException{
		ArrayList<EmgDTO> list = new ArrayList<EmgDTO>();
		BufferedReader in = new BufferedReader(new FileReader("e:/EmgData/"+file_name+".txt"));
		
		String line;
		
		while((line = in.readLine()) != null) {
			String[] value = line.split("\t");
			
			for(int i=0; i<value.length; i++)
				value[i] = value[i].trim();
			
			if(value.length == 10) {
				EmgDTO dto = new EmgDTO();
				
				dto.setTime(Long.parseLong(value[0]));
				dto.setEmg1(Integer.parseInt(value[1]));
				dto.setEmg2(Integer.parseInt(value[2]));
				dto.setEmg3(Integer.parseInt(value[3]));
				dto.setEmg4(Integer.parseInt(value[4]));
				dto.setEmg5(Integer.parseInt(value[5]));
				dto.setEmg6(Integer.parseInt(value[6]));
				dto.setEmg7(Integer.parseInt(value[7]));
				dto.setEmg8(Integer.parseInt(value[8]));
				dto.setEx_num(Integer.parseInt(value[9]));
				list.add(dto);
			}
		}
		
		if(in != null) in.close();
		
		return list;
	}
	
	/**
	 * read EMG to ABS
	 */
	public ArrayList<EmgDTO> readEmgtoABS() throws IOException{
		ArrayList<EmgDTO> list = new ArrayList<EmgDTO>();
		BufferedReader in = new BufferedReader(new FileReader("e:/EmgData/"+file_name+".txt"));
		
		String line;
		ABSConvert abs = new ABSConvert();
		
		while((line = in.readLine()) != null) {
			String[] value = line.split("\t");
			
			for(int i=0; i<value.length; i++)
				value[i] = value[i].trim();
			
			if(value.length == 10) {
				EmgDTO dto = new EmgDTO();
				dto = abs.rawtoABS(value);
				list.add(dto);
			}
		}
		
		if(in != null) in.close();
		
		return list;
	}
	
	/**
	 * write Raw
	 */
	public void writeRawEmg(ArrayList<EmgDTO> list) throws IOException {
		File f = new File("e:/EmgData/"+file_name+"/raw_"+file_name+".txt");
		FileWriter out = new FileWriter(f);
		
		for(int i=0; i<list.size(); i++) {
			String str = 
					list.get(i).getTime() + 
					"\t" + (int)list.get(i).getEmg1() +
					"\t" + (int)list.get(i).getEmg2() + 
					"\t" + (int)list.get(i).getEmg3() + 
					"\t" + (int)list.get(i).getEmg4() +
					"\t" + (int)list.get(i).getEmg5() +
					"\t" + (int)list.get(i).getEmg6() +
					"\t" + (int)list.get(i).getEmg7() +
					"\t" + (int)list.get(i).getEmg8() +
					"\t" + (int)list.get(i).getEx_num() + "\n";
			out.write(str);
		}
		out.close();
	}
	
	/**
	 * write ABS
	 */
	public void writeABSEmg(ArrayList<EmgDTO> list) throws IOException {
		File f = new File("e:/EmgData/"+file_name+"/abs_"+file_name+".txt");
		FileWriter out = new FileWriter(f);
		
		for(int i=0; i<list.size(); i++) {
			String str = 
					list.get(i).getTime() + 
					"\t" + (int)list.get(i).getEmg1() +
					"\t" + (int)list.get(i).getEmg2() + 
					"\t" + (int)list.get(i).getEmg3() + 
					"\t" + (int)list.get(i).getEmg4() +
					"\t" + (int)list.get(i).getEmg5() +
					"\t" + (int)list.get(i).getEmg6() +
					"\t" + (int)list.get(i).getEmg7() +
					"\t" + (int)list.get(i).getEmg8() +
					"\t" + (int)list.get(i).getEx_num() + "\n";
			out.write(str);
		}
		out.close();
	}

	/**
	 * write Moving Average (ma=2)
	 */
	public void writeMAEmg2(ArrayList<EmgDTO> list) throws IOException {
		File f = new File("e:/EmgData/"+file_name+"/ma2_"+file_name+".txt");
		FileWriter out = new FileWriter(f);
		
		for(int i=0; i<list.size(); i++) {
			String str = 
					list.get(i).getTime() + 
					"\t" + list.get(i).getEmg1() +
					"\t" + list.get(i).getEmg2() + 
					"\t" + list.get(i).getEmg3() + 
					"\t" + list.get(i).getEmg4() +
					"\t" + list.get(i).getEmg5() +
					"\t" + list.get(i).getEmg6() +
					"\t" + list.get(i).getEmg7() +
					"\t" + list.get(i).getEmg8() +
					"\t" + list.get(i).getEx_num() + "\n";
			out.write(str);
		}
		out.close();
	}

	/**
	 * write Moving Average (ma=3)
	 */
	public void writeMAEmg3(ArrayList<EmgDTO> list) throws IOException {
		File f = new File("e:/EmgData/"+file_name+"/ma3_"+file_name+".txt");
		FileWriter out = new FileWriter(f);
		
		for(int i=0; i<list.size(); i++) {
			String str = 
					list.get(i).getTime() + 
					"\t" + list.get(i).getEmg1() +
					"\t" + list.get(i).getEmg2() + 
					"\t" + list.get(i).getEmg3() + 
					"\t" + list.get(i).getEmg4() +
					"\t" + list.get(i).getEmg5() +
					"\t" + list.get(i).getEmg6() +
					"\t" + list.get(i).getEmg7() +
					"\t" + list.get(i).getEmg8() +
					"\t" + list.get(i).getEx_num() + "\n";
			out.write(str);
		}
		out.close();
	}

	/**
	 * write Root Mean Square (MA=2)
	 */
	public void writeRMSEmg2(ArrayList<EmgDTO> list) throws IOException {
		File f = new File("e:/EmgData/"+file_name+"/rms2_"+file_name+".txt");
		FileWriter out = new FileWriter(f);
		
		for(int i=0; i<list.size(); i++) {
			String str = 
					list.get(i).getTime() + 
					"\t" + list.get(i).getEmg1() +
					"\t" + list.get(i).getEmg2() + 
					"\t" + list.get(i).getEmg3() + 
					"\t" + list.get(i).getEmg4() +
					"\t" + list.get(i).getEmg5() +
					"\t" + list.get(i).getEmg6() +
					"\t" + list.get(i).getEmg7() +
					"\t" + list.get(i).getEmg8() +
					"\t" + list.get(i).getEx_num() + "\n";
			out.write(str);
		}
		out.close();
	}

	/**
	 * write Root Mean Square (MA=3)
	 */
	public void writeRMSEmg3(ArrayList<EmgDTO> list) throws IOException {
		File f = new File("e:/EmgData/"+file_name+"/rms3_"+file_name+".txt");
		FileWriter out = new FileWriter(f);
		
		for(int i=0; i<list.size(); i++) {
			String str = 
					list.get(i).getTime() + 
					"\t" + list.get(i).getEmg1() +
					"\t" + list.get(i).getEmg2() + 
					"\t" + list.get(i).getEmg3() + 
					"\t" + list.get(i).getEmg4() +
					"\t" + list.get(i).getEmg5() +
					"\t" + list.get(i).getEmg6() +
					"\t" + list.get(i).getEmg7() +
					"\t" + list.get(i).getEmg8() +
					"\t" + list.get(i).getEx_num() + "\n";
			out.write(str);
		}
		out.close();
	}
}
