package com.exercises.leetcode.binarytrees.easy;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class MaximumBinaryTree {
    private int[] numbers;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.numbers = nums;
        return findMax(0, nums.length - 1, null);
    }

    private TreeNode findMax(int start, int end, TreeNode node) {
        if (start > end) {
            return null;
        }
        int maxIdx = start;
        for (int i = start; i <= end; i++) {
            if (numbers[i] > numbers[maxIdx]) {
                maxIdx = i;
            }
        }

        node = new TreeNode(numbers[maxIdx]);
        node.left = findMax(start, maxIdx - 1, node.left);
        node.right = findMax(maxIdx + 1, end, node.right);
        return node;
    }
}
