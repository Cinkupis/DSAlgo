package com.exercises.leetcode.narytree.easy;

import com.exercises.leetcode.narytree.NaryNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(NaryNode root) {
        List<List<Integer>> traversal = new LinkedList<>();
        if (root == null) {
            return traversal;
        }

        Queue<NaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currLevel = new LinkedList<>();

            int length = queue.size();
            for (int i = 0; i < length; i++) {
                NaryNode curr = queue.remove();
                currLevel.add(curr.val);
                for (NaryNode c : curr.children) {
                    queue.add(c);
                }
            }

            traversal.add(currLevel);
        }

        return traversal;
    }
}
