package com.company.utils.exception;

public class TextCheckException extends Exception{
    public TextCheckException() {
    }

    public TextCheckException(String message) {
        super(message);
    }

    public TextCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextCheckException(Throwable cause) {
        super(cause);
    }

    public TextCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
