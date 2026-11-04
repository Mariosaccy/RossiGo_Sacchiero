package org.example;

public abstract class Veicolo {
    private Integer codice;
    private Double livelloBatteria;
    private StatoVeicolo stato;

    public abstract double calcolaCosto(int minuti);

    public abstract double consumoBatteriaPerMinuto(double percentualeAlMinuto);
}
