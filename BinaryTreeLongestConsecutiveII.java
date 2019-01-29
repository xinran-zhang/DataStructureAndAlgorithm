package grace.shuati;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path could be start and end at any node in the tree
 */

public class BinaryTreeLongestConsecutiveII {
    class ResultType {
        int maxLength, maxUp, maxDown;
        public ResultType(int len, int up, int down) {
            maxLength = len;
            maxUp = up;
            maxDown = down;
        }
    }
    public int longestConsecutive2(TreeNode root) {
        return helper(root).maxLength;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0 , 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int up = 0;
        int down = 0;
        if (root.left != null && root.left.val + 1 == root.val) {
            down = Math.max(down, left.maxDown + 1);
        }
        if (root.left != null && root.left.val - 1 == root.val) {
            up = Math.max(up, left.maxUp + 1);
        }
        if (root.right != null && root.right.val + 1 == root.val) {
            down = Math.max(down, right.maxDown + 1);
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            up = Math.max(up, right.maxUp + 1);
        }
        int len = up + down + 1;
        len = Math.max(len, Math.max(left.maxLength, right.maxLength));

        return new ResultType(len, up, down);
    }
}
