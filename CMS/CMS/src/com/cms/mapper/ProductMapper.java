package com.cms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cms.domain.Product;


public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int arg1) throws SQLException {
		Product product = new Product();
		product.setProductId(rs.getInt("product_id"));
		//product.setName(rs.getString("name"));
		product.setImagePath(rs.getString("image_path"));
		product.setPrice(rs.getDouble("price"));
		product.setDescription(rs.getString("description"));
		product.setStockNumber(rs.getString("stock_number"));
		product.setAvailability(rs.getString("availablilty"));
		return product;
	}

}
