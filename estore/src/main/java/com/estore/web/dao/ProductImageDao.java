package com.estore.web.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.estore.jpa.ProductImage;

@Component
public class ProductImageDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public ProductImage findProductImageById(Integer id) {
        if (id == null) return null;
        return entityManager.find(ProductImage.class, id);
    }
    
    @Transactional
    public void persist(ProductImage locationType) {
        this.entityManager.persist(locationType);
    }
    
    @Transactional
    public void remove(ProductImage locationType) {
        if (this.entityManager.contains(locationType)) {
            this.entityManager.remove(locationType);
        } else {
        	ProductImage attached = findProductImageById((locationType.getImageId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(ProductImage locationType) {
    	ProductImage toPopulateCreatedBy = findProductImageById(locationType.getImageId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<ProductImage> getAllProductImages(){		
		List<ProductImage> list=entityManager.createQuery("select e from ProductImage e").getResultList();

		return list;
    }

}
