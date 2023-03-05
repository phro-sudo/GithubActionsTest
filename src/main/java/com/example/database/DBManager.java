package com.example.database;


import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {

    Connection connection = DBConnection.getInstance();

    public boolean isPrime(String numberStr) throws SQLException {
        return connection.createStatement().executeQuery("SELECT prime FROM public.\"Primes\" WHERE number = " + numberStr).getBoolean(1);
    }

    public void setPrime(String numberStr, boolean isPrime) throws SQLException {
        connection.createStatement().execute("INSERT INTO public.\"Primes\" VALUES (" + numberStr + ", " + isPrime + ")");
    }


}
