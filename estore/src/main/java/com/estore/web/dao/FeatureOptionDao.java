package com.estore.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

import com.estore.jpa.FeatureOption;
import com.estore.jpa.FeatureOptionPK;


@Component
public class FeatureOptionDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public FeatureOption findFeatureOptionById(FeatureOptionPK id) {
        if (id == null) return null;
        return entityManager.find(FeatureOption.class, id.getFeatureOptionId());
    }
    
    @Transactional
    public void persist(FeatureOption address) {
        this.entityManager.persist(address);
    }
    
    @Transactional
    public void remove(FeatureOption address) {
        if (this.entityManager.contains(address)) {
            this.entityManager.remove(address);
        } else {
        	FeatureOption attached = findFeatureOptionById((address.getId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(FeatureOption address) {
    	FeatureOption toPopulateCreatedBy = findFeatureOptionById(address.getId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<FeatureOption> getAllFeatureOptions(){		
		List<FeatureOption> list=entityManager.createQuery("select e from FeatureOption e").getResultList();

		return list;
    }

}
