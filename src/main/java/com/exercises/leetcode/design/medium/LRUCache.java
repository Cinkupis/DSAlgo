package com.exercises.leetcode.design.medium;

import java.util.HashMap;

@SuppressWarnings("unused")
public class LRUCache {
    private static final int NOT_FOUND = -1;

    private int capacity;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    private HashMap<Integer, DoubleLinkedNode> cache = new HashMap<>();

    private class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode pop() {
        DoubleLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return NOT_FOUND;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode found = cache.get(key);

        if (found == null) {
            DoubleLinkedNode node = new DoubleLinkedNode();
            node.key = key;
            node.value = value;

            cache.put(key, node);
            addNode(node);

            if (capacity < cache.size()) {
                DoubleLinkedNode leastUsed = pop();
                cache.remove(leastUsed.key);
            }

        } else {
            found.value = value;
            moveToHead(found);
        }
    }
}
