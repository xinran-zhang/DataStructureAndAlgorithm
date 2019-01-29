package grace.shuati;
import java.util.*;

public class BinaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            helper(root, target, new ArrayList<Integer>(), result);
        }
        return result;
    }

    private void helper(TreeNode root, int target, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == target) {
                result.add(new ArrayList<Integer>(path.subList(i, path.size())));
            }
        }
        helper(root.left, target, path, result);
        helper(root.right, target, path, result);
        path.remove(path.size() - 1);
    }
}
