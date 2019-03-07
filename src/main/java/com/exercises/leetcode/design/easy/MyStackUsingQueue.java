package com.exercises.leetcode.design.easy;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class MyStackUsingQueue {
    private int size = 0;
    private Queue<Integer> mainMemory;
    private Queue<Integer> helperMemory;

    public MyStackUsingQueue() {
        mainMemory = new LinkedList<>();
    }

    public void push(int x) {
        mainMemory.offer(x);
        size++;
    }

    public int pop() {
        int removed = getStackTop();
        mainMemory = helperMemory;
        size--;
        return removed;
    }

    public int top() {
        int top = getStackTop();
        helperMemory.offer(top);
        mainMemory = helperMemory;
        return top;
    }

    private int getStackTop() {
        helperMemory = new LinkedList<>();
        for (int i = 0; i < this.size - 1; i++) {
            helperMemory.offer(mainMemory.poll());
        }
        return mainMemory.poll();
    }

    public boolean empty() {
        return this.size == 0;
    }
}
