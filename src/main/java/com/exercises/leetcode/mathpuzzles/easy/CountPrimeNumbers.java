package com.exercises.leetcode.mathpuzzles.easy;

@SuppressWarnings("unused")
public class CountPrimeNumbers {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        return sieveOfEratosthenes(n - 1);
    }

    public int sieveOfEratosthenes(int max) {
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

        for (int i = 2; i < max + 1; i++) {
            if (flags[i]) {
                count++;
            }
        }

        return count;
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
