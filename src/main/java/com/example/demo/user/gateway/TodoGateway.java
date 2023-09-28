package com.example.demo.user.gateway;

import com.example.demo.user.model.TodoModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component

public class TodoGateway {

    private final RestTemplate restTemplate;
    private final String todoUrl;

    public TodoGateway(final RestTemplate restTemplate, @Value("${todo.url}") String todoUrl) {
        this.restTemplate = restTemplate;
        this.todoUrl = todoUrl;
    }

    public Optional<List<TodoModel>> getTodoByUserId(int id){
        String url = String.format("%s?userId=%d", todoUrl, id);
        return Optional.ofNullable(restTemplate.getForObject(url, List.class));
    }
}
