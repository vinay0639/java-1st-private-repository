package com.vin.bankservice.exception;

public class InvalidAccNumException extends RuntimeException{

    public InvalidAccNumException (String message){
        super(message);
    }
}
