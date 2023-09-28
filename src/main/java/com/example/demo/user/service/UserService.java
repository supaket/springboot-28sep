package com.example.demo.user.service;

import com.example.demo.user.model.IUserStore;
import com.example.demo.user.model.UserDto;
import org.springframework.stereotype.Service;

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

    public UserDto get(int id) {
        final UserDto user = new UserDto();
        users.forEach(userDto -> {
            if(userDto.getId() == id) {
                user.setId(userDto.getId());
                user.setName(userDto.getName());
                user.setAge(userDto.getAge());
            }
        });
        return user;
    }

    public void update(int id, UserDto user) {
        UserDto existingUser = this.get(id);
        if(existingUser!=null) {
            users.remove(existingUser);
            users.add(user);
        }
    }
}
