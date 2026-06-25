package com.crafter.patterns.binaryTree;

public class DiameterOfBinartTree {

    public static void main(String []args){
        // Balanced Binary Tree
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(9);
        calculateDiameter(tree);
        System.out.println("Diameter : "+diameter);
    }
    static int diameter = 0;
        public static  int calculateDiameter(TreeNode root){
    
            if(root == null){
                return 0;
            }
    
            int right = calculateDiameter(root.right);
            int left = calculateDiameter(root.left);
            diameter = Math.max(diameter, right+ left);

            return(1+Math.max(right,left));
    }

}
