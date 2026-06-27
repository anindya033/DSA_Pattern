package com.crafter.patterns.binaryTree;

public class SameTree {

    public static void main(String[] args) {
        // Constructing tree1:
        //      1
        //     / \
        //    2   3
        //   /
        //  4
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);

        // Constructing tree2:
        //      1
        //     / \
        //    2   3
        //   /
        //  5
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(5);

        // Printing results for comparison
        System.out.println("isSame : " + isSame(tree1, tree2));
        System.out.println("isMirror : " + isMirror(tree1, tree2));
    }

    /**
     * Checks if two trees are identical in structure and node values.
     */
    public static boolean isSame(TreeNode tree1, TreeNode tree2) {
        // If both nodes are null, the trees are identical at this path
        if (tree1 == null && tree2 == null) {
            return true;
        }
        // If one is null and the other isn't, they are not identical
        if (tree1 == null || tree2 == null) {
            return false;
        }
        // If the values at the current nodes differ, they are not identical
        if (tree1.val != tree2.val) {
            return false;
        }

        // Recursively check if left subtrees match AND right subtrees match
        return (isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right));
    }

    /**
     * Checks if one tree is a mirror image of the other.
     */
    public static boolean isMirror(TreeNode tree1, TreeNode tree2) {
        // Base case: both reach the end simultaneously
        if (tree1 == null && tree2 == null) {
            return true;
        }
        // If only one is null, they cannot be mirrors
        if (tree1 == null || tree2 == null) {
            return false;
        }
        // Values must match to be a mirror
        if (tree1.val != tree2.val) {
            return false;
        }

        // To be a mirror:
        // 1. tree1's left must match tree2's right
        // 2. tree1's right must match tree2's left
        return (isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left));
    }
}