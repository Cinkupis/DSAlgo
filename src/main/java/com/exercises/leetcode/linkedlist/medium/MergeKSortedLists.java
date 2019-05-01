package com.exercises.leetcode.linkedlist.medium;

import com.exercises.leetcode.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minheap = new PriorityQueue<>(lists.length, Comparator.comparingInt(node -> node.val));
        ListNode result = new ListNode(0);
        ListNode tail = result;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minheap.offer(lists[i]);
            }
        }

        while (!minheap.isEmpty()) {
            tail.next = minheap.poll();
            tail = tail.next;
            if (tail.next != null) {
                minheap.offer(tail.next);
            }
        }

        return result.next;
    }
}
