package com.crafter.patterns.binaryTree;

public class InvertBinaryTree {

    public static void main(String[] args) {
        // Constructing tree to invert:
        /*
                  4
                 / \
                2   7
               / \ / \
               1  3 6  9
         */
        TreeNode tree1 = new TreeNode(4);

        tree1.left= new TreeNode(2);
        tree1.left.left= new TreeNode(1);
        tree1.left.right= new TreeNode(3);
        
        tree1.right= new TreeNode(7);
        tree1.right.left= new TreeNode(6);
        tree1.right.right= new TreeNode(9);
    }

    public static TreeNode invert(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
        return root;
    }

}
