package com.crafter.patterns.binaryTree;

public class InvertBinaryTree {

    public static void main(String[] args) {
        // Constructing tree:
        /*
                4
               / \
              2   7
             / \ / \
            1  3 6  9
        */
        TreeNode tree1 = new TreeNode(4);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(3);
        
        tree1.right = new TreeNode(7);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(9);
        
        // Execute the inversion
        invert(tree1);
    }

    /**
     * Inverts a binary tree by swapping the left and right children
     * for every node, recursively.
     */
    public static TreeNode invert(TreeNode root){
        // Base case: If the current node is null, there's nothing to invert.
        // This stops the recursion at the leaves.
        if(root == null){
            return null;
        }

        // --- SWAP OPERATION ---
        // Store the left child temporarily so it isn't lost during the swap.
        TreeNode temp = root.left;
        
        // Assign the right child to the left position.
        root.left = root.right;
        
        // Assign the stored left child to the right position.
        root.right = temp;

        // --- RECURSIVE STEPS ---
        // After swapping the current node's children, move deeper into the tree
        // to repeat the same swap process for the left and right subtrees.
        invert(root.left);
        invert(root.right);
        
        // Return the modified root node.
        return root;
    }
}