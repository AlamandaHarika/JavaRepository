package com.capg.campsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.campsite.entity.User;
import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/get-all-user")
	public ResponseEntity<List<User>> getAllUsers() throws ResourceNotFoundException {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/get-user-by-id/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable long userId) throws ResourceNotFoundException {

		return new ResponseEntity(this.userService.getUserById(userId), HttpStatus.OK);
	}

	@PostMapping("/add-user")
	public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);

	}

	@PutMapping("/update-user")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws ResourceNotFoundException {
		return ResponseEntity.ok(userService.updateUser(user));

	}

	@DeleteMapping("/delete-user-by-id/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable long userId) throws ResourceNotFoundException {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}

}
