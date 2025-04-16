package com.thejonnyboyd.quoteapi.exception;

public class QuoteNotFoundException extends RuntimeException {
    public QuoteNotFoundException(String message){
        super(message);
    }
}
