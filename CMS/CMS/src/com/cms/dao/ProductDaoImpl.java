package com.cms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.cms.domain.Product;
import com.cms.mapper.ProductMapper;

@Service("productDaoImpl")
public class ProductDaoImpl implements ProductDao{
	
	
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	/**
	 * This function will return all products from db
	 */
	@Override
	public List<Product> getProductList() {
		StringBuilder query = new StringBuilder("");
		query.append("select product_id, name, image_path, price, description, stock_number,");
		query.append(" availablilty from product");

		List<Product> prodList = null;
		try {
			prodList = simpleJdbcTemplate.getJdbcOperations().query(query.toString(), new ProductMapper());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return prodList;
	}

	/**
	 * This function will return product from db
	 * for given product id
	 */
	@Override
	public Product getSingleProduct(int productId) {
		StringBuilder query = new StringBuilder("");
		query.append("select product_id, name, image_path, price, description, stock_number,");
		query.append(" availablilty from product where product_id = ? ");
		Product product = null;
		try {
			product = simpleJdbcTemplate.getJdbcOperations().
					queryForObject(query.toString(), new Object[]{productId}, new ProductMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	/**
	 * This function updates the modified product details in DB
	 */
	@Override
	public boolean updateProduct(Product product){
		StringBuilder query = new StringBuilder("");
		query.append("update product set  image_path = ? , price = ? , description = ? , ");
		query.append(" availablilty = ?  where product_id = ? ");
		int result=0;
		try {
			result = simpleJdbcTemplate.getJdbcOperations().update(query.toString(), 
						new Object[]{product.getImagePath(),
									product.getPrice(),
									product.getDescription(),
									product.getAvailability(),
									product.getProductId()});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result>0?true:false;
		
	}
	
}
