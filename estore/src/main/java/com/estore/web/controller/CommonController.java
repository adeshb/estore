package com.estore.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estore.jpa.CategoryMaster;
import com.estore.jpa.LocationType;
import com.estore.web.service.CommonService;
import com.estore.web.service.UserService;

@RestController
@RequestMapping("/common")
public class CommonController {

	private static final Logger logger = Logger.getLogger(CommonController.class);

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private UserService userService;

	/**
	 * getLoctionTypes
	 */
	@RequestMapping(value = "/getLoctionTypes", method = RequestMethod.POST)
	public ResponseEntity<List<LocationType>> getLoctionTypes() {
		try {
			logger.info("entered");
			List<LocationType> LocationTypes = commonService.findAllLocationTypes();
			logger.info("LocationTypes size:"+LocationTypes.size());
			return new ResponseEntity<List<LocationType>>(LocationTypes, HttpStatus.OK);
		} catch (Exception e) {
			// set failure due to exception
			return new ResponseEntity<List<LocationType>>(HttpStatus.EXPECTATION_FAILED);
		}
	}


	/**
	 * getCategoryByLocType
	 */
	@RequestMapping(value = "/getCategoryByLocType/{typeId}", method = RequestMethod.POST)
	public ResponseEntity<List<CategoryMaster>> getCategoryByLocType(@PathVariable int typeId) {
		try {
			logger.info("entered typeId:"+typeId);
			List<CategoryMaster> categoryMasters = commonService.getCategoryByLocType(typeId);
			logger.info("categoryMasters size:"+categoryMasters.size());
			return new ResponseEntity<List<CategoryMaster>>(categoryMasters, HttpStatus.OK);
		} catch (Exception e) {
			// set failure due to exception
			return new ResponseEntity<List<CategoryMaster>>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}