package com.exercises.leetcode.binarytrees.easy;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return addNode(0, nums.length - 1, nums);
    }

    private TreeNode addNode(int minIndex, int maxIndex, int[] array) {
        if (maxIndex < minIndex) {
            return null;
        }

        int midIndex = (minIndex + maxIndex) / 2;
        TreeNode node = new TreeNode(array[midIndex]);
        if (minIndex <= midIndex - 1) {
            node.left = addNode(minIndex, midIndex - 1, array);
        }

        if (midIndex + 1 <= maxIndex) {
            node.right = addNode(midIndex + 1, maxIndex, array);
        }

        return node;
    }
}
