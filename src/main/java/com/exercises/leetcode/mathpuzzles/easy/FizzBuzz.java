package com.exercises.leetcode.mathpuzzles.easy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String FizzBuzz = "";
            if (i % 3 == 0) {
                FizzBuzz += "Fizz";
            }
            if (i % 5 == 0) {
                FizzBuzz += "Buzz";
            }
            if (FizzBuzz.isEmpty()) {
                result.add(Integer.toString(i));
            } else {
                result.add(FizzBuzz);
            }
        }
        return result;
    }
}
