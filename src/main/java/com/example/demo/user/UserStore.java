package com.example.demo.user;

import java.util.ArrayList;

public class UserStore implements IUserStore{
    ArrayList<UserDto> store;

    public UserStore(){
        store =  new ArrayList<>();
    }
    @Override
    public ArrayList<UserDto> getUsers() {
        return store;
    }
}