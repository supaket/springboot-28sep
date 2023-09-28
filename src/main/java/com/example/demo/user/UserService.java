package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<UserDto> users;

    public UserService(IUserStore userStore){
        this.users = userStore.getUsers();
    }
    public void create(UserDto user){
        this.users.add(user);
    }

    public List<UserDto> get() {
        return users;
    }

    public void delete(int id) {
        UserDto user = new UserDto();
        user.setId(id);
        this.users.remove(user);
    }
}
