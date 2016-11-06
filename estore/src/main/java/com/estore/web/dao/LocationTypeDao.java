package com.estore.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.estore.jpa.LocationType;


@Component
public class LocationTypeDao {

	private static final Logger log = Logger.getLogger(LocationTypeDao.class);
	
    @PersistenceContext
    transient EntityManager entityManager;
    
    public LocationType findLocationTypeById(Integer id) {
        if (id == null) return null;
        return entityManager.find(LocationType.class, id);
    }
    
    @Transactional
    public void persist(LocationType locationType) {
        this.entityManager.persist(locationType);
    }
    
    @Transactional
    public void remove(LocationType locationType) {
        if (this.entityManager.contains(locationType)) {
            this.entityManager.remove(locationType);
        } else {
        	LocationType attached = findLocationTypeById((locationType.getTypeId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(LocationType locationType) {
    	LocationType toPopulateCreatedBy = findLocationTypeById(locationType.getTypeId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<LocationType> getAllLocationTypes(){
    	log.info("entered");
		List<LocationType> list=entityManager.createQuery("select e from LocationType e").getResultList();
		log.info("list size:"+list.size());
		return list;
    }

}
