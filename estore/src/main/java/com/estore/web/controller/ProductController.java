package com.estore.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estore.jpa.Product;
import com.estore.web.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	/**
	 * manageCustomer
	 */
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts() {
		try {
			List<Product> products = productService.findAllProducts();
			//model.addAttribute("products", products);
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		} catch (Exception e) {
			// set failure due to exception
			return new ResponseEntity<List<Product>>(HttpStatus.EXPECTATION_FAILED);
		}
	}


	/**
	 * saveBillCust
	 */
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ResponseEntity<Void> saveBillCust(@RequestBody Product product) {
		logger.info("inside...");
		try {
			productService.saveProduct(product);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}