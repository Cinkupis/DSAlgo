package com.exercises.leetcode.mathpuzzles.medium;

@SuppressWarnings("unused")
public class ReplaceTwoAdjacentDigits {
    public static int findSmallestAfterReplacing(int n) {
        int current = n;
        int countOfDigits = 0;

        while (current > 0) {
            countOfDigits++;
            current /= 10;
        }

        current = n;
        for (int i = 1; i <= countOfDigits - 2; i++) {
            int first = n / (int)Math.pow(10, countOfDigits - i) % 10;
            int second = n / (int)Math.pow(10, countOfDigits - (i + 1)) % 10;
            int third = n / (int)Math.pow(10, countOfDigits - (i + 2)) % 10;
            if (first >= second && second > third) {
                current = n / (int)Math.pow(10, countOfDigits - i);
                current *= (int)Math.pow(10, countOfDigits - (i + 1));
                current += n % Math.pow(10, countOfDigits - (i + 1));
                break;
            }
        }

        if (current == n) {
            int last = n % 10;
            int secondToLast = n / 10 % 10;
            if (last < secondToLast) {
                current /= 10;
            } else {
                current = n / 100 * 10;
                current += n % 10;
            }
        }

        return current;
    }
}
