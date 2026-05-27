package com.crafter.patterns.binaryTree;

public class SameTree {

    public static void main(String [] args){


        // insert same tree
        /*
                1
               / \
               2  3   
              /
              4
        */
       
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left =new TreeNode(4);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left =new TreeNode(5);
        System.out.println("is true : "+isMirror(tree1, tree2));



    }

    public static boolean isSame(TreeNode tree1, TreeNode tree2){
        
        if(tree1 == null && tree2 == null){
            return true;
        }
        if(tree1 == null || tree2 == null){
            return false;
        }
        if(tree1.val != tree2.val){
            return false;
        }
        
        return (isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right));

    }

    public static boolean isMirror(TreeNode tree1, TreeNode tree2){
        
        if(tree1 == null && tree2 == null){
            return true;
        }
        if(tree1 == null || tree2 == null){
            return false;
        } 
        if(tree1.val != tree2.val){
            return false;
        }
        
        return (isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left));

    }

}
