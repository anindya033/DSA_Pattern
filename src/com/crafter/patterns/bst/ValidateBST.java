package com.crafter.patterns.bst;
import com.crafter.patterns.binaryTree.TreeNode;

public class ValidateBST {

    public static void main(String[] args) {

        // Valid BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        boolean result = validate(root);
        rootValue = 5;
        System.out.println("Is Valid BST: " + result);
    }
    static int rootValue = Integer.MIN_VALUE;
    private static boolean validate(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean validate(TreeNode root, long lower, long upper) {
    
        // Empty tree/subtree is valid
        if (root == null) {
            return true;
        }
    
        // Current node must be within the allowed range
        boolean currentValid = root.val > lower && root.val < upper;
    
        if (!currentValid) {
            return false;
        }
    
        // For LEFT subtree:
        // current node becomes the new upper bound
        boolean leftValid = validate(root.left, lower, root.val);
    
        if (!leftValid) {
            return false;
        }
    
        // For RIGHT subtree:
        // current node becomes the new lower bound
        boolean rightValid = validate(root.right, root.val, upper);
    
        if (!rightValid) {
            return false;
        }
    
        // Current + left + right are all valid
        return true;
    }
 }