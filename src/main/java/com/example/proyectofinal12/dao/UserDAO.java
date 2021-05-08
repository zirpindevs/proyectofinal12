package com.example.proyectofinal12.dao;

import com.example.proyectofinal12.model.User;

import java.util.List;

public interface UserDAO {

/*
    List<User> findAllFromSession();
*/
    User createUser(User userToCreate);
    User findById(Long id);
    User findByEmail(String email);
}
