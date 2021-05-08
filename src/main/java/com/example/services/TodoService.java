package com.example.services;

import com.example.models.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getTodos();

    Todo createTodo(Todo todo);
}
