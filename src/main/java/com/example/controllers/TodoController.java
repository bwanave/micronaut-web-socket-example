package com.example.controllers;

import com.example.models.Todo;
import com.example.services.TodoService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

@Controller("/api/v1/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Get
    public HttpResponse<List<Todo>> getTodos() {
        List<Todo> todos = todoService.getTodos();
        return HttpResponse.ok(todos);
    }

    @Post
    public HttpResponse<Todo> createTodo(@Body Todo todo) {
        Todo newTodo = todoService.createTodo(todo);
        return HttpResponse.created(newTodo);
    }
}
