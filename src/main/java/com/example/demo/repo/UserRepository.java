package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
    List<User> findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    // User findOne(long id);
}