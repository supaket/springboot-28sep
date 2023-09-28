package com.example.demo.user.controller;

import com.example.demo.user.gateway.TodoGateway;
import com.example.demo.user.model.TodoDto;
import com.example.demo.user.model.TodoModel;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    UserService userService;
    TodoGateway todoGateway;

    public UserController(UserService userService, TodoGateway gateway){
        this.userService = userService;
        this.todoGateway = gateway;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return this.userService.get();
    }

    @PostMapping("/users")
    public void createUsers(@Valid @RequestBody UserDto user) {
        userService.create(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable int id)
    {
        UserDto user = userService.get(id);
        return user;
    }


    @GetMapping("/todos/{id}")
    public TodoDto getTodosByUserId(@PathVariable int id)
    {
        Optional<List<TodoModel>> todoModels = todoGateway.getTodoByUserId(id);

        //Exception 404 if user not found
        UserDto user = userService.get(id);

        TodoDto todos = new TodoDto();
        todos.setUser(user);
        if(todoModels.isPresent()) {
            todos.setTodos(todoModels.get());
        }
        return todos;
    }


    @PutMapping("/users/{id}")
    public void updateUserById(@PathVariable int id, @Valid @RequestBody UserDto user) {
        userService.update(id, user);
    }

}
