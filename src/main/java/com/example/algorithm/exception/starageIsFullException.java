package com.example.algorithm.exception;

public class starageIsFullException extends RuntimeException {
    public starageIsFullException() {
    }

    public starageIsFullException(String message) {
        super(message);
    }

    public starageIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public starageIsFullException(Throwable cause) {
        super(cause);
    }

    public starageIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
