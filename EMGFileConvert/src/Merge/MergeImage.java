package Merge;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MergeImage {
	String file_name;
	
	public MergeImage(String file_name) {
		this.file_name = file_name;
	}
	
	public void start() {
		for(int i=1; i<=10; i++) {
			merge("raw","ex"+i);
			merge("abs","ex"+i);
			merge("square","ex"+i);
			merge("ma2","ex"+i);
			merge("ma3","ex"+i);
			merge("rms2","ex"+i);
			merge("rms3","ex"+i);
		}
	}
	
	public void merge(String type, String ex_num) {
		try {
			BufferedImage emg1 = ImageIO.read(new File("E:/EmgData/" + file_name + "/image/"+type+"/"+ex_num+"/"+type+"_emg1_"+ex_num+".jpeg"));
			BufferedImage emg2 = ImageIO.read(new File("E:/EmgData/" + file_name + "/image/"+type+"/"+ex_num+"/"+type+"_emg2_"+ex_num+".jpeg"));
			BufferedImage emg3 = ImageIO.read(new File("E:/EmgData/" + file_name + "/image/"+type+"/"+ex_num+"/"+type+"_emg3_"+ex_num+".jpeg"));
			BufferedImage emg4 = ImageIO.read(new File("E:/EmgData/" + file_name + "/image/"+type+"/"+ex_num+"/"+type+"_emg4_"+ex_num+".jpeg"));
			BufferedImage emg5 = ImageIO.read(new File("E:/EmgData/" + file_name + "/image/"+type+"/"+ex_num+"/"+type+"_emg5_"+ex_num+".jpeg"));
			BufferedImage emg6 = ImageIO.read(new File("E:/EmgData/" + file_name + "/image/"+type+"/"+ex_num+"/"+type+"_emg6_"+ex_num+".jpeg"));
			BufferedImage emg7 = ImageIO.read(new File("E:/EmgData/" + file_name + "/image/"+type+"/"+ex_num+"/"+type+"_emg7_"+ex_num+".jpeg"));
			BufferedImage emg8 = ImageIO.read(new File("E:/EmgData/" + file_name + "/image/"+type+"/"+ex_num+"/"+type+"_emg8_"+ex_num+".jpeg"));
			
			int width = emg1.getWidth()*4;
			int height = emg1.getHeight()*2;
			
			BufferedImage mergedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = (Graphics2D) mergedImage.getGraphics();
			
			
			graphics.setBackground(Color.WHITE);
			graphics.drawImage(emg1, 0, 0, null);
			graphics.drawImage(emg2, emg2.getWidth(), 0, null);
			graphics.drawImage(emg3, emg3.getWidth()*2, 0, null);
			graphics.drawImage(emg4, emg4.getWidth()*3, 0, null);
			graphics.drawImage(emg5, 0, emg5.getHeight(), null);
			graphics.drawImage(emg6, emg6.getWidth(), emg5.getHeight(), null);
			graphics.drawImage(emg7, emg7.getWidth()*2, emg5.getHeight(), null);
			graphics.drawImage(emg8, emg8.getWidth()*3, emg5.getHeight(), null);
			
			ImageIO.write(mergedImage, "jpg", new File("E:/EmgData/" + file_name + "/image/"+type+"/"+ex_num+"/merge.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
