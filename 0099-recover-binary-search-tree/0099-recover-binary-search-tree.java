class Solution {
    TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        inorder(node.right);
    }
}
