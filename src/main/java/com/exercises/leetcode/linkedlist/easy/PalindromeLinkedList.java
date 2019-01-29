package com.exercises.leetcode.linkedlist.easy;

import com.exercises.leetcode.linkedlist.ListNode;

@SuppressWarnings("unused")
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversedListHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversedListHead;
    }
}
