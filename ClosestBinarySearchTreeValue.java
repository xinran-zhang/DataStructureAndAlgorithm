package grace.shuati;

/**
 * Given a non-empty binary search tree and a target value,
 * find the value in the BST that is closest to the target.
 */

// binary search
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        // find the closest value in left subtree and in right subtree
        if (root == null) return Integer.MIN_VALUE;

        if (target < root.val) {
            int left = closestValue(root.left, target);
            if (Math.abs(left - target) >= Math.abs(root.val - target)) {
                return root.val;
            }
            return left;
        } else {
            int right = closestValue(root.right, target);
            if (Math.abs(right - target) >= Math.abs(root.val - target)) {
                return root.val;
            }
            return right;
        }
    }
}
