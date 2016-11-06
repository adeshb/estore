package com.estore.web.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.estore.jpa.SubCatProductMap;
import com.estore.jpa.SubCatProductMapPK;

@Component
public class SubCatProductMapDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public SubCatProductMap findSubCatProductMapById(SubCatProductMapPK id) {
        if (id == null) return null;
        return entityManager.find(SubCatProductMap.class, id.getSubCategoryId());
    }
    
    @Transactional
    public void persist(SubCatProductMap subCatProductMap) {
        this.entityManager.persist(subCatProductMap);
    }
    
    @Transactional
    public void remove(SubCatProductMap subCatProductMap) {
        if (this.entityManager.contains(subCatProductMap)) {
            this.entityManager.remove(subCatProductMap);
        } else {
        	SubCatProductMap attached = findSubCatProductMapById((subCatProductMap.getId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(SubCatProductMap subCatProductMap) {
    	SubCatProductMap toPopulateCreatedBy = findSubCatProductMapById(subCatProductMap.getId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<SubCatProductMap> getAllSubCatProductMaps(){		
		List<SubCatProductMap> list=entityManager.createQuery("select e from SubCatProductMap e").getResultList();

		return list;
    }

}
