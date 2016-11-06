package com.estore.web.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.estore.jpa.User;

public interface UserService {

    @Transactional
    void createUser(String uname, String upwd);
    
    List<User> findAll();
}