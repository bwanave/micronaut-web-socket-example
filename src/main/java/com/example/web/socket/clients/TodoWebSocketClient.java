package com.example.web.socket.clients;

import com.example.models.Todo;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.ClientWebSocket;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;

@ClientWebSocket
public abstract class TodoWebSocketClient implements AutoCloseable {

    private WebSocketSession session;

    @OnOpen
    public void onOpen(WebSocketSession session) {
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
    }

    public abstract void send(Todo message);
}