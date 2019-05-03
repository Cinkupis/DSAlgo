package com.exercises.leetcode.design.easy;

import java.util.HashMap;
import java.util.Stack;

@SuppressWarnings("unused")
public class FreqStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> freqStacks = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {

    }

    public void push(int x) {
        int frequency = freq.getOrDefault(x, 0) + 1;
        freq.put(x, frequency);
        if (freqStacks.get(frequency) == null) {
            freqStacks.put(frequency, new Stack<Integer>());
        }
        maxFreq = Math.max(maxFreq, frequency);
        freqStacks.get(frequency).push(x);
    }

    public int pop() {
        int value = freqStacks.get(maxFreq).pop();
        freq.put(value, maxFreq - 1);
        if (freq.get(value) == 0) {
            freq.remove(value);
        }

        if (freqStacks.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        return value;
    }
}
