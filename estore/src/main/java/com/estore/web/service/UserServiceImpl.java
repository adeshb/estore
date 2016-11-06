package com.estore.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.web.dao.UserDao;
import com.estore.jpa.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //@Override
    public void createUser(String uname, String upwd) {
        User u = new User();
        u.setFullName(uname);
        u.setPassword(upwd);
        userDao.persist(u);
    }

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
		//return null;
	}
    
    
}