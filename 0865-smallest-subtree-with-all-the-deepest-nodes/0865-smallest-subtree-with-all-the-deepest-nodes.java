class Solution {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        if (root == null)
            return new Result(null, 0);

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth > right.depth)
            return new Result(left.node, left.depth + 1);

        if (right.depth > left.depth)
            return new Result(right.node, right.depth + 1);

        // equal depth
        return new Result(root, left.depth + 1);
    }

    class Result {
        TreeNode node;
        int depth;
        Result(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
}
