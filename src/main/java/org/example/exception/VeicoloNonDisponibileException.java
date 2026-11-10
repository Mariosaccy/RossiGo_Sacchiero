package org.example.exception;

public class VeicoloNonDisponibileException extends RossiGoException {
    public VeicoloNonDisponibileException(String message) {
        super(message);
    }

    public VeicoloNonDisponibileException(String message, Throwable cause){
        super(message, cause);
    }
}
