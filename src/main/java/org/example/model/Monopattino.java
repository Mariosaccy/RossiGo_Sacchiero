package org.example.model;

import org.example.StatoVeicolo;

public class Monopattino extends Veicolo{
    double velocitaMax;
    double battPerMin;
    boolean limitatoInZonaPedonale;

    public  Monopattino(double velocitaMax, Integer codice, double livelloBatteria, StatoVeicolo stato, double tariffa, double battPerMin, boolean limitatoInZonaPedonale) throws Exception {
        super(codice, livelloBatteria, stato, tariffa);
        setVelocitaMax(velocitaMax);
        setBattPerMin(battPerMin);
        setLimitatoInZonaPedonale(limitatoInZonaPedonale);
    }

    public void setBattPerMin(double battPerMin) throws Exception {
        if(battPerMin < 0 || battPerMin > 100){
            throw new Exception("percentuale batteria per minuto non valida");
        }
        this.battPerMin = battPerMin;
    }

    public void setLimitatoInZonaPedonale(boolean limitatoInZonaPedonale) throws Exception {
        if( limitatoInZonaPedonale != true && limitatoInZonaPedonale != false){
            throw new Exception("dato su zona pedonale non valido");
        }
        this.limitatoInZonaPedonale = limitatoInZonaPedonale;
    }

    public boolean isLimitatoInZonaPedonale(){
        return limitatoInZonaPedonale;
    }

    public void setVelocitaMax(double velocitaMax) throws Exception {
        if(velocitaMax <= 0){
            throw new Exception("velocità massima non valida");
        }
        this.velocitaMax = velocitaMax;
    }

    public  double getVelocitaMax(){
        return velocitaMax;
    }

    public double getBattPerMin() {
        return battPerMin;
    }

    @Override
    public double calcolaCosto(int minuti) throws Exception {
        if(minuti <= 0){
            throw new Exception("minuti non validi");
        }
        return this.getTariffa() * minuti;
    }

    @Override
    public double consumoBatteriaPerMinuto(){
        return battPerMin;
    }
}
