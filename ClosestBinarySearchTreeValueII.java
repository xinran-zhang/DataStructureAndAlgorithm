package grace.shuati;
import java.util.*;

/**
 * Given a non-empty binary search tree and a target value,
 * find k values in the BST that are closest to the target.
 */

public class ClosestBinarySearchTreeValueII {
    // brute force: inorder traversal -> traverse through the entire tree
    // find the element that is closest to target
    // start from this element, two pointers
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        List<Integer> values = new ArrayList<>();
        traverse(root, values);

        // find the smaller element that is greater to the target
        int i = 0, n = values.size();
        for (; i < n; i++) {
            if (values.get(i) > target) {
                break;
            }
        }

        // two pointers, add k element to res
        int left = i - 1, right = i;
        for (int j = 0; j < k; j++) {
            if (left >= 0 && (right >= values.size() || target - values.get(left) < values.get(right) - target)) {
                res.add(values.get(left));
                left--;
            } else {
                res.add(values.get(right));
                right++;
            }
        }

        return res;
    }

    private void traverse(TreeNode root, List<Integer> results) {
        if (root == null) return;
        traverse(root.left, results);
        results.add(root.val);
        traverse(root.right, results);
    }

}
