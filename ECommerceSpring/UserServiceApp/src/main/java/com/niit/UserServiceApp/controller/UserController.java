package com.niit.UserServiceApp.controller;


import com.niit.UserServiceApp.model.User;
import com.niit.UserServiceApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private ResponseEntity responseEntity;
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody User user) {

        User createdUser = userService.saveUser(user);
        return responseEntity = new ResponseEntity("User Created",HttpStatus.CREATED);
    }
    @GetMapping("/api/v1/userservice/users")
    public ResponseEntity getAllUsers(HttpServletRequest request){
        List<User> list =  userService.getAllUsers();
        responseEntity = new ResponseEntity(list,HttpStatus.OK);
        return responseEntity;
    }

}
