package com.exercises.leetcode.mathpuzzles.easy;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class DecimalToAnyBase {
    public void printValueInBase(int value, int base) {
        List<Character> converted = new LinkedList<>();
        if (base == 10) {
            System.out.println(value);
        }

        int power = 0;
        int currentValue = value;
        while (currentValue != 0) {
            int mod = currentValue % base;
            if (mod > 9) {
                converted.add((char)('A' + mod - 10));
            } else {
                converted.add((char)('0' + mod));
            }
            currentValue = currentValue / base;
            power++;
        }

        for (int i = converted.size() - 1; i >= 0; i--) {
            System.out.print(converted.get(i));
        }
    }
}