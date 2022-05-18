package com.niit.UserServiceApp.services;




import com.niit.UserServiceApp.exception.UserNotFoundException;
import com.niit.UserServiceApp.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    public User findByUsernameAndPassword(String username , String password) throws UserNotFoundException;
    List<User> getAllUsers();
}

