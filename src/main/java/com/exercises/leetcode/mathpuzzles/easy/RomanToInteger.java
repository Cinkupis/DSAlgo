package com.exercises.leetcode.mathpuzzles.easy;

@SuppressWarnings("unused")
public class RomanToInteger {
    public int romanToInt(String s) {
        int current = 0;
        if (s == null || s.isEmpty()) {
            return current;
        }

        char[] roman = s.toCharArray();
        int previous = Integer.MAX_VALUE;
        for (int i = 0; i < roman.length; i++) {
            switch (roman[i]) {
                case 'M':
                    if (previous < 1000) {
                        current = current + 1000 - previous - previous;
                    } else {
                        current += 1000;
                    }
                    previous = 1000;
                    break;
                case 'D':
                    if (previous < 500) {
                        current = current + 500 - previous - previous;
                    } else {
                        current += 500;
                    }
                    previous = 500;
                    break;
                case 'C':
                    if (previous < 100) {
                        current = current + 100 - previous - previous;
                    } else {
                        current += 100;
                    }
                    previous = 100;
                    break;
                case 'L':
                    if (previous < 50) {
                        current = current + 50 - previous - previous;
                    } else {
                        current += 50;
                    }
                    previous = 50;
                    break;
                case 'X':
                    if (previous < 10) {
                        current = current + 10 - previous - previous;
                    } else {
                        current += 10;
                    }
                    previous = 10;
                    break;
                case 'V':
                    if (previous < 5) {
                        current = current + 5 - previous - previous;
                    } else {
                        current += 5;
                    }
                    previous = 5;
                    break;
                case 'I':
                    if (previous < 1) {
                        current = current + 1 - previous - previous;
                    } else {
                        current += 1;
                    }
                    previous = 1;
                    break;
                default:
                    break;
            }
        }

        return current;
    }
}
