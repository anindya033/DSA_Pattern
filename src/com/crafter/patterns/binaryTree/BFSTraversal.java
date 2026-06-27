package com.crafter.patterns.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class BFSTraversal {

    public static void main(String [] args){
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
        doBFSTraversal(tree1);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
    static Stack<Integer> stack = new Stack<>();
        public static void doBFSTraversal(TreeNode root) {
            if(root == null){
                return;
            }
            stack.push(root.val);
            if(root.left.val != null){
                stack.push(root.left.val);
            }
            
            if(root.right.val != null){
                stack.push(root.right.val);
            }
            doBFSTraversal(root.left);
            
            doBFSTraversal(root.right);
    }
}
