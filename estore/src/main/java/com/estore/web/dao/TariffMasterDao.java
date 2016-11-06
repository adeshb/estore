package com.estore.web.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.estore.jpa.TariffMaster;


@Component
public class TariffMasterDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public TariffMaster findTariffMasterById(Integer id) {
        if (id == null) return null;
        return entityManager.find(TariffMaster.class, id);
    }
    
    @Transactional
    public void persist(TariffMaster tariffMaster) {
        this.entityManager.persist(tariffMaster);
    }
    
    @Transactional
    public void remove(TariffMaster tariffMaster) {
        if (this.entityManager.contains(tariffMaster)) {
            this.entityManager.remove(tariffMaster);
        } else {
        	TariffMaster attached = findTariffMasterById((tariffMaster.getTariffPlanId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(TariffMaster tariffMaster) {
    	TariffMaster toPopulateCreatedBy = findTariffMasterById(tariffMaster.getTariffPlanId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<TariffMaster> getAllTariffMasters(){		
		List<TariffMaster> list=entityManager.createQuery("select e from TariffMaster e").getResultList();

		return list;
    }

}
