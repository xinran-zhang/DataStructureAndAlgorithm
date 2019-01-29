package grace.shuati;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        // min depth of left tree vs min depth of right tree
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 && right == 0) {
            return 1;
        } else if (left == 0) {
            left = right;
        } else if (right == 0) {
            right = left;
        }

        return Math.min(left, right) + 1;
    }
}
