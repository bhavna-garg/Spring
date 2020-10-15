package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService service;
	
	//Here login form is rendered when get request is done to /login
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login_form() {
		
		return "login";
		
	}
	//Here welcome form is rendered when post request is done to /login. like when form is submitted
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String welcome(ModelMap model, @RequestParam String name,  @RequestParam String password) {
		boolean isValidUser = service.validateUser(name, password);
		if(!isValidUser) {
			model.put("errorMsg", "Invalid Credentials!!");
			return "login";
		}
			
		model.put("name", name);
		return "welcome";
		
	}

}
