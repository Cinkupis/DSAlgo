package com.dataStructures.queue;

@SuppressWarnings("unused")
public class MyCircularQueue {
    private int[] queue;
    private int tail;
    private int head;
    private int size;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % size;
        queue[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }

}
