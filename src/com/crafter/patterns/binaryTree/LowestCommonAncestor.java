package com.crafter.patterns.binaryTree;

/*
 * Problem:
 * Find the Lowest Common Ancestor (LCA) of two given nodes (p and q)
 * in a Binary Tree.
 *
 * ------------------------------------------------------------------------
 * Intuition
 * ------------------------------------------------------------------------
 * Instead of asking:
 *
 *      "Is the current node the LCA?"
 *
 * Think like recursion:
 *
 *      "What information should I return to my parent?"
 *
 * ------------------------------------------------------------------------
 * Recursive Contract
 * ------------------------------------------------------------------------
 * Every recursive call returns ONE of the following:
 *
 * 1. null
 *      -> Neither p nor q exists in this subtree.
 *
 * 2. p or q (TreeNode)
 *      -> One of the target nodes was found.
 *
 * 3. LCA (TreeNode)
 *      -> The Lowest Common Ancestor has already been found in this subtree.
 *
 * The parent DOES NOT care whether it receives p, q or an LCA.
 * It simply trusts that the child has solved the problem correctly
 * for its subtree.
 *
 * ------------------------------------------------------------------------
 * Decision Table
 * ------------------------------------------------------------------------
 *
 * Left Result     Right Result        Current Node Returns
 * --------------------------------------------------------------
 * null            null                null
 * Node            null                Left Node
 * null            Node                Right Node
 * Node            Node                Current Node (LCA)
 *
 * ------------------------------------------------------------------------
 * Key Learning
 * ------------------------------------------------------------------------
 * Don't try to identify the LCA directly.
 *
 * Every recursive call solves the LCA problem for its own subtree
 * and returns the correct node to its parent.
 *
 * The parent simply combines the answers returned by its children.
 */

public class LowestCommonAncestor {

    public static void main(String[] args) {

        /*
         * 3
         * / \
         * 5 1
         * / \ / \
         * 6 2 0 8
         * / \
         * 7 4
         */

        // Construct Binary Tree
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Test Case
        TreeNode p = root.left.left; // Node 6
        TreeNode q = root.left.right.right; // Node 4

        TreeNode ans = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor : " + ans.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root,
            TreeNode p,
            TreeNode q) {

        // Base Case 1:
        // Reached beyond a leaf node.
        // This subtree does not contain p or q.
        if (root == null) {
            return null;
        }

        // Base Case 2:
        // Found one of the target nodes.
        // Return it to the parent.
        if (root == p || root == q) {
            return root;
        }

        // Search in the left subtree.
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Search in the right subtree.
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Left subtree found nothing.
        // Right subtree found either:
        // - p
        // - q
        // - LCA
        // Pass the answer upward.
        if (left == null && right != null) {
            return right;
        }

        // Right subtree found nothing.
        // Left subtree found either:
        // - p
        // - q
        // - LCA
        // Pass the answer upward.
        if (left != null && right == null) {
            return left;
        }

        // Neither subtree contains p or q.
        if (left == null && right == null) {
            return null;
        }

        // One target came from the left subtree
        // and the other came from the right subtree.
        //
        // Therefore, the current node is the
        // Lowest Common Ancestor.
        if (left != null && right != null) {
            return root;
        }

        // Unreachable (kept for Java compilation).
        return null;
    }
}