package com.capg.campsite.service;

import java.util.List;

import com.capg.campsite.entity.User;
import com.capg.campsite.exception.ResourceNotFoundException;

public interface UserService {
	public List<User> getAllUsers() throws ResourceNotFoundException;

	public User addUser(User user) throws Exception;

	public User updateUser(User user) throws ResourceNotFoundException;

	public User getUserById(long userId) throws ResourceNotFoundException;

	public void deleteUser(long userId) throws ResourceNotFoundException;

}
