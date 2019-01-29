package grace.shuati;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // divide and conquer
        // find the LCA of left subtree and right subtree
        // if leftLCA and rightLCA both exists, root is the LCA
        // if leftLCA exists while rightLCA not, leftLCA is the LCA, vice versa
        // if both not exist, return null
        if (root == null || A == root || B == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }
        if (left != null && right == null) {
            return left;
        }
        if (right != null && left == null) {
            return right;
        }
        return null;
    }
}
