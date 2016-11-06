package com.estore.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

import com.estore.jpa.CategoryMaster;
import com.estore.jpa.LocationType;


@Component
public class CategoryMasterDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public CategoryMaster findCategoryMasterById(Integer id) {
        if (id == null) return null;
        return entityManager.find(CategoryMaster.class, id);
    }
    
    @Transactional
    public void persist(CategoryMaster address) {
        this.entityManager.persist(address);
    }
    
    @Transactional
    public void remove(CategoryMaster address) {
        if (this.entityManager.contains(address)) {
            this.entityManager.remove(address);
        } else {
        	CategoryMaster attached = findCategoryMasterById((address.getCategoryId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(CategoryMaster address) {
    	CategoryMaster toPopulateCreatedBy = findCategoryMasterById(address.getCategoryId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<CategoryMaster> getAllCategoryMasters(){		
		List<CategoryMaster> list=entityManager.createQuery("select e from CategoryMaster e").getResultList();

		return list;
    }

    @SuppressWarnings("unchecked")
	public List<CategoryMaster> getCategoryByLocType(int typeId){
    	LocationType locationType = entityManager.find(LocationType.class, typeId);
		List<CategoryMaster> list=entityManager.createQuery("select e from CategoryMaster e WHERE e.locationType=:locType").setParameter("locType", locationType).getResultList();

		return list;
    }

}
