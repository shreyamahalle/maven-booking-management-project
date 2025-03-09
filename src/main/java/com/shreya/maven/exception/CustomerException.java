package com.shreya.maven.exception;


public class CustomerException extends RuntimeException{
    public CustomerException(String NotAvailable){
        super(NotAvailable);
    }
}
