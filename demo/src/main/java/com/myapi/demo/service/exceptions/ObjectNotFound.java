package com.myapi.demo.service.exceptions;

public class ObjectNotFound  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectNotFound(String message, Throwable causa){
        super(message, causa);
        
    }

    public ObjectNotFound(String message){
        super(message);

    }
}
