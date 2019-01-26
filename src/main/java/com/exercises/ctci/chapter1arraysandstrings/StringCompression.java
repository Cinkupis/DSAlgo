package com.exercises.ctci.chapter1arraysandstrings;

/*
    Implement a method to perform basic string compression using the counts of repeated characters. For example,
    the string "aabcccccaaa" would become "a2b1c5a3". If the compressed string would not become smaller than the
    original string, then the method should return the original string. You can assume string has only uppercase
    and lowercase letters (a-z).
 */
@SuppressWarnings("unused")
public class StringCompression {

    private String compressString(String uncompressed) {
        if (uncompressed == null || uncompressed.isEmpty() || uncompressed.length() <= 2) {
            return uncompressed;
        }
        uncompressed = uncompressed.toLowerCase();
        StringBuilder compressed = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < uncompressed.length(); i++) {
            if (i == 0) {
                compressed.append(uncompressed.charAt(i));
                counter++;
            } else if (uncompressed.charAt(i) == uncompressed.charAt(i - 1)) {
                counter++;
            } else {
                compressed.append(counter);
                compressed.append(uncompressed.charAt(i));
                counter = 1;
            }
        }
        compressed.append(counter);

        if (compressed.length() < uncompressed.length()) {
            return compressed.toString();
        }
        return uncompressed;
    }
}
