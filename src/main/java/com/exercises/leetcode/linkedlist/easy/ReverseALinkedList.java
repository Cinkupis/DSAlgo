package com.exercises.leetcode.linkedlist.easy;

import com.exercises.leetcode.linkedlist.ListNode;

@SuppressWarnings("unused")
public class ReverseALinkedList {
    public ListNode reverseListIteratively(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversedListHead = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return reversedListHead;
    }
}
