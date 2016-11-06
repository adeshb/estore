package com.estore.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estore.jpa.Store;
import com.estore.web.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {

	private static final Logger logger = Logger.getLogger(StoreController.class);

	@Autowired
	private StoreService storeService;

	@RequestMapping(value = "/saveStore", method = RequestMethod.POST)
	public ResponseEntity<Void> saveStore(@RequestBody Store store) {
		logger.info("inside saveStore()...");
		try {
			storeService.saveStore(store);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}