package com.exercises.leetcode.dynamicprogramming.easy;

@SuppressWarnings("unused")
public class FibonacciEvenValuedSum100 {
    public int fibonacci() {
        int first = 0;
        int second = 1;
        int total = 0;
        int count = 0;
        while (count < 100) {
            int current = first + second;
            if (current % 2 == 0) {
                total += current;
                count++;
            }
            first = second;
            second = current;
        }
        return total;
    }
}
