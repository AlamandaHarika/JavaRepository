package com.capg.campsite.dao;

import java.time.LocalDate;
import java.util.List;

import com.capg.campsite.entity.User;
import com.capg.campsite.exception.UserNotFoundException;

public interface UserDao {
	public List<User>getAllUsers();
	public User addUser(User user);
	public User updateUser(User user);
	public User getUserById(long userId) throws UserNotFoundException;
	public void deleteUser(long userId);
	

}

