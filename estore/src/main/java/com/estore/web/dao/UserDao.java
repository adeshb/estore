package com.estore.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.estore.jpa.User;
import com.estore.jpa.UserPK;

@Component
public class UserDao {

    @PersistenceContext
    transient EntityManager entityManager;
    
    public User findUserById(Integer userId) {
        if (userId == null) return null;
        return entityManager.find(User.class, userId);
    }
    
    @Transactional
    public void persist(User user) {
        this.entityManager.persist(user);
    }
    
    @Transactional
    public void remove(User user) {
        if (this.entityManager.contains(user)) {
            this.entityManager.remove(user);
        } else {
        	User attached = findUserById((user.getUserId()));
            this.entityManager.remove(attached);
        }
    }
    
    
    @Transactional
    public void merge(User user) {
    	User toPopulateCreatedBy = findUserById(user.getUserId());
        entityManager.merge(toPopulateCreatedBy);
    }
    
    @SuppressWarnings("unchecked")
	public List<User> getAllUsers(){		
		List<User> list=entityManager.createQuery("select e from User e").getResultList();

		return list;
    }

}
