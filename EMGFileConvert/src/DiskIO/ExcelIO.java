package DiskIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import DTO.EmgDTO;

public class ExcelIO {
	String file_name;
	HSSFWorkbook workbook;
	
	public ExcelIO(String file_name) throws IOException {
		this.file_name = file_name;
		workbook = new HSSFWorkbook();				// 况农合 积己
	}
	
	public void writeRawEmg(ArrayList<EmgDTO> list) throws IOException {
		HSSFSheet sheet = workbook.createSheet("Raw_ABS");	// 况农矫飘 积己
        HSSFRow row = sheet.createRow(0);				// 青 积己
        HSSFCell cell;									// 届 积己
        
        // 庆歹 沥焊 备己
        cell = row.createCell(0);
        cell.setCellValue("time");
        cell = row.createCell(1);
        cell.setCellValue("emg1");
        cell = row.createCell(2);
        cell.setCellValue("emg2");
        cell = row.createCell(3);
        cell.setCellValue("emg3");
        cell = row.createCell(4);
        cell.setCellValue("emg4");
        cell = row.createCell(5);
        cell.setCellValue("emg5");
        cell = row.createCell(6);
        cell.setCellValue("emg6");
        cell = row.createCell(7);
        cell.setCellValue("emg7");
        cell = row.createCell(8);
        cell.setCellValue("emg8");
        cell = row.createCell(9);
        cell.setCellValue("ex_num");
        
        for(int i=0; i<list.size(); i++) {
            row = sheet.createRow(i+1);
            cell = row.createCell(0);
            cell.setCellValue(list.get(i).getTime());
            cell = row.createCell(1);
            cell.setCellValue((int)list.get(i).getEmg1());
            cell = row.createCell(2);
            cell.setCellValue((int)list.get(i).getEmg2());
            cell = row.createCell(3);
            cell.setCellValue((int)list.get(i).getEmg3());
            cell = row.createCell(4);
            cell.setCellValue((int)list.get(i).getEmg4());
            cell = row.createCell(5);
            cell.setCellValue((int)list.get(i).getEmg5());
            cell = row.createCell(6);
            cell.setCellValue((int)list.get(i).getEmg6());
            cell = row.createCell(7);
            cell.setCellValue((int)list.get(i).getEmg7());
            cell = row.createCell(8);
            cell.setCellValue((int)list.get(i).getEmg8());
            cell = row.createCell(9);
            cell.setCellValue(list.get(i).getEx_num());
        }
        
        // 涝仿等 郴侩 颇老肺 静扁
        File file = new File("e:/EmgData/"+file_name+"/abs_"+file_name+".xls");
        FileOutputStream fos = null;
        fos = new FileOutputStream(file);
        workbook.write(fos);
		
		if(fos != null)
			fos.close();
	}
	
	public void writeABSEmg(ArrayList<EmgDTO> list) throws IOException {
		HSSFSheet sheet = workbook.getSheet("Raw_ABS");	// 况农矫飘 积己
        HSSFRow row = sheet.getRow(0);					// 青 积己
        HSSFCell cell;									// 届 积己
        
        // 庆歹 沥焊 备己
        cell = row.createCell(11);
        cell.setCellValue("time");
        cell = row.createCell(12);
        cell.setCellValue("emg1");
        cell = row.createCell(13);
        cell.setCellValue("emg2");
        cell = row.createCell(14);
        cell.setCellValue("emg3");
        cell = row.createCell(15);
        cell.setCellValue("emg4");
        cell = row.createCell(16);
        cell.setCellValue("emg5");
        cell = row.createCell(17);
        cell.setCellValue("emg6");
        cell = row.createCell(18);
        cell.setCellValue("emg7");
        cell = row.createCell(19);
        cell.setCellValue("emg8");
        cell = row.createCell(20);
        cell.setCellValue("ex_num");
        
        for(int i=0; i<list.size(); i++) {
            row = sheet.getRow(i+1);
            cell = row.createCell(11);
            cell.setCellValue(list.get(i).getTime());
            cell = row.createCell(12);
            cell.setCellValue((int)list.get(i).getEmg1());
            cell = row.createCell(13);
            cell.setCellValue((int)list.get(i).getEmg2());
            cell = row.createCell(14);
            cell.setCellValue((int)list.get(i).getEmg3());
            cell = row.createCell(15);
            cell.setCellValue((int)list.get(i).getEmg4());
            cell = row.createCell(16);
            cell.setCellValue((int)list.get(i).getEmg5());
            cell = row.createCell(17);
            cell.setCellValue((int)list.get(i).getEmg6());
            cell = row.createCell(18);
            cell.setCellValue((int)list.get(i).getEmg7());
            cell = row.createCell(19);
            cell.setCellValue((int)list.get(i).getEmg8());
            cell = row.createCell(20);
            cell.setCellValue(list.get(i).getEx_num());
        }
        
        // 涝仿等 郴侩 颇老肺 静扁
        File file = new File("e:/EmgData/"+file_name+"/abs_"+file_name+".xls");
        FileOutputStream fos = null;
        fos = new FileOutputStream(file);
        workbook.write(fos);
		
		if(fos != null)
			fos.close();
	}

