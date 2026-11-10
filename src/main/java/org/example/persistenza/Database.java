package org.example.persistenza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    private Connection connection = null;
    private static Database istance = null;

    private Database() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
    }

    public static Database GetIstance() throws SQLException {
        if(istance == null){
            istance = new Database();
        }
        return istance;
    }

    public void insertUtente(String nome, String cognome, String email, String cf, double credito){
        if(!this.testConnectiom()){
            throw new RuntimeException("impossibile collegarsi al db");
        } else {
            String query = "INSERT INTO utente (nome, cognome, email, cf, credito) values (?, ?, ?, ?, ?)";

            try {
                PreparedStatement statement = this.connection.prepareStatement(query);

                statement.setString(1, nome);
                statement.setString(2, cognome);
                statement.setString(3, email);
                statement.setString(4, cf);
                statement.setDouble(5, credito);
                
                statement.execute();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void insertVeicolo(double livelloBatt, String statoVeicolo, double tariffa, int numeroMarce, double velMax, double battPerMin, boolean limitatoInZonaPedonale){
        if(!this.testConnectiom()){
            throw new RuntimeException("impossibile collegarsi al db");
        } else {
            String query = "INSERT INTO veicolo (livelloBatt, statoVeicolo, tariffa, numeroMarce, velMax, battPerMin, limitatoInZonaPedonale) values (?, ?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement statement = this.connection.prepareStatement(query);

                statement.setDouble(1, livelloBatt);
                statement.setString(2, statoVeicolo);
                statement.setDouble(3, tariffa);
                statement.setInt(4, numeroMarce);
                statement.setDouble(5, velMax);
                statement.setDouble(6, battPerMin);
                statement.setBoolean(7, limitatoInZonaPedonale);
                
                
                statement.execute();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    private boolean testConnectiom(){
        try {
            return this.connection.isValid(5);
        } catch (SQLException e){
            return false;
        }
    }
}
