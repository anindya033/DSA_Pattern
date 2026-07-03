package com.crafter.patterns.binaryTree;

public class DiameterOfBinartTree {

    public static void main(String []args){
        // Setup: Constructing a sample Balanced Binary Tree
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(9);
        
        // Initiate the diameter calculation
        calculateDiameter(tree);
        System.out.println("Diameter : "+diameter);
    }
    
    // Global variable to store the maximum diameter found during recursion
    static int diameter = 0;

    /**
     * Recursive function to calculate the height of the tree 
     * and update the diameter simultaneously.
     */
    public static int calculateDiameter(TreeNode root){
        // Base case: If node is null, height is 0
        if(root == null){
            return 0;
        }

        // Recursively find the height of left and right subtrees
        int right = calculateDiameter(root.right);
        int left = calculateDiameter(root.left);
        
        // The diameter at current node = sum of heights of left and right subtrees.
        // Update the global maximum if this path is longer than previous ones.
        diameter = Math.max(diameter, right + left);

        // Return the height of current node to the parent (1 + max height of subtrees)
        return(1 + Math.max(right, left));
    }
}