	public void writeMAEmg2(ArrayList<EmgDTO> list) throws IOException {
		HSSFSheet sheet = workbook.createSheet("MA");	// 况农矫飘 积己
        HSSFRow row = sheet.createRow(0);				// 青 积己
        HSSFCell cell;									// 届 积己
        
        // 庆歹 沥焊 备己
        cell = row.createCell(0);
        cell.setCellValue("time");
        cell = row.createCell(1);
        cell.setCellValue("emg1");
        cell = row.createCell(2);
        cell.setCellValue("emg2");
        cell = row.createCell(3);
        cell.setCellValue("emg3");
        cell = row.createCell(4);
        cell.setCellValue("emg4");
        cell = row.createCell(5);
        cell.setCellValue("emg5");
        cell = row.createCell(6);
        cell.setCellValue("emg6");
        cell = row.createCell(7);
        cell.setCellValue("emg7");
        cell = row.createCell(8);
        cell.setCellValue("emg8");
        cell = row.createCell(9);
        cell.setCellValue("ex_num");
        
        for(int i=0; i<list.size(); i++) {
            row = sheet.createRow(i+1);
            cell = row.createCell(0);
            cell.setCellValue(list.get(i).getTime());
            cell = row.createCell(1);
            cell.setCellValue(list.get(i).getEmg1());
            cell = row.createCell(2);
            cell.setCellValue(list.get(i).getEmg2());
            cell = row.createCell(3);
            cell.setCellValue(list.get(i).getEmg3());
            cell = row.createCell(4);
            cell.setCellValue(list.get(i).getEmg4());
            cell = row.createCell(5);
            cell.setCellValue(list.get(i).getEmg5());
            cell = row.createCell(6);
            cell.setCellValue(list.get(i).getEmg6());
            cell = row.createCell(7);
            cell.setCellValue(list.get(i).getEmg7());
            cell = row.createCell(8);
            cell.setCellValue(list.get(i).getEmg8());
            cell = row.createCell(9);
            cell.setCellValue(list.get(i).getEx_num());
        }
        
        // 涝仿等 郴侩 颇老肺 静扁
        File file = new File("e:/EmgData/"+file_name+"/abs_"+file_name+".xls");
        FileOutputStream fos = null;
        fos = new FileOutputStream(file);
        workbook.write(fos);
		
		if(fos != null)
			fos.close();
	}

