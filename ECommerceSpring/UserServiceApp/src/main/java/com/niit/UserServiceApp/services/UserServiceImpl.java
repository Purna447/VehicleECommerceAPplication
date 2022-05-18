package com.niit.UserServiceApp.services;


import com.niit.UserServiceApp.exception.UserNotFoundException;
import com.niit.UserServiceApp.model.User;
import com.niit.UserServiceApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }



    @Override
    public User findByUsernameAndPassword(String username , String password) throws UserNotFoundException {
        User user =  userRepository.findByUsernameAndPassword(username , password);
        if(user == null){
            throw new UserNotFoundException();
        }
        else
        {
            System.out.println(user.toString());
        }
        return user;

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
