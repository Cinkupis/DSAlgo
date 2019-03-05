package com.datastructures.linkedlists;

@SuppressWarnings("unused")
public class MyDoublyLinkedList {

    private class ListNode {
        private ListNode right;
        private ListNode left;
        private int value;

        public ListNode(int value) {
            this.value = value;
        }
    }

    private int size;
    public ListNode head;

    public MyDoublyLinkedList() {
        size = 0;
        this.head = null;
    }

    public MyDoublyLinkedList(int value) {
        size = 1;
        this.head = new ListNode(value);
    }

    public void addHead(int value) {
        if (this.head == null) {
            this.head = new ListNode(value);
            size++;
            return;
        }

        ListNode currentHead = this.head;
        this.head = new ListNode(value);
        this.head.left = currentHead.left == null ? currentHead : currentHead.left;
        this.head.right = currentHead;
        currentHead.left = this.head;
        size++;
    }

    public void addTail(int value) {
        if (this.head == null) {
            this.head = new ListNode(value);
            size++;
            return;
        }

        ListNode currentTail = this.head.left;
        if (currentTail == null) {
            currentTail = new ListNode(value);
            currentTail.left = this.head;
            currentTail.right = this.head;
            this.head.left = currentTail;
            this.head.right = currentTail;
        } else {
            ListNode newTail = new ListNode(value);
            currentTail.right = newTail;
            newTail.right = this.head;
            newTail.left = currentTail;
            this.head.left = newTail;
        }
        size++;
    }

    public void removeByIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }

        if (index > size / 2) {
            traverseLeftAndDelete(size - index);
        } else {
            traverseRightAndDelete(index);
        }
        size--;
    }

    private void traverseLeftAndDelete(int times) {
        ListNode node = this.head;
        for (int i = 0; i < times; i++) {
            node = node.left;
        }
        if (node != null) {
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }

    private void traverseRightAndDelete(int times) {
        if (times == 0) {
            this.head = this.head.right;
            return;
        }

        ListNode node = this.head;
        for (int i = 0; i < times; i++) {
            node = node.right;
        }
        if (node != null) {
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }

    public void removeByNode(ListNode node) {
        if (size == 0 || this.head == null) {
            return;
        }

        if (size == 1) {
            if (this.head == node) {
                this.head = null;
                size--;
                return;
            } else {
                return;
            }
        }

        ListNode backwards = this.head.left;
        ListNode forwards = this.head;

        for (int i = 0; i <= size / 2; i++) {
            if (backwards == node) {
                backwards.left.right = backwards.right;
                backwards.right.left = backwards.left;
                size--;
                break;
            } else if (forwards == node) {
                forwards.left.right = forwards.right;
                forwards.right.left = forwards.left;
                size--;
                break;
            } else {
                backwards = backwards.left;
                forwards = forwards.right;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MyDoublyLinkedList{size = " + size + ", [");
        ListNode node = this.head;
        for (int i = 0; i < size; i++) {
            sb.append(node.value);
            if (i != size - 1) {
                sb.append(", ");
            }
            node = node.right;
        }
        sb.append("]}");
        return  sb.toString();
    }
}