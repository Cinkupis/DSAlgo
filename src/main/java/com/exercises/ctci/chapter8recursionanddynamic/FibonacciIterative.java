package com.exercises.ctci.chapter8recursionanddynamic;

@SuppressWarnings("unused")
public class FibonacciIterative {
    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i < n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }
        return first + second;
    }
}
