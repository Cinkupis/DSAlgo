package com.exercises.ctci.chapter1arraysandstrings;

/*
    Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional
    data structures?
 */
@SuppressWarnings("unused")
public class IsUnique {

    private boolean isUniqueUsingIndexes(String input) {
        if (input == null || input.length() > 256) {
            return false;
        }
        if (input.length() < 2) {
            return true;
        }
        for (char current : input.toCharArray()) {
            if (input.indexOf(current) != input.lastIndexOf(current)) {
                return false;
            }
        }
        return true;
    }
}