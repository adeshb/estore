package com.estore.web.service;

import java.util.List;

import com.estore.jpa.Store;



public interface StoreService {
	
	Store findById(long id);
	
	Store findByName(String name);
	
	void saveStore(Store store);
	
	void updateStore(Store store);
	
	void deleteStoreById(long id);

	List<Store> findAllStores(); 
	
	void deleteAllStores();
	
	public boolean isStoreExist(Store store);
	
}
