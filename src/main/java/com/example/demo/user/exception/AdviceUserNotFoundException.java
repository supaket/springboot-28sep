package com.example.demo.user.exception;


import com.example.demo.user.model.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceUserNotFoundException extends RuntimeException {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDto> handle(UserNotFoundException exception) {
        ExceptionDto ex = new ExceptionDto("Not found User id = " + exception.getMessage());
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }
}
