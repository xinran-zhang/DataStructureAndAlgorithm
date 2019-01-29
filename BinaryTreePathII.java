package grace.shuati;

import java.util.*;

public class BinaryTreePathII {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        for (String path: leftPaths) {
            res.add(root.val + "->" + path);
        }

        for (String path: rightPaths) {
            res.add(root.val + "->" + path);
        }
        //  if root is a leaf
        if (res.size() == 0) {
            res.add("" + root.val);
        }
        return res;
    }
}
