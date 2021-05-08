package com.example.web.socket.servers;

import com.example.models.Todo;
import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
@ServerWebSocket("/ws/todos")
public class TodoWebSocketServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoWebSocketServer.class);
    private final WebSocketBroadcaster broadcaster;

    public TodoWebSocketServer(WebSocketBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }

    @OnMessage
    public Publisher<String> onMessage(Todo todo) {
        String message = todo.toString();
        LOGGER.info("New message: {}", message);
        return broadcaster.broadcast(message);
    }

    @OnClose
    public Publisher<String> onClose() {
        return broadcaster.broadcast("Web socket connection closed");
    }
}
