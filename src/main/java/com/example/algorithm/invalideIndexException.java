package com.example.algorithm;

public class invalideIndexException extends RuntimeException {
    public invalideIndexException() {
    }

    public invalideIndexException(String message) {
        super(message);
    }

    public invalideIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public invalideIndexException(Throwable cause) {
        super(cause);
    }

    public invalideIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
