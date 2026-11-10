package org.example.model;

import org.example.StatoVeicolo;

public class Bici extends Veicolo{

    private Integer numeroMarce;

    public  Bici(Integer numeroMarce, Integer codice, double livelloBatteria, StatoVeicolo stato, double tariffa) throws Exception {
        super(codice, livelloBatteria, stato, tariffa);
        setNumeroMarce(numeroMarce);

    }

    public Integer getNumeroMarce(){
        return numeroMarce;
    }

    public void setNumeroMarce(Integer numeroMarce) throws Exception {
        if(numeroMarce <= 0){
            throw new Exception("numero marce non valido");
        }
        this.numeroMarce = numeroMarce;
    }

    @Override
    public double calcolaCosto(int minuti) throws Exception {
        if(minuti <= 0){
            throw new Exception("minuti inseriti non validi");
        }
        return minuti*this.getTariffa();
    }

    @Override
    public double consumoBatteriaPerMinuto() {
        return 2;
    }
}
