package com.example;

import java.math.BigInteger;

public class PrimeChecker {

    public static boolean isPrime(BigInteger big) {

        long number = big.longValue();

        if (number < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number);

        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
