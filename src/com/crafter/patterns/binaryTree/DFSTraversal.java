package com.crafter.patterns.binaryTree;

public class DFSTraversal {
    public static void main(String[] args) {
        // insert into tree
        /*
         * 1
         * / \
         * 2 3
         * /
         * 4
         */

        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(5);
        inorder(tree1);

    }
    //(Root → Left → Right)
    public static void preorder(TreeNode root){
        if(root == null){
            return ;
        }
        int val = root.val;
        System.out.println(val);
        preorder(root.left);
        preorder(root.right);
    }
    //(Left → Right → Root)
    public static void postorder(TreeNode root){
        if(root == null){
            return ;
        }
        preorder(root.left);
        preorder(root.right);
        int val = root.val;
        System.out.println(val);
    }

     //(Left → Root → Right) ; 4 2 1 3
     public static void inorder(TreeNode root){
        if(root == null){
            return ;
        }
        
        inorder(root.left);
        int val = root.val;
        System.out.println(val);
        inorder(root.right);
    }
}
