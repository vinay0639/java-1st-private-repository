package com.vin.casestudy.exception;

public class NoDoctorsFoundException extends RuntimeException{

    public NoDoctorsFoundException(String message){
        super(message);
    }
}
