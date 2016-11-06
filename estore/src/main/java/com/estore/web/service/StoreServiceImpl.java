package com.estore.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.jpa.Store;


@Service("storeService")
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	//AbstractDao abstractDao;
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Store> stores;
	
	static{
		stores= populateDummyStores();
	}

	public List<Store> findAllStores() {
		return stores;
	}
	
	public Store findById(long id) {
		for(Store store : stores){
			if(store.getStoreId() == id){
				return store;
			}
		}
		return null;
	}
	
	public Store findByName(String name) {
		for(Store store : stores){
			if(store.getStoreName().equalsIgnoreCase(name)){
				return store;
			}
		}
		return null;
	}
	
	public void saveStore(Store store) {
		//store.setStoreId(counter.incrementAndGet());
		stores.add(store);
	}

	public void updateStore(Store store) {
		int index = stores.indexOf(store);
		stores.set(index, store);
	}

	public void deleteStoreById(long id) {
		
		for (Iterator<Store> iterator = stores.iterator(); iterator.hasNext(); ) {
		    Store store = iterator.next();
		    if (store.getStoreId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isStoreExist(Store store) {
		return findByName(store.getStoreName())!=null;
	}
	
	public void deleteAllStores(){
		stores.clear();
	}

	private static List<Store> populateDummyStores(){
		List<Store> stores = new ArrayList<Store>();
		/*stores.add(new Store(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
		stores.add(new Store(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
		stores.add(new Store(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com"));*/
		return stores;
	}

	/*public List<Store> getAll(){
		return abstractDao.getAll(Store.class);
	}*/
}
