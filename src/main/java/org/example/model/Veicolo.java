package org.example.model;

import org.example.StatoVeicolo;

public abstract class Veicolo {
    private Integer codice;
    private Double livelloBatteria;
    private StatoVeicolo stato;
    private double tariffa;

    public Veicolo(Integer codice, double livelloBatteria, StatoVeicolo stato, double tariffa) throws Exception {
        setCodice(codice);
        setLivelloBatteria(livelloBatteria);
        setStato(stato);
        setTariffa(tariffa);
    }

    public Integer getCodice() {
        return codice;
    }

    public Double getLivelloBatteria() {
        return livelloBatteria;
    }

    public double getTariffa() {
        return tariffa;
    }

    public StatoVeicolo getStato() {
        return stato;
    }

    public void setCodice(Integer codice) throws Exception {
        if(codice <= 0){
            throw new Exception("codice non valido");
        }
        this.codice = codice;
    }

    public void setLivelloBatteria(Double livelloBatteria) throws Exception {
        if(livelloBatteria < 0 || livelloBatteria > 100){
            throw new Exception("stato batteria non valido");
        }
        this.livelloBatteria = livelloBatteria;
    }

    public void setStato(StatoVeicolo stato) {
        this.stato = stato;
    }

    public void setTariffa(double tariffa) throws Exception {
        if(tariffa < 0){
            throw new Exception("tariffa non valida");
        }
        this.tariffa = tariffa;
    }

    public abstract double calcolaCosto(int minuti) throws Exception;

    public abstract double consumoBatteriaPerMinuto();
}
