package grace.shuati;

public class InorderPredecessorInBST {
    TreeNode predecessor = null;
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        inorderTraverse(root, p);
        return predecessor;
    }

    private void inorderTraverse(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        if (root == p) {
            if (root.left != null) {
                TreeNode tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                predecessor = tmp;
            }
        } else if (root.val > p.val) {
            inorderPredecessor(root.left, p);
        } else {
            predecessor = root;
            inorderPredecessor(root.right, p);
        }
    }
}
