package grace.shuati;

class ResultType {
    boolean isBST;
    TreeNode maxNode, minNode;
    public ResultType(boolean isBST) {
        isBST = true;
        maxNode = null;
        minNode = null;
    }
}

public class ValidateBSTDivideConquer {
    public boolean isValidBST(TreeNode root) {
        return divideConquer(root).isBST;
    }

    private ResultType divideConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(true);
        }

        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);

        if (left.maxNode != null && left.maxNode.val >= root.val) {
            return new ResultType(false);
        }
        if (right.minNode != null && right.minNode.val <= root.val) {
            return new ResultType(false);
        }

        ResultType result = new ResultType(true);
        if (left.minNode != null) {
            result.minNode = left.minNode;
        } else {
            result.minNode = root;
        }

        if (right.maxNode != null) {
            result.maxNode = right.maxNode;
        } else {
            result.maxNode = root;
        }
        return result;
    }
}
