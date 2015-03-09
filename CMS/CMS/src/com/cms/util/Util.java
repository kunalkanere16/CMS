package com.cms.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cms.constant.Constants;

/**
 * This class contains all utility functions
 * @author Kunal
 *
 */
public class Util {
	
	/**
	 * this function uploads the new image file to system default
	 * directory and return the image path
	 * @param imageData
	 * @return
	 */
	public static String uploadNewFile(CommonsMultipartFile imageData){
		
		String newFileName =getModifiedFileName(imageData.getOriginalFilename());
		String filePath = Constants.DEFAULT_IMAGE_PATH+newFileName;
		
		//File Upload operation
		try {
			FileOutputStream fout = new FileOutputStream(filePath);
			fout.write(imageData.getBytes(),0,imageData.getBytes().length);
			fout.flush();
			fout.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return filePath;
	}
	
	/**
	 * This function modifies the file name using timestamp
	 * @param originalName
	 * @return
	 */
	public static String getModifiedFileName(String originalName){
		int lastPos=originalName.lastIndexOf(".");
		String fileExt = originalName.substring(lastPos+1, originalName.length());
		String name = originalName.substring(0, lastPos);
		String newFileName = name+getCurrentTimestamp()+"."+fileExt;
		
		return newFileName;
	}
	
	/**
	 * this function returns system time and date in (ddMMyyyyHHmmssSSS)
	 * format
	 * @return
	 */
	public static String getCurrentTimestamp(){
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
		//get current date time with Date()
		Date date = new Date();
		return dateFormat.format(date);
	}
}
