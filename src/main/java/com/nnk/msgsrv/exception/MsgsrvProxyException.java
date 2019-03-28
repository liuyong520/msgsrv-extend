package com.nnk.msgsrv.exception;

public class MsgsrvProxyException extends RuntimeException{
    public MsgsrvProxyException(String message) {
        super(message);
    }

    public MsgsrvProxyException(Throwable cause) {
        super(cause);
    }
}
