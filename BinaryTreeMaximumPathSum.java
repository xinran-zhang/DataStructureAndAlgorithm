package grace.shuati;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 */

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // left tree sum
        // right tree sum
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        int sum = Math.max(left, right) + root.val;
        max = Math.max(max, left + right + root.val);
        return sum;
    }
}
