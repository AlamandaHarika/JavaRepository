package com.capg.campsite.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.campsite.entity.User;
import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.repository.UserRepository;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository repository;

	@Test
	void testGetAllUsers() throws ResourceNotFoundException {
		User u = new User(2000L, "harika@gmail.com", "Harika", "Alamanda", 9900123123L, "Ap");
		repository.save(u);
		assertNotNull(userService.getAllUsers().size());
		repository.delete(u);
	}

	@Test
	void testAddUser() throws Exception {
		User u = new User(2001L, "harika@gmail.com", "Harika", "Alamanda", 9900123123L, "Ap");
		User uu = userService.addUser(u);
		assertEquals(u.getUserId(), uu.getUserId());
		repository.delete(uu);

	}

	@Test
	void testUpdateUser() throws ResourceNotFoundException {
		User u = new User(2001L, "harika@gmail.com", "Harika", "Alamanda", 9900123123L, "Ap");
		repository.save(u);
		//updated one
		User updated = userService.updateUser(new User(2001L, "harika@gmail.com", "Harika_almanda", "Alamanda", 9900123456L, "Ap"));
		assertEquals(updated.getFirstName(),"Harika_almanda");
		repository.delete(updated);
		
	}

	@Test
	void testGetUserById() throws ResourceNotFoundException {
		User u = new User(2001L, "harika@gmail.com", "Harika", "Alamanda", 9900123123L, "Ap");
		repository.save(u);
		assertNotNull(userService.getUserById(u.getUserId()));
		repository.delete(u);
	}

	@Test
	void testDeleteUser() throws ResourceNotFoundException {
		User u = new User(2001L, "harika@gmail.com", "Harika", "Alamanda", 9900123123L, "Ap");
		repository.save(u);
		userService.deleteUser(u.getUserId());
		assertTrue(true);
	}

}
