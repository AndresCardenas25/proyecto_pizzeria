package com.sasf.pizza.service.exception;

public class EmailApiException extends RuntimeException {
    public EmailApiException(){
        super("Error sendings email...");
    }
}
