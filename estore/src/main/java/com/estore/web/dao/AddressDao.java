package com.estore.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

import com.estore.jpa.Address;


@Component
public class AddressDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public Address findAddressById(Integer id) {
        if (id == null) return null;
        return entityManager.find(Address.class, id);
    }
    
    @Transactional
    public void persist(Address address) {
        this.entityManager.persist(address);
    }
    
    @Transactional
    public void remove(Address address) {
        if (this.entityManager.contains(address)) {
            this.entityManager.remove(address);
        } else {
        	Address attached = findAddressById((address.getAddressId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(Address address) {
    	Address toPopulateCreatedBy = findAddressById(address.getAddressId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<Address> getAllAddresss(){		
		List<Address> list=entityManager.createQuery("select e from Address e").getResultList();

		return list;
    }

}
