package com.exercises.hackerrank.miscellaneous;

@SuppressWarnings("unused")
public class Staircase {
    public void staircase(int n) {
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
}
