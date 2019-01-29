package grace.shuati;

/**
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 */

public class MinimumSubtree {
    private int minSum;
    private TreeNode minNode;
    public TreeNode findSubtree(TreeNode root) {
        minSum = Integer.MAX_VALUE;
        minNode = null;
        traverse(root);
        return minNode;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = traverse(root.left) + traverse(root.right) + root.val;
        if (sum <= minSum) {
            minNode = root;
            minSum = sum;
        }
        return sum;
    }
}
