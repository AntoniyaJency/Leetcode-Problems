import java.util.*;

class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }

    void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);    // LEFT
        result.add(node.val);  // ROOT
        inorder(node.right);   // RIGHT
    }
}
