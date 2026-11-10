package org.example.model;

import java.time.format.DateTimeFormatter;

public class Noleggio {

    Utente utente;
    Veicolo veicolo;
    DateTimeFormatter oraInizo;
    DateTimeFormatter oraFine;

    public void setUtente(Utente utente) throws Exception {
        if(utente == null){
            throw new Exception("utente non trovato");
        }
        this.utente = utente;
    }

    public void setVeicolo(Veicolo veicolo) throws Exception {
        if(veicolo == null){
            throw new Exception("veicolo non trovato");
        }
        this.veicolo = veicolo;
    }

    public void setOraInizo(DateTimeFormatter oraInizo) throws Exception {
        if(oraInizo == null){
            throw new Exception("ora inizio non valida");
        }
        this.oraInizo = oraInizo;
    }

    public void setOraFine(DateTimeFormatter oraFine) throws Exception {
        if(oraFine == null){
            throw new Exception("ora fine non valida");
        }
        this.oraFine = oraFine;
    }

    public Utente getUtente() {
        return utente;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public DateTimeFormatter getOraInizo() {
        return oraInizo;
    }

    public DateTimeFormatter getOraFine() {
        return oraFine;
    }

    public Noleggio(Utente utente, Veicolo veicolo, DateTimeFormatter oraInizo, DateTimeFormatter oraFine) throws Exception {
        setUtente(utente);
        setVeicolo(veicolo);
        setOraInizo(oraInizo);
        setOraFine(oraFine);
    }
    
}
