package com.datastructures.stack;

import java.util.EmptyStackException;

@SuppressWarnings("unused")
public class MyStack<T extends Object> {
    private class StackNode<T extends Object> {
        private T value;
        private StackNode<T> next;

        public StackNode(T value) {
            this.value = value;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T item = top.value;
        top = top.next;
        return item;
    }

    public void push(T value) {
        StackNode<T> newTop = new StackNode<>(value);
        newTop.next = top;
        top = newTop;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }

        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
