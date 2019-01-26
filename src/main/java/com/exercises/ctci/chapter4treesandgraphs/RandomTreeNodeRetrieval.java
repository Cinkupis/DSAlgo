package com.exercises.ctci.chapter4treesandgraphs;

import com.datastructures.trees.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unused")
public class RandomTreeNodeRetrieval {
    public TreeNode getRandomNode(TreeNode root, int size) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, size);
        return findNodeOfIndexLevelOrder(root, randomIndex);
    }

    private TreeNode findNodeOfIndexLevelOrder(TreeNode root, int index) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode ofIndex = nodes.remove();
            if (index == 0) {
                return ofIndex;
            }

            if (ofIndex.left != null) {
                nodes.add(ofIndex.left);
            }

            if (ofIndex.right != null) {
                nodes.add(ofIndex.right);
            }
            index--;
        }
        return null;
    }
}
