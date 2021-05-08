package com.example.controllers;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@MicronautTest
class TodoControllerTest {

    @Client("/api/v1/todos")
    @Inject
    private RxHttpClient httpClient;

    @Test
    void getTodos() {
        HttpResponse<List> response = httpClient.toBlocking().exchange(HttpRequest.GET(""), Argument.of(List.class));
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
        List<?> body = response.getBody().orElse(Collections.emptyList());
        Assertions.assertEquals(2, body.size());
    }
}