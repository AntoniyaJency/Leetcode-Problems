class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    List<TreeNode> build(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();

        // If no numbers left, add null
        if (start > end) {
            trees.add(null);
            return trees;
        }

        // Try each number as root
        for (int i = start; i <= end; i++) {

            // All possible left trees
            List<TreeNode> leftTrees = build(start, i - 1);

            // All possible right trees
            List<TreeNode> rightTrees = build(i + 1, end);

            // Combine left & right
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
