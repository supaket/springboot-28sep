package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<UserDto> users;

    public UserService(){
        this.users = new ArrayList<>();
    }
    public void create(UserDto user){
        this.users.add(user);
    }

    public List<UserDto> get() {
        return users;
    }

    public void delete(String name) {
        UserDto user = new UserDto();
        user.setName(name);
        this.users.remove(user);
    }
}
