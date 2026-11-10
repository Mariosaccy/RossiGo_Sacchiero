package org.example.exception;

public class ErroreDatabaseException extends RossiGoException {
    public ErroreDatabaseException(String message) {
        super(message);
    }

    public ErroreDatabaseException(String message, Throwable cause){
        super(message, cause);
    }
}
