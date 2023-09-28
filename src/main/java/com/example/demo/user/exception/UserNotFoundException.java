package com.example.demo.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super(new Integer(id).toString());
    }
}
