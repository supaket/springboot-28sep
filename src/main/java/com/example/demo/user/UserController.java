package com.example.demo.user;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public void createUsers(@Valid @RequestBody UserDto user) {
        userService.create(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

}
