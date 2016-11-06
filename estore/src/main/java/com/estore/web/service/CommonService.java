package com.estore.web.service;

import java.util.List;

import com.estore.jpa.CategoryMaster;
import com.estore.jpa.LocationType;



public interface CommonService {
	
	List<LocationType> findAllLocationTypes(); 
	
	List<CategoryMaster> getCategoryByLocType(int typeId);
	
}
