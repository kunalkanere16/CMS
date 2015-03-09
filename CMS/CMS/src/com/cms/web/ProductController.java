package com.cms.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cms.domain.Product;
import com.cms.service.ProductManager;
import com.cms.util.Util;
import com.cms.validator.ProductValidator;
/**
 * This is the controller class
 * @author Kunal
 *
 */
@Controller
public class ProductController {
	
	@Autowired
	private ProductManager productManager;
	
	@Autowired
	private ProductValidator formValidator;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	/** To redirect to home page*/
	@RequestMapping(value = "/home.do",method = RequestMethod.GET)
	public ModelAndView defaultView(Model model, HttpServletRequest request ){
		
	
		ModelAndView modelAndView = new ModelAndView("home"); 
		logger.info("returning home page");
		return modelAndView ;
	}
	
	/** To view all products in inventory*/
	@RequestMapping(value = "/viewProducts.do",method = RequestMethod.GET)
	public ModelAndView viewProducts(Model model, HttpServletRequest request){
		
		System.out.println("view mode");
		ModelAndView modelAndView = new ModelAndView("viewAllProducts"); 
		List<Product> prodList = productManager.getProductList();
//		logger.info("Total products = "+prodList.size());
		modelAndView.addObject("prodList", prodList);
		logger.info("returning product list");
		return modelAndView ;
		
		
	}
	/** To view all products in inventory and edit*/
	@RequestMapping(value = "/editProducts.do",method = RequestMethod.GET)
	public ModelAndView editProducts(Model model, HttpServletRequest request){
		
		
		ModelAndView modelAndView = new ModelAndView("editAllProducts"); 
		List<Product> prodList = productManager.getProductList();
//		logger.info("Total products = "+prodList.size());
		modelAndView.addObject("prodList", prodList);
		logger.info("returning edit product list");
		return modelAndView ;
		
		
	}
	
	
	@RequestMapping(value = "/editSingleProduct.do",method = RequestMethod.GET)
	public ModelAndView editSingleProduct(@RequestParam("productId") Integer productId, 
			Model model, HttpServletRequest request){
		
		ModelAndView modelAndView = new ModelAndView("editSingleProduct"); 
		Product product = productManager.getSingleProduct(productId);
		modelAndView.addObject("product", product);
		logger.info("returning edit product");
		return modelAndView ;
		
	}
	
	@RequestMapping(value = "/updateProduct.do",method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute("product") Product product,
                            BindingResult result)
    {
		logger.info(product.getImageData().getOriginalFilename());
		//Validate
		formValidator.validate(product, result);
		if(result.hasErrors()){
		logger.info("some errors in form..........");
			// below code is for testing purpose
			/*for (Object object : result.getAllErrors()) {
	 		    if(object instanceof FieldError) {
	 		        FieldError fieldError = (FieldError) object;

//	 		        System.out.println("field------"+fieldError.getCode());
	 		        System.out.println("field name - "+fieldError.getField() );
//	 		        System.out.println("object name - "+fieldError.getObjectName() );
	 		    }

	 		   
	 		}*/
			
			//return to update form
			return "editSingleProduct";
		}else{
			
			if(product.getImageData().getSize()>0){
				//new image exists
				//upload file
				String newFilePath = Util.uploadNewFile(product.getImageData());
				product.setImagePath(newFilePath);
				logger.info(product);
			}
			//Update the product information in database
			if(productManager.updateProduct(product)){
				return "redirect:/viewProducts.do";
			}else{
				logger.info("error in updating product");
			}
//			logger.info("success..................");
		}
		
        
        return "redirect:/home.do";
    }
	
}
