package grace.shuati;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */

public class BalancedBinaryTree {
    private int NOT_BALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != NOT_BALANCED;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == NOT_BALANCED || right == NOT_BALANCED) {
            return NOT_BALANCED;
        }
        if (Math.abs(left - right) > 1) {
            return NOT_BALANCED;
        }
        return Math.max(left, right) + 1;
    }
}
