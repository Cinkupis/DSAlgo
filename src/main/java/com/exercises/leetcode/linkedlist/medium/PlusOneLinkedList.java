package com.exercises.leetcode.linkedlist.medium;

import com.exercises.leetcode.linkedlist.ListNode;

@SuppressWarnings("unused")
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        boolean carry = addOne(head);

        if (carry) {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(0);
            head.val = 1;
        }

        return head;
    }

    private boolean addOne(ListNode current) {
        if (current == null) {
            return false;
        }

        boolean carry = addOne(current.next);

        if (carry) {
            if (current.val == 9) {
                current.val = 0;
                return true;
            } else {
                current.val++;
                return false;
            }
        } else {
            if (current.next == null && current.val == 9) {
                current.val = 0;
                return true;
            } else if (current.next == null) {
                current.val++;
                return false;
            } else {
                return false;
            }
        }
    }
}
