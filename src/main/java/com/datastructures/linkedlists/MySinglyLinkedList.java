package com.datastructures.linkedlists;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class MySinglyLinkedList<E extends Object> {

    private int size;
    private ListNode head;

    private class ListNode {
        private ListNode next;
        private E value;

        public ListNode(E value) {
            this.next = null;
            this.value = value;
        }

        public ListNode(E value, ListNode next) {
            this.next = next;
            this.value = value;
        }
    }

    public MySinglyLinkedList() {
        size = 0;
        this.head = null;
    }

    public MySinglyLinkedList(E value) {
        size = 1;
        this.head = new ListNode(value);
    }

    public void add(E value) {
        if (this.head == null) {
            this.head = new ListNode(value);
            size++;
            return;
        }

        ListNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new ListNode(value);
        size++;
    }

    public void add(E value, int index) {
        ListNode temp = new ListNode(value);
        ListNode current = this.head;
        if (current != null) {
            for (int i = 0; i < index && current.next != null; i++) {
                current = current.next;
            }
        }

        temp.next = current.next;
        current.next = temp;
        size++;
    }

    public E get(int index) {
        if (index < 0 || this.head == null || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        ListNode current = this.head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                throw new ArrayIndexOutOfBoundsException();
            }

            current = current.next;
        }
        return current.value;
    }

    public E remove(int index) {
        if (index < 0 || index >= size || this.head == null) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (size == 1) {
            ListNode temp = this.head;
            this.head = null;
            return temp.value;
        }

        ListNode current = this.head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (i != size - 2) {
                current = current.next;
            }
        }
        E e = null;
        if (index == size - 1) {
            e = current.next.value;
            current.next = current.next.next;
        } else if (current.next != null) {
            e = current.value;
            current.value = current.next.value;
            current.next = current.next.next;
        }

        size--;
        return e;
    }

    public void removeDuplicates() {
        if (this.head == null) {
            return;
        }
        ListNode current = this.head;
        Set<E> set = new HashSet<>();
        int uniques = 0;
        for (int i = 0; i < size; i++) {
            set.add(current.value);
            uniques++;
            if (set.size() != uniques) {
                remove(i);
                uniques--;
            }
            current = current.next;
        }
    }

    public void removeDuplicatesNoBuffer() {
        if (this.head == null) {
            return;
        }

        ListNode p1 = this.head;
        ListNode p2 = this.head;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j != i && p1.value == p2.value) {
                    remove(j);
                }
                p1 = p1.next;
            }
            p2 = p1.next;
            p1 = this.head;
        }
    }

    public E returnKthToLast(int k) {
        if (size - k >= 0) {
            return this.get(size - k);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public E returnKthToLastUnknownSize(int k) {
        ListNode p1 = this.head;
        ListNode p2 = this.head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                throw new ArrayIndexOutOfBoundsException();
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.value;
    }

    public void deleteMiddleNode(ListNode toDelete) {
        if (toDelete == null) {
            return;
        }
        ListNode current = this.head;
        while (current.next != toDelete && current != null) {
            current = current.next;
        }

        if (current == null) {
            return;
        }

        current.next = toDelete.next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode current = this.head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean equals(Object object) {
        if (!(object instanceof MySinglyLinkedList<?>)) {
            return false;
        }

        MySinglyLinkedList<?> comparable = (MySinglyLinkedList<?>) object;
        if (this.size() != comparable.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (this.get(i) != comparable.get(i)) {
                return false;
            }
        }

        return true;
    }
}
