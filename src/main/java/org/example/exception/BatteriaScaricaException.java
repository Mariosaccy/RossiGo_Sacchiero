package org.example.exception;

public class BatteriaScaricaException extends RossiGoException {

    private final double livelloAttuale;

    public BatteriaScaricaException(String message, double livelloAttuale){
        super(message);
        this.livelloAttuale = livelloAttuale;
    }

    public BatteriaScaricaException(String message, double livelloAttuale, Throwable cause) {
        super(message, cause);
        this.livelloAttuale = livelloAttuale;
    }

    public double getLivelloAttuale() {
        return livelloAttuale;
    }
}
