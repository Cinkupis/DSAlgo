package com.exercises.leetcode.binarytrees.easy;

import com.exercises.leetcode.binarytrees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        double difference = Double.MAX_VALUE;
        int value = -1;

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (queue.size() > 0) {
            TreeNode curr = queue.poll();
            if (Math.abs(curr.val - target) < difference) {
                difference = Math.abs(curr.val - target);
                value = curr.val;
            }

            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return value;
    }
}
