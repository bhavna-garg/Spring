package com.example.demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	// The methods written in service are all present by default expect one.
	// retrive todo by user name. So we have declared that method in this way here
	List<Todo> findByUser(String user);

}
