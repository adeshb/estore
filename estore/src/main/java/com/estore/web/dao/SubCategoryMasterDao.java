package com.estore.web.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.estore.jpa.SubCategoryMaster;

@Component
public class SubCategoryMasterDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public SubCategoryMaster findSubCategoryMasterById(Integer id) {
        if (id == null) return null;
        return entityManager.find(SubCategoryMaster.class, id);
    }
    
    @Transactional
    public void persist(SubCategoryMaster subCategoryMaster) {
        this.entityManager.persist(subCategoryMaster);
    }
    
    @Transactional
    public void remove(SubCategoryMaster subCategoryMaster) {
        if (this.entityManager.contains(subCategoryMaster)) {
            this.entityManager.remove(subCategoryMaster);
        } else {
        	SubCategoryMaster attached = findSubCategoryMasterById((subCategoryMaster.getSubCategoryId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(SubCategoryMaster subCategoryMaster) {
    	SubCategoryMaster toPopulateCreatedBy = findSubCategoryMasterById(subCategoryMaster.getSubCategoryId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<SubCategoryMaster> getAllSubCategoryMasters(){		
		List<SubCategoryMaster> list=entityManager.createQuery("select e from SubCategoryMaster e").getResultList();

		return list;
    }

}
