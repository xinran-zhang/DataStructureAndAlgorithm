package grace.shuati;

public class BinaryTreeMaximumPathSumII {
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        return Math.max(0, Math.max(left, right)) + root.val;
    }
}
