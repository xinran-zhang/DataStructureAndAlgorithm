package grace.shuati;

public class BinaryTreeLongestConsecutiveSequence {
    int longest = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return longest;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int subtreeLongest = 1;
        if (root.left != null && root.left.val == root.val + 1) {
            subtreeLongest = Math.max(subtreeLongest, left + 1);
        }
        if (root.right != null && root.right.val == root.val + 1) {
            subtreeLongest = Math.max(subtreeLongest, right + 1);
        }
        if (subtreeLongest > longest) {
            longest = subtreeLongest;
        }
        return subtreeLongest;
    }
}
