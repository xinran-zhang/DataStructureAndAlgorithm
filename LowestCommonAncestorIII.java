package grace.shuati;

import javax.xml.transform.Result;

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Return null if LCA does not exist.
 */
// divide and conquer
// helper method -> identify if A, B exists and their LCA
public class LowestCommonAncestorIII {
    class ResultType {
        boolean isA;
        boolean isB;
        TreeNode LCA;
        ResultType(boolean isA, boolean isB, TreeNode LCA) {
            this.isA = isA;
            this.isB = isB;
            this.LCA = LCA;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType rt = helper(root, A, B);
        if (rt.isA && rt.isB) {
            return rt.LCA;
        }
        return null;
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }

        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);

        boolean isA = left.isA || right.isA || root == A;
        boolean isB = left.isB || right.isB || root == B;

        if (root == A || root == B) {
            return new ResultType(isA, isB, root);
        }
        if (left.LCA != null && right.LCA != null) {
            return new ResultType(isA, isB, root);
        }
        if (left.LCA != null && right.LCA == null) {
            return new ResultType(isA, isB, left.LCA);
        }
        if (right.LCA != null && left.LCA == null) {
            return new ResultType(isA, isB, right.LCA);
        }
        return new ResultType(isA, isB, null);
    }
}
