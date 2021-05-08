package com.example.proyectofinal12.service;

import com.example.proyectofinal12.model.User;

public interface UserService {
    User findOne(Long id);
    User findByEmail(String email);
    User createUser(User user);

}
