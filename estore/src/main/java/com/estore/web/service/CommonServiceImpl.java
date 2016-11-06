package com.estore.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.jpa.CategoryMaster;
import com.estore.jpa.LocationType;
import com.estore.jpa.User;
import com.estore.web.dao.CategoryMasterDao;
import com.estore.web.dao.LocationTypeDao;
import com.estore.web.dao.UserDao;

@Service
public class CommonServiceImpl implements CommonService{
	
	private static final Logger log = Logger.getLogger(CommonServiceImpl.class);
	
	@Autowired
	LocationTypeDao locationTypeDao;

	@Autowired
	UserDao userDao;

	@Autowired
	CategoryMasterDao categoryMasterDao;
	
	public List<LocationType> findAllLocationTypes() {
		log.info("entered");
		List<LocationType> locTypeList= locationTypeDao.getAllLocationTypes();
		log.info("locTypeList size:"+locTypeList.size());
		return locTypeList;
	}
	
	public List<User> findAllUser() {
		log.info("entered");
		List<User> userList= userDao.getAllUsers();
		log.info("userList size:"+userList.size());
		return userList;
	}

	public List<CategoryMaster> getCategoryByLocType(int typeId) {
		// TODO Auto-generated method stub
		return categoryMasterDao.getCategoryByLocType(typeId);
		//return null;
	}
	
}
