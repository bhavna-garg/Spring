package com.example.demo.services;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;

@Component
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	static {
        todos.add(new Todo(1, "bhavna", "Learn Spring Boot", new Date(), false));
        todos.add(new Todo(2, "bhavna", "revise", new Date(), false));
        todos.add(new Todo(3, "bhavna", "Code", new Date(), false));
    }
	
	public List<Todo> retriveTodos(String user){
	List<Todo> list = new ArrayList<Todo>();
	for(Todo todo: todos) {
		if(todo.getUser().equals(user)) {
			list.add(todo);
		}
	}
	return list;
	}
	
	public Todo retriveTodo(int id){
		for(Todo todo: todos) {
			if(todo.getId() == id ) {
				return todo;
			}
		}
		return null;
		}
	
	public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }
	
	public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
	}
	
	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
		
	}
}
