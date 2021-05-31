package com.bootcamp.bootcamp.exceptions;

public class ExceptionsResponse {
    private String message;
    public String getMessage() {
        return message;
    }
    ExceptionsResponse(String message) {
        this.message = message;
    }
}
