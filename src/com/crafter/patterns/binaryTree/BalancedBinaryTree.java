package com.crafter.patterns.binaryTree;

public class BalancedBinaryTree {

    public static void main(String [] args){
        // Setup a test tree
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(9);

        // Result will be true as the tree is balanced
        System.out.println(isBalanced(tree));
    }

    public static boolean isBalanced(TreeNode root){
        // If getHeight returns -1, it means the tree is unbalanced
        return getHeight(root) != -1;
    }

    public static int getHeight(TreeNode root){
        // Base case: An empty tree has height 0
        if(root == null){
            return 0;
        }

        // Recursively find the height of left and right subtrees
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        // If either subtree is already flagged as unbalanced (-1),
        // propagate the -1 up the recursive call stack
        if(leftH == -1 || rightH == -1){
            return -1;
        }

        // Check if the current node is unbalanced (difference > 1)
        if(Math.abs(rightH - leftH) > 1){
            return -1; // Return -1 to flag that this subtree is unbalanced
        }

        // If balanced, return the height (1 + max height of children)
        return 1 + Math.max(leftH, rightH);
    }
}