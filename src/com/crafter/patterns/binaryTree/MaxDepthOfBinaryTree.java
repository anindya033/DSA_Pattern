package com.crafter.patterns.binaryTree;

public class MaxDepthOfBinaryTree{
   
    public static void main(String [] args){


        // insert 
        /*
                1
               / \
               2  3   
              /
              4
        */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left =new TreeNode(4);
        System.out.println("maxDepth : "+maxDepth(tree));


    }

    public static int maxDepth(TreeNode root){

        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return(1+Math.max(left, right));
    }
} 