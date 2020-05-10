package com.exercises.leetcode.linkedlist.easy;

import com.exercises.leetcode.linkedlist.ListNode;

@SuppressWarnings("unused")
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode speedy = head;
        while (speedy.next != null && speedy.next.next != null) {
            head = head.next;
            speedy = speedy.next.next;
        }
        if (speedy.next != null) {
            return head.next;
        }
        return head;
    }
}
