package com.exercises.leetcode.linkedlist.medium;

import com.exercises.leetcode.linkedlist.ListNode;

import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode chain;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                pQueue.offer(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        if (pQueue.size() == 0) {
            return null;
        }
        chain = new ListNode(pQueue.poll());
        ListNode result = chain;
        while (pQueue.size() > 0) {
            chain.next = new ListNode(pQueue.poll());
            chain = chain.next;
        }
        return result;
    }
}
