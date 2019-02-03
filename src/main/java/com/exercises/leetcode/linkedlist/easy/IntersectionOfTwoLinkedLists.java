package com.exercises.leetcode.linkedlist.easy;

import com.exercises.leetcode.linkedlist.ListNode;

@SuppressWarnings("unused")
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = calcLen(headA);
        int lenB = calcLen(headB);
        if(lenA > lenB){
            headA = moveNStep(headA,lenA-lenB);
        } else {
            headB = moveNStep(headB, lenB - lenA);
        }

        while(headA != null){
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private ListNode moveNStep (ListNode node,int n){
        while (n != 0) {
            node = node.next;
            n--;
        }
        return node;
    }

    private int calcLen (ListNode node){
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
