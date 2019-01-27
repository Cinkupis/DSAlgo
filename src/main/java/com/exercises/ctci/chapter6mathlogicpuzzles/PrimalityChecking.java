package com.exercises.ctci.chapter6mathlogicpuzzles;

@SuppressWarnings("unused")
public class PrimalityChecking {
    public boolean primeNaive(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean primeSlightlyBetter(int n) {
        if (n < 2) {
            return false;
        }

        int sqroot = (int) Math.sqrt(n);
        for (int i = 2; i <= sqroot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];
        int count = 0;

        flags[0] = false;
        flags[1] = false;
        for (int i = 2; i < max + 1; i++) {
            flags[i] = true;
        }

        int prime = 2;
        while (prime <= Math.sqrt(max)) {
            crossOff(flags, prime);
            prime = getNextPrime(flags, prime);
        }

        return flags;
    }

    private void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i = i + prime) {
            flags[i] = false;
        }
    }

    private int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }
}
