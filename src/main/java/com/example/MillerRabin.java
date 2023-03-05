package com.example;

import java.math.BigInteger;
import java.util.Random;

public class MillerRabin {

    public static boolean isProbablePrime(BigInteger n, int k) {
        if (n.compareTo(BigInteger.ONE) == 0 || n.compareTo(BigInteger.valueOf(4)) == 0) {
            return false;
        }
        if (n.compareTo(BigInteger.valueOf(3)) == 0 || n.compareTo(BigInteger.valueOf(2)) == 0) {
            return true;
        }
        int s = 0;
        BigInteger d = n.subtract(BigInteger.ONE);
        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            s++;
            d = d.divide(BigInteger.TWO);
        }
        for (int i = 0; i < k; i++) {
            BigInteger a = randomBigInt(BigInteger.TWO, n.subtract(BigInteger.ONE));
            BigInteger x = a.modPow(d, n);
            if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE))) {
                continue;
            }
            boolean isProbablePrime = false;
            for (int j = 0; j < s - 1; j++) {
                x = x.modPow(BigInteger.TWO, n);
                if (x.equals(BigInteger.ONE)) {
                    return false;
                }
                if (x.equals(n.subtract(BigInteger.ONE))) {
                    isProbablePrime = true;
                    break;
                }
            }
            if (!isProbablePrime) {
                return false;
            }
        }
        return true;
    }

    private static BigInteger randomBigInt(BigInteger min, BigInteger max) {
        BigInteger n;
        Random rand = new Random();
        do {
            n = new BigInteger(max.bitLength(), rand);
        } while (n.compareTo(min) < 0 || n.compareTo(max) > 0);
        return n;
    }

}
