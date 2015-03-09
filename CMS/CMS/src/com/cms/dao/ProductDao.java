package com.cms.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cms.domain.Product;


public interface ProductDao {
	public List<Product> getProductList();
	
	public Product getSingleProduct(int productId);

	public boolean updateProduct(Product product);
}
