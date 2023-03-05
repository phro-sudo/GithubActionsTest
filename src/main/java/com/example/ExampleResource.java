package com.example;

import com.example.database.DBManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;
import java.sql.SQLException;


@Path("/prime")
public class ExampleResource {

    DBManager dbManager = new DBManager();

    @GET
    @Path("/isPrime/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean isPrime(@PathParam("number") String numberStr) {

        try {
            return dbManager.isPrime(numberStr);
        } catch (SQLException ignored) {
        }

        BigInteger number;
        try {
            number = new BigInteger(numberStr);
        } catch (NumberFormatException e) {
            throw new WebApplicationException("Wrong number format", 400);
        }

        boolean response;
        if (number.compareTo(new BigInteger(String.valueOf(1000000))) < 0) {
            response = PrimeChecker.isPrime(number);
        } else {
            response =  MillerRabin.isProbablePrime(number, 10);
        }

        try {
            dbManager.setPrime(numberStr, response);
        } catch (SQLException e) {
        }

        return response;

    }

}