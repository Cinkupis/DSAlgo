package com.exercises.leetcode.narytree.easy;

import com.exercises.leetcode.narytree.NaryNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("unused")
public class NaryTreePreOrderTraversal {
    public List<Integer> traversal(NaryNode root) {
        List<Integer> traversal = new LinkedList<>();

        if (root == null) {
            return traversal;
        }

        Stack<NaryNode> nextNodes = new Stack<>();
        nextNodes.push(root);
        while (nextNodes.size() > 0) {
            NaryNode next = nextNodes.pop();
            if (next.children != null) {
                for (int i = next.children.size() - 1; i >= 0; i--) {
                    nextNodes.push(next.children.get(i));
                }
            }
            traversal.add(next.val);
        }
        return traversal;
    }
}
