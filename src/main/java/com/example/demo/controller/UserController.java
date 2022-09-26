package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.exception.UserIdMismatchException;
import com.example.demo.exception.UserNotFoundException;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public Iterable<User> findAll() {
	return userRepository.findAll();
    }

    @GetMapping("/user/{username}")
    public List<User> findByUsername(@PathVariable String username) {
	return userRepository.findByUsername(username);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
	return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable long id) {
	userRepository.findById(id).orElseThrow(UserNotFoundException::new);
	userRepository.deleteById(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable long id) {
	if (user.getId() != id) {
	    throw new UserIdMismatchException();
	}
	userRepository.findById(id).orElseThrow(UserNotFoundException::new);
	return userRepository.save(user);
    }

}