package com.exercises.leetcode.strings.easy;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class CountAndSay {
    public String countAndSay(int n) {
        return new String(recurse(n));
    }

    private char[] recurse(int n) {
        if (n == 1) {
            char[] result = new char[1];
            result[0] = '1';
            return result;
        }

        char[] previous = recurse(n - 1);

        char[] current = sayPrevious(previous);
        return current;
    }

    private char[] sayPrevious(char[] previous) {
        int counter = 0;
        List<Character> currentList = new LinkedList<>();
        char current = previous[0];
        for (int i = 0; i < previous.length; i++) {
            if (previous[i] == current) {
                counter++;
            } else {
                currentList.add((char)(counter + '0'));
                currentList.add(current);
                counter = 1;
                current = previous[i];
            }
        }
        currentList.add((char)(counter + '0'));
        currentList.add(current);

        char[] result = new char[currentList.size()];
        for (int i = 0; i < currentList.size(); i++) {
            result[i] = currentList.get(i);
        }
        return result;
    }
}
