package com.datastructures.hashtables;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        public K key;
        public V value;
        public HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<HashNode<K, V>> buckets;
    private int capacity;
    private int size;

    private static final int INITIAL_CAPACITY = 1 << 4;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new ArrayList<>();
        this.size = 0;

        for (int i = 0; i < this.capacity; i++)
            buckets.add(null);
    }

    public MyHashTable() {
        this(INITIAL_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % this.capacity;
    }

    public V remove(K key) {
        int index = getIndex(key);
        HashNode<K, V> head = buckets.get(index);

        HashNode<K, V> previous = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }

            previous = head;
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        size--;

        if (previous != null) {
            previous.next = head.next;
        } else {
            buckets.set(index, head.next);
        }

        return head.value;
    }

    public V get(K key) {
        int index = getIndex(key);
        HashNode<K, V> head = buckets.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        HashNode<K, V> head = buckets.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = buckets.get(index);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        buckets.set(index, newNode);

        if ((1.0*size()) / this.capacity >= 0.7) {
            ArrayList<HashNode<K, V>> temp = buckets;
            buckets = new ArrayList<>();
            this.capacity *= 2;
            size = 0;

            for (int i = 0; i < this.capacity; i++) {
                buckets.add(null);
            }

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}
