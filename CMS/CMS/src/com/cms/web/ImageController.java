package com.cms.web;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * this is controller class to retrieve image
 * @author Kunal
 *
 */
@Controller
public class ImageController {
	
	@RequestMapping(value = "/showImageByPath.do",method = RequestMethod.GET)
	public void showImageByPath(@RequestParam("imagePath") String imagePath, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
//		System.out.println("image path is ==== "+imagePath);
		
		try {
			OutputStream out = response.getOutputStream();
			InputStream in = new FileInputStream(imagePath);
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			//This function is used to copy one stream to another
			IOUtils.copy(in,out);
			out.close();
			in.close();
		} catch (Exception e) {
			//Image not found
			e.printStackTrace();
		}
		
	}
}
