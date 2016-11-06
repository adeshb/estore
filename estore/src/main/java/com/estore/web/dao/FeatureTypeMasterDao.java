package com.estore.web.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.estore.jpa.FeatureTypeMaster;

@Component
public class FeatureTypeMasterDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public FeatureTypeMaster findFeatureTypeMasterById(Integer id) {
        if (id == null) return null;
        return entityManager.find(FeatureTypeMaster.class, id);
    }
    
    @Transactional
    public void persist(FeatureTypeMaster featureTypeMaster) {
        this.entityManager.persist(featureTypeMaster);
    }
    
    @Transactional
    public void remove(FeatureTypeMaster featureTypeMaster) {
        if (this.entityManager.contains(featureTypeMaster)) {
            this.entityManager.remove(featureTypeMaster);
        } else {
        	FeatureTypeMaster attached = findFeatureTypeMasterById((featureTypeMaster.getFeatureTypeId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(FeatureTypeMaster featureTypeMaster) {
    	FeatureTypeMaster toPopulateCreatedBy = findFeatureTypeMasterById(featureTypeMaster.getFeatureTypeId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<FeatureTypeMaster> getAllFeatureTypeMasters(){		
		List<FeatureTypeMaster> list=entityManager.createQuery("select e from FeatureTypeMaster e").getResultList();

		return list;
    }

}
