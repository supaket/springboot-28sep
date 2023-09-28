package com.example.demo.user.model;

import java.util.List;

public class TodoDto {
    private UserDto user;
    private List<TodoModel> todos;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<TodoModel> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoModel> todos) {
        this.todos = todos;
    }
}
