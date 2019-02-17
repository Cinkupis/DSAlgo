package com.exercises.ctci.chapter1arraysandstrings;

/*
    Write a method to replace all spaces in a char array with '%20'. You may assume that the char array has sufficient
    space at the end to hold the additional characters, and that you are given the "true" length of the string.
    Do not use Java Strings.
 */
@SuppressWarnings("unused")
public class URLify {
    private String urlify(char[] original, int actualLength) {
        int spaceCount = 0;
        for (int i = 0; i < actualLength; i++) {
            if (original[i] == ' ') {
                spaceCount++;
            }
        }
        int index = actualLength + spaceCount * 2;
        for (int i = actualLength - 1; i >= 0; i--) {
            if (original[i] == ' ') {
                original[--index] = '0';
                original[--index] = '2';
                original[--index] = '%';
            } else {
                original[--index] = original[i];
            }
        }

        return String.copyValueOf(original);
    }
}
