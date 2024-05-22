package com.sapient.bookshowsmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.bookshowsmgmt.dto.UserDTO;
import com.sapient.bookshowsmgmt.model.User;
import com.sapient.bookshowsmgmt.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserDTO> findAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
	public UserDTO getUserById(@PathVariable Long id) {
		return userService.findByUserId(id);
	}

	@GetMapping("/{username}")
	public UserDTO getUserByUsername(@PathVariable String username) {
		return userService.findByUsername(username);
	}

	@PostMapping("/register")
	public User registerUser(@RequestBody UserDTO user) {
		return userService.registerUser(user);
	}
}