package com.crafter.patterns.binaryTree;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        /*
         * Constructing the following tree:
         * 1
         * / \
         * 2   3
         * /
         * 4
         */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);

        // Call the recursive function and print the result
        System.out.println("maxDepth : " + maxDepth(tree));
    }

    /**
     * Calculates the maximum depth of a binary tree.
     * The depth is the number of nodes along the longest path from 
     * the root node down to the farthest leaf node.
     */
    public static int maxDepth(TreeNode root) {
        // Base Case: If the current node is null, it contributes 0 to the depth.
        if (root == null) {
            return 0;
        }

        // Recursive Step: 
        // 1. Calculate the max depth of the left subtree.
        int left = maxDepth(root.left);
        // 2. Calculate the max depth of the right subtree.
        int right = maxDepth(root.right);

        // Return the depth of the current subtree:
        // We add 1 to account for the current node itself, 
        // and take the maximum of the left or right paths found.
        return (1 + Math.max(left, right));
    }
}