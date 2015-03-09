package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.ProductDao;
import com.cms.domain.Product;

/**
 * This is the service class which interacts directly with the dao class
 * @author Kunal
 *
 */
@Service("productManagerImpl")
public class ProductManagerImpl implements ProductManager{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getProductList() {
		return productDao.getProductList();
	}

	@Override
	public Product getSingleProduct(int productId) {
		return productDao.getSingleProduct(productId);
	}

	@Override
	public boolean updateProduct(Product product) {
		return productDao.updateProduct(product);
	}
	
}
