package com.example.Backend.exception;

public class BadAuthenticationException extends Exception {
    public BadAuthenticationException(String msg) {
        super(msg);
    }
}
