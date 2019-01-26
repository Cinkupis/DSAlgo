package com.datastructures.queue;

import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public class MyQueue<T extends Object> {

    private QueueNode<T> first;
    private QueueNode<T> last;

    private static class QueueNode<T extends Object> {
        private T value;
        private QueueNode<T> next;

        public QueueNode(T value) {
            this.value = value;
        }
    }

    public void add(T item) {
        QueueNode<T> newNode = new QueueNode<>(item);
        if (last != null) {
            last.next = newNode;
        }
        last = newNode;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T value = first.value;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return value;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.value;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
