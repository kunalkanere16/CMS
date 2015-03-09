package com.cms.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Product implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private int productId;
	private String imagePath;
	private CommonsMultipartFile imageData;
	private double price;
	private String stockNumber;
	private String availability;
	private String description;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public CommonsMultipartFile getImageData() {
		return imageData;
	}
	public void setImageData(CommonsMultipartFile imageData) {
		this.imageData = imageData;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId 
				+ ", imagePath=" + imagePath + ", price=" + price
				+ ", stockNumber=" + stockNumber + ", availability="
				+ availability + ", description=" + description + "]";
	}
	
	
}
