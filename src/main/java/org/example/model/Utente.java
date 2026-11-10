package org.example.model;

import org.apache.commons.validator.routines.EmailValidator;
import it.kamaladafrica.codicefiscale.CodiceFiscale;
import org.example.exception.CodiceFiscaleNonValidoException;

public class Utente {
    Integer id;
    String nome;
    String cognome;
    String email;
    String cf;
    double credito;

    public Utente(Integer id, String nome, String cognome, String email, String cf, double credito) throws Exception {
        setId(id);
        setNome(nome);
        setCognome(cognome);
        setEmail(email);
        setCf(cf);
        setCredito(credito);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) throws Exception {
        if(id <= 0){
            throw new Exception("id non valido");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("nome non valido");
        }
        this.nome = nome;
    }

    public String getCognome(){
        return cognome;
    }

    public void setCognome(String cognome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("cognome non valido");
        }
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email == null || email.isEmpty() || !EmailValidator.getInstance().isValid(email)){
            throw new Exception("email non valida");
        }
        this.email = email;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) throws Exception {
        if (cf == null || cf.isBlank()) {
            throw new CodiceFiscaleNonValidoException("codice fiscale non valido");
        }
        cf = cf.trim().toUpperCase();
        if (!CodiceFiscale.isFormatValid(cf)) {
            throw new CodiceFiscaleNonValidoException("codice fiscale non valido");
        }
        this.cf = cf;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) throws Exception {
        if(credito < 0){
            throw new Exception("credito non valido");
        }
        this.credito = credito;
    }
    
}
