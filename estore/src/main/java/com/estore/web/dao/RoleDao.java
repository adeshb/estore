package com.estore.web.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.estore.jpa.Role;

@Component
public class RoleDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public Role findRoleById(Integer id) {
        if (id == null) return null;
        return entityManager.find(Role.class, id);
    }
    
    @Transactional
    public void persist(Role role) {
        this.entityManager.persist(role);
    }
    
    @Transactional
    public void remove(Role role) {
        if (this.entityManager.contains(role)) {
            this.entityManager.remove(role);
        } else {
        	Role attached = findRoleById((role.getRoleId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(Role role) {
    	Role toPopulateCreatedBy = findRoleById(role.getRoleId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<Role> getAllRoles(){		
		List<Role> list=entityManager.createQuery("select e from Role e").getResultList();

		return list;
    }

}
