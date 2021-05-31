package com.bootcamp.bootcamp.exceptions;


public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
