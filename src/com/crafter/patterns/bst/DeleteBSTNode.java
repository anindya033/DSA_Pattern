package com.crafter.patterns.bst;

import com.crafter.patterns.binaryTree.TreeNode;

public class DeleteBSTNode {

    public static void main(String[] args) {
        
        // Create the tree:
        //         50
        //        /  \
        //       30   70
        //      / \   / \
        //     20 40 60  80
        
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        
        System.out.println("Original Tree (In-order): ");
        inOrder(root);
        System.out.println();
        
        // Delete node 30 (has two children)
        int keyToDelete = 30;
        System.out.println("Deleting node: " + keyToDelete);
        root = deleteNode(root, keyToDelete);
        
        System.out.println("After deletion (In-order): ");
        inOrder(root);
        System.out.println();
    }
    
    private static TreeNode deleteNode(TreeNode root, int key) {
        
        if (root == null) {
            return null;
        }
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        else {
            // Found the node to delete
            
            // Case 1: No children
            if (root.left == null && root.right == null) {
                return null;
            }
            
            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }
            
            // Case 3: Only left child
            if (root.right == null) {
                return root.left;
            }
            
            // Case 4: Two children
            TreeNode minRight = findMin(root.right);
            root.val = minRight.val;
            root.right = deleteNode(root.right, minRight.val);
        }
        
        return root;
    }
    
    private static TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    private static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}