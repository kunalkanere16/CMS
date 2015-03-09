package com.cms.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cms.domain.Product;

@Service("productFormValidator")
public class ProductValidator implements Validator{

	protected final Log logger = LogFactory.getLog(getClass());
	@Override
	public boolean supports(Class clazz) {
		return ProductValidator.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Product productBo = (Product)obj;
		
		//image validation
		String imageName = productBo.getImageData().getOriginalFilename();
		if(imageName.equalsIgnoreCase("")){
			//no new image uploaded
		}else{
			//check new image file
			int lastPos=imageName.lastIndexOf(".");
			String fileExt = imageName.substring(lastPos+1, imageName.length());
			logger.info("file ext is ---- "+fileExt);
			if(lastPos == -1){
				//invalid file uploaded
				errors.rejectValue("imageData", "invalid.image");
			}
			else if((!fileExt.equalsIgnoreCase("jpeg")) && (!fileExt.equalsIgnoreCase("jpg")) 
					&& (!fileExt.equalsIgnoreCase("png")) ){
//			logger.info("error here -----");
				//invalid file uploaded1
				errors.rejectValue("imageData", "invalid.image");
			}
			else if (productBo.getImageData().getSize()>1000000){
				//file size exceeds
				errors.rejectValue("imageData", "max.image");
			}
		}
		
		//Price validation
		if(productBo.getPrice()<=0){
			logger.info("prod price is = "+productBo.getPrice());
			errors.rejectValue("price", "invalid.price");
		}
		else if(productBo.getPrice()>99999){
			errors.rejectValue("price", "max.price");
		}
		
		//Description validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required", "required.description");
		
		if(productBo.getDescription().length()>4000){
			errors.rejectValue("description", "invalid.description");
		}
		
	}
	
}
