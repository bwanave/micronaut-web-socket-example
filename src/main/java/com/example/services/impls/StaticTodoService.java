package com.example.services.impls;

import com.example.models.Todo;
import com.example.services.TodoService;
import com.example.web.socket.clients.TodoWebSocketClient;
import io.micronaut.context.annotation.Primary;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.websocket.RxWebSocketClient;

import javax.inject.Singleton;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

@Primary
@Singleton
public class StaticTodoService implements TodoService {

    private static final List<Todo> TODOS;
    private final TodoWebSocketClient todoWebSocketClient;

    static {
        ZonedDateTime today = ZonedDateTime.now();
        Todo pythonTodo = new Todo("Python", "Learn Python", today.plusDays(10));
        Todo javaTodo = new Todo("Java", "Checkout Java 16 features", today.plusDays(20));
        TODOS = new ArrayList<>(of(pythonTodo, javaTodo));
    }

    public StaticTodoService(@Client("/") RxWebSocketClient webSocketClient) {
        this.todoWebSocketClient = webSocketClient
                .connect(TodoWebSocketClient.class, "/ws/todos")
                .blockingFirst();
    }

    @Override
    public List<Todo> getTodos() {
        return TODOS;
    }

    @Override
    public Todo createTodo(Todo todo) {
        TODOS.add(todo);
        todoWebSocketClient.send(todo);
        return todo;
    }
}
