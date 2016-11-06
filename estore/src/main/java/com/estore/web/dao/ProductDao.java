package com.estore.web.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.estore.jpa.Product;

@Component
public class ProductDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public Product findProductById(Integer id) {
        if (id == null) return null;
        return entityManager.find(Product.class, id);
    }
    
    @Transactional
    public void persist(Product locationType) {
        this.entityManager.persist(locationType);
    }
    
    @Transactional
    public void remove(Product locationType) {
        if (this.entityManager.contains(locationType)) {
            this.entityManager.remove(locationType);
        } else {
        	Product attached = findProductById((locationType.getProductId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(Product locationType) {
    	Product toPopulateCreatedBy = findProductById(locationType.getProductId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<Product> getAllProducts(){		
		List<Product> list=entityManager.createQuery("select e from Product e").getResultList();

		return list;
    }

}
