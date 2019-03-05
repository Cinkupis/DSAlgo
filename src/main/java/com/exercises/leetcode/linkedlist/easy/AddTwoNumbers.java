package com.exercises.leetcode.linkedlist.easy;

import com.exercises.leetcode.linkedlist.ListNode;

@SuppressWarnings("unused")
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, false);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean carry) {
        int sum;
        if (l1 == null && l2 == null) {
            if (carry) {
                ListNode result = new ListNode(1);
                return result;
            }
            return null;
        } else if (l1 == null) {
            sum = l2.val;
        } else if (l2 == null) {
            sum = l1.val;
        } else {
            sum = l1.val + l2.val;
        }
        if (carry) {
            sum++;
        }
        if (sum > 9) {
            carry = true;
            sum -= 10;
        } else {
            carry = false;
        }
        ListNode result = new ListNode(sum);
        result.next = addTwoNumbers(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, carry);

        return result;
    }
}
