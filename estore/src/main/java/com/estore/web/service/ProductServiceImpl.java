package com.estore.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.jpa.Product;
import com.estore.web.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Product> products;
	
	static{
		products= populateDummyProducts();
	}

	public List<Product> findAllProducts() {
		return products;
	}
	
	public Product findById(long id) {
		for(Product product : products){
			if(product.getProductId() == id){
				return product;
			}
		}
		return null;
	}
	
	public Product findByName(String name) {
		for(Product product : products){
			if(product.getProductName().equalsIgnoreCase(name)){
				return product;
			}
		}
		return null;
	}
	
	public void saveProduct(Product product) {
		//product.setProductId(counter.incrementAndGet());
		products.add(product);
	}

	public void updateProduct(Product product) {
		int index = products.indexOf(product);
		products.set(index, product);
	}

	public void deleteProductById(long id) {
		
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext(); ) {
		    Product product = iterator.next();
		    if (product.getProductId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isProductExist(Product product) {
		return findByName(product.getProductName())!=null;
	}
	
	public void deleteAllProducts(){
		products.clear();
	}

	private static List<Product> populateDummyProducts(){
		List<Product> products = new ArrayList<Product>();
		/*products.add(new Product(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
		products.add(new Product(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
		products.add(new Product(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com"));*/
		return products;
	}

	/*public List<Product> getAll(){
		return productDao.Product.class);
	}*/
}
