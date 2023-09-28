package com.example.demo.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return this.userService.get();
    }

    @PostMapping("/users")
    public void createUsers(@RequestBody UserDto user) {
        userService.create(user);
    }

    @DeleteMapping("/users/{name}")
    public void delete(@PathVariable String name){
        userService.delete(name);
    }

}
