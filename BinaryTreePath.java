package grace.shuati;
import java.util.*;

// traverse
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        String p = "" + root.val;
        traverse(root, p, res);
        return res;
    }

    private void traverse(TreeNode root, String path, List<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(path);
        }

        if (root.left != null) {
            traverse(root.left, path + "->" + root.left.val, res);
        }
        if (root.right != null) {
            traverse(root.right, path + "->" + root.right.val, res);
        }
    }
}
