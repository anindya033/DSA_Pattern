package com.crafter.patterns.binaryTree;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem:
 * Find the path from the Root node to a given Target node.
 *
 * Approach:
 * - Every recursive call answers one question:
 *      "Does my subtree contain the target?"
 * - Assume the current node is part of the path and add it to the list.
 * - If the target is found, return true.
 * - Otherwise, search the left subtree first. If not found, search the right subtree.
 * - If neither subtree contains the target, remove the current node from the path
 *   (Backtracking) because it is not part of the final answer.
 *
 * Key Learning:
 * Don't think "Is this node the target?"
 * Think "Does my subtree contain the target?"
 * The boolean returned by recursion helps the parent decide whether to
 * keep or remove itself from the path.
 */

public class FindPathInBinrayTree {

    public static void main(String[] args) {

        // Construct the Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.left = new TreeNode(6);

        int target = 6;

        // Stores the final Root -> Target path
        List<Integer> path = new ArrayList<>();

        // Start DFS traversal
        findPath(root, target, path);

        // Print the path
        System.out.println(path);
    }

    private static boolean findPath(TreeNode root, int target, List<Integer> path) {

        // Empty subtree -> Target not found
        if (root == null) {
            return false;
        }

        // Assume current node belongs to the answer path
        path.add(root.val);

        // Target found -> Keep current path
        if (root.val == target) {
            return true;
        }

        boolean isRight = false;

        // Search in the left subtree
        boolean isLeft = findPath(root.left, target, path);

        // Search right subtree only if target was not found on the left
        if (!isLeft) {
            isRight = findPath(root.right, target, path);
        }

        // Target doesn't exist in either subtree
        // Remove current node while backtracking
        if (!isLeft && !isRight) {
            path.remove(path.size() - 1);
            return false;
        }

        // Target found in one of the subtrees
        // Keep current node in the path
        return true;
    }

}