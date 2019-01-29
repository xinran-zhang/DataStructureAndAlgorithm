package grace.shuati;

// traversal
public class ValidateBinarySearchTree {
    private boolean isValid;
    private TreeNode prevNode;
    public boolean isValidBST(TreeNode root) {
        isValid = true;
        prevNode = null;

        traverse(root);
        return isValid;
    }

    // inorder traversal
    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        if (prevNode != null && prevNode.val >= root.val) {
            isValid = false;
            return;
        }
        prevNode = root;
        traverse(root.right);
    }
}
