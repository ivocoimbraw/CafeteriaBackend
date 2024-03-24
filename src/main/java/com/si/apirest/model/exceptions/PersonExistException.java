package com.si.apirest.model.exceptions;

public class PersonExistException extends RuntimeException{
    
    
    public PersonExistException(String msg) {
        super(msg);
    }
}
