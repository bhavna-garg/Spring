package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Todo;
import com.example.demo.services.TodoRepository;
import com.example.demo.services.TodoService;

@Controller
public class TodoController {
	//@Autowired
	//TodoService service;
	@Autowired
	TodoRepository todoRepository;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String listTodos(ModelMap model) {
		String name = getLoggedInUserName(model);
		//model.put("todos", service.retriveTodos(name));
		model.put("todos", todoRepository.findByUser(name));
		return "list-todos";
		
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String ShowTodoPage(ModelMap model) {
//		this todo will be available in view to add the values of desc
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "", new Date(), false));
		return "todo";
		
	}


	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	// @valid is added to bind the validations to this todo, validation results are binded to BindingResult
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String name = getLoggedInUserName(model);
		todo.setUser(name);
		todoRepository.save(todo);
		//service.addTodo(name, todo.getDesc(), todo.getTargetDate(), false);
		//model.put("todos", service.retriveTodos(name));
		//return "list-todos";
		return "redirect:/list-todos";
		
	}
	
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		
		//service.deleteTodo(id);
		todoRepository.deleteById(id);
		return "redirect:/list-todos";
		
	}

	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		
		//Todo todo = service.retriveTodo(id);
		Todo todo = todoRepository.getOne(id);
		model.put("todo", todo);
		return "todo";
		
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		todo.setUser(getLoggedInUserName(model));
		if(result.hasErrors()) {
			return "todo";
		}
		//service.updateTodo(todo);
		todoRepository.save(todo);
		
		return "redirect:/list-todos";
		
	}
}
