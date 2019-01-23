package com.exercises.hackerrank;

import java.util.*;

public class Staircase {

    static void staircase(int n) {
        for (int numTags = 1; numTags < n + 1; numTags++) {
            for (int i = 0; i < n - numTags; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < numTags; i++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        staircase(n);
        scanner.close();
    }
}
