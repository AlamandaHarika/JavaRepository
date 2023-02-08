package com.capg.campsite.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.campsite.entity.User;
import com.capg.campsite.exception.UserNotFoundException;
import com.capg.campsite.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository repo;
    @Override
	public List<User> getAllUsers() {

    	return repo.findAll();
	}

	@Override
	public User addUser(User user){

		return repo.save(user);
	}

	@Override
	public User updateUser(User user) {		
		return repo.save(user);
	}

	
//	User user;
//	if(repository.findById(userId).isEmpty()) {
//		throw new UserNotFoundException();
//		}
//		else {
//			user=repo.findById(userId).get();
//		     }
//	return user;

	@Override
	public User getUserById(long userId) throws UserNotFoundException {
		User user;
		if(repo.findById(userId).isEmpty()){
			throw new UserNotFoundException();
		}
		else {
			user=repo.findById(userId).get();
		}
//        return entityManager.find(User.class, userId);
		return user;
	}

	@Override
	public void deleteUser(long userId) {
		repo.deleteById(userId);

		
	}
}

	