	public void writeMAEmg3(ArrayList<EmgDTO> list) throws IOException {
		HSSFSheet sheet = workbook.getSheet("MA");	// 况农矫飘 积己
        HSSFRow row = sheet.getRow(0);				// 青 积己
        HSSFCell cell;									// 届 积己
        
        // 庆歹 沥焊 备己
        cell = row.createCell(11);
        cell.setCellValue("time");
        cell = row.createCell(12);
        cell.setCellValue("emg1");
        cell = row.createCell(13);
        cell.setCellValue("emg2");
        cell = row.createCell(14);
        cell.setCellValue("emg3");
        cell = row.createCell(15);
        cell.setCellValue("emg4");
        cell = row.createCell(16);
        cell.setCellValue("emg5");
        cell = row.createCell(17);
        cell.setCellValue("emg6");
        cell = row.createCell(18);
        cell.setCellValue("emg7");
        cell = row.createCell(19);
        cell.setCellValue("emg8");
        cell = row.createCell(20);
        cell.setCellValue("ex_num");
        
        for(int i=0; i<list.size(); i++) {
            row = sheet.getRow(i+1);
            cell = row.createCell(11);
            cell.setCellValue(list.get(i).getTime());
            cell = row.createCell(12);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg1())));
            cell = row.createCell(13);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg2())));
            cell = row.createCell(14);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg3())));
            cell = row.createCell(15);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg4())));
            cell = row.createCell(16);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg5())));
            cell = row.createCell(17);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg6())));
            cell = row.createCell(18);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg7())));
            cell = row.createCell(19);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg8())));
            cell = row.createCell(20);
            cell.setCellValue(list.get(i).getEx_num());
        }
        
        // 涝仿等 郴侩 颇老肺 静扁
        File file = new File("e:/EmgData/"+file_name+"/abs_"+file_name+".xls");
        FileOutputStream fos = null;
        fos = new FileOutputStream(file);
        workbook.write(fos);
		
		if(fos != null)
			fos.close();
	}
	
	public void writeRMSEmg2(ArrayList<EmgDTO> list) throws IOException {
		HSSFSheet sheet = workbook.createSheet("RMS");	// 况农矫飘 积己
        HSSFRow row = sheet.createRow(0);				// 青 积己
        HSSFCell cell;									// 届 积己
        
        // 庆歹 沥焊 备己
        cell = row.createCell(0);
        cell.setCellValue("time");
        cell = row.createCell(1);
        cell.setCellValue("emg1");
        cell = row.createCell(2);
        cell.setCellValue("emg2");
        cell = row.createCell(3);
        cell.setCellValue("emg3");
        cell = row.createCell(4);
        cell.setCellValue("emg4");
        cell = row.createCell(5);
        cell.setCellValue("emg5");
        cell = row.createCell(6);
        cell.setCellValue("emg6");
        cell = row.createCell(7);
        cell.setCellValue("emg7");
        cell = row.createCell(8);
        cell.setCellValue("emg8");
        cell = row.createCell(9);
        cell.setCellValue("ex_num");
        
        for(int i=0; i<list.size(); i++) {
            row = sheet.createRow(i+1);
            cell = row.createCell(0);
            cell.setCellValue(list.get(i).getTime());
            cell = row.createCell(1);
            cell.setCellValue(list.get(i).getEmg1());
            cell = row.createCell(2);
            cell.setCellValue(list.get(i).getEmg2());
            cell = row.createCell(3);
            cell.setCellValue(list.get(i).getEmg3());
            cell = row.createCell(4);
            cell.setCellValue(list.get(i).getEmg4());
            cell = row.createCell(5);
            cell.setCellValue(list.get(i).getEmg5());
            cell = row.createCell(6);
            cell.setCellValue(list.get(i).getEmg6());
            cell = row.createCell(7);
            cell.setCellValue(list.get(i).getEmg7());
            cell = row.createCell(8);
            cell.setCellValue(list.get(i).getEmg8());
            cell = row.createCell(9);
            cell.setCellValue(list.get(i).getEx_num());
        }
        
        // 涝仿等 郴侩 颇老肺 静扁
        File file = new File("e:/EmgData/"+file_name+"/abs_"+file_name+".xls");
        FileOutputStream fos = null;
        fos = new FileOutputStream(file);
        workbook.write(fos);
		
		if(fos != null)
			fos.close();
	}

	public void writeRMSEmg3(ArrayList<EmgDTO> list) throws IOException {
		HSSFSheet sheet = workbook.getSheet("RMS");	// 况农矫飘 积己
        HSSFRow row = sheet.getRow(0);				// 青 积己
        HSSFCell cell;									// 届 积己
        
        // 庆歹 沥焊 备己
        cell = row.createCell(11);
        cell.setCellValue("time");
        cell = row.createCell(12);
        cell.setCellValue("emg1");
        cell = row.createCell(13);
        cell.setCellValue("emg2");
        cell = row.createCell(14);
        cell.setCellValue("emg3");
        cell = row.createCell(15);
        cell.setCellValue("emg4");
        cell = row.createCell(16);
        cell.setCellValue("emg5");
        cell = row.createCell(17);
        cell.setCellValue("emg6");
        cell = row.createCell(18);
        cell.setCellValue("emg7");
        cell = row.createCell(19);
        cell.setCellValue("emg8");
        cell = row.createCell(20);
        cell.setCellValue("ex_num");
        
        for(int i=0; i<list.size(); i++) {
            row = sheet.getRow(i+1);
            cell = row.createCell(11);
            cell.setCellValue(list.get(i).getTime());
            cell = row.createCell(12);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg1())));
            cell = row.createCell(13);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg2())));
            cell = row.createCell(14);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg3())));
            cell = row.createCell(15);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg4())));
            cell = row.createCell(16);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg5())));
            cell = row.createCell(17);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg6())));
            cell = row.createCell(18);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg7())));
            cell = row.createCell(19);
            cell.setCellValue(Double.parseDouble(String.format("%.2f", list.get(i).getEmg8())));
            cell = row.createCell(20);
            cell.setCellValue(list.get(i).getEx_num());
        }
        
        // 涝仿等 郴侩 颇老肺 静扁
        File file = new File("e:/EmgData/"+file_name+"/abs_"+file_name+".xls");
        FileOutputStream fos = null;
        fos = new FileOutputStream(file);
        workbook.write(fos);
		
		if(fos != null)
			fos.close();
	}
	
	public void close() throws IOException {
		if(workbook != null)
			workbook.close();
	}
}
