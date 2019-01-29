package grace.shuati;

public class InorderSuccessorInBST {
    TreeNode successor = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        inorderTraverse(root, p);
        return successor;
    }

    private void inorderTraverse(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }

        if (root == p) {
            if (root.right != null) {
                TreeNode tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                successor = tmp;
            }
        } else if (root.val > p.val) {
            successor = root;
            inorderSuccessor(root.left, p);
        } else {
            inorderSuccessor(root.right, p);
        }
    }
}
