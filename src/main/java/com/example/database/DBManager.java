package com.example.database;


import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {

    Connection connection = DBConnection.getInstance();

    public boolean isPrime(String numberStr) throws SQLException {
        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS Primes (number numeric(1000,0) NOT NULL, prime boolean NOT NULL, CONSTRAINT Primes_pkey PRIMARY KEY (number))");
        return connection.createStatement().executeQuery("SELECT prime FROM Primes WHERE number = " + numberStr).next();
    }

    public void setPrime(String numberStr, boolean isPrime) throws SQLException {
        connection.createStatement().execute("INSERT INTO Primes VALUES (" + numberStr + ", " + isPrime + ")");
    }


}
