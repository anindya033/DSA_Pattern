package com.crafter.patterns.binaryTree;

public class BalamcedBinaryTree {

    //Ba
    public static void main(String [] args){
        // Balanced Binary Tree
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(9);

        /*
        //Un balanced biary tree
            TreeNode tree = new TreeNode(5);
            tree.left = new TreeNode(3);
            tree.left.left = new TreeNode(2);
            tree.left.left.left = new TreeNode(1);
            tree.right = new TreeNode(8);
        */
            System.out.println(isBalanced(tree));
    }

    public static boolean isBalanced(TreeNode root){
        int height = getHeight(root);

        if(height == -1){
            return false;
        }else{
            return true;
        }
    }

    public static int getHeight(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        if(leftH == -1 || rightH == -1){
            return -1;
        }

        if(Math.abs(rightH - leftH) > 1){
            return -1; // why returning -1; got understood. why -1 only.
        }

        return 1+ (Math.max(leftH, rightH));
    }

}
