package com.exercises.ctci.chapter4TreesAndGraphs;

import com.dataStructures.trees.nodes.TreeNode;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class ListOfDepths {
    public List<List<Integer>> getList(TreeNode root) {
        List<List<Integer>> depthList = new LinkedList<>();
        if (root != null) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            recurseLevel(depthList, queue, 0);
        }
        return depthList;
    }

    private void recurseLevel(List<List<Integer>> depthList, LinkedList<TreeNode> queue, int level) {
        LinkedList<TreeNode> newQueue = new LinkedList<>();
        depthList.add(new LinkedList<>());
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            depthList.get(level).add(node.value);

            if (node.left != null) {
                newQueue.add(node.left);
            }
            if (node.right != null) {
                newQueue.add(node.right);
            }
        }
        if (!newQueue.isEmpty()) {
            recurseLevel(depthList, newQueue, level + 1);
        }
    }
}
