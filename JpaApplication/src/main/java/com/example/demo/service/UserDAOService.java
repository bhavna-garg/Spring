package com.example.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

// All these things can be avoided and we can only use UserRepository as Spring data Repository manages all
// It is written in UserRepository
@Repository
@Transactional
public class UserDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}

}

// http://localhost:8080/h2-console/ - user this url to check the db
// db name: 'jdbc:h2:mem:testdb' as set in the application.properties
