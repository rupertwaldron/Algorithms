package com.ruppyrup.primes;

public class Primarly {


    static String primality(int n) {
        String NOT_PRIME = "Not prime";
        String PRIME = "Prime";
        if (n == 1) return NOT_PRIME;
        if (n == 2) return PRIME;

        if (n % 2 == 0) return NOT_PRIME;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return NOT_PRIME;
        }
        return PRIME;
    }

    public static void main(String[] args) {
        System.out.println(primality(841));
    }
}
