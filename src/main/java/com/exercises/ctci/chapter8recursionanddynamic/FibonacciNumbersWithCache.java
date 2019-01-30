package com.exercises.ctci.chapter8recursionanddynamic;

@SuppressWarnings("unused")
public class FibonacciNumbersWithCache {
    public int fibonacci(int n) {
        return fibonacci(n, new int[n + 1]);
    }

    private int fibonacci(int i, int[] cache) {
        if (i == 0 || i == 1) {
            return i;
        }

        if (cache[i] == 0) {
            cache[i] = fibonacci(i - 1, cache) + fibonacci(i - 2, cache);
        }
        return cache[i];
    }
}
