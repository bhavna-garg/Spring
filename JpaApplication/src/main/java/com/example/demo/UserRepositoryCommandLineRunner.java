package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.service.UserDAOService;
import com.example.demo.service.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user = new User("Jill" , "Admin");
		// save is used for both insert n update
		userRepository.save(user);
		log.info("New user is created: " + user);
		
		
		Optional<User> userWithId1 = userRepository.findById(1L);
		log.info("User retrived: " + userWithId1);
		
		List<User> users = userRepository.findAll();
		log.info("All Users: " + users);

	

}
}