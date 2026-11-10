package org.example.exception;

public class CreditoInsufficienteException extends RossiGoException {
    public CreditoInsufficienteException(String message) {
        super(message);
    }

    public CreditoInsufficienteException(String message, Throwable cause){
        super(message, cause);
    }
}
