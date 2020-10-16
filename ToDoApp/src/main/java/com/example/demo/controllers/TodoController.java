package com.example.demo.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.services.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String listTodos(ModelMap model) {
		String name = (String) model.get("name");
		model.put("todos", service.retriveTodos(name));
		return "list-todos";
		
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String addTodos(ModelMap model) {
	
		return "todo";
		
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addTodos(ModelMap model, @RequestParam String description) {
		String name = (String) model.get("name");
		service.addTodo(name, description, new Date(), false);
		//model.put("todos", service.retriveTodos(name));
		//return "list-todos";
		return "redirect:/list-todos";
		
	}

}
