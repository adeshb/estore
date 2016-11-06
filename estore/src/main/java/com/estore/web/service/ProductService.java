package com.estore.web.service;

import java.util.List;

import com.estore.jpa.Product;



public interface ProductService {
	
	Product findById(long id);
	
	Product findByName(String name);
	
	void saveProduct(com.estore.jpa.Product product);
	
	void updateProduct(Product product);
	
	void deleteProductById(long id);

	List<Product> findAllProducts(); 
	
	void deleteAllProducts();
	
	public boolean isProductExist(Product product);
	
}
