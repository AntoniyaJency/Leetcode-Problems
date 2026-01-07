/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long maxProduct = 0;       // to store maximum product
    long totalSum = 0;         // sum of all nodes
    final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = sum(root);      // Step 1: total sum of tree
        helper(root);              // Step 2: find max product
        return (int)(maxProduct % MOD);
    }

    // Step 1: Compute total sum of tree
    private long sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    // Step 2: Recursive function to compute subtree sums & max product
    private long helper(TreeNode node) {
        if (node == null) return 0;

        long left = helper(node.left);
        long right = helper(node.right);
        long subTreeSum = node.val + left + right;

        // Check max product if we split here
        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }
}
