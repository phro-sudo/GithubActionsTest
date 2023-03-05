package com.example.database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

    Connection connection = DBConnection.getInstance();

    public boolean isPrime(String numberStr) throws SQLException {
        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS Primes (number numeric(1000,0) NOT NULL, prime boolean NOT NULL, CONSTRAINT Primes_pkey PRIMARY KEY (number))");
        ResultSet set = connection.createStatement().executeQuery("SELECT prime FROM Primes WHERE number = " + numberStr);
        set.next();
        return set.getBoolean(1);
    }

    public void setPrime(String numberStr, boolean isPrime) throws SQLException {
        connection.createStatement().execute("INSERT INTO Primes VALUES (" + numberStr + ", " + isPrime + ")");
    }


}
