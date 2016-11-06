package com.estore.web.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.estore.jpa.Subscription;


@Component
public class SubscriptionDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public Subscription findSubscriptionById(Integer id) {
        if (id == null) return null;
        return entityManager.find(Subscription.class, id);
    }
    
    @Transactional
    public void persist(Subscription subscription) {
        this.entityManager.persist(subscription);
    }
    
    @Transactional
    public void remove(Subscription subscription) {
        if (this.entityManager.contains(subscription)) {
            this.entityManager.remove(subscription);
        } else {
        	Subscription attached = findSubscriptionById((subscription.getSubscriptionId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(Subscription subscription) {
    	Subscription toPopulateCreatedBy = findSubscriptionById(subscription.getSubscriptionId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<Subscription> getAllSubscriptions(){		
		List<Subscription> list=entityManager.createQuery("select e from Subscription e").getResultList();

		return list;
    }

}
