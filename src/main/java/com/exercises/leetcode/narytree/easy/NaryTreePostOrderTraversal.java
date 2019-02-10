package com.exercises.leetcode.narytree.easy;

import com.exercises.leetcode.narytree.NaryNode;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class NaryTreePostOrderTraversal {
    public List<Integer> traverse(NaryNode root) {
        List<Integer> traversal = new LinkedList<>();

        if (root == null) {
            return traversal;
        }
        traverse(root, traversal);
        traversal.add(root.val);
        return traversal;
    }

    private void traverse(NaryNode node, List<Integer> traversal) {
        if (node != null && node.children != null) {
            for (int i = 0; i < node.children.size(); i++) {
                traverse(node.children.get(i), traversal);
                traversal.add(node.children.get(i).val);
            }
        }
    }
}
