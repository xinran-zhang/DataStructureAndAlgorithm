package grace.shuati;

public class MaximumDepthOfBinaryTreeTraversal {
    private int depth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root, 1);
        return depth;
    }

    private void traverse(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }

        depth = Math.max(depth, curDepth);
        traverse(root.left, curDepth + 1);
        traverse(root.right, curDepth + 1);
    }
}
