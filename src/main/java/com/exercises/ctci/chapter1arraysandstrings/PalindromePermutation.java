package com.exercises.ctci.chapter1arraysandstrings;

import java.util.HashMap;

/*
    Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase
    that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need
    to be limited to just dictionary words.

    EXAMPLE:
    Input: "Tact Coa"
    Output: True
    (permutations: "taco cat", "atco cta", etc.)
 */
@SuppressWarnings("unused")
public class PalindromePermutation {
    public boolean hasPalindromePermutation(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        char[] input = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();

        int leftBound = 0;
        int rightBound = input.length - 1;

        while (leftBound < rightBound) {
            if (input[leftBound] != input[rightBound]) {
                return false;
            }
            leftBound++;
            rightBound--;
        }

        return true;
    }
}
