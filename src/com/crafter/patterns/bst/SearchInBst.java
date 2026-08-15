package com.crafter.patterns.bst;

import com.crafter.patterns.binaryTree.TreeNode;

public class SearchInBst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        int target = 7;
        TreeNode result = searchTarget(root, target);
        if(result == null){
            System.out.println("Not Found");
        }else{
            System.out.println("Found");
        }
    }

    public static TreeNode searchTarget(TreeNode root, int target) {
        // TODO Auto-generated method stub
        if (root == null) {
            return null;
        }

        if(root.val == target){
            return root;
        }

        if (target > root.val){
            return searchTarget(root.right, target);
        }else{
            return searchTarget(root.left, target);
        }
    }

}
