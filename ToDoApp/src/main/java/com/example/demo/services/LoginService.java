package com.example.demo.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("bhavna") && password.equals("password");
			
		
	}

}
