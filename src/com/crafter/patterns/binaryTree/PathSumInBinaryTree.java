package com.crafter.patterns.binaryTree;

public class PathSumInBinaryTree {

    public static void main(String[] args) {

        /*
         * // Visual representation of the 'root' tree built below:
         *            5
         *           / \
         *          4   8
         *         /   / \
         *        11  13  7
         *        / \
         *       2   6
         */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(2);
        root.right.right.right = new TreeNode(6);

        // Test case 2: Minimal tree to test partial path matching
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4); 
        
        // This will safely return true because root1.left (node 4) is a true leaf 
        // with no children, and 5 + 4 = 9.
        boolean isPathSumAvailable = calculatePathSum(root1, 9);
        System.out.println("Path Sum available : " + isPathSumAvailable);
    }

    /**
     * Recursively checks if the tree has a root-to-leaf path where the sum
     * of all node values along the path equals the given target sum.
     *
     * @param root   The current node in the binary tree.
     * @param target The remaining sum required to fulfill the path condition.
     * @return true if a valid root-to-leaf path matches the target sum, false otherwise.
     */
    private static boolean calculatePathSum(TreeNode root, int target) {
        
        // Base Case 1: If the current node is null, the path is invalid.
        if (root == null){
            return false;
        }

        // Base Case 2: Check if we have reached a true leaf node (no left or right children).
        if (root.left == null && root.right == null) {
            // If the leaf node's value perfectly matches the remaining target, we found a path.
            if (root.val == target) {
                return true;
            }
        }
        
        // Subtract the current node's value from the target to find the remaining sum needed.
        int val = root.val;
        int remaining = target - val;
        
        // Recursively search the left and right subtrees with the updated remaining target.
        boolean leftT = calculatePathSum(root.left, remaining);
        boolean rightT = calculatePathSum(root.right, remaining);

        // If either the left subtree or the right subtree returns true, a valid path exists.
        return (leftT || rightT);
    }
}