package grace.shuati;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */

public class KthSmallestItemInABST {
    public int kthSmallest(TreeNode root, int k) {
        // find out the num of nodes on the left subtree
        // compare with k, if k < num, find in the left subtree
        int left = traverse(root.left);
        if (k <= left) {
            return kthSmallest(root.left, k);
        }
        if (k > left + 1) {
            return kthSmallest(root.right, k - left - 1);
        }
        return root.val;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);

        return left + right + 1;
    }
}
