package grace.shuati;
import java.util.*;

public class BinaryTreePathSumIII {
    class ParentTreeNode {
        public int val;
        public ParentTreeNode parent, left, right;
    }

    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, target, res);
        return res;
    }

    private void dfs(ParentTreeNode root, int target, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        List<Integer> path = new ArrayList<>();
        findSum(root, null, target, path, res);

        dfs(root.left, target, res);
        dfs(root.right, target, res);
    }
    // start from a node on the tree and find nodes that sums up to target
    // use father to indicate the direction it comes from
    private void findSum(ParentTreeNode root, ParentTreeNode father, int target,
                         List<Integer> path, List<List<Integer>> res) {
        path.add(root.val);
        target -= root.val;

        if (target == 0) {
            List<Integer> tmp = new ArrayList<>();
            Collections.addAll(tmp, new Integer[path.size()]);
            Collections.copy(tmp, path);
            res.add(tmp);
        }

        if (root.parent != null && root.parent != father) {
            findSum(root.parent, root, target, path, res);
        }
        if (root.left != null && root.left != father) {
            findSum(root.left, root, target, path, res);
        }
        if (root.right != null && root.right != father) {
            findSum(root.right, root, target, path, res);
        }
        path.remove(path.size() - 1);
    }
}
