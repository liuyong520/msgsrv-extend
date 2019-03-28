package com.nnk.msgsrv.exception;

public class BindingException extends RuntimeException{
    public BindingException(String message) {
        super(message);
    }

    public BindingException(String message, Throwable cause) {
        super(message, cause);
    }
}
