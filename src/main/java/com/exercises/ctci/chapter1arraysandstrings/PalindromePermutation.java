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
public class PalindromePermutation {
    private boolean hasPalindromePermutation(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        input = input.toLowerCase();
        input = input.replaceAll(" ", "");

        HashMap<Character, Integer> charCounter = new HashMap<>();
        short oddCounter = 0;

        for (char c : input.toCharArray()) {
            if (!charCounter.containsKey(c)) {
                charCounter.put(c, 1);
                oddCounter++;
            } else {
                charCounter.put(c, charCounter.get(c) + 1);
                if (charCounter.get(c) % 2 == 0) {
                    oddCounter--;
                } else {
                    oddCounter++;
                }
            }
        }

        if (oddCounter > 1) {
            return false;
        }

        if (oddCounter == 1 && input.length() % 2 == 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.print(palindromePermutation.hasPalindromePermutation("aaabbtt"));
    }
}
