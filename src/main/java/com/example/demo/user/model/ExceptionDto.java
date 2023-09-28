package com.example.demo.user.model;

import java.util.Date;

public class ExceptionDto {
    public ExceptionDto(String message) {
        this.message = message;
        this.timestamp = new Date();
    }

    private Date timestamp;
    private String message;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
