package com.exercises.ctci.chapter4treesandgraphs;

import com.datastructures.trees.nodes.TreeNode;

import java.util.HashMap;

@SuppressWarnings("unused")
public class CountPathsWithSum {
    public int solutionOofN(TreeNode node, int targetSum) {
        return pathsWithSumOofN(node, targetSum, 0, new HashMap<Integer, Integer>());
    }

    public int solutionOofNLogN(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int pathsFromRoot = pathsWithSumOofNLogN(root, targetSum, 0);
        int pathsOnLeft = solutionOofNLogN(root.left, targetSum);
        int pathsOnRight = solutionOofNLogN(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    private int pathsWithSumOofNLogN(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum += node.value;

        int totalPaths = 0;
        if (currentSum == targetSum) {
            totalPaths++;
        }

        totalPaths += pathsWithSumOofNLogN(node.left, targetSum, currentSum);
        totalPaths += pathsWithSumOofNLogN(node.right, targetSum, currentSum);

        return totalPaths;
    }

    private void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }

    private int pathsWithSumOofN(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) {
            return 0;
        }

        runningSum += node.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if (runningSum == targetSum) {
            totalPaths++;
        }

        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += pathsWithSumOofN(node.left, targetSum, runningSum, pathCount);
        totalPaths += pathsWithSumOofN(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }
}
