package com.example.proyectofinal12.controller;

import com.example.proyectofinal12.model.User;
import com.example.proyectofinal12.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
         * FIND USER BY EMAIL
         * @return String
         */
    @PostMapping("/users")
    public ResponseEntity<User> findUserName(@RequestBody User user) throws URISyntaxException {
        log.debug("REST request to find an user by mail: {} ", user);

        System.out.println(user);
        User checkUser = new User();

     /*   if (userRepository.findByEmail(user.getEmail()) != null) {
            checkUser = userRepository.findByEmail((user.getEmail()));
            if (checkUser.getEmail().equals(user.getEmail()))
                return ResponseEntity.ok().body(checkUser);
        }*/

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    /**
     * CREATE USER
     *
     * @param userToCreate
     * @return ResponseEntity<User>
     * @throws URISyntaxException
     */
    @PostMapping("/users/create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<User> createUser(@RequestBody User userToCreate) throws URISyntaxException {
        log.debug("REST request to create an user: {} ", userToCreate);

        if (userToCreate.getEmail() != null || userToCreate.getPassword() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        User createdUser = this.userService.createUser(userToCreate);

        return ResponseEntity
                .created(new URI("/api/expertos/" + createdUser.getEmail()))
                .body(createdUser);
    }
}
