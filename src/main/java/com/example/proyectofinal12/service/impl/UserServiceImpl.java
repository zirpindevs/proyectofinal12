package com.example.proyectofinal12.service.impl;

import com.example.proyectofinal12.dao.UserDAO;
import com.example.proyectofinal12.model.User;
import com.example.proyectofinal12.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User findOne(Long id) {
        log.info("REST request to find one user by id");

        if(id == null)
            return null;
        return this.userDAO.findById(id);
    }

    @Override
    public User findByEmail(String email){
        log.info("REST request to find an username by email");

        if(email == null)
            return null;
        return this.userDAO.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        log.info("REST request to create an iser");
        return this.userDAO.createUser(user);
    }

}
