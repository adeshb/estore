package com.estore.web.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.estore.jpa.Store;

@Component
public class StoreDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public Store findStoreById(Integer id) {
        if (id == null) return null;
        return entityManager.find(Store.class, id);
    }
    
    @Transactional
    public void persist(Store store) {
        this.entityManager.persist(store);
    }
    
    @Transactional
    public void remove(Store store) {
        if (this.entityManager.contains(store)) {
            this.entityManager.remove(store);
        } else {
        	Store attached = findStoreById((store.getStoreId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(Store store) {
    	Store toPopulateCreatedBy = findStoreById(store.getStoreId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<Store> getAllStores(){		
		List<Store> list=entityManager.createQuery("select e from Store e").getResultList();

		return list;
    }

}
