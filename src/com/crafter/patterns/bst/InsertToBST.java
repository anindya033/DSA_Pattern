package com.crafter.patterns.bst;

import com.crafter.patterns.binaryTree.TreeNode;

public class InsertToBST {

    public static void main(String [] args){
         TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        
        TreeNode value = new TreeNode(5);
        TreeNode result = insert(root, value);
        TreeNode found = SearchInBst.searchTarget(result, 5);

        if (found != null) {
            System.out.println("Inserted successfully");
        }
    }

    private static TreeNode insert(TreeNode root, TreeNode value) {

        if(root == null){
            return null;
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
        
        if(value.val > root.val){
            if(root.right == null){
                root.right = value;
                return root;
            }
            return insert(root.right, value);
        }
        else if(value.val < root.val){
            if(root.left == null){
                root.left = value;
                return root;
            }
            return insert(root.left, value);
        }

        return root;

    }

}
