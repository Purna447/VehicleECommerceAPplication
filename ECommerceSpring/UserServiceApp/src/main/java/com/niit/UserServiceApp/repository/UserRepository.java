package com.niit.UserServiceApp.repository;


import com.niit.UserServiceApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsernameAndPassword(String username, String password);
